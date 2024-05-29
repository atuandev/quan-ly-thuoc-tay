package gui.dialog;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.DanhMucController;
import entities.DanhMuc;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utils.MessageDialog;
import utils.RandomGenerator;
import utils.TableSorter;

/**
 *
 * @author atuandev
 */
public class ThuocTinhDanhMucDialog extends javax.swing.JDialog {

    private DanhMucController DM_CON = new DanhMucController(this);

    public ThuocTinhDanhMucDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        searchLayout();
        tableLayout();
    }

    private void searchLayout() {
        btnReload.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tìm kiếm...");

        String[] searchType = {"Tất cả", "Mã", "Tên"};
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(searchType);
        cboxSearch.setModel(model);
    }

    private void tableLayout() {
        String[] header = new String[]{"STT", "Mã danh mục thuốc", "Tên danh mục thuốc"};

        DefaultTableModel modal = new DefaultTableModel();
        modal.setColumnIdentifiers(header);
        table.setModel(modal);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        table.setDefaultRenderer(Object.class, centerRenderer);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);

        loadTable();
        sortTable();
    }

    private void sortTable() {
        table.setAutoCreateRowSorter(true);
        TableSorter.configureTableColumnSorter(table, 0, TableSorter.STRING_COMPARATOR);
    }

    public void loadTable() {
        DefaultTableModel modal = (DefaultTableModel) table.getModel();
        modal.setRowCount(0);

        List<DanhMuc> list = DM_CON.getAllList();
        int stt = 1;
        for (DanhMuc e : list) {
            modal.addRow(new Object[]{String.valueOf(stt), e.getId(), e.getTen()});
            stt++;
        }
    }

    private boolean isValidateFields() {
        if (txtTenDVT.getText().trim().equals("")) {
            MessageDialog.warring(this, "Tên danh mục không được rỗng!");
            txtTenDVT.requestFocus();
            return false;
        }

        return true;
    }

    private DanhMuc getInputFields() {
        String id = RandomGenerator.getRandomId();
        String ten = txtTenDVT.getText().trim();

        return new DanhMuc(id, ten);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lblTenDVT = new javax.swing.JLabel();
        txtTenDVT = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cboxSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnReload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnRemove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel15.setBackground(new java.awt.Color(0, 153, 153));
        jPanel15.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel15.setPreferredSize(new java.awt.Dimension(500, 50));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DANH MỤC THUỐC");
        jPanel15.add(jLabel8, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel15, java.awt.BorderLayout.NORTH);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 16));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));

        lblTenDVT.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblTenDVT.setText("Tên danh mục thuốc");
        lblTenDVT.setMaximumSize(new java.awt.Dimension(44, 40));
        lblTenDVT.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel18.add(lblTenDVT);

        txtTenDVT.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTenDVT.setToolTipText("");
        txtTenDVT.setPreferredSize(new java.awt.Dimension(330, 40));
        jPanel18.add(txtTenDVT);

        jPanel1.add(jPanel18);

        jSeparator1.setPreferredSize(new java.awt.Dimension(460, 3));
        jPanel1.add(jSeparator1);

        jPanel2.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 48));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        cboxSearch.setToolTipText("");
        cboxSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cboxSearch.setPreferredSize(new java.awt.Dimension(80, 32));
        jPanel3.add(cboxSearch);

        txtSearch.setToolTipText("Tìm kiếm");
        txtSearch.setPreferredSize(new java.awt.Dimension(140, 36));
        txtSearch.setSelectionColor(new java.awt.Color(230, 245, 245));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel3.add(txtSearch);

        btnReload.setIcon(new FlatSVGIcon("./icon/reload.svg"));
        btnReload.setToolTipText("Làm mới");
        btnReload.setBorder(null);
        btnReload.setBorderPainted(false);
        btnReload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReload.setFocusPainted(false);
        btnReload.setFocusable(false);
        btnReload.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReload.setPreferredSize(new java.awt.Dimension(40, 40));
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });
        jPanel3.add(btnReload);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setFocusable(false);
        table.setRowHeight(40);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setShowHorizontalLines(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 5));

        btnRemove.setBackground(new java.awt.Color(255, 102, 102));
        btnRemove.setFont(new java.awt.Font("Roboto Mono Medium", 0, 16)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("XÓA");
        btnRemove.setBorderPainted(false);
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove.setFocusPainted(false);
        btnRemove.setFocusable(false);
        btnRemove.setPreferredSize(new java.awt.Dimension(120, 40));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel8.add(btnRemove);

        btnUpdate.setBackground(new java.awt.Color(255, 204, 51));
        btnUpdate.setFont(new java.awt.Font("Roboto Mono Medium", 0, 16)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("SỬA");
        btnUpdate.setBorderPainted(false);
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setFocusPainted(false);
        btnUpdate.setFocusable(false);
        btnUpdate.setPreferredSize(new java.awt.Dimension(120, 40));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel8.add(btnUpdate);

        btnAdd.setBackground(new java.awt.Color(0, 204, 102));
        btnAdd.setFont(new java.awt.Font("Roboto Mono Medium", 0, 16)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("THÊM");
        btnAdd.setBorderPainted(false);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setFocusPainted(false);
        btnAdd.setFocusable(false);
        btnAdd.setPreferredSize(new java.awt.Dimension(120, 40));
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

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try {
            DefaultTableModel modal = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            String id = table.getValueAt(row, 1).toString();

            if (MessageDialog.confirm(this, "Bạn có chắc chắn xóa dòng này?", "Xóa")) {
                DM_CON.deleteById(id);
                MessageDialog.info(this, "Xóa thành công!");
                modal.removeRow(row);
            }
        } catch (Exception e) {
            MessageDialog.error(this, "Vui lòng chọn dòng cần thực hiện!");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (isValidateFields()) {
            DanhMuc tk = getInputFields();
            DM_CON.create(tk);
            MessageDialog.info(this, "Thêm thành công!");
            this.loadTable();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        DefaultTableModel modal = (DefaultTableModel) table.getModel();
        modal.setRowCount(0);

        String search = txtSearch.getText().toLowerCase().trim();
        String searchType = cboxSearch.getSelectedItem().toString();
        List<DanhMuc> listsearch = DM_CON.getSearchTable(search, searchType);

        int stt = 1;
        for (DanhMuc e : listsearch) {
            modal.addRow(new Object[]{String.valueOf(stt), e.getId(), e.getTen()});
            stt++;
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (isValidateFields()) {
            try {
                int row = table.getSelectedRow();
                String id = table.getValueAt(row, 1).toString();
                String ten = txtTenDVT.getText();
                DanhMuc e = new DanhMuc(id, ten);

                DM_CON.update(e);
                MessageDialog.info(this, "Sửa thành công!");
                this.loadTable();
            } catch (Exception e) {
                MessageDialog.error(this, "Vui lòng chọn dòng cần thực hiện!");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        txtTenDVT.setText("");
        txtSearch.setText("");
        cboxSearch.setSelectedIndex(0);
        loadTable();
    }//GEN-LAST:event_btnReloadActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = table.getSelectedRow();
        txtTenDVT.setText(table.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboxSearch;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTenDVT;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenDVT;
    // End of variables declaration//GEN-END:variables
}
