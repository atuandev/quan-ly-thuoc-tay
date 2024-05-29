package gui.page;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.ChiTietHoaDonController;
import controller.HoaDonController;
import controller.KhachHangController;
import controller.ThuocController;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import entities.TaiKhoan;
import entities.Thuoc;
import gui.MainLayout;
import gui.dialog.CreateKhachHangDialog;
import java.awt.Image;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utils.Formatter;
import utils.MessageDialog;
import utils.RandomGenerator;
import utils.TableSorter;
import utils.Validation;
import utils.WritePDF;

/**
 *
 * @author HP
 */
public class CreateHoaDonPage extends javax.swing.JPanel {

    private final ThuocController THUOC_CON = new ThuocController();
    private final HoaDonController HD_CON = new HoaDonController();
    private final ChiTietHoaDonController CTHD_CON = new ChiTietHoaDonController();

    private List<Thuoc> listThuoc = THUOC_CON.getAllList();
    private List<ChiTietHoaDon> listCTHD = new ArrayList<>();

    private MainLayout main;
    private TaiKhoan tk;

    private DefaultTableModel modal;
    private DefaultTableModel modalCart;

    public CreateHoaDonPage() {
        initComponents();
        pruductLayout();
        billLayout();
        tableThuocLayout();
        tableCartLayout();
    }

    public CreateHoaDonPage(MainLayout main, TaiKhoan tk) {
        this.main = main;
        this.tk = tk;
        initComponents();
        pruductLayout();
        billLayout();
        tableThuocLayout();
        tableCartLayout();
    }

    private void pruductLayout() {
        txtSoLuong.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Số lượng...");
        btnReload.putClientProperty(FlatClientProperties.STYLE, "arc: 15");

        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tìm kiếm...");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("./icon/search.svg"));

        String[] searchType = {"Tất cả", "Mã", "Tên"};
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(searchType);
        cboxSearch.setModel(model);
    }

    private void tableThuocLayout() {
        lblThuoc.setText(" thông tin thuốc".toUpperCase());
        String[] header = new String[]{"STT", "Mã thuốc", "Tên thuốc", "Danh mục", "Xuất xứ", "Đơn vị tính", "Số lượng tồn", "Đơn giá"};
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

    public void loadTable(List<Thuoc> list) {
        modal.setRowCount(0);

        listThuoc = list;
        int stt = 1;
        for (Thuoc e : listThuoc) {
            modal.addRow(new Object[]{String.valueOf(stt), e.getId(), e.getTenThuoc(), e.getDanhMuc().getTen(),
                e.getXuatXu().getTen(), e.getDonViTinh().getTen(), e.getSoLuongTon(), Formatter.FormatVND(e.getDonGia())});
            stt++;
        }
    }

    private void sortTable() {
        table.setAutoCreateRowSorter(true);
        TableSorter.configureTableColumnSorter(table, 0, TableSorter.STRING_COMPARATOR);
    }

    private void tableCartLayout() {
        modalCart = new DefaultTableModel();
        String[] header = new String[]{"STT", "Tên thuốc", "Số lượng", "Đơn giá"};
        modalCart.setColumnIdentifiers(header);
        tableCart.setModel(modalCart);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        tableCart.setDefaultRenderer(Object.class, centerRenderer);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableCart.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableCart.getColumnModel().getColumn(0).setPreferredWidth(30);
        tableCart.getColumnModel().getColumn(1).setPreferredWidth(200);

        loadTableCTHD(listCTHD);
        sortTable();
    }

    public void loadTableCTHD(List<ChiTietHoaDon> list) {
        modalCart.setRowCount(0);

        listCTHD = list;
        int stt = 1;
        double sum = 0;
        for (ChiTietHoaDon e : listCTHD) {
            sum += e.getThanhTien();
            modalCart.addRow(new Object[]{String.valueOf(stt), e.getThuoc().getTenThuoc(), e.getSoLuong(), Formatter.FormatVND(e.getDonGia())});
            stt++;
        }
        txtTong.setText(Formatter.FormatVND(sum));
    }

    private void billLayout() {
        btnAddCustomer.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        formatNumberFields();

        // Set Random HoaDon ID
        txtMaHoaDon.setText(RandomGenerator.getRandomId());
    }

    private void formatNumberFields() {
        String txtDonGiaFormat = Formatter.FormatVND(Double.parseDouble(txtDonGia.getText()));
        txtDonGia.setText(txtDonGiaFormat);
        String txtTongFormat = Formatter.FormatVND(Double.parseDouble(txtTong.getText()));
        txtTong.setText(txtTongFormat);
    }

    private boolean isValidHoaDon() {
        if (Validation.isEmpty(txtTienKhachDua.getText().trim())) {
            txtTienKhachDua.requestFocus();
            return false;
        }

        if (listCTHD.isEmpty()) {
            MessageDialog.warring(this, "Vui lòng chọn sản phẩm!");
            return false;
        }

        if (Validation.isEmpty(txtSdtKH.getText())) {
            MessageDialog.warring(this, "Vui lòng chọn khách hàng!");
            txtSdtKH.requestFocus();
            return false;
        }

        try {
            double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText());
            if (tienKhachDua < 0) {
                MessageDialog.warring(this, "Tiền khách đưa phải >= 0");
                Validation.resetTextfield(txtTienKhachDua);
                return false;
            }
        } catch (NumberFormatException e) {
            MessageDialog.warring(this, "Tiền khách đưa phải là số!");
            Validation.resetTextfield(txtTienKhachDua);
            return false;
        }

        return true;
    }

    private boolean isValidChiTietHoaDon() {
        if (Validation.isEmpty(txtSoLuong.getText().trim())) {
            MessageDialog.warring(this, "Số lượng không được để trống!");
            txtSoLuong.requestFocus();
            return false;
        } else {
            try {
                Thuoc selectedThuoc = THUOC_CON.selectById(txtMaThuoc.getText());

                if (selectedThuoc == null) {
                    MessageDialog.warring(this, "Vui lòng chọn sản phẩm");
                    return false;
                }

                int soLuongTon = selectedThuoc.getSoLuongTon();
                int sl = Integer.parseInt(txtSoLuong.getText());
                if (sl < 0) {
                    MessageDialog.warring(this, "Số lượng đưa phải >= 0");
                    txtSoLuong.requestFocus();
                    return false;
                } else if (soLuongTon < sl) {
                    MessageDialog.warring(this, "Không đủ số lượng!");
                    txtSoLuong.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                MessageDialog.warring(this, "Số lượng đưa phải là số!");
                txtSoLuong.requestFocus();
                return false;
            }
        }

        Thuoc selectedThuoc = THUOC_CON.selectById(txtMaThuoc.getText());
        for (ChiTietHoaDon cthd : listCTHD) {
            if (cthd.getThuoc().equals(selectedThuoc)) {
                MessageDialog.warring(this, "Thuốc đã tồn tại trong giỏ hàng!");
                return false;
            }
        }

        return true;
    }

    private HoaDon getInputHoaDon() {
        String idHD = txtMaHoaDon.getText();
        Timestamp thoiGian = new Timestamp(System.currentTimeMillis());
        NhanVien nhanVien = tk.getNhanVien();
        KhachHang khachHang = new KhachHangController().selectBySdt(txtSdtKH.getText());
        double tongTien = Formatter.unformatVND(txtTong.getText());

        return new HoaDon(idHD, thoiGian, nhanVien, khachHang, tongTien);
    }

    private ChiTietHoaDon getInputChiTietHoaDon() {
        HoaDon hoaDon = getInputHoaDon();
        Thuoc thuoc = THUOC_CON.selectById(txtMaThuoc.getText());
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        double donGia = thuoc.getDonGia();

        return new ChiTietHoaDon(hoaDon, thuoc, soLuong, donGia);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        sanPhamPanel = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        lblThuoc = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        txtHinhAnh = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtMaThuoc = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtTenThuoc = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtThanhPhan = new javax.swing.JTextArea();
        jPanel21 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        actionPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        cboxSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnReload = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        txtSoLuong = new javax.swing.JTextField();
        btnAddCart = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        billPanel = new javax.swing.JPanel();
        cardPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        btnDeleteCartItem = new javax.swing.JButton();
        billInfoPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSdtKH = new javax.swing.JTextField();
        btnSearchKH = new javax.swing.JButton();
        btnAddCustomer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtHoTenKH = new javax.swing.JTextField();
        cboxGioiTinhKH = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel26 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();

        setBackground(new java.awt.Color(230, 245, 245));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 245, 245), 6, true));
        setLayout(new java.awt.BorderLayout(5, 0));

        mainPanel.setBackground(new java.awt.Color(230, 245, 245));
        mainPanel.setLayout(new java.awt.BorderLayout(5, 5));

        sanPhamPanel.setBackground(new java.awt.Color(255, 255, 255));
        sanPhamPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 237, 237), 2, true));
        sanPhamPanel.setPreferredSize(new java.awt.Dimension(832, 300));
        sanPhamPanel.setLayout(new java.awt.BorderLayout());

        jPanel15.setBackground(new java.awt.Color(0, 153, 153));
        jPanel15.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel15.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel15.setLayout(new java.awt.BorderLayout());

        lblThuoc.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblThuoc.setForeground(new java.awt.Color(255, 255, 255));
        lblThuoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThuoc.setText("Thông tin thuốc");
        jPanel15.add(lblThuoc, java.awt.BorderLayout.CENTER);

        sanPhamPanel.add(jPanel15, java.awt.BorderLayout.NORTH);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new java.awt.BorderLayout(16, 16));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(300, 200));
        jPanel22.setLayout(new java.awt.BorderLayout(20, 20));

        txtHinhAnh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 4, true));
        txtHinhAnh.setPreferredSize(new java.awt.Dimension(300, 200));
        jPanel22.add(txtHinhAnh, java.awt.BorderLayout.CENTER);

        jPanel16.add(jPanel22, java.awt.BorderLayout.WEST);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(215, 40));
        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 0));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setText("Mã thuốc:");
        jLabel10.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel10.setPreferredSize(new java.awt.Dimension(90, 40));
        jPanel17.add(jLabel10);

        txtMaThuoc.setEditable(false);
        txtMaThuoc.setText("ASZX21Z1X");
        txtMaThuoc.setFocusable(false);
        txtMaThuoc.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel17.add(txtMaThuoc);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(340, 40));
        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 0));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel11.setText("Tên thuốc:");
        jLabel11.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel11.setPreferredSize(new java.awt.Dimension(90, 40));
        jPanel18.add(jLabel11);

        txtTenThuoc.setEditable(false);
        txtTenThuoc.setFocusable(false);
        txtTenThuoc.setPreferredSize(new java.awt.Dimension(350, 40));
        jPanel18.add(txtTenThuoc);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(215, 40));
        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 0));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel12.setText("Thành phần:");
        jLabel12.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel12.setPreferredSize(new java.awt.Dimension(90, 40));
        jPanel19.add(jLabel12);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(350, 100));

        txtThanhPhan.setEditable(false);
        txtThanhPhan.setColumns(20);
        txtThanhPhan.setLineWrap(true);
        txtThanhPhan.setRows(5);
        txtThanhPhan.setFocusable(false);
        txtThanhPhan.setPreferredSize(new java.awt.Dimension(320, 40));
        jScrollPane3.setViewportView(txtThanhPhan);

        jPanel19.add(jScrollPane3);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(215, 40));
        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 0));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel14.setText("Đơn giá:");
        jLabel14.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel14.setPreferredSize(new java.awt.Dimension(90, 40));
        jPanel21.add(jLabel14);

        txtDonGia.setEditable(false);
        txtDonGia.setFont(new java.awt.Font("Roboto Mono Medium", 0, 14)); // NOI18N
        txtDonGia.setText("123123");
        txtDonGia.setFocusable(false);
        txtDonGia.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel21.add(txtDonGia);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(612, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(66, Short.MAX_VALUE)))
        );

        jPanel16.add(jPanel24, java.awt.BorderLayout.CENTER);

        sanPhamPanel.add(jPanel16, java.awt.BorderLayout.CENTER);

        mainPanel.add(sanPhamPanel, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(230, 245, 245));
        jPanel4.setPreferredSize(new java.awt.Dimension(832, 400));
        jPanel4.setLayout(new java.awt.BorderLayout(0, 5));

        actionPanel.setBackground(new java.awt.Color(255, 255, 255));
        actionPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 237, 237), 2, true));
        actionPanel.setPreferredSize(new java.awt.Dimension(605, 60));
        actionPanel.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 8));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));
        jPanel12.add(jPanel14);

        cboxSearch.setToolTipText("");
        cboxSearch.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel12.add(cboxSearch);

        txtSearch.setToolTipText("Tìm kiếm");
        txtSearch.setPreferredSize(new java.awt.Dimension(200, 40));
        txtSearch.setSelectionColor(new java.awt.Color(230, 245, 245));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel12.add(txtSearch);

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
        jPanel12.add(btnReload);

        actionPanel.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(260, 60));
        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 8));

        txtSoLuong.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtSoLuong.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel13.add(txtSoLuong);

        btnAddCart.setBackground(new java.awt.Color(0, 179, 246));
        btnAddCart.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btnAddCart.setForeground(new java.awt.Color(255, 220, 0));
        btnAddCart.setIcon(new FlatSVGIcon("./icon/add-to-cart.svg"));
        btnAddCart.setText("THÊM");
        btnAddCart.setBorderPainted(false);
        btnAddCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCart.setFocusPainted(false);
        btnAddCart.setFocusable(false);
        btnAddCart.setPreferredSize(new java.awt.Dimension(120, 40));
        btnAddCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCartActionPerformed(evt);
            }
        });
        jPanel13.add(btnAddCart);

        actionPanel.add(jPanel13, java.awt.BorderLayout.EAST);

        jPanel4.add(actionPanel, java.awt.BorderLayout.PAGE_START);

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 237, 237), 2, true));
        tablePanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setFocusable(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        tablePanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.add(tablePanel, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(mainPanel, java.awt.BorderLayout.CENTER);

        billPanel.setBackground(new java.awt.Color(230, 245, 245));
        billPanel.setPreferredSize(new java.awt.Dimension(460, 800));
        billPanel.setLayout(new java.awt.BorderLayout(0, 5));

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 238), 2, true));
        cardPanel.setPreferredSize(new java.awt.Dimension(600, 500));
        cardPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true));

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableCart.setFocusable(false);
        jScrollPane2.setViewportView(tableCart);

        cardPanel.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Giỏ hàng");
        jPanel3.add(jLabel1, java.awt.BorderLayout.CENTER);

        cardPanel.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setForeground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(456, 42));
        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 6, 2));

        btnDeleteCartItem.setBackground(new java.awt.Color(255, 102, 102));
        btnDeleteCartItem.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        btnDeleteCartItem.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCartItem.setIcon(new FlatSVGIcon("./icon/trash-cart.svg"));
        btnDeleteCartItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteCartItem.setPreferredSize(new java.awt.Dimension(50, 38));
        btnDeleteCartItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCartItemActionPerformed(evt);
            }
        });
        jPanel20.add(btnDeleteCartItem);

        cardPanel.add(jPanel20, java.awt.BorderLayout.PAGE_END);

        billPanel.add(cardPanel, java.awt.BorderLayout.CENTER);

        billInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        billInfoPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 238), 2, true));
        billInfoPanel.setPreferredSize(new java.awt.Dimension(500, 400));
        billInfoPanel.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel5.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hóa đơn");
        jPanel5.add(jLabel2, java.awt.BorderLayout.CENTER);

        billInfoPanel.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(440, 140));
        jPanel23.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("Mã hóa đơn ");
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel7.add(jLabel4);

        txtMaHoaDon.setEditable(false);
        txtMaHoaDon.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        txtMaHoaDon.setText("Z2NX8CN1A");
        txtMaHoaDon.setFocusable(false);
        txtMaHoaDon.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel7.add(txtMaHoaDon);

        jPanel23.add(jPanel7);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setText("Số điện thoại:");
        jLabel8.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel25.add(jLabel8);

        txtSdtKH.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel25.add(txtSdtKH);

        btnSearchKH.setIcon(new FlatSVGIcon("./icon/search.svg"));
        btnSearchKH.setBorderPainted(false);
        btnSearchKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchKH.setFocusPainted(false);
        btnSearchKH.setFocusable(false);
        btnSearchKH.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSearchKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchKHActionPerformed(evt);
            }
        });
        jPanel25.add(btnSearchKH);

        btnAddCustomer.setIcon(new FlatSVGIcon("./icon/add-customer.svg"));
        btnAddCustomer.setBorderPainted(false);
        btnAddCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCustomer.setFocusPainted(false);
        btnAddCustomer.setFocusable(false);
        btnAddCustomer.setPreferredSize(new java.awt.Dimension(40, 40));
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });
        jPanel25.add(btnAddCustomer);

        jPanel23.add(jPanel25);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Tên khách hàng");
        jLabel3.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel2.add(jLabel3);

        txtHoTenKH.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel2.add(txtHoTenKH);

        jPanel23.add(jPanel2);

        cboxGioiTinhKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cboxGioiTinhKH.setPreferredSize(new java.awt.Dimension(90, 40));
        jPanel23.add(cboxGioiTinhKH);

        jPanel6.add(jPanel23);

        jSeparator1.setPreferredSize(new java.awt.Dimension(400, 3));
        jPanel6.add(jSeparator1);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setPreferredSize(new java.awt.Dimension(440, 150));
        jPanel26.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 0));
        jLabel7.setText("Tổng hóa đơn:");
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel11.add(jLabel7);

        txtTong.setEditable(false);
        txtTong.setFont(new java.awt.Font("Roboto Mono Medium", 0, 14)); // NOI18N
        txtTong.setForeground(new java.awt.Color(255, 51, 0));
        txtTong.setText("1000000");
        txtTong.setFocusable(false);
        txtTong.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel11.add(txtTong);

        jPanel26.add(jPanel11);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setText("Tiền khách đưa:");
        jLabel6.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel10.add(jLabel6);

        txtTienKhachDua.setPreferredSize(new java.awt.Dimension(200, 40));
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });
        jPanel10.add(txtTienKhachDua);

        jPanel26.add(jPanel10);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Tiền thừa:");
        jLabel5.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel9.add(jLabel5);

        txtTienThua.setEditable(false);
        txtTienThua.setFont(new java.awt.Font("Roboto Mono Medium", 0, 14)); // NOI18N
        txtTienThua.setFocusable(false);
        txtTienThua.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel9.add(txtTienThua);

        jPanel26.add(jPanel9);

        jPanel6.add(jPanel26);

        billInfoPanel.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

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

        btnThanhToan.setBackground(new java.awt.Color(0, 204, 51));
        btnThanhToan.setFont(new java.awt.Font("Roboto Mono Medium", 0, 16)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.setBorderPainted(false);
        btnThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThanhToan.setFocusPainted(false);
        btnThanhToan.setFocusable(false);
        btnThanhToan.setPreferredSize(new java.awt.Dimension(200, 40));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        jPanel8.add(btnThanhToan);

        billInfoPanel.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        billPanel.add(billInfoPanel, java.awt.BorderLayout.SOUTH);

        add(billPanel, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

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
        loadTable(THUOC_CON.getAllList());
    }//GEN-LAST:event_btnReloadActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = table.getSelectedRow();
        String idThuoc = modal.getValueAt(row, 1).toString();
        Thuoc e = THUOC_CON.selectById(idThuoc);
        ImageIcon imageIcon = new ImageIcon(
                new ImageIcon(e.getHinhAnh()).getImage().getScaledInstance(txtHinhAnh.getWidth(), txtHinhAnh.getHeight(), Image.SCALE_SMOOTH));
        txtHinhAnh.setIcon(imageIcon);
        txtHinhAnh.setIcon(imageIcon);
        txtMaThuoc.setText(e.getId());
        txtTenThuoc.setText(e.getTenThuoc());
        txtThanhPhan.setText(e.getThanhPhan());
        txtDonGia.setText(Formatter.FormatVND(e.getDonGia()));
    }//GEN-LAST:event_tableMouseClicked

    private void btnAddCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCartActionPerformed
        if (isValidChiTietHoaDon()) {
            ChiTietHoaDon cthd = getInputChiTietHoaDon();
            listCTHD.add(cthd);
            loadTableCTHD(listCTHD);

            // Update số lượng tồn
            Thuoc thuoc = THUOC_CON.selectById(txtMaThuoc.getText());
            int updatedSoLuongTon = thuoc.getSoLuongTon() - cthd.getSoLuong();
            THUOC_CON.updateSoLuongTon(thuoc, updatedSoLuongTon);
            loadTable(THUOC_CON.getAllList());

            txtSoLuong.setText("");
        }
    }//GEN-LAST:event_btnAddCartActionPerformed

    private void btnDeleteCartItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCartItemActionPerformed
        if (MessageDialog.confirm(this, "Bạn có chắc muốc xóa khỏi giỏ hàng?", "Xóa thuốc khỏi giỏ hàng")) {
            if (listCTHD.isEmpty()) {
                MessageDialog.error(this, "Không có sản phẩm trong giỏ hàng!");
                return;
            }

            ChiTietHoaDon cthd = listCTHD.get(tableCart.getSelectedRow());
            listCTHD.remove(tableCart.getSelectedRow());
            loadTableCTHD(listCTHD);

            // Update số lượng tồn
            Thuoc thuocCTHD = cthd.getThuoc();
            Thuoc thuoc = listThuoc.get(listThuoc.indexOf(thuocCTHD));
            int updatedSoLuongTon = thuoc.getSoLuongTon() + cthd.getSoLuong();
            THUOC_CON.updateSoLuongTon(thuoc, updatedSoLuongTon);
            loadTable(THUOC_CON.getAllList());
        }
    }//GEN-LAST:event_btnDeleteCartItemActionPerformed

    private void btnSearchKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchKHActionPerformed
        KhachHang kh = new KhachHangController().selectBySdt(txtSdtKH.getText());

        if (kh == null) {
            MessageDialog.error(this, "Không tìm thấy khách hàng!");
            txtHoTenKH.setText("");
            cboxGioiTinhKH.setSelectedIndex(0);
            txtHoTenKH.setEnabled(true);
            cboxGioiTinhKH.setEnabled(true);
        } else {
            txtHoTenKH.setText(kh.getHoTen());
            cboxGioiTinhKH.setSelectedItem(kh.getGioiTinh());
            txtHoTenKH.setEnabled(false);
            cboxGioiTinhKH.setEnabled(false);
        }
    }//GEN-LAST:event_btnSearchKHActionPerformed

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        CreateKhachHangDialog dialog = new CreateKhachHangDialog(null, true, new KhachHangPage());
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        if (isValidHoaDon()) {
            Double tong = Formatter.unformatVND(txtTong.getText());
            Double tienKhachDua = Double.valueOf(txtTienKhachDua.getText());
            Double tienThua = tienKhachDua - tong;

            if (tienThua <= 0) {
                tienThua = 0.0;
            }

            txtTienThua.setText(Formatter.FormatVND(tienThua));
        }
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        if (MessageDialog.confirm(this, "Xác nhận hủy hóa đơn?", "Hủy hóa đơn")) {
            for (ChiTietHoaDon cthd : listCTHD) {
                Thuoc thuocCTHD = cthd.getThuoc();
                Thuoc thuoc = listThuoc.get(listThuoc.indexOf(thuocCTHD));
                int updatedSoLuongTon = thuoc.getSoLuongTon() + cthd.getSoLuong();
                THUOC_CON.updateSoLuongTon(thuoc, updatedSoLuongTon);
            }

            main.setPanel(new HoaDonPage(main));
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private boolean isValidPayment() {
        if (isValidHoaDon()) {
            double tongTien = Formatter.unformatVND(txtTong.getText());
            double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText());
            if (tienKhachDua < tongTien) {
                MessageDialog.warring(this, "Không đủ tiền thanh toán!");
                txtTienKhachDua.requestFocus();
                return false;
            }
        }

        return true;
    }

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (isValidHoaDon() && isValidPayment()) {
            if (MessageDialog.confirm(this, "Xác nhận thanh toán?", "Lập hóa đơn")) {
                HoaDon hd = getInputHoaDon();
                HD_CON.create(hd);
                CTHD_CON.create(listCTHD);
                MessageDialog.info(this, "Lập hóa đơn thành công!");

                // In hóa đơn
                if (MessageDialog.confirm(this, "Bạn có muốn in hóa đơn không?", "In hóa đơn")) {
                    new WritePDF().printHoaDon(hd, listCTHD);
                }

                // Trở về trang hóa đơn
                main.setPanel(new HoaDonPage(main));
            }
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JPanel billInfoPanel;
    private javax.swing.JPanel billPanel;
    private javax.swing.JButton btnAddCart;
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnDeleteCartItem;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSearchKH;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JComboBox<String> cboxGioiTinhKH;
    private javax.swing.JComboBox<String> cboxSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblThuoc;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel sanPhamPanel;
    private javax.swing.JTable table;
    private javax.swing.JTable tableCart;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JLabel txtHinhAnh;
    private javax.swing.JTextField txtHoTenKH;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaThuoc;
    private javax.swing.JTextField txtSdtKH;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenThuoc;
    private javax.swing.JTextArea txtThanhPhan;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTong;
    // End of variables declaration//GEN-END:variables

}
