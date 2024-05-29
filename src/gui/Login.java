package gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import controller.TaiKhoanController;
import entities.TaiKhoan;
import java.awt.event.KeyEvent;
import utils.BCrypt;
import utils.MessageDialog;
import utils.Validation;

/**
 *
 * @author atuandev
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        loginLayout();
    }

    public static void main(String args[]) {
        initFlatlaf();
        java.awt.EventQueue.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });
    }

    private static void initFlatlaf() {
        FlatRobotoFont.install();
        FlatLaf.setPreferredFontFamily(FlatRobotoFont.FAMILY);
        FlatLaf.setPreferredLightFontFamily(FlatRobotoFont.FAMILY_LIGHT);
        FlatLaf.setPreferredSemiboldFontFamily(FlatRobotoFont.FAMILY_SEMIBOLD);
        FlatLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
    }

    private void loginLayout() {
        txtUsername.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("./icon/username.svg"));
        txtPassword.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("./icon/password.svg"));
    }

    private boolean isValidateFields() {
        if (Validation.isEmpty(txtUsername.getText()) || Validation.isEmpty(txtPassword.getText())) {
            MessageDialog.warring(this, "Không được để trống!");
            return false;
        }

        return true;
    }

    private void authentication() {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (isValidateFields()) {
            TaiKhoan tk = new TaiKhoanController().selectByUsername(username);

            if (tk == null) {
                MessageDialog.error(this, "Tài khoản không tồn tại!");
                return;
            }

            if (username.equals(tk.getUsername()) && BCrypt.compare(password, tk.getPassword())) {
                new MainLayout(tk).setVisible(true);
                this.dispose();
            } else {
                MessageDialog.error(this, "Tài khoản hoặc mật khẩu không chính xác. Vui lòng kiểm tra lại!");
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng Nhập");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 600));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new FlatSVGIcon("./img/login.svg"));
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.WEST);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(400, 400));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(360, 600));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 16));

        logo.setFont(new java.awt.Font("Segoe Print", 1, 32)); // NOI18N
        logo.setForeground(new java.awt.Color(0, 183, 183));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo-64.png"))); // NOI18N
        logo.setText("PharmaStore");
        logo.setPreferredSize(new java.awt.Dimension(360, 120));
        jPanel4.add(logo);

        lblLogin.setFont(new java.awt.Font("Roboto Mono SemiBold", 0, 24)); // NOI18N
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("ĐĂNG NHẬP");
        lblLogin.setToolTipText("");
        lblLogin.setPreferredSize(new java.awt.Dimension(360, 60));
        jPanel4.add(lblLogin);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(360, 80));
        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        lblUsername.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        lblUsername.setText("Tài khoản");
        jPanel6.add(lblUsername);

        txtUsername.setFont(new java.awt.Font("Roboto Mono", 0, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 0));
        txtUsername.setText("admin");
        txtUsername.setPreferredSize(new java.awt.Dimension(350, 27));
        txtUsername.setSelectionColor(new java.awt.Color(0, 153, 153));
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });
        jPanel6.add(txtUsername);

        jPanel4.add(jPanel6);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(360, 80));
        jPanel3.setPreferredSize(new java.awt.Dimension(360, 80));
        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        lblPassword.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        lblPassword.setText("Mật khẩu");
        jPanel3.add(lblPassword);

        txtPassword.setFont(new java.awt.Font("Roboto Mono", 0, 14)); // NOI18N
        txtPassword.setText("123123");
        txtPassword.setPreferredSize(new java.awt.Dimension(90, 40));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        jPanel3.add(txtPassword);

        jPanel4.add(jPanel3);

        btnLogin.setBackground(new java.awt.Color(0, 204, 204));
        btnLogin.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Đăng nhập");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setFocusable(false);
        btnLogin.setPreferredSize(new java.awt.Dimension(360, 40));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel4.add(btnLogin);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        authentication();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            authentication();
        }
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            authentication();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
