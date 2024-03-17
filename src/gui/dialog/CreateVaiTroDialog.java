package gui.dialog;

import controller.VaiTroController;
import entities.VaiTro;
import gui.page.VaiTroPage;
import java.util.List;
import utils.MessageDialog;

/**
 *
 * @author atuandev
 */
public class CreateVaiTroDialog extends javax.swing.JDialog {

    private VaiTroController VT_CON = new VaiTroController();
    private VaiTroPage VT_GUI;

    public CreateVaiTroDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public CreateVaiTroDialog(java.awt.Frame parent, boolean modal, VaiTroPage VT_GUI) {
        super(parent, modal);
        initComponents();
        this.VT_GUI = VT_GUI;
    }

    private boolean isValidateFields() {
        if (txtId.getText().trim().equals("")) {
            MessageDialog.warring(this, "Mã vai trò không được rỗng!");
            txtId.requestFocus();
            return false;
        } else {
            List<VaiTro> listVT = VT_CON.getAllList();
            for (VaiTro vt : listVT) {
                if (vt.getId().equals(txtId.getText())) {
                    MessageDialog.warring(this, "Trùng mã!");
                    txtId.requestFocus();
                    return false;
                }
            }
        }

        if (txtTen.getText().trim().equals("")) {
            MessageDialog.warring(this, "Tên vai trò không được rỗng!");
            txtTen.requestFocus();
            return false;
        }

        return true;
    }

    private VaiTro getInputFields() {
        String id = txtId.getText().trim();
        String ten = txtTen.getText().trim();

        return new VaiTro(id, ten);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        lblmaVaiTro = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        lblHoTen = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
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
        jLabel8.setText("THÊM VAI TRÒ");
        jPanel15.add(jLabel8, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel15, java.awt.BorderLayout.NORTH);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 16));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));

        lblmaVaiTro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblmaVaiTro.setText("Mã vai trò");
        lblmaVaiTro.setMaximumSize(new java.awt.Dimension(44, 40));
        lblmaVaiTro.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel19.add(lblmaVaiTro);

        txtId.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtId.setToolTipText("");
        txtId.setPreferredSize(new java.awt.Dimension(330, 40));
        jPanel19.add(txtId);

        jPanel1.add(jPanel19);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));

        lblHoTen.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblHoTen.setText("Tên vai trò");
        lblHoTen.setMaximumSize(new java.awt.Dimension(44, 40));
        lblHoTen.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel18.add(lblHoTen);

        txtTen.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTen.setToolTipText("");
        txtTen.setPreferredSize(new java.awt.Dimension(330, 40));
        jPanel18.add(txtTen);

        jPanel1.add(jPanel18);

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
            VaiTro e = getInputFields();
            VT_CON.create(e);
            VT_GUI.loadTable();
            this.dispose();
        }
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnHuy;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblmaVaiTro;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
