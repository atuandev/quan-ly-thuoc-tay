package gui.dialog;

import controller.NhanVienController;
import controller.TaiKhoanController;
import controller.VaiTroController;
import entities.NhanVien;
import entities.TaiKhoan;
import entities.VaiTro;
import gui.page.TaiKhoanPage;
import java.util.List;
import utils.MessageDialog;

/**
 *
 * @author atuandev
 */
public class UpdateTaiKhoanDialog extends javax.swing.JDialog {

    private TaiKhoanController TK_CON = new TaiKhoanController();
    private TaiKhoanPage TK_GUI;
    private TaiKhoan tk;

    private final List<NhanVien> listNV = new NhanVienController().getAllList();
    private final List<VaiTro> listVT = new VaiTroController().getAllList();

    public UpdateTaiKhoanDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public UpdateTaiKhoanDialog(java.awt.Frame parent, boolean modal, TaiKhoanPage TK_GUI, TaiKhoan tk) {
        super(parent, modal);
        initComponents();
        this.TK_GUI = TK_GUI;
        this.tk = tk;
        fillCombobox();
        fillInput();
    }

    private void fillCombobox() {
        for (NhanVien nv : listNV) {
            cboxNhanVien.addItem(nv.getHoTen());
        }

        for (VaiTro vt : listVT) {
            if (!vt.getId().equals("admin")) {
                cboxVaiTro.addItem(vt.getTen());
            }
        }
    }

    private void fillInput() {
        txtUsername.setText(tk.getUsername());
        cboxNhanVien.setSelectedItem(tk.getNhanVien().getHoTen());
        cboxVaiTro.setSelectedItem(tk.getVaiTro().getTen());
    }

    private boolean isValidateFields() {
        if (txtUsername.getText().trim().equals("") || txtUsername.getText().length() < 3) {
            MessageDialog.warring(this, "Username không được để trống và có ít nhất 3 ký tự!");
            txtUsername.requestFocus();
            return false;
        }

        return true;
    }

    private TaiKhoan getInputFields() {
        String id = tk.getId();
        String username = tk.getUsername();
        String password = tk.getPassword();
        String idNV = tk.getNhanVien().getId();
        NhanVien nhanVien = new NhanVienController().selectById(idNV);
        String idVT = listVT.get(cboxVaiTro.getSelectedIndex() + 1).getId();
        VaiTro vaiTro = new VaiTroController().selectById(idVT);

        return new TaiKhoan(id, username, password, nhanVien, vaiTro);
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
        jPanel21 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cboxNhanVien = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cboxVaiTro = new javax.swing.JComboBox<>();
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
        jLabel8.setText("CẬP NHẬP TÀI KHOẢN");
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

        txtUsername.setEditable(false);
        txtUsername.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtUsername.setToolTipText("");
        txtUsername.setFocusable(false);
        txtUsername.setPreferredSize(new java.awt.Dimension(330, 40));
        jPanel18.add(txtUsername);

        jPanel1.add(jPanel18);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel14.setText("Nhân viên");
        jLabel14.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel14.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel21.add(jLabel14);

        cboxNhanVien.setEnabled(false);
        cboxNhanVien.setFocusable(false);
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

        btnUpdate.setBackground(new java.awt.Color(0, 204, 102));
        btnUpdate.setFont(new java.awt.Font("Roboto Mono Medium", 0, 16)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Cập nhập");
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
            TaiKhoan e = getInputFields();
            TK_CON.update(e);
            MessageDialog.info(this, "Cập nhập thành công!");
            TK_GUI.loadTable(TK_CON.getAllList());
            this.dispose();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboxNhanVien;
    private javax.swing.JComboBox<String> cboxVaiTro;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
