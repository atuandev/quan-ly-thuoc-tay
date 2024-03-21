package gui.dialog;

import controller.KhachHangController;
import entities.KhachHang;
import gui.page.KhachHangPage;
import java.util.Date;
import utils.MessageDialog;
import utils.RandomGenerator;
import utils.Validation;

/**
 *
 * @author atuandev
 */
public class CreateKhachHangDialog extends javax.swing.JDialog {

    private KhachHangController KH_CON = new KhachHangController();
    private KhachHangPage KH_GUI;

    public CreateKhachHangDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public CreateKhachHangDialog(java.awt.Frame parent, boolean modal, KhachHangPage NV_GUI) {
        super(parent, modal);
        initComponents();
        this.KH_GUI = NV_GUI;
        fillInput();
    }

    private void fillInput() {
        txtNgayThamGia.setDate(new Date());
    }

    private boolean isValidateFields() {
        if (txtHoTen.getText().trim().equals("")) {
            MessageDialog.warring(this, "Họ tên không được rỗng!");
            txtHoTen.requestFocus();
            return false;
        }

        if (txtSdt.getText().trim().equals("") || !Validation.isNumber(txtSdt.getText()) || txtSdt.getText().length() != 10) {
            MessageDialog.warring(this, "Số điện thoại không được rỗng và có 10 ký tự sô!");
            txtSdt.requestFocus();
            return false;
        }

        if (txtNgayThamGia.getDate() == null || !txtNgayThamGia.getDateFormatString().equals("dd/MM/yyyy")) {
            MessageDialog.warring(this, "Ngày tham gia không được rỗng và có kiểu dd/MM/yyyy");
            return false;
        } else if (txtNgayThamGia.getDate().after(new Date())) {
            MessageDialog.warring(this, "Ngày tham gia phải trước ngày hiện tại");
            return false;
        }

        return true;
    }

    private KhachHang getInputFields() {
        String id = RandomGenerator.getRandomId();
        String hoTen = txtHoTen.getText().trim();
        String sdt = txtSdt.getText().trim();
        String gioiTinh = cboxGioiTinh.getSelectedItem().toString();
        Date ngayThamGia = txtNgayThamGia.getDate();

        return new KhachHang(id, hoTen, sdt, gioiTinh, ngayThamGia);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        lblDialog = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lblHoTen = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cboxGioiTinh = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtNgayThamGia = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 600));

        jPanel15.setBackground(new java.awt.Color(0, 153, 153));
        jPanel15.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel15.setPreferredSize(new java.awt.Dimension(500, 50));
        jPanel15.setLayout(new java.awt.BorderLayout());

        lblDialog.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        lblDialog.setForeground(new java.awt.Color(255, 255, 255));
        lblDialog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDialog.setText("THÊM KHÁCH HÀNG");
        jPanel15.add(lblDialog, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel15, java.awt.BorderLayout.NORTH);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 16));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        lblHoTen.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblHoTen.setText("Họ tên");
        lblHoTen.setMaximumSize(new java.awt.Dimension(44, 40));
        lblHoTen.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel18.add(lblHoTen);

        txtHoTen.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtHoTen.setToolTipText("");
        txtHoTen.setPreferredSize(new java.awt.Dimension(330, 40));
        jPanel18.add(txtHoTen);

        jPanel1.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel12.setText("Số điện thoại");
        jLabel12.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel12.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel19.add(jLabel12);

        txtSdt.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtSdt.setPreferredSize(new java.awt.Dimension(330, 40));
        jPanel19.add(txtSdt);

        jPanel1.add(jPanel19);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel14.setText("Giới tính");
        jLabel14.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel14.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel21.add(jLabel14);

        cboxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cboxGioiTinh.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel21.add(cboxGioiTinh);

        jPanel1.add(jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel15.setText("Ngày tham gia");
        jLabel15.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel15.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel22.add(jLabel15);

        txtNgayThamGia.setBackground(new java.awt.Color(255, 255, 255));
        txtNgayThamGia.setDateFormatString("dd/MM/yyyy");
        txtNgayThamGia.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel22.add(txtNgayThamGia);

        jPanel1.add(jPanel22);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

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

        btnAdd.setBackground(new java.awt.Color(0, 204, 102));
        btnAdd.setFont(new java.awt.Font("Roboto Mono Medium", 0, 16)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("THÊM");
        btnAdd.setBorderPainted(false);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setFocusPainted(false);
        btnAdd.setFocusable(false);
        btnAdd.setPreferredSize(new java.awt.Dimension(200, 40));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel8.add(btnAdd);

        getContentPane().add(jPanel8, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (isValidateFields()) {
            KhachHang nv = getInputFields();
            KH_CON.create(nv);
            MessageDialog.info(null, "Thêm thành công!");
            KH_GUI.loadTable();
            this.dispose();
        }
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnHuy;
    private javax.swing.JComboBox<String> cboxGioiTinh;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblDialog;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JTextField txtHoTen;
    private com.toedter.calendar.JDateChooser txtNgayThamGia;
    private javax.swing.JTextField txtSdt;
    // End of variables declaration//GEN-END:variables
}
