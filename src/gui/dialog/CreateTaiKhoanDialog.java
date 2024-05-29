package gui.dialog;

import controller.NhanVienController;
import controller.TaiKhoanController;
import controller.VaiTroController;
import entities.NhanVien;
import entities.TaiKhoan;
import entities.VaiTro;
import gui.page.TaiKhoanPage;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utils.BCrypt;
import utils.MessageDialog;
import utils.RandomGenerator;
import utils.TableSorter;
import utils.Validation;

/**
 *
 * @author atuandev
 */
public class CreateTaiKhoanDialog extends javax.swing.JDialog {

    private final TaiKhoanController TK_CON = new TaiKhoanController();
    private TaiKhoanPage TK_GUI;

    private final List<VaiTro> listVT = new VaiTroController().getAllList();

    DefaultTableModel modal;

    public CreateTaiKhoanDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public CreateTaiKhoanDialog(java.awt.Frame parent, boolean modal, TaiKhoanPage TK_GUI) {
        super(parent, modal);
        this.TK_GUI = TK_GUI;
        initComponents();
        fillCombobox();
        tableLayout();
    }

    private void fillCombobox() {
        for (VaiTro vt : listVT) {
            if (!vt.getId().equals("admin")) {
                cboxVaiTro.addItem(vt.getTen());
            }
        }
    }

    private void tableLayout() {
        String[] header = new String[]{"STT", "Mã nhân viên", "Họ tên", "Số điện thoại", "Năm sinh"};

        modal = new DefaultTableModel();
        modal.setColumnIdentifiers(header);
        tableNV.setModel(modal);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        tableNV.setDefaultRenderer(Object.class, centerRenderer);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableNV.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableNV.getColumnModel().getColumn(0).setPreferredWidth(30);
        tableNV.getColumnModel().getColumn(2).setPreferredWidth(200);

        loadTable();
        sortTable();
    }

    private void sortTable() {
        tableNV.setAutoCreateRowSorter(true);
        TableSorter.configureTableColumnSorter(tableNV, 0, TableSorter.STRING_COMPARATOR);
    }

    public void loadTable() {
        modal.setRowCount(0);

        List<NhanVien> listNV = new NhanVienController().getAllList();
        List<NhanVien> listNVInTK = TK_CON.getListNV();
        int stt = 1;
        for (NhanVien e : listNV) {
            if (!listNVInTK.contains(e)) {
                modal.addRow(new Object[]{String.valueOf(stt), e.getId(), e.getHoTen(), e.getSdt(), e.getNamSinh()});
            }
            stt++;
        }
    }

    private boolean isValidateFields() {
        for (TaiKhoan tk : TK_CON.getAllList()) {
            if (tk.getUsername().equals(txtUsername.getText().trim())) {
                MessageDialog.warring(this, "Tên đăng nhập đã tồn tại!");
                return false;
            }
        }
        
        if (Validation.isEmpty(txtUsername.getText()) || txtUsername.getText().length() < 3) {
            MessageDialog.warring(this, "Username không được để trống và có ít nhất 3 ký tự!");
            txtUsername.requestFocus();
            return false;
        }

        if (txtPassword.getText().trim().equals("") || txtPassword.getText().length() < 6) {
            MessageDialog.warring(this, "Password không được để trống và có ít nhất 6 ký tự!");
            txtPassword.requestFocus();
            return false;
        }

        if (tableNV.getSelectedRow() < 0) {
            MessageDialog.warring(this, "Vui lòng chọn nhân viên!");
            return false;
        }

        return true;
    }

    private TaiKhoan getInputFields() {
        String id = RandomGenerator.getRandomId();
        String username = txtUsername.getText().trim();
        String password = BCrypt.hashpw(txtPassword.getText(), BCrypt.gensalt(10));
        int row = tableNV.getSelectedRow();
        String idNV = tableNV.getValueAt(row, 1).toString();
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
        jPanel19 = new javax.swing.JPanel();
        Password = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cboxVaiTro = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNV = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 600));

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
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));
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

        jPanel2.setPreferredSize(new java.awt.Dimension(600, 230));
        jPanel2.setLayout(new java.awt.BorderLayout());

        tableNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"123", "Anh Tuấn", "123123", null, null, null},
                {"13124", "czczxc", "zxc", null, null, null},
                {"14123", "zxczc", "zxc", null, null, null},
                {"124123", "zxczx", "zxc", null, null, null}
            },
            new String [] {
                "Mã", "Họ tên", "Số điện thoại", "Giới tính", "Năm sinh", "Ngày vào làm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNV.setFocusable(false);
        tableNV.setRowHeight(40);
        tableNV.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableNV.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(tableNV);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);

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
            TaiKhoan e = getInputFields();
            TK_CON.create(e);
            this.dispose();
            MessageDialog.info(this, "Thêm thành công!");
            TK_GUI.loadTable(TK_CON.getAllList());
        }
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Password;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnHuy;
    private javax.swing.JComboBox<String> cboxVaiTro;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JTable tableNV;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
