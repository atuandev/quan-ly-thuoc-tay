package gui.dialog;

import controller.NhanVienController;
import controller.TaiKhoanController;
import controller.VaiTroController;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.VaiTro;
import gui.page.TaiKhoanPage;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import utils.BCrypt;
import utils.MessageDialog;
import utils.RandomGenerator;

/**
 *
 * @author atuandev
 */
public class CreateTaiKhoanDialog extends javax.swing.JDialog {

    private TaiKhoanController TK_CON = new TaiKhoanController();
    private TaiKhoanPage TK_GUI;
    
    private List<NhanVien> listNV = new NhanVienController().getAllList();
    private List<VaiTro> listVT = new VaiTroController().getAllList();

    public CreateTaiKhoanDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public CreateTaiKhoanDialog(java.awt.Frame parent, boolean modal, TaiKhoanPage TK_GUI) {
        super(parent, modal);
        this.TK_GUI = TK_GUI;
        initComponents();
        fillCombobox();
    }

    private void fillCombobox() {
        for (NhanVien nv : listNV) {
            cboxNhanVien.addItem(nv.getHoTen());
        }

        for (VaiTro vt : listVT) {
            cboxVaiTro.addItem(vt.getTen());
        }
    }

    private boolean isValidateFields() {
        if (txtUsername.getText().trim().equals("")) {
            MessageDialog.warring(this, "Username không được rỗng!");
            txtUsername.requestFocus();
            return false;
        } else {
            for (TaiKhoan tk : TK_CON.getAllList()) {
                if (tk.getUsername().equals(txtUsername.getText().trim())) {
                    MessageDialog.warring(TK_GUI, "Tên đăng nhập đã tồn tại!");
                    return false;
                }
            }
        }

        if (txtPassword.getText().trim().equals("") || txtPassword.getText().length() < 6) {
            MessageDialog.warring(this, "Password không được rỗng và có ít nhất 6 ký tự!");
            txtPassword.requestFocus();
            return false;
        }

        return true;
    }

    private TaiKhoan getInputFields() {
        String id = RandomGenerator.getRandomId();
        String username = txtUsername.getText().trim();
        String password = BCrypt.hashpw(txtPassword.getText(), BCrypt.gensalt(10));
        String idNV = listNV.get(cboxNhanVien.getSelectedIndex()).getId();
        String idVT = listVT.get(cboxVaiTro.getSelectedIndex()).getId();

        return new TaiKhoan(id, username, password, new NhanVien(idNV), new VaiTro(idVT));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lblHoTen = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        Password = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jPanel21 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cboxNhanVien = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cboxVaiTro = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 600));

        jPanel15.setBackground(new java.awt.Color(0, 153, 153));
        jPanel15.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel15.setPreferredSize(new java.awt.Dimension(500, 50));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("THÊM TÀI KHOẢN");
        jPanel15.add(jLabel8, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel15, java.awt.BorderLayout.NORTH);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 16));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));

        lblHoTen.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblHoTen.setText("Username");
        lblHoTen.setMaximumSize(new java.awt.Dimension(44, 40));
        lblHoTen.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel18.add(lblHoTen);

        txtUsername.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtUsername.setToolTipText("");
        txtUsername.setPreferredSize(new java.awt.Dimension(330, 40));
        jPanel18.add(txtUsername);

        jPanel1.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));

        Password.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Password.setText("Password");
        Password.setMaximumSize(new java.awt.Dimension(44, 40));
        Password.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel19.add(Password);

        txtPassword.setPreferredSize(new java.awt.Dimension(330, 40));
        jPanel19.add(txtPassword);

        jPanel1.add(jPanel19);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel14.setText("Nhân viên");
        jLabel14.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel14.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel21.add(jLabel14);

        cboxNhanVien.setPreferredSize(new java.awt.Dimension(330, 40));
        jPanel21.add(cboxNhanVien);

        jPanel1.add(jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel15.setText("Vai trò");
        jLabel15.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel15.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel22.add(jLabel15);

        cboxVaiTro.setPreferredSize(new java.awt.Dimension(330, 40));
        jPanel22.add(cboxVaiTro);

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
            TaiKhoan tk = getInputFields();
            TK_CON.create(tk);
            TK_GUI.loadTable();
            this.dispose();
        }
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Password;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnHuy;
    private javax.swing.JComboBox<String> cboxNhanVien;
    private javax.swing.JComboBox<String> cboxVaiTro;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
