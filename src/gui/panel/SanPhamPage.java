package gui.panel;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author atuandev
 */
public class SanPhamPage extends javax.swing.JPanel {

    private List<JButton> listButton;

    public SanPhamPage() {
        initComponents();
        headerLayout();
        FlatIntelliJLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
    }

    private void headerLayout() {
        listButton = new ArrayList<>();
        listButton.add(btnAdd);
        listButton.add(btnUpdate);
        listButton.add(btnDelete);
        listButton.add(btnInfo);
        listButton.add(btnImport);
        listButton.add(btnExport);
        
        // Border radius
        for (JButton item : listButton) {
            item.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        }
        headerPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tìm kiếm...");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("./icon/search.svg"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnReload = new javax.swing.JButton();
        cboxSearch = new javax.swing.JComboBox<>();
        actionPanel = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBackground(new java.awt.Color(230, 245, 245));
        setMinimumSize(new java.awt.Dimension(1130, 800));
        setPreferredSize(new java.awt.Dimension(1130, 800));
        setLayout(new java.awt.BorderLayout());

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));
        headerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 245, 245), 10));
        headerPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(590, 100));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(584, 40));
        jPanel3.setLayout(new java.awt.BorderLayout(6, 0));

        txtSearch.setToolTipText("Tìm kiếm");
        txtSearch.setPreferredSize(new java.awt.Dimension(80, 40));
        txtSearch.setSelectionColor(new java.awt.Color(230, 245, 245));
        jPanel3.add(txtSearch, java.awt.BorderLayout.CENTER);

        btnReload.setIcon(new FlatSVGIcon("./icon/reload.svg"));
        btnReload.setToolTipText("Làm mới");
        btnReload.setBorder(null);
        btnReload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReload.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReload.setPreferredSize(new java.awt.Dimension(40, 40));
        jPanel3.add(btnReload, java.awt.BorderLayout.EAST);

        cboxSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm theo", "Mã", "Tên", "Giá" }));
        cboxSearch.setToolTipText("");
        cboxSearch.setPreferredSize(new java.awt.Dimension(120, 26));
        jPanel3.add(cboxSearch, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        headerPanel.add(jPanel1, java.awt.BorderLayout.CENTER);

        actionPanel.setBackground(new java.awt.Color(255, 255, 255));
        actionPanel.setPreferredSize(new java.awt.Dimension(560, 100));
        actionPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

        btnAdd.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnAdd.setIcon(new FlatSVGIcon("./icon/add.svg"));
        btnAdd.setText("THÊM");
        btnAdd.setBorder(null);
        btnAdd.setBorderPainted(false);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setFocusPainted(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setPreferredSize(new java.awt.Dimension(90, 90));
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        actionPanel.add(btnAdd);

        btnUpdate.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnUpdate.setIcon(new FlatSVGIcon("./icon/update.svg"));
        btnUpdate.setText("SỬA");
        btnUpdate.setBorder(null);
        btnUpdate.setBorderPainted(false);
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setFocusPainted(false);
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.setPreferredSize(new java.awt.Dimension(90, 90));
        btnUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        actionPanel.add(btnUpdate);

        btnDelete.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnDelete.setIcon(new FlatSVGIcon("./icon/delete.svg"));
        btnDelete.setText("XÓA");
        btnDelete.setBorder(null);
        btnDelete.setBorderPainted(false);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setFocusPainted(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setPreferredSize(new java.awt.Dimension(90, 90));
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        actionPanel.add(btnDelete);

        btnInfo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnInfo.setIcon(new FlatSVGIcon("./icon/info.svg"));
        btnInfo.setText("INFO");
        btnInfo.setBorder(null);
        btnInfo.setBorderPainted(false);
        btnInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInfo.setFocusPainted(false);
        btnInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInfo.setPreferredSize(new java.awt.Dimension(90, 90));
        btnInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        actionPanel.add(btnInfo);

        btnImport.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnImport.setIcon(new FlatSVGIcon("./icon/import.svg"));
        btnImport.setText("IMPORT");
        btnImport.setBorder(null);
        btnImport.setBorderPainted(false);
        btnImport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImport.setFocusPainted(false);
        btnImport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImport.setPreferredSize(new java.awt.Dimension(90, 90));
        btnImport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        actionPanel.add(btnImport);

        btnExport.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnExport.setIcon(new FlatSVGIcon("./icon/export.svg"));
        btnExport.setText("EXPORT");
        btnExport.setBorder(null);
        btnExport.setBorderPainted(false);
        btnExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExport.setFocusPainted(false);
        btnExport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExport.setPreferredSize(new java.awt.Dimension(90, 90));
        btnExport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        actionPanel.add(btnExport);

        headerPanel.add(actionPanel, java.awt.BorderLayout.WEST);

        add(headerPanel, java.awt.BorderLayout.PAGE_START);

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 245, 245), 10));
        tablePanel.setLayout(new java.awt.BorderLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"00022268", "Thuốc Paralmax Extra 500mg/65mg",  new Integer(12),  new Double(55000.0), " Thuốc giảm đau (không opioid) & hạ sốt", "Viên", "Việt Nam "}
            },
            new String [] {
                "Mã thuốc", "Tên thuốc", "Số lượng tồn", "Đơn giá", "Danh mục", "Đơn vị tính", "Xuất xứ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setFocusable(false);
        table.setRowHeight(40);
        scrollTable.setViewportView(table);

        tablePanel.add(scrollTable, java.awt.BorderLayout.CENTER);

        add(tablePanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboxSearch;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable table;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
