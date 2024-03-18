package gui.page;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.DanhMucController;
import controller.DonViTinhController;
import controller.ThuocController;
import controller.XuatXuController;
import entities.DanhMuc;
import entities.DonViTinh;
import entities.Thuoc;
import entities.XuatXu;
import gui.dialog.CreateThuocDialog;
import gui.dialog.DetailThuocDialog;
import gui.dialog.UpdateThuocDialog;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utils.Formatter;
import utils.JTableExporter;
import utils.MessageDialog;
import utils.TableSorter;

/**
 *
 * @author atuandev
 */
public class ThuocPage extends javax.swing.JPanel {
    
    private ThuocController THUOC_CON = new ThuocController(this);
    private List<Thuoc> listThuoc = THUOC_CON.getAllList();
    
    private final List<DonViTinh> listDVT = new DonViTinhController().getAllList();
    private final List<XuatXu> listXX = new XuatXuController().getAllList();
    private final List<DanhMuc> listDM = new DanhMucController().getAllList();

    DefaultTableModel modal;

    public ThuocPage() {
        initComponents();
        headerLayout();
        tableLayout();
        fillCombobox();
    }

    private void headerLayout() {
        List<JButton> listButton = new ArrayList<>();
        listButton.add(btnAdd);
        listButton.add(btnUpdate);
        listButton.add(btnDelete);
        listButton.add(btnInfo);
        listButton.add(btnImport);
        listButton.add(btnExport);

        // Border radius
        for (JButton item : listButton) {
            item.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        }
        btnReload.putClientProperty(FlatClientProperties.STYLE, "arc: 15");

        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tìm kiếm...");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("./icon/search.svg"));

        String[] searchType = {"Tất cả", "Mã", "Tên"};
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(searchType);
        cboxSearch.setModel(model);
    }

    private void tableLayout() {
        lblTable.setText("danh sách thông tin thuốc".toUpperCase());
        String[] header = new String[]{"STT", "Mã thuốc", "Tên thuốc", "Danh mục", "Xuất xứ", "Đơn vị tính", "Số lượng", "Giá nhập", "Đơn giá"};
        modal = new DefaultTableModel();
        modal.setColumnIdentifiers(header);
        table.setModel(modal);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        table.setDefaultRenderer(Object.class, centerRenderer);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);

        loadTable(listThuoc);
        sortTable();
    }

    private void sortTable() {
        table.setAutoCreateRowSorter(true);
        TableSorter.configureTableColumnSorter(table, 0, TableSorter.STRING_COMPARATOR);
    }

    public void loadTable(List<Thuoc> list) {
        modal.setRowCount(0);

        listThuoc = list;
        int stt = 1;
        for (Thuoc e : listThuoc) {
            modal.addRow(new Object[]{String.valueOf(stt), e.getId(), e.getTenThuoc(), e.getDanhMuc().getTen(), e.getXuatXu().getTen(), e.getDonViTinh().getTen(),
                e.getSoLuongTon(), Formatter.FormatVND(e.getGiaNhap()), Formatter.FormatVND(e.getDonGia())});
            stt++;
        }
    }

    private void fillCombobox() {
        cboxDonViTinh.addItem("Tất cả");
        for (DonViTinh e : listDVT) {
            cboxDonViTinh.addItem(e.getTen());
        }

        cboxXuatXu.addItem("Tất cả");
        for (XuatXu e : listXX) {
            cboxXuatXu.addItem(e.getTen());
        }

        cboxDanhMuc.addItem("Tất cả");
        for (DanhMuc e : listDM) {
            cboxDanhMuc.addItem(e.getTen());
        }
    }

    private List<Thuoc> getListFilter() {
        String tenDM = "";
        String tenDVT = "";
        String tenXX = "";

        // Check if selected item is not null before converting to string
        if (cboxDanhMuc.getSelectedItem() != null) {
            tenDM = cboxDanhMuc.getSelectedItem().toString();
        }
        if (cboxDonViTinh.getSelectedItem() != null) {
            tenDVT = cboxDonViTinh.getSelectedItem().toString();
        }
        if (cboxXuatXu.getSelectedItem() != null) {
            tenXX = cboxXuatXu.getSelectedItem().toString();
        }

        return THUOC_CON.getFilterTable(tenDM, tenDVT, tenXX);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cboxSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnReload = new javax.swing.JButton();
        actionPanel = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        lblTable = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboxDanhMuc = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboxXuatXu = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboxDonViTinh = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(230, 245, 245));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 245, 245), 6, true));
        setMinimumSize(new java.awt.Dimension(1130, 800));
        setPreferredSize(new java.awt.Dimension(1130, 800));
        setLayout(new java.awt.BorderLayout(0, 10));

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));
        headerPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(232, 232, 232), 2, true));
        headerPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(590, 100));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 16, 24));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(370, 50));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING));

        cboxSearch.setToolTipText("");
        cboxSearch.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel3.add(cboxSearch);

        txtSearch.setToolTipText("Tìm kiếm");
        txtSearch.setPreferredSize(new java.awt.Dimension(200, 40));
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

        jPanel1.add(jPanel3);

        headerPanel.add(jPanel1, java.awt.BorderLayout.CENTER);

        actionPanel.setBackground(new java.awt.Color(255, 255, 255));
        actionPanel.setPreferredSize(new java.awt.Dimension(600, 100));
        actionPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 5));

        btnAdd.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnAdd.setIcon(new FlatSVGIcon("./icon/add.svg"));
        btnAdd.setText("THÊM");
        btnAdd.setBorder(null);
        btnAdd.setBorderPainted(false);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setFocusPainted(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setPreferredSize(new java.awt.Dimension(90, 90));
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        actionPanel.add(btnAdd);

        btnUpdate.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnUpdate.setIcon(new FlatSVGIcon("./icon/update.svg"));
        btnUpdate.setText("SỬA");
        btnUpdate.setBorder(null);
        btnUpdate.setBorderPainted(false);
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setFocusPainted(false);
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.setPreferredSize(new java.awt.Dimension(90, 90));
        btnUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        actionPanel.add(btnUpdate);

        btnDelete.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnDelete.setIcon(new FlatSVGIcon("./icon/delete.svg"));
        btnDelete.setText("XÓA");
        btnDelete.setBorder(null);
        btnDelete.setBorderPainted(false);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setFocusPainted(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setPreferredSize(new java.awt.Dimension(90, 90));
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        actionPanel.add(btnDelete);

        btnInfo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnInfo.setIcon(new FlatSVGIcon("./icon/info.svg"));
        btnInfo.setText("INFO");
        btnInfo.setBorder(null);
        btnInfo.setBorderPainted(false);
        btnInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInfo.setFocusPainted(false);
        btnInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInfo.setPreferredSize(new java.awt.Dimension(90, 90));
        btnInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });
        actionPanel.add(btnInfo);

        btnImport.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnImport.setIcon(new FlatSVGIcon("./icon/import.svg"));
        btnImport.setText("IMPORT");
        btnImport.setBorder(null);
        btnImport.setBorderPainted(false);
        btnImport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImport.setFocusPainted(false);
        btnImport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImport.setPreferredSize(new java.awt.Dimension(90, 90));
        btnImport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });
        actionPanel.add(btnImport);

        btnExport.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnExport.setIcon(new FlatSVGIcon("./icon/export.svg"));
        btnExport.setText("EXPORT");
        btnExport.setBorder(null);
        btnExport.setBorderPainted(false);
        btnExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExport.setFocusPainted(false);
        btnExport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExport.setPreferredSize(new java.awt.Dimension(90, 90));
        btnExport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        actionPanel.add(btnExport);

        headerPanel.add(actionPanel, java.awt.BorderLayout.WEST);

        add(headerPanel, java.awt.BorderLayout.PAGE_START);

        tablePanel.setBackground(new java.awt.Color(243, 243, 243));
        tablePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 2, true));
        tablePanel.setLayout(new java.awt.BorderLayout(2, 0));

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
        table.setFocusable(false);
        table.setRowHeight(40);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        tablePanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel5.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel5.setLayout(new java.awt.BorderLayout());

        lblTable.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        lblTable.setForeground(new java.awt.Color(255, 255, 255));
        lblTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTable.setText("THÔNG TIN NHÂN VIÊN");
        jPanel5.add(lblTable, java.awt.BorderLayout.CENTER);

        tablePanel.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 100));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 16));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(200, 80));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 16, 8));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Danh mục thuốc");
        jLabel3.setPreferredSize(new java.awt.Dimension(140, 20));
        jPanel8.add(jLabel3);

        cboxDanhMuc.setToolTipText("");
        cboxDanhMuc.setPreferredSize(new java.awt.Dimension(170, 40));
        cboxDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxDanhMucActionPerformed(evt);
            }
        });
        jPanel8.add(cboxDanhMuc);

        jPanel4.add(jPanel8);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 80));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 16, 8));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("Xuất xứ");
        jLabel1.setPreferredSize(new java.awt.Dimension(140, 20));
        jPanel6.add(jLabel1);

        cboxXuatXu.setToolTipText("");
        cboxXuatXu.setPreferredSize(new java.awt.Dimension(170, 40));
        cboxXuatXu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxXuatXuActionPerformed(evt);
            }
        });
        jPanel6.add(cboxXuatXu);

        jPanel4.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 80));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 16, 8));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Đơn vị tính");
        jLabel2.setPreferredSize(new java.awt.Dimension(140, 20));
        jPanel7.add(jLabel2);

        cboxDonViTinh.setToolTipText("");
        cboxDonViTinh.setPreferredSize(new java.awt.Dimension(170, 40));
        cboxDonViTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxDonViTinhActionPerformed(evt);
            }
        });
        jPanel7.add(cboxDonViTinh);

        jPanel4.add(jPanel7);

        tablePanel.add(jPanel4, java.awt.BorderLayout.LINE_START);

        add(tablePanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        CreateThuocDialog dialog = new CreateThuocDialog(null, true, this);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            int row = table.getSelectedRow();
            String id = table.getValueAt(row, 1).toString();
            Thuoc thuoc = THUOC_CON.selectById(id);

            UpdateThuocDialog dialog = new UpdateThuocDialog(null, true, this, thuoc);
            dialog.setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            MessageDialog.error(this, "Vui lòng chọn dòng cần thực hiện!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int row = table.getSelectedRow();
            String id = table.getValueAt(row, 1).toString();

            if (MessageDialog.confirm(this, "Bạn có chắc chắn xóa dòng này?", "Xóa")) {
                THUOC_CON.deleteById(id);
                MessageDialog.info(this, "Xóa thành công!");
                modal.removeRow(row);
            }
        } catch (Exception e) {
            MessageDialog.error(this, "Vui lòng chọn dòng cần thực hiện!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        THUOC_CON.importExcel();
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        JTableExporter.exportJTableToExcel(table);
    }//GEN-LAST:event_btnExportActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        modal.setRowCount(0);

        String search = txtSearch.getText().toLowerCase().trim();
        String searchType = cboxSearch.getSelectedItem().toString();
        List<Thuoc> listsearch = THUOC_CON.getSearchTable(search, searchType);

        loadTable(listsearch);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        txtSearch.setText("");
        cboxSearch.setSelectedIndex(0);
        cboxDanhMuc.setSelectedIndex(0);
        cboxDonViTinh.setSelectedIndex(0);
        cboxXuatXu.setSelectedIndex(0);
        loadTable(listThuoc);
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        try {
            int row = table.getSelectedRow();
            String id = table.getValueAt(row, 1).toString();
            Thuoc thuoc = THUOC_CON.selectById(id);

            DetailThuocDialog dialog = new DetailThuocDialog(null, true, this, thuoc);
            dialog.setVisible(true);
        } catch (Exception e) {
            MessageDialog.error(this, "Vui lòng chọn dòng cần thực hiện!");
        }
    }//GEN-LAST:event_btnInfoActionPerformed

    private void cboxXuatXuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxXuatXuActionPerformed
        modal.setRowCount(0);

        List<Thuoc> listSearch = getListFilter();

        String tenXX = cboxXuatXu.getSelectedItem().toString();
        if (tenXX.equals("Tất cả")) {
            listSearch = THUOC_CON.getAllList();
        }

        loadTable(listSearch);
    }//GEN-LAST:event_cboxXuatXuActionPerformed

    private void cboxDonViTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxDonViTinhActionPerformed
        modal.setRowCount(0);

        List<Thuoc> listSearch = getListFilter();

        String tenDVT = cboxDonViTinh.getSelectedItem().toString();
        if (tenDVT.equals("Tất cả")) {
            listSearch = THUOC_CON.getAllList();
        }

        loadTable(listSearch);
    }//GEN-LAST:event_cboxDonViTinhActionPerformed

    private void cboxDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxDanhMucActionPerformed
        modal.setRowCount(0);

        List<Thuoc> listSearch = getListFilter();

        String tenDM = cboxDanhMuc.getSelectedItem().toString();
        if (tenDM.equals("Tất cả")) {
            listSearch = THUOC_CON.getAllList();
        }

        loadTable(listSearch);
    }//GEN-LAST:event_cboxDanhMucActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboxDanhMuc;
    private javax.swing.JComboBox<String> cboxDonViTinh;
    private javax.swing.JComboBox<String> cboxSearch;
    private javax.swing.JComboBox<String> cboxXuatXu;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTable;
    private javax.swing.JTable table;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
