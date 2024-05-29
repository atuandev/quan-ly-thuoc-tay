package gui.page;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.ChiTietHoaDonController;
import controller.HoaDonController;
import controller.NhanVienController;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.NhanVien;
import entities.TaiKhoan;
import gui.MainLayout;
import gui.dialog.DetailHoaDonDialog;
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
import utils.Validation;

/**
 *
 * @author atuandev
 */
public class HoaDonPage extends javax.swing.JPanel {

    private final HoaDonController HD_CON = new HoaDonController();
    private List<HoaDon> listHD = HD_CON.getAllList();

    private DefaultTableModel modal;
    private MainLayout main;

    public HoaDonPage() {
        initComponents();
        headerLayout();
        tableLayout();
        fillCombobox();
    }

    public HoaDonPage(MainLayout main) {
        this.main = main;
        initComponents();
        headerLayout();
        tableLayout();
        fillCombobox();
    }

    private void headerLayout() {
        List<JButton> listButton = new ArrayList<>();
        listButton.add(btnAdd);
        listButton.add(btnDelete);
        listButton.add(btnInfo);
        listButton.add(btnExport);
        listButton.add(btnReload);

        // Border radius
        for (JButton item : listButton) {
            item.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        }

        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tìm kiếm...");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("./icon/search.svg"));

        String[] searchType = {"Tất cả", "Mã", "Tên khách hàng"};
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(searchType);
        cboxSearch.setModel(model);
    }

    private void tableLayout() {
        lblTable.setText("danh sách thông tin hóa đơn".toUpperCase());
        String[] header = new String[]{"STT", "Mã hóa đơn", "Thời gian", "Tên nhân viên", "Tên khách hàng", "Tổng hóa đơn"};
        modal = new DefaultTableModel();
        modal.setColumnIdentifiers(header);
        table.setModel(modal);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        table.setDefaultRenderer(Object.class, centerRenderer);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);

        loadTable(listHD);
        sortTable();
    }

    private void sortTable() {
        table.setAutoCreateRowSorter(true);
        TableSorter.configureTableColumnSorter(table, 0, TableSorter.STRING_COMPARATOR);
    }

    public void loadTable(List<HoaDon> list) {
        modal.setRowCount(0);

        listHD = list;
        int stt = 1;

        for (HoaDon e : listHD) {
            modal.addRow(new Object[]{String.valueOf(stt), e.getId(), Formatter.FormatTime(e.getThoiGian()),
                e.getNhanVien().getHoTen(), e.getKhachHang().getHoTen(), Formatter.FormatVND(e.getTongTien())});
            stt++;
        }
    }

    private void fillCombobox() {
        List<NhanVien> listNV = new NhanVienController().getAllList();
        cboxNhanVien.addItem("Tất cả");
        for (NhanVien e : listNV) {
            cboxNhanVien.addItem(e.getHoTen());
        }
    }

    private boolean isValidFilterFields() {
        if (Validation.isEmpty(txtFromPrice.getText().trim())) {
            return false;
        } else {
            try {
                double fromPrice = Double.parseDouble(txtFromPrice.getText());
                if (fromPrice < 0) {
                    MessageDialog.warring(this, "Số tiền phải >= 0");
                    txtFromPrice.setText("");
                    txtFromPrice.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                MessageDialog.warring(this, "Số tiền phải là số!");
                txtFromPrice.setText("");
                txtFromPrice.requestFocus();
                return false;
            }
        }

        if (Validation.isEmpty(txtToPrice.getText().trim())) {
            return false;
        } else {
            try {
                double toPrice = Double.parseDouble(txtToPrice.getText());
                if (toPrice < 0) {
                    MessageDialog.warring(this, "Số tiền phải >= 0");
                    txtToPrice.setText("");
                    txtToPrice.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                MessageDialog.warring(this, "Số tiền phải là số!");
                txtToPrice.setText("");
                txtToPrice.requestFocus();
                return false;
            }
        }

        return true;
    }

    private List<HoaDon> getListFilter() {
        String tenNV = "";

        // Check if selected item is not null before converting to string
        if (cboxNhanVien.getSelectedItem() != null) {
            tenNV = cboxNhanVien.getSelectedItem().toString();
        }

        double fromPrice = isValidFilterFields() ? Double.parseDouble(txtFromPrice.getText()) : 0;
        double toPrice = isValidFilterFields() ? Double.parseDouble(txtToPrice.getText()) : 0;
        
        return HD_CON.getFilterTable(tenNV, fromPrice, toPrice);
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
        btnDelete = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        lblTable = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboxNhanVien = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtFromPrice = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtToPrice = new javax.swing.JTextField();

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
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 8));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(200, 80));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 16, 8));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Tên nhân viên");
        jLabel3.setPreferredSize(new java.awt.Dimension(140, 20));
        jPanel8.add(jLabel3);

        cboxNhanVien.setToolTipText("");
        cboxNhanVien.setPreferredSize(new java.awt.Dimension(170, 40));
        cboxNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxNhanVienActionPerformed(evt);
            }
        });
        jPanel8.add(cboxNhanVien);

        jPanel4.add(jPanel8);

        jSeparator1.setPreferredSize(new java.awt.Dimension(140, 3));
        jPanel4.add(jSeparator1);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(200, 80));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 16, 8));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("Từ số tiền");
        jLabel4.setPreferredSize(new java.awt.Dimension(140, 20));
        jPanel9.add(jLabel4);

        txtFromPrice.setPreferredSize(new java.awt.Dimension(170, 40));
        txtFromPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFromPriceKeyReleased(evt);
            }
        });
        jPanel9.add(txtFromPrice);

        jPanel4.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(200, 80));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 16, 8));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Đến số tiền:");
        jLabel5.setPreferredSize(new java.awt.Dimension(140, 20));
        jPanel10.add(jLabel5);

        txtToPrice.setPreferredSize(new java.awt.Dimension(170, 40));
        txtToPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtToPriceKeyReleased(evt);
            }
        });
        jPanel10.add(txtToPrice);

        jPanel4.add(jPanel10);

        tablePanel.add(jPanel4, java.awt.BorderLayout.LINE_START);

        add(tablePanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        TaiKhoan tk = main.tk;
        CreateHoaDonPage page = new CreateHoaDonPage(main, tk);
        main.setPanel(page);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int row = table.getSelectedRow();
            String id = table.getValueAt(row, 1).toString();

            if (MessageDialog.confirm(this, "Bạn có chắc chắn xóa dòng này?", "Xóa")) {
                new ChiTietHoaDonController().deleteById(id);
                HD_CON.deleteById(id);
                MessageDialog.info(this, "Xóa thành công!");
                modal.removeRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.error(this, "Vui lòng chọn dòng cần thực hiện!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        JTableExporter.exportJTableToExcel(table);
    }//GEN-LAST:event_btnExportActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        modal.setRowCount(0);

        String search = txtSearch.getText().toLowerCase().trim();
        String searchType = cboxSearch.getSelectedItem().toString();
        List<HoaDon> listsearch = HD_CON.getSearchTable(search, searchType);

        loadTable(listsearch);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        txtSearch.setText("");
        txtFromPrice.setText("");
        txtToPrice.setText("");
        cboxSearch.setSelectedIndex(0);
        cboxNhanVien.setSelectedIndex(0);
        loadTable(listHD);
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        try {
            int row = table.getSelectedRow();
            HoaDon hoaDon = listHD.get(row);
            List<ChiTietHoaDon> listCTHD = new ChiTietHoaDonController().selectAllById(hoaDon.getId());

            DetailHoaDonDialog dialog = new DetailHoaDonDialog(null, true, listCTHD);
            dialog.setVisible(true);
        } catch (Exception e) {
            MessageDialog.error(this, "Vui lòng chọn dòng cần thực hiện!");
        }
    }//GEN-LAST:event_btnInfoActionPerformed

    private void cboxNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxNhanVienActionPerformed
        modal.setRowCount(0);

        List<HoaDon> listSearch = getListFilter();

        String tenDM = cboxNhanVien.getSelectedItem().toString();
        if (tenDM.equals("Tất cả")) {
            listSearch = HD_CON.getAllList();
        }

        loadTable(listSearch);
    }//GEN-LAST:event_cboxNhanVienActionPerformed

    private void txtToPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtToPriceKeyReleased
        modal.setRowCount(0);
        List<HoaDon> listSearch = getListFilter();
        loadTable(listSearch);
    }//GEN-LAST:event_txtToPriceKeyReleased

    private void txtFromPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFromPriceKeyReleased
        modal.setRowCount(0);
        List<HoaDon> listSearch = getListFilter();
        loadTable(listSearch);
    }//GEN-LAST:event_txtFromPriceKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnReload;
    private javax.swing.JComboBox<String> cboxNhanVien;
    private javax.swing.JComboBox<String> cboxSearch;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTable;
    private javax.swing.JTable table;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTextField txtFromPrice;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtToPrice;
    // End of variables declaration//GEN-END:variables
}
