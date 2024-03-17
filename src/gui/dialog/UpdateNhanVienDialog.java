package gui.dialog;

import controller.NhanVienController;
import entities.NhanVien;
import gui.page.NhanVienPage;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import utils.MessageDialog;
import utils.Validation;

/**
 *
 * @author atuandev
 */
public class UpdateNhanVienDialog extends javax.swing.JDialog {

    private NhanVienController NV_CON = new NhanVienController();
    private NhanVienPage NV_GUI;
    private NhanVien nv;

    public UpdateNhanVienDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public UpdateNhanVienDialog(java.awt.Frame parent, boolean modal, NhanVienPage NV_GUI, NhanVien nv) {
        super(parent, modal);
        initComponents();
        this.NV_GUI = NV_GUI;
        this.nv = nv;
        fillInput();
    }

    private void fillInput() {
        txtHoTen.setText(nv.getHoTen());
        txtSdt.setText(nv.getSdt());
        txtNamSinh.setText(String.valueOf(nv.getNamSinh()));
        cboxGioiTinh.setSelectedItem(nv.getGioiTinh());
        txtNgayVaoLam.setDate(nv.getNgayVaoLam());
    }

    private boolean isValidateFields() {
        if (txtHoTen.getText().trim().equals("")) {
            MessageDialog.warring(this, "Tên nhân viên không được rỗng!");
            txtHoTen.requestFocus();
            return false;
        }

        if (txtSdt.getText().trim().equals("") || !Validation.isNumber(txtSdt.getText()) || txtSdt.getText().length() != 10) {
            MessageDialog.warring(this, "Số điện thoại không được rỗng và có 10 ký tự sô!");
            txtSdt.requestFocus();
            return false;
        }

        if (txtNamSinh.getText().trim().equals("")) {
            MessageDialog.warring(this, "Năm sinh không được rỗng!");
            txtNamSinh.requestFocus();
            return false;
        } else {
            try {
                int namSinh = Integer.parseInt(txtNamSinh.getText());
                int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
                if (!(namSinh >= 1900 && namSinh <= namHienTai)) {
                    MessageDialog.warring(this, "Năm sinh phải >= 1900 và <= " + namHienTai);
                    txtNamSinh.requestFocus();
                    return false;
                } else if (namHienTai - namSinh < 18) {
                    MessageDialog.warring(this, "Nhân viên phải đủ 18 tuổi");
                    txtNamSinh.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                MessageDialog.warring(this, "Năm sinh phải có 4 ký tự số!");
                txtNamSinh.requestFocus();
                return false;
            }
        }

        if (txtNgayVaoLam.getDate() == null || !txtNgayVaoLam.getDateFormatString().equals("dd/MM/yyyy")) {
            MessageDialog.warring(this, "Ngày vào làm không được rỗng và có kiểu dd/MM/yyyy");
            return false;
        } else if (txtNgayVaoLam.getDate().after(new Date())) {
            MessageDialog.warring(this, "Ngày vào làm phải trước ngày hiện tại");
            return false;
        }

        return true;
    }

    private NhanVien getInputFields() {
        String id = nv.getId();
        String hoTen = txtHoTen.getText().trim();
        String sdt = txtSdt.getText().trim();
        String gioiTinh = cboxGioiTinh.getSelectedItem().toString();
        int namSinh = Integer.parseInt(txtNamSinh.getText().trim());
        Date ngayVaoLam = txtNgayVaoLam.getDate();

        return new NhanVien(id, hoTen, sdt, gioiTinh, namSinh, ngayVaoLam);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lblHoTen = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtNamSinh = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cboxGioiTinh = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtNgayVaoLam = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 600));

        jPanel15.setBackground(new java.awt.Color(0, 153, 153));
        jPanel15.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel15.setPreferredSize(new java.awt.Dimension(500, 50));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CẬP NHẬP NHÂN VIÊN");
        jPanel15.add(jLabel8, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel15, java.awt.BorderLayout.NORTH);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 16));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));

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
        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel12.setText("Số điện thoại");
        jLabel12.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel12.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel19.add(jLabel12);

        txtSdt.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtSdt.setPreferredSize(new java.awt.Dimension(330, 40));
        jPanel19.add(txtSdt);

        jPanel1.add(jPanel19);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel13.setText("Năm sinh");
        jLabel13.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel13.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel20.add(jLabel13);

        txtNamSinh.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNamSinh.setPreferredSize(new java.awt.Dimension(330, 40));
        jPanel20.add(txtNamSinh);

        jPanel1.add(jPanel20);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));

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
        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel15.setText("Ngày vào làm");
        jLabel15.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel15.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel22.add(jLabel15);

        txtNgayVaoLam.setBackground(new java.awt.Color(255, 255, 255));
        txtNgayVaoLam.setDateFormatString("dd/MM/yyyy");
        txtNgayVaoLam.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel22.add(txtNgayVaoLam);

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

        btnUpdate.setBackground(new java.awt.Color(0, 204, 102));
        btnUpdate.setFont(new java.awt.Font("Roboto Mono Medium", 0, 16)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("CẬP NHẬP");
        btnUpdate.setBorderPainted(false);
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setFocusPainted(false);
        btnUpdate.setFocusable(false);
        btnUpdate.setPreferredSize(new java.awt.Dimension(200, 40));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel8.add(btnUpdate);

        getContentPane().add(jPanel8, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (isValidateFields()) {
            NhanVien nv = getInputFields();
            NV_CON.update(nv);
            NV_GUI.loadTable();
            this.dispose();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboxGioiTinh;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNamSinh;
    private com.toedter.calendar.JDateChooser txtNgayVaoLam;
    private javax.swing.JTextField txtSdt;
    // End of variables declaration//GEN-END:variables
}
