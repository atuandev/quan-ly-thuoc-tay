package gui.dialog;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.DanhMucController;
import controller.DonViTinhController;
import controller.XuatXuController;
import entities.DanhMuc;
import entities.DonViTinh;
import entities.Thuoc;
import entities.XuatXu;
import gui.page.ThuocPage;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author atuandev
 */
public class DetailThuocDialog extends javax.swing.JDialog {

    private byte[] thuocImage;
    private Thuoc thuoc;

    public DetailThuocDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public DetailThuocDialog(java.awt.Frame parent, boolean modal, Thuoc thuoc) {
        super(parent, modal);
        initComponents();
        this.thuoc = thuoc;
        fillInput();
        fillCombobox();
    }

    private void fillCombobox() {
        List<DanhMuc> listDM = new DanhMucController().getAllList();
        for (DanhMuc vt : listDM) {
            cboxDanhMuc.addItem(vt.getTen());
        }

        List<DonViTinh> listDVT = new DonViTinhController().getAllList();
        for (DonViTinh vt : listDVT) {
            cboxDonViTinh.addItem(vt.getTen());
        }

        List<XuatXu> listXX = new XuatXuController().getAllList();
        for (XuatXu vt : listXX) {
            cboxXuatXu.addItem(vt.getTen());
        }
    }

    private void fillInput() {
        txtTenThuoc.setText(thuoc.getTenThuoc());
        thuocImage = thuoc.getHinhAnh();
        ImageIcon imageIcon = new ImageIcon(
                new ImageIcon(thuocImage).getImage().getScaledInstance(txtHinhAnh.getWidth(), txtHinhAnh.getHeight(), Image.SCALE_SMOOTH));
        txtHinhAnh.setIcon(imageIcon);
        txtThanhPhan.setText(thuoc.getThanhPhan());
        cboxDanhMuc.setSelectedItem(thuoc.getDanhMuc().getTen());
        cboxDonViTinh.setSelectedItem(thuoc.getDonViTinh().getTen());
        cboxXuatXu.setSelectedItem(thuoc.getXuatXu().getTen());
        txtSoLuong.setText(String.valueOf(thuoc.getSoLuongTon()));
        txtGiaNhap.setText(String.valueOf(thuoc.getGiaNhap()));
        txtDonGia.setText(String.valueOf(thuoc.getDonGia()));
        txtHanSuDung.setDate(thuoc.getHanSuDung());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtHinhAnh = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lblHoTen = new javax.swing.JLabel();
        txtTenThuoc = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtThanhPhan = new javax.swing.JTextArea();
        jPanel21 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cboxDanhMuc = new javax.swing.JComboBox<>();
        jPanel23 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        cboxXuatXu = new javax.swing.JComboBox<>();
        jPanel24 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cboxDonViTinh = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtHanSuDung = new com.toedter.calendar.JDateChooser();
        jPanel26 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel15.setBackground(new java.awt.Color(0, 153, 153));
        jPanel15.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel15.setPreferredSize(new java.awt.Dimension(500, 50));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CHI TIẾT THUỐC");
        jLabel8.setPreferredSize(new java.awt.Dimension(149, 40));
        jPanel15.add(jLabel8, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel15, java.awt.BorderLayout.NORTH);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 100));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 237, 237), 2, true));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 300));
        jPanel4.setLayout(new java.awt.BorderLayout());

        txtHinhAnh.setBackground(new java.awt.Color(255, 255, 255));
        txtHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtHinhAnh.setIcon(new FlatSVGIcon("./icon/image.svg"));
        txtHinhAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtHinhAnh.setPreferredSize(new java.awt.Dimension(200, 100));
        jPanel4.add(txtHinhAnh, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 16));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 470));
        jPanel1.setLayout(new java.awt.GridLayout(5, 2, 16, 8));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        lblHoTen.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblHoTen.setText("Tên thuốc");
        lblHoTen.setMaximumSize(new java.awt.Dimension(44, 40));
        lblHoTen.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel18.add(lblHoTen);

        txtTenThuoc.setEditable(false);
        txtTenThuoc.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTenThuoc.setToolTipText("");
        txtTenThuoc.setEnabled(false);
        txtTenThuoc.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel18.add(txtTenThuoc);

        jPanel1.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel12.setText("Thành phần");
        jLabel12.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel12.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel19.add(jLabel12);

        jScrollPane1.setMaximumSize(new java.awt.Dimension(300, 70));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 70));

        txtThanhPhan.setEditable(false);
        txtThanhPhan.setColumns(20);
        txtThanhPhan.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtThanhPhan.setLineWrap(true);
        txtThanhPhan.setRows(4);
        txtThanhPhan.setEnabled(false);
        jScrollPane1.setViewportView(txtThanhPhan);

        jPanel19.add(jScrollPane1);

        jPanel1.add(jPanel19);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel14.setText("Danh mục");
        jLabel14.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel14.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel21.add(jLabel14);

        cboxDanhMuc.setEnabled(false);
        cboxDanhMuc.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel21.add(cboxDanhMuc);

        jPanel1.add(jPanel21);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel23.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel16.setText("Xuất xứ");
        jLabel16.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel16.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel23.add(jLabel16);

        cboxXuatXu.setEnabled(false);
        cboxXuatXu.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel23.add(cboxXuatXu);

        jPanel1.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel24.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel17.setText("Đơn vị tính");
        jLabel17.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel17.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel24.add(jLabel17);

        cboxDonViTinh.setEnabled(false);
        cboxDonViTinh.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel24.add(cboxDonViTinh);

        jPanel1.add(jPanel24);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel15.setText("Hạn sử dụng");
        jLabel15.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel15.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel22.add(jLabel15);

        txtHanSuDung.setBackground(new java.awt.Color(255, 255, 255));
        txtHanSuDung.setDateFormatString("dd/MM/yyyy");
        txtHanSuDung.setEnabled(false);
        txtHanSuDung.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel22.add(txtHanSuDung);

        jPanel1.add(jPanel22);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel26.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel19.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel19.setText("Giá nhập");
        jLabel19.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel19.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel26.add(jLabel19);

        txtGiaNhap.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtGiaNhap.setEnabled(false);
        txtGiaNhap.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel26.add(txtGiaNhap);

        jPanel1.add(jPanel26);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel25.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel18.setText("Đơn giá");
        jLabel18.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel18.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel25.add(jLabel18);

        txtDonGia.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDonGia.setEnabled(false);
        txtDonGia.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel25.add(txtDonGia);

        jPanel1.add(jPanel25);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel13.setText("Số lượng");
        jLabel13.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel13.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel20.add(jLabel13);

        txtSoLuong.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtSoLuong.setEnabled(false);
        txtSoLuong.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel20.add(txtSoLuong);

        jPanel1.add(jPanel20);

        jPanel2.add(jPanel1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 5));

        btnHuy.setBackground(new java.awt.Color(255, 102, 102));
        btnHuy.setFont(new java.awt.Font("Roboto Mono Medium", 0, 16)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("HỦY BỎ");
        btnHuy.setBorderPainted(false);
        btnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuy.setFocusPainted(false);
        btnHuy.setFocusable(false);
        btnHuy.setPreferredSize(new java.awt.Dimension(200, 40));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel8.add(btnHuy);

        getContentPane().add(jPanel8, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JComboBox<String> cboxDanhMuc;
    private javax.swing.JComboBox<String> cboxDonViTinh;
    private javax.swing.JComboBox<String> cboxXuatXu;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGiaNhap;
    private com.toedter.calendar.JDateChooser txtHanSuDung;
    private javax.swing.JLabel txtHinhAnh;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenThuoc;
    private javax.swing.JTextArea txtThanhPhan;
    // End of variables declaration//GEN-END:variables
}
