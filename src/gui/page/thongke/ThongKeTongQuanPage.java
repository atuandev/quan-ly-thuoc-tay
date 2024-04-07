package gui.page.thongke;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.KhachHangController;
import controller.NhanVienController;
import controller.ThongKeController;
import controller.ThuocController;
import entities.ThongKe;
import gui.curvechart.ModelChart2;
import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utils.Formatter;
import utils.TableSorter;

/**
 *
 * @author atuandev
 */
public class ThongKeTongQuanPage extends javax.swing.JPanel {

    private final List<ThongKe> listTK = new ThongKeController().getStatistic7DaysAgo();

    private DefaultTableModel modal;

    public ThongKeTongQuanPage() {
        initComponents();
        initChart();
        initHeader();
        tableLayout();
    }

    private void initHeader() {
        int tongThuoc = new ThuocController().getSoLuongThuoc();
        txtTongThuoc.setText(String.valueOf(tongThuoc));

        int tongKH = new KhachHangController().getSoLuongKH();
        txtTongKhachHang.setText(String.valueOf(tongKH));

        int tongNV = new NhanVienController().getSoLuongNV();
        txtTongNhanVien.setText(String.valueOf(tongNV));
    }

    private void initChart() {
        lblChart.setText("thống kê doanh thu 7 ngày gần nhất".toUpperCase());

        curveChart.addLegend("Doanh thu", new Color(54, 4, 143), new Color(104, 49, 200));
        curveChart.addLegend("Chi phí", new Color(211, 84, 0), new Color(230, 126, 34));
        curveChart.addLegend("Lợi nhuận", new Color(22, 163, 74), new Color(34, 197, 94));

        loadDataChart();

        curveChart.start();
    }

    public void loadDataChart() {
        for (ThongKe e : listTK) {
            curveChart.addData(new ModelChart2(Formatter.FormatDate(e.getThoiGian()), new double[]{e.getDoanhThu(), e.getChiPhi(), e.getLoiNhuan()}));
        }
    }
    
    private void tableLayout() {
        String[] header = new String[]{"STT", "Thời gian", "Doanh thu", "Chi phí", "Lợi nhuận"};
        modal = new DefaultTableModel();
        modal.setColumnIdentifiers(header);
        table.setModel(modal);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        table.setDefaultRenderer(Object.class, centerRenderer);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);

        loadTable(listTK);
        sortTable();
    }

    private void sortTable() {
        table.setAutoCreateRowSorter(true);
        TableSorter.configureTableColumnSorter(table, 0, TableSorter.STRING_COMPARATOR);
    }


    public void loadTable(List<ThongKe> list) {
        modal.setRowCount(0);
        int stt = 1;
        for (ThongKe e : list) {
            modal.addRow(new Object[]{
                stt, Formatter.FormatDate(e.getThoiGian()), Formatter.FormatVND(e.getDoanhThu()), Formatter.FormatVND(e.getChiPhi()), Formatter.FormatVND(e.getLoiNhuan())
            });
            stt++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtTongThuoc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtTongKhachHang = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txtTongNhanVien = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        curveChart = new gui.curvechart.CurveChart();
        jPanel5 = new javax.swing.JPanel();
        lblChart = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBackground(new java.awt.Color(230, 245, 245));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 245, 245), 6, true));
        setMinimumSize(new java.awt.Dimension(1130, 800));
        setPreferredSize(new java.awt.Dimension(1130, 800));
        setLayout(new java.awt.BorderLayout(0, 6));

        jPanel2.setBackground(new java.awt.Color(230, 245, 245));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 110));
        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 16, 8));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(370, 100));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(120, 100));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new FlatSVGIcon("./icon/medicine_52.svg"));
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel7.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel7, java.awt.BorderLayout.WEST);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(120, 100));

        txtTongThuoc.setFont(new java.awt.Font("Roboto Mono", 1, 36)); // NOI18N
        txtTongThuoc.setForeground(new java.awt.Color(51, 51, 51));
        txtTongThuoc.setText("50");
        txtTongThuoc.setPreferredSize(new java.awt.Dimension(100, 16));

        jLabel3.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Thuốc hiện có trong kho");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtTongThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(370, 100));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(120, 100));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new FlatSVGIcon("./icon/customer_52.svg"));
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel9.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel9, java.awt.BorderLayout.WEST);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(120, 100));

        txtTongKhachHang.setFont(new java.awt.Font("Roboto Mono", 1, 36)); // NOI18N
        txtTongKhachHang.setForeground(new java.awt.Color(51, 51, 51));
        txtTongKhachHang.setText("50");
        txtTongKhachHang.setPreferredSize(new java.awt.Dimension(100, 16));

        jLabel4.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Khách hàng từ trước đến nay");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtTongKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(370, 100));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(120, 100));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new FlatSVGIcon("./icon/man_52.svg"));
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel12.add(jLabel5, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel12, java.awt.BorderLayout.WEST);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(120, 100));

        txtTongNhanVien.setFont(new java.awt.Font("Roboto Mono", 1, 36)); // NOI18N
        txtTongNhanVien.setForeground(new java.awt.Color(51, 51, 51));
        txtTongNhanVien.setText("50");
        txtTongNhanVien.setPreferredSize(new java.awt.Dimension(100, 16));

        jLabel6.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Nhân viên đang hoạt động");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtTongNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel11.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel11);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(curveChart, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1188, 30));
        jPanel5.setLayout(new java.awt.BorderLayout());

        lblChart.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblChart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChart.setText("Thống kê");
        lblChart.setPreferredSize(new java.awt.Dimension(37, 30));
        jPanel5.add(lblChart, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(230, 245, 245));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 280));
        jPanel4.setLayout(new java.awt.BorderLayout());

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

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel4, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.curvechart.CurveChart curveChart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChart;
    private javax.swing.JTable table;
    private javax.swing.JLabel txtTongKhachHang;
    private javax.swing.JLabel txtTongNhanVien;
    private javax.swing.JLabel txtTongThuoc;
    // End of variables declaration//GEN-END:variables
}
