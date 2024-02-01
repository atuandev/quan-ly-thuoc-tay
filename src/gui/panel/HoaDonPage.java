/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.panel;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import utils.Formater;

/**
 *
 * @author HP
 */
public class HoaDonPage extends javax.swing.JPanel {

    /**
     * Creates new form HoaDonPanel
     */
    public HoaDonPage() {
        initComponents();
        FlatIntelliJLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
        pruductLayout();
        billLayout();
    }
    
    private void billLayout() {
        btnAddCustomer.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        String txtTongFormat = Formater.FormatVND(Double.parseDouble(txtTong.getText()));
        String txtTienThuaFormat = Formater.FormatVND(Double.parseDouble(txtTienThua.getText()));
        String txtGiaNhapFormat = Formater.FormatVND(Double.parseDouble(txtGiaNhap.getText()));
        String txtDonGiaFormat = Formater.FormatVND(Double.parseDouble(txtDonGia.getText()));
        
        txtTong.setText(txtTongFormat);
        txtTienThua.setText(txtTienThuaFormat);
        txtGiaNhap.setText(txtGiaNhapFormat);
        txtDonGia.setText(txtDonGiaFormat);
    }
    
    private void pruductLayout() {
        txtSoLuong.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Số lượng...");
        btnReload.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
    }
            
            
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        sanPhamPanel = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtMaThuoc = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtTenThuoc = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtThanhPhan = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        actionPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnReload = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        txtSoLuong = new javax.swing.JTextField();
        btnIn1 = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        billPanel = new javax.swing.JPanel();
        cardPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCard = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtSdtKH = new javax.swing.JTextField();
        btnAddCustomer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtHoTenKH = new javax.swing.JTextField();
        cboxGioiTinhKH = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        btnIn = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtDiaChiKH = new javax.swing.JTextField();

        setBackground(new java.awt.Color(230, 245, 245));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 245, 245), 10, true));
        setLayout(new java.awt.BorderLayout(5, 0));

        mainPanel.setBackground(new java.awt.Color(230, 245, 245));
        mainPanel.setLayout(new java.awt.BorderLayout(5, 5));

        sanPhamPanel.setBackground(new java.awt.Color(255, 255, 255));
        sanPhamPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 237, 237), 2, true));
        sanPhamPanel.setPreferredSize(new java.awt.Dimension(832, 300));
        sanPhamPanel.setLayout(new java.awt.BorderLayout());

        jPanel15.setBackground(new java.awt.Color(0, 153, 153));
        jPanel15.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel15.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Thông tin thuốc");
        jPanel15.add(jLabel8, java.awt.BorderLayout.CENTER);

        sanPhamPanel.add(jPanel15, java.awt.BorderLayout.NORTH);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 2, true));
        jLabel9.setPreferredSize(new java.awt.Dimension(200, 200));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(215, 40));
        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setText("Mã thuốc:");
        jLabel10.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel10.setPreferredSize(new java.awt.Dimension(90, 40));
        jPanel17.add(jLabel10);

        txtMaThuoc.setEditable(false);
        txtMaThuoc.setFocusable(false);
        txtMaThuoc.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel17.add(txtMaThuoc);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(215, 40));
        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel11.setText("Tên thuốc:");
        jLabel11.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel11.setPreferredSize(new java.awt.Dimension(90, 40));
        jPanel18.add(jLabel11);

        txtTenThuoc.setEditable(false);
        txtTenThuoc.setFocusable(false);
        txtTenThuoc.setPreferredSize(new java.awt.Dimension(270, 40));
        jPanel18.add(txtTenThuoc);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(215, 40));
        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel12.setText("Thành phần:");
        jLabel12.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel12.setPreferredSize(new java.awt.Dimension(90, 40));
        jPanel19.add(jLabel12);

        txtThanhPhan.setEditable(false);
        txtThanhPhan.setFocusable(false);
        txtThanhPhan.setPreferredSize(new java.awt.Dimension(270, 40));
        jPanel19.add(txtThanhPhan);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(215, 40));
        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel13.setText("Giá nhập:");
        jLabel13.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel13.setPreferredSize(new java.awt.Dimension(90, 40));
        jPanel20.add(jLabel13);

        txtGiaNhap.setEditable(false);
        txtGiaNhap.setFont(new java.awt.Font("Roboto Mono Medium", 0, 14)); // NOI18N
        txtGiaNhap.setText("123123");
        txtGiaNhap.setToolTipText("");
        txtGiaNhap.setFocusable(false);
        txtGiaNhap.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel20.add(txtGiaNhap);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(215, 40));
        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel14.setText("Đơn giá:");
        jLabel14.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel14.setPreferredSize(new java.awt.Dimension(90, 40));
        jPanel21.add(jLabel14);

        txtDonGia.setEditable(false);
        txtDonGia.setFont(new java.awt.Font("Roboto Mono Medium", 0, 14)); // NOI18N
        txtDonGia.setText("123123");
        txtDonGia.setFocusable(false);
        txtDonGia.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel21.add(txtDonGia);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(215, 40));
        jPanel23.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel16.setText("Số lượng tồn:");
        jLabel16.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel16.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel23.add(jLabel16);

        txtSoLuongTon.setEditable(false);
        txtSoLuongTon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoLuongTon.setText("12");
        txtSoLuongTon.setFocusable(false);
        txtSoLuongTon.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanel23.add(txtSoLuongTon);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        sanPhamPanel.add(jPanel16, java.awt.BorderLayout.CENTER);

        mainPanel.add(sanPhamPanel, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(230, 245, 245));
        jPanel4.setPreferredSize(new java.awt.Dimension(832, 400));
        jPanel4.setLayout(new java.awt.BorderLayout(0, 5));

        actionPanel.setBackground(new java.awt.Color(255, 255, 255));
        actionPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 237, 237), 2, true));
        actionPanel.setPreferredSize(new java.awt.Dimension(605, 60));
        actionPanel.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 8));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Tên" }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(80, 40));
        jPanel14.add(jComboBox2);

        txtSearch.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel14.add(txtSearch);

        btnReload.setIcon(new FlatSVGIcon("./icon/reload.svg"));
        btnReload.setBorderPainted(false);
        btnReload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReload.setFocusPainted(false);
        btnReload.setFocusable(false);
        btnReload.setPreferredSize(new java.awt.Dimension(40, 40));
        jPanel14.add(btnReload);

        jPanel12.add(jPanel14);

        actionPanel.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(260, 60));
        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 4));

        txtSoLuong.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtSoLuong.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel13.add(txtSoLuong);

        btnIn1.setBackground(new java.awt.Color(0, 179, 246));
        btnIn1.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btnIn1.setForeground(new java.awt.Color(255, 220, 0));
        btnIn1.setIcon(new FlatSVGIcon("./icon/add-to-cart.svg"));
        btnIn1.setText("THÊM");
        btnIn1.setBorderPainted(false);
        btnIn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIn1.setFocusPainted(false);
        btnIn1.setFocusable(false);
        btnIn1.setPreferredSize(new java.awt.Dimension(120, 48));
        jPanel13.add(btnIn1);

        actionPanel.add(jPanel13, java.awt.BorderLayout.EAST);

        jPanel4.add(actionPanel, java.awt.BorderLayout.PAGE_START);

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 237, 237), 2, true));
        tablePanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setFocusable(false);
        jScrollPane1.setViewportView(jTable1);

        tablePanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.add(tablePanel, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(mainPanel, java.awt.BorderLayout.CENTER);

        billPanel.setBackground(new java.awt.Color(230, 245, 245));
        billPanel.setPreferredSize(new java.awt.Dimension(500, 800));
        billPanel.setLayout(new java.awt.BorderLayout(0, 5));

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 238), 2, true));
        cardPanel.setPreferredSize(new java.awt.Dimension(600, 500));
        cardPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(null);

        tableCard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableCard.setFocusable(false);
        jScrollPane2.setViewportView(tableCard);

        cardPanel.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Giỏ hàng");
        jPanel3.add(jLabel1, java.awt.BorderLayout.CENTER);

        cardPanel.add(jPanel3, java.awt.BorderLayout.NORTH);

        billPanel.add(cardPanel, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 238), 2, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel5.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hóa đơn");
        jPanel5.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("Số điện thoại:");
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel7.add(jLabel4);

        txtSdtKH.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel7.add(txtSdtKH);

        btnAddCustomer.setIcon(new FlatSVGIcon("./icon/add-customer.svg"));
        btnAddCustomer.setBorderPainted(false);
        btnAddCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCustomer.setFocusPainted(false);
        btnAddCustomer.setFocusable(false);
        btnAddCustomer.setPreferredSize(new java.awt.Dimension(40, 40));
        jPanel7.add(btnAddCustomer);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Họ tên:");
        jLabel3.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel2.add(jLabel3);

        txtHoTenKH.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel2.add(txtHoTenKH);

        cboxGioiTinhKH.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cboxGioiTinhKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cboxGioiTinhKH.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel2.add(cboxGioiTinhKH);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setText("Tổng hóa đơn:");
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel11.add(jLabel7);

        txtTong.setEditable(false);
        txtTong.setFont(new java.awt.Font("Roboto Mono Medium", 0, 14)); // NOI18N
        txtTong.setText("100000");
        txtTong.setFocusable(false);
        txtTong.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel11.add(txtTong);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setText("Tiền khách đưa:");
        jLabel6.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel10.add(jLabel6);

        txtTienKhachDua.setFont(new java.awt.Font("Roboto Mono Medium", 0, 14)); // NOI18N
        txtTienKhachDua.setText("100000");
        txtTienKhachDua.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel10.add(txtTienKhachDua);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Tiền thừa:");
        jLabel5.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel9.add(jLabel5);

        txtTienThua.setEditable(false);
        txtTienThua.setFont(new java.awt.Font("Roboto Mono Medium", 0, 14)); // NOI18N
        txtTienThua.setText("55000");
        txtTienThua.setFocusable(false);
        txtTienThua.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel9.add(txtTienThua);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        btnHuy.setBackground(new java.awt.Color(255, 102, 102));
        btnHuy.setFont(new java.awt.Font("Roboto Mono Medium", 0, 16)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("HỦY BỎ");
        btnHuy.setBorderPainted(false);
        btnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuy.setFocusPainted(false);
        btnHuy.setFocusable(false);
        btnHuy.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel8.add(btnHuy);

        btnIn.setBackground(new java.awt.Color(0, 204, 51));
        btnIn.setFont(new java.awt.Font("Roboto Mono Medium", 0, 16)); // NOI18N
        btnIn.setForeground(new java.awt.Color(255, 255, 255));
        btnIn.setText("IN HÓA ĐƠN");
        btnIn.setBorderPainted(false);
        btnIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIn.setFocusPainted(false);
        btnIn.setFocusable(false);
        btnIn.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel8.add(btnIn);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel15.setText("Địa chỉ:");
        jLabel15.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel22.add(jLabel15);

        txtDiaChiKH.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel22.add(txtDiaChiKH);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        billPanel.add(jPanel1, java.awt.BorderLayout.SOUTH);

        add(billPanel, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JPanel billPanel;
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnIn1;
    private javax.swing.JButton btnReload;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JComboBox<String> cboxGioiTinhKH;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel sanPhamPanel;
    private javax.swing.JTable tableCard;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTextField txtDiaChiKH;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtHoTenKH;
    private javax.swing.JTextField txtMaThuoc;
    private javax.swing.JTextField txtSdtKH;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTenThuoc;
    private javax.swing.JTextField txtThanhPhan;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTong;
    // End of variables declaration//GEN-END:variables
}
