package gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import gui.page.HoaDonPage;
import gui.page.KhachHangPage;
import gui.page.NhaSanXuatPage;
import gui.page.NhanVienPage;
import gui.page.SanPhamPage;
import gui.page.TaiKhoanPage;
import gui.page.ThuocTinhPage;
import java.awt.Color;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    private NhaSanXuatPage nhaSanXuat;
    private KhachHangPage khachHang;
    private NhanVienPage nhanVien;
    private TaiKhoanPage taiKhoan;

    private List<JButton> listItem;

    Color ACTIVE_BACKGROUND_COLOR = new Color(195, 240, 235);

    public MainLayout() {
        initComponents();
        sideBarLayout();
    }

    public void setPanel(JPanel pn) {
        mainContent.removeAll();
        mainContent.add(pn).setVisible(true);
        mainContent.repaint();
        mainContent.validate();
    }

    private void sideBarLayout() {
        // Add list item Sidebar
        listItem = new ArrayList<>();
        listItem.add(sanPhamItem);
        listItem.add(thuocTinhItem);
        listItem.add(hoaDonItem);
        listItem.add(phieuNhapItem);
        listItem.add(nhaSanXuatItem);
        listItem.add(khachHangItem);
        listItem.add(nhanVienItem);
        listItem.add(taiKhoanItem);
        listItem.add(thongKeItem);
        listItem.add(phieuDatHang);
        listItem.add(vaiTroItem);

        for (JButton item : listItem) {
            item.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        }
        btnLogout.putClientProperty(FlatClientProperties.STYLE, "arc: 15");

        // Default content
        sanPham = new SanPhamPage();
        mainContent.add(sanPham).setVisible(true);

        // Default selected
        listItem.get(0).setSelected(true);
        listItem.get(0).setBackground(ACTIVE_BACKGROUND_COLOR);

        // Set active item
        for (JButton item : listItem) {
            item.getModel().addChangeListener((ChangeEvent e) -> {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isSelected()) {
                    item.setBackground(ACTIVE_BACKGROUND_COLOR); // Change color when selected
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
        jScrollPane1 = new javax.swing.JScrollPane();
        itemPanel = new javax.swing.JPanel();
        sanPhamItem = new javax.swing.JButton();
        thuocTinhItem = new javax.swing.JButton();
        khachHangItem = new javax.swing.JButton();
        hoaDonItem = new javax.swing.JButton();
        phieuDatHang = new javax.swing.JButton();
        phieuNhapItem = new javax.swing.JButton();
        nhaSanXuatItem = new javax.swing.JButton();
        nhanVienItem = new javax.swing.JButton();
        taiKhoanItem = new javax.swing.JButton();
        vaiTroItem = new javax.swing.JButton();
        thongKeItem = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnLogout = new javax.swing.JButton();
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

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(220, 550));

        itemPanel.setBackground(new java.awt.Color(255, 255, 255));
        itemPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 8, true));
        itemPanel.setPreferredSize(new java.awt.Dimension(250, 550));

        sanPhamItem.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        sanPhamItem.setIcon(new FlatSVGIcon("./icon/medicine.svg"));
        sanPhamItem.setText("Thuốc");
        sanPhamItem.setBorder(null);
        sanPhamItem.setBorderPainted(false);
        sanPhamItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sanPhamItem.setFocusPainted(false);
        sanPhamItem.setFocusable(false);
        sanPhamItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        sanPhamItem.setIconTextGap(16);
        sanPhamItem.setPreferredSize(new java.awt.Dimension(226, 46));
        sanPhamItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sanPhamItemActionPerformed(evt);
            }
        });
        itemPanel.add(sanPhamItem);

        thuocTinhItem.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        thuocTinhItem.setIcon(new FlatSVGIcon("./icon/menu.svg"));
        thuocTinhItem.setText("Thuộc tính");
        thuocTinhItem.setBorder(null);
        thuocTinhItem.setBorderPainted(false);
        thuocTinhItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        thuocTinhItem.setFocusPainted(false);
        thuocTinhItem.setFocusable(false);
        thuocTinhItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        thuocTinhItem.setIconTextGap(16);
        thuocTinhItem.setPreferredSize(new java.awt.Dimension(226, 46));
        thuocTinhItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thuocTinhItemActionPerformed(evt);
            }
        });
        itemPanel.add(thuocTinhItem);

        khachHangItem.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        khachHangItem.setIcon(new FlatSVGIcon("./icon/customer.svg"));
        khachHangItem.setText("Khách hàng");
        khachHangItem.setBorder(null);
        khachHangItem.setBorderPainted(false);
        khachHangItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        khachHangItem.setFocusPainted(false);
        khachHangItem.setFocusable(false);
        khachHangItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        khachHangItem.setIconTextGap(16);
        khachHangItem.setPreferredSize(new java.awt.Dimension(226, 46));
        khachHangItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khachHangItemActionPerformed(evt);
            }
        });
        itemPanel.add(khachHangItem);

        hoaDonItem.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        hoaDonItem.setIcon(new FlatSVGIcon("./icon/bill.svg"));
        hoaDonItem.setText("Hóa đơn");
        hoaDonItem.setBorder(null);
        hoaDonItem.setBorderPainted(false);
        hoaDonItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hoaDonItem.setFocusPainted(false);
        hoaDonItem.setFocusable(false);
        hoaDonItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        hoaDonItem.setIconTextGap(16);
        hoaDonItem.setPreferredSize(new java.awt.Dimension(226, 46));
        hoaDonItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoaDonItemActionPerformed(evt);
            }
        });
        itemPanel.add(hoaDonItem);

        phieuDatHang.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        phieuDatHang.setIcon(new FlatSVGIcon("./icon/ticket.svg"));
        phieuDatHang.setText("Phiếu đặt hàng");
        phieuDatHang.setBorder(null);
        phieuDatHang.setBorderPainted(false);
        phieuDatHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phieuDatHang.setFocusPainted(false);
        phieuDatHang.setFocusable(false);
        phieuDatHang.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        phieuDatHang.setIconTextGap(16);
        phieuDatHang.setPreferredSize(new java.awt.Dimension(226, 46));
        itemPanel.add(phieuDatHang);

        phieuNhapItem.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        phieuNhapItem.setIcon(new FlatSVGIcon("./icon/bill-import.svg"));
        phieuNhapItem.setText("Phiếu nhập");
        phieuNhapItem.setBorder(null);
        phieuNhapItem.setBorderPainted(false);
        phieuNhapItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phieuNhapItem.setFocusPainted(false);
        phieuNhapItem.setFocusable(false);
        phieuNhapItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        phieuNhapItem.setIconTextGap(16);
        phieuNhapItem.setPreferredSize(new java.awt.Dimension(226, 46));
        itemPanel.add(phieuNhapItem);

        nhaSanXuatItem.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        nhaSanXuatItem.setIcon(new FlatSVGIcon("./icon/trucks.svg"));
        nhaSanXuatItem.setText("Nhà sản xuất");
        nhaSanXuatItem.setBorder(null);
        nhaSanXuatItem.setBorderPainted(false);
        nhaSanXuatItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nhaSanXuatItem.setFocusPainted(false);
        nhaSanXuatItem.setFocusable(false);
        nhaSanXuatItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        nhaSanXuatItem.setIconTextGap(16);
        nhaSanXuatItem.setPreferredSize(new java.awt.Dimension(226, 46));
        nhaSanXuatItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhaSanXuatItemActionPerformed(evt);
            }
        });
        itemPanel.add(nhaSanXuatItem);

        nhanVienItem.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        nhanVienItem.setIcon(new FlatSVGIcon("./icon/employee.svg"));
        nhanVienItem.setText("Nhân viên");
        nhanVienItem.setBorder(null);
        nhanVienItem.setBorderPainted(false);
        nhanVienItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nhanVienItem.setFocusPainted(false);
        nhanVienItem.setFocusable(false);
        nhanVienItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        nhanVienItem.setIconTextGap(16);
        nhanVienItem.setPreferredSize(new java.awt.Dimension(226, 46));
        nhanVienItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhanVienItemActionPerformed(evt);
            }
        });
        itemPanel.add(nhanVienItem);

        taiKhoanItem.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        taiKhoanItem.setIcon(new FlatSVGIcon("./icon/account.svg"));
        taiKhoanItem.setText("Tài khoản");
        taiKhoanItem.setBorder(null);
        taiKhoanItem.setBorderPainted(false);
        taiKhoanItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        taiKhoanItem.setFocusPainted(false);
        taiKhoanItem.setFocusable(false);
        taiKhoanItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        taiKhoanItem.setIconTextGap(16);
        taiKhoanItem.setPreferredSize(new java.awt.Dimension(226, 46));
        taiKhoanItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taiKhoanItemActionPerformed(evt);
            }
        });
        itemPanel.add(taiKhoanItem);

        vaiTroItem.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        vaiTroItem.setIcon(new FlatSVGIcon("./icon/security.svg"));
        vaiTroItem.setText("Phân quyền");
        vaiTroItem.setBorder(null);
        vaiTroItem.setBorderPainted(false);
        vaiTroItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vaiTroItem.setFocusPainted(false);
        vaiTroItem.setFocusable(false);
        vaiTroItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vaiTroItem.setIconTextGap(16);
        vaiTroItem.setPreferredSize(new java.awt.Dimension(226, 46));
        vaiTroItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaiTroItemActionPerformed(evt);
            }
        });
        itemPanel.add(vaiTroItem);

        thongKeItem.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        thongKeItem.setIcon(new FlatSVGIcon("./icon/statistics.svg"));
        thongKeItem.setText("Thống kê");
        thongKeItem.setBorder(null);
        thongKeItem.setBorderPainted(false);
        thongKeItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        thongKeItem.setFocusPainted(false);
        thongKeItem.setFocusable(false);
        thongKeItem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        thongKeItem.setIconTextGap(16);
        thongKeItem.setPreferredSize(new java.awt.Dimension(226, 46));
        itemPanel.add(thongKeItem);

        jScrollPane1.setViewportView(itemPanel);

        sidebarPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jPanel5.setPreferredSize(new java.awt.Dimension(246, 80));
        jPanel5.setLayout(new java.awt.BorderLayout(0, 10));
        jPanel5.add(jSeparator1, java.awt.BorderLayout.PAGE_START);

        btnLogout.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnLogout.setIcon(new FlatSVGIcon("./icon/logout.svg"));
        btnLogout.setText("Đăng Xuất");
        btnLogout.setBorder(null);
        btnLogout.setBorderPainted(false);
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.setFocusPainted(false);
        btnLogout.setFocusable(false);
        btnLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnLogout.setIconTextGap(16);
        btnLogout.setPreferredSize(new java.awt.Dimension(226, 46));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel5.add(btnLogout, java.awt.BorderLayout.CENTER);

        sidebarPanel.add(jPanel5, java.awt.BorderLayout.SOUTH);

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));
        infoPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true));
        infoPanel.setForeground(new java.awt.Color(243, 243, 243));
        infoPanel.setPreferredSize(new java.awt.Dimension(200, 80));
        infoPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(64, 80));

        jLabel1.setIcon(new FlatSVGIcon("./icon/man.svg"));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel1);

        infoPanel.add(jPanel2, java.awt.BorderLayout.WEST);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtFullName.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
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

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        if (MessageDialog.confirm(this, "Bạn có chắc chắn muốn đăng xuất không?", "Đăng xuẩt")) {
            this.dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void taiKhoanItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taiKhoanItemActionPerformed
        taiKhoan = new TaiKhoanPage();
        this.setPanel(taiKhoan);
        resetActive();
        taiKhoanItem.setSelected(true);
    }//GEN-LAST:event_taiKhoanItemActionPerformed

    private void nhanVienItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhanVienItemActionPerformed
        nhanVien = new NhanVienPage();
        this.setPanel(nhanVien);
        resetActive();
        nhanVienItem.setSelected(true);
    }//GEN-LAST:event_nhanVienItemActionPerformed

    private void khachHangItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khachHangItemActionPerformed
        khachHang = new KhachHangPage();
        this.setPanel(khachHang);
        resetActive();
        khachHangItem.setSelected(true);
    }//GEN-LAST:event_khachHangItemActionPerformed

    private void nhaSanXuatItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhaSanXuatItemActionPerformed
        nhaSanXuat = new NhaSanXuatPage();
        this.setPanel(nhaSanXuat);
        resetActive();
        nhaSanXuatItem.setSelected(true);
    }//GEN-LAST:event_nhaSanXuatItemActionPerformed

    private void hoaDonItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoaDonItemActionPerformed
        hoaDon = new HoaDonPage(this);
        this.setPanel(hoaDon);
        resetActive();
        hoaDonItem.setSelected(true);
    }//GEN-LAST:event_hoaDonItemActionPerformed

    private void thuocTinhItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thuocTinhItemActionPerformed
        thuocTinh = new ThuocTinhPage();
        this.setPanel(thuocTinh);
        resetActive();
        thuocTinhItem.setSelected(true);
    }//GEN-LAST:event_thuocTinhItemActionPerformed

    private void sanPhamItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sanPhamItemActionPerformed
        sanPham = new SanPhamPage();
        this.setPanel(sanPham);
        resetActive();
        sanPhamItem.setSelected(true);
    }//GEN-LAST:event_sanPhamItemActionPerformed

    private void vaiTroItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaiTroItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vaiTroItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton hoaDonItem;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel itemPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton khachHangItem;
    private javax.swing.JPanel leftContent;
    private javax.swing.JPanel mainContent;
    private javax.swing.JButton nhaSanXuatItem;
    private javax.swing.JButton nhanVienItem;
    private javax.swing.JButton phieuDatHang;
    private javax.swing.JButton phieuNhapItem;
    private javax.swing.JButton sanPhamItem;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JButton taiKhoanItem;
    private javax.swing.JButton thongKeItem;
    private javax.swing.JButton thuocTinhItem;
    private javax.swing.JLabel txtFullName;
    private javax.swing.JLabel txtRole;
    private javax.swing.JButton vaiTroItem;
    // End of variables declaration//GEN-END:variables
}
