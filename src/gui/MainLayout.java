package gui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import gui.panel.HoaDonPage;
import gui.panel.SanPhamPage;
import gui.panel.ThuocTinhPage;
import java.awt.Color;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import utils.MessageDialog;

/**
 *
 * @author atuandev
 */
public class MainLayout extends javax.swing.JFrame {

    private SanPhamPage sanPham;
    private HoaDonPage hoaDon;
    private ThuocTinhPage thuocTinh;

    private List<JButton> listItem;

    Color ACTIVE_BACKGROUND_COLOR = new Color(195, 240, 235);

    public MainLayout() {
        initComponents();
        initFlatLaf();
        sideBarLayout();
    }

    public void setPanel(JPanel pn) {
        mainContent.removeAll();
        mainContent.add(pn).setVisible(true);
        mainContent.repaint();
        mainContent.validate();
    }

    private void initFlatLaf() {
        FlatRobotoFont.install();
        FlatLaf.setPreferredFontFamily(FlatRobotoFont.FAMILY);
        FlatLaf.setPreferredLightFontFamily(FlatRobotoFont.FAMILY_LIGHT);
        FlatLaf.setPreferredSemiboldFontFamily(FlatRobotoFont.FAMILY_SEMIBOLD);
        FlatIntelliJLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
        UIManager.put("TextComponent.arc", 5);
        UIManager.put("ScrollBar.thumbArc", 999);
        UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
        UIManager.put("Table.scrollPaneBorder", new EmptyBorder(0, 0, 0, 0));
        UIManager.put("Table.rowHeight", 40);
        UIManager.put("Table.showVerticalLines", false);
        UIManager.put("Table.showHorizontalLines", true);
        UIManager.put("TabbedPane.selectedBackground", Color.white);
        UIManager.put("TableHeader.height", 40);
        UIManager.put("TableHeader.font", UIManager.getFont("h4.font"));
        UIManager.put("TableHeader.background", new Color(242, 242, 242));
        UIManager.put("TableHeader.separatorColor", new Color(242, 242, 242));
        UIManager.put("TableHeader.bottomSeparatorColor", new Color(242, 242, 242));
    }

    private void sideBarLayout() {
        // Add list item Sidebar
        listItem = new ArrayList<>();
        listItem.add(sanPhamItem);
        listItem.add(thuocTinhItem);
        listItem.add(hoaDonItem);
        listItem.add(nhanVienItem);

        // Default content
        sanPham = new SanPhamPage();
        mainContent.add(sanPham).setVisible(true);

        // Default selected
        listItem.get(0).setSelected(true);
        listItem.get(0).setBackground(ACTIVE_BACKGROUND_COLOR);

        // Set active item
        for (JButton item : listItem) {
            item.getModel().addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    ButtonModel model = (ButtonModel) e.getSource();

                    if (model.isSelected()) {
                        item.setBackground(ACTIVE_BACKGROUND_COLOR); // Change color when selected
                    }
                }
            });
        }
    }

    private void resetActive() {
        for (JButton item : listItem) {
            item.setSelected(false);
            item.setBackground(Color.WHITE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftContent = new javax.swing.JPanel();
        sidebarPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        sanPhamItem = new javax.swing.JButton();
        thuocTinhItem = new javax.swing.JButton();
        hoaDonItem = new javax.swing.JButton();
        nhanVienItem = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        logoutItem = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtFullName = new javax.swing.JLabel();
        txtRole = new javax.swing.JLabel();
        mainContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hệ thống quản lý hiệu thuốc tây");
        setPreferredSize(new java.awt.Dimension(1400, 800));

        leftContent.setBackground(new java.awt.Color(230, 245, 245));
        leftContent.setPreferredSize(new java.awt.Dimension(250, 800));

        sidebarPanel.setBackground(new java.awt.Color(255, 255, 255));
        sidebarPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(200, 800));
        sidebarPanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        sanPhamItem.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        sanPhamItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pills.png"))); // NOI18N
        sanPhamItem.setText("Thuốc");
        sanPhamItem.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        sanPhamItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sanPhamItem.setFocusable(false);
        sanPhamItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        sanPhamItem.setIconTextGap(16);
        sanPhamItem.setPreferredSize(new java.awt.Dimension(226, 46));
        sanPhamItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sanPhamItemActionPerformed(evt);
            }
        });
        jPanel3.add(sanPhamItem);

        thuocTinhItem.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        thuocTinhItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product.png"))); // NOI18N
        thuocTinhItem.setText("Thuộc tính");
        thuocTinhItem.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        thuocTinhItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        thuocTinhItem.setFocusable(false);
        thuocTinhItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        thuocTinhItem.setIconTextGap(16);
        thuocTinhItem.setPreferredSize(new java.awt.Dimension(226, 46));
        thuocTinhItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thuocTinhItemActionPerformed(evt);
            }
        });
        jPanel3.add(thuocTinhItem);

        hoaDonItem.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        hoaDonItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N
        hoaDonItem.setText("Hóa đơn");
        hoaDonItem.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        hoaDonItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hoaDonItem.setFocusable(false);
        hoaDonItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        hoaDonItem.setIconTextGap(16);
        hoaDonItem.setPreferredSize(new java.awt.Dimension(226, 46));
        hoaDonItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoaDonItemActionPerformed(evt);
            }
        });
        jPanel3.add(hoaDonItem);

        nhanVienItem.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        nhanVienItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/employee.png"))); // NOI18N
        nhanVienItem.setText("Nhân viên");
        nhanVienItem.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        nhanVienItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nhanVienItem.setFocusable(false);
        nhanVienItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        nhanVienItem.setIconTextGap(16);
        nhanVienItem.setPreferredSize(new java.awt.Dimension(226, 46));
        nhanVienItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhanVienItemActionPerformed(evt);
            }
        });
        jPanel3.add(nhanVienItem);

        sidebarPanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jPanel5.setPreferredSize(new java.awt.Dimension(246, 80));
        jPanel5.setLayout(new java.awt.BorderLayout(0, 10));
        jPanel5.add(jSeparator1, java.awt.BorderLayout.PAGE_START);

        logoutItem.setBackground(new java.awt.Color(255, 255, 255));
        logoutItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutItem.setPreferredSize(new java.awt.Dimension(226, 46));
        logoutItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutItemMouseClicked(evt);
            }
        });
        logoutItem.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Đăng xuất");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel6.setFocusable(false);
        logoutItem.add(jLabel6, java.awt.BorderLayout.CENTER);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        jLabel9.setFocusable(false);
        jLabel9.setPreferredSize(new java.awt.Dimension(60, 32));
        logoutItem.add(jLabel9, java.awt.BorderLayout.LINE_START);

        jPanel5.add(logoutItem, java.awt.BorderLayout.CENTER);

        sidebarPanel.add(jPanel5, java.awt.BorderLayout.SOUTH);

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));
        infoPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true));
        infoPanel.setForeground(new java.awt.Color(243, 243, 243));
        infoPanel.setPreferredSize(new java.awt.Dimension(200, 80));
        infoPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(64, 80));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user-avatar.png"))); // NOI18N
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        infoPanel.add(jPanel2, java.awt.BorderLayout.WEST);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtFullName.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        txtFullName.setText("Nguyễn Phan Anh Tuấn");

        txtRole.setFont(new java.awt.Font("Roboto Mono", 2, 12)); // NOI18N
        txtRole.setText("Quản lý");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFullName, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(txtRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRole)
                .addGap(15, 15, 15))
        );

        infoPanel.add(jPanel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout leftContentLayout = new javax.swing.GroupLayout(leftContent);
        leftContent.setLayout(leftContentLayout);
        leftContentLayout.setHorizontalGroup(
            leftContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftContentLayout.createSequentialGroup()
                .addGroup(leftContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        leftContentLayout.setVerticalGroup(
            leftContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftContentLayout.createSequentialGroup()
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
        );

        getContentPane().add(leftContent, java.awt.BorderLayout.WEST);

        mainContent.setBackground(new java.awt.Color(243, 255, 255));
        mainContent.setLayout(new java.awt.BorderLayout());
        getContentPane().add(mainContent, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutItemMouseClicked
        if (MessageDialog.confirm(this, "Bạn có chắc chắn muốn đăng xuất không?", "Đăng xuẩt")) {
            this.dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_logoutItemMouseClicked

    private void sanPhamItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sanPhamItemActionPerformed
        sanPham = new SanPhamPage();
        this.setPanel(sanPham);
        resetActive();
        sanPhamItem.setSelected(true);
    }//GEN-LAST:event_sanPhamItemActionPerformed

    private void thuocTinhItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thuocTinhItemActionPerformed
        thuocTinh = new ThuocTinhPage();
        this.setPanel(thuocTinh);
        resetActive();
        thuocTinhItem.setSelected(true);
    }//GEN-LAST:event_thuocTinhItemActionPerformed

    private void hoaDonItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoaDonItemActionPerformed
        hoaDon = new HoaDonPage();
        this.setPanel(hoaDon);
        resetActive();
        hoaDonItem.setSelected(true);
    }//GEN-LAST:event_hoaDonItemActionPerformed

    private void nhanVienItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhanVienItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhanVienItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hoaDonItem;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel leftContent;
    private javax.swing.JPanel logoutItem;
    private javax.swing.JPanel mainContent;
    private javax.swing.JButton nhanVienItem;
    private javax.swing.JButton sanPhamItem;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JButton thuocTinhItem;
    private javax.swing.JLabel txtFullName;
    private javax.swing.JLabel txtRole;
    // End of variables declaration//GEN-END:variables
}
