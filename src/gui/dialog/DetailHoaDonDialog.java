package gui.dialog;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.ChiTietHoaDonController;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utils.Formatter;
import utils.WritePDF;

/**
 *
 * @author atuandev
 */
public class DetailHoaDonDialog extends javax.swing.JDialog {

    private final ChiTietHoaDonController CTHD_CON = new ChiTietHoaDonController();
    private List<ChiTietHoaDon> listCTHD;

    private DefaultTableModel modal;

    public DetailHoaDonDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public DetailHoaDonDialog(java.awt.Frame parent, boolean modal, List<ChiTietHoaDon> cthd) {
        super(parent, modal);
        initComponents();
        this.listCTHD = cthd;
        fillInput();
        fillTable();
    }

    private void fillInput() {
        HoaDon hoaDon = listCTHD.get(0).getHoaDon();
        txtMaHD.setText(hoaDon.getId());
        txtTenKH.setText(hoaDon.getKhachHang().getHoTen());
        txtTenNV.setText(hoaDon.getNhanVien().getHoTen());
    }

    private void fillTable() {
        modal = new DefaultTableModel();
        String[] header = new String[]{"STT", "Tên thuốc", "Đơn vị tính", "Số lượng", "Đơn giá", "Thành tiền"};
        modal.setColumnIdentifiers(header);
        table.setModel(modal);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        table.setDefaultRenderer(Object.class, centerRenderer);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);

        loadTableCTHD(listCTHD);
    }

    public void loadTableCTHD(List<ChiTietHoaDon> list) {
        modal.setRowCount(0);

        listCTHD = list;
        int stt = 1;
        double sum = 0;
        for (ChiTietHoaDon e : listCTHD) {
            sum += e.getThanhTien();
            modal.addRow(new Object[]{String.valueOf(stt), e.getThuoc().getTenThuoc(), e.getThuoc().getDonViTinh(),
                e.getSoLuong(), Formatter.FormatVND(e.getDonGia()), Formatter.FormatVND(e.getThanhTien())});
            stt++;
        }
        txtTong.setText(Formatter.FormatVND(sum));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        hoaDonPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        imagePanel = new javax.swing.JPanel();
        txtHinhAnh = new javax.swing.JLabel();
        tableItemPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        lblThuoc = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel15.setBackground(new java.awt.Color(0, 153, 153));
        jPanel15.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel15.setPreferredSize(new java.awt.Dimension(500, 50));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CHI TIẾT HÓA ĐƠN");
        jLabel8.setPreferredSize(new java.awt.Dimension(149, 40));
        jPanel15.add(jLabel8, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel15, java.awt.BorderLayout.NORTH);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        hoaDonPanel.setBackground(new java.awt.Color(255, 255, 255));
        hoaDonPanel.setPreferredSize(new java.awt.Dimension(1200, 80));
        hoaDonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 16));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(340, 40));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("Mã hóa đơn ");
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel7.add(jLabel4);

        txtMaHD.setEditable(false);
        txtMaHD.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        txtMaHD.setText("Z2NX8CN1A");
        txtMaHD.setFocusable(false);
        txtMaHD.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel7.add(txtMaHD);

        hoaDonPanel.add(jPanel7);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(340, 40));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Tên khách hàng");
        jLabel5.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel9.add(jLabel5);

        txtTenKH.setEditable(false);
        txtTenKH.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTenKH.setText("Nguyễn Văn A");
        txtTenKH.setFocusable(false);
        txtTenKH.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel9.add(txtTenKH);

        hoaDonPanel.add(jPanel9);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(340, 40));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setText("Tên nhân viên");
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel11.add(jLabel7);

        txtTenNV.setEditable(false);
        txtTenNV.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTenNV.setText("Vũ Nương");
        txtTenNV.setFocusable(false);
        txtTenNV.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel11.add(txtTenNV);

        hoaDonPanel.add(jPanel11);

        jPanel2.add(hoaDonPanel, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 100));

        imagePanel.setBackground(new java.awt.Color(255, 255, 255));
        imagePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 237, 237), 2, true));
        imagePanel.setPreferredSize(new java.awt.Dimension(300, 300));
        imagePanel.setLayout(new java.awt.BorderLayout());

        txtHinhAnh.setBackground(new java.awt.Color(255, 255, 255));
        txtHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtHinhAnh.setIcon(new FlatSVGIcon("./icon/image.svg"));
        txtHinhAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtHinhAnh.setPreferredSize(new java.awt.Dimension(200, 100));
        imagePanel.add(txtHinhAnh, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.WEST);

        tableItemPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));

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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        tableItemPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 60));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 0));
        jLabel9.setText("Tổng hóa đơn:");
        jLabel9.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel12.add(jLabel9);

        txtTong.setEditable(false);
        txtTong.setFont(new java.awt.Font("Roboto Mono Medium", 0, 14)); // NOI18N
        txtTong.setForeground(new java.awt.Color(255, 51, 0));
        txtTong.setText("1000000");
        txtTong.setFocusable(false);
        txtTong.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel12.add(txtTong);

        jPanel1.add(jPanel12);

        tableItemPanel.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel16.setBackground(new java.awt.Color(0, 153, 153));
        jPanel16.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel16.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel16.setLayout(new java.awt.BorderLayout());

        lblThuoc.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblThuoc.setForeground(new java.awt.Color(255, 255, 255));
        lblThuoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThuoc.setText("Thông tin thuốc");
        jPanel16.add(lblThuoc, java.awt.BorderLayout.CENTER);

        tableItemPanel.add(jPanel16, java.awt.BorderLayout.NORTH);

        jPanel2.add(tableItemPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

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

        btnPrint.setBackground(new java.awt.Color(0, 153, 153));
        btnPrint.setFont(new java.awt.Font("Roboto Mono Medium", 0, 16)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("In hóa đơn");
        btnPrint.setBorderPainted(false);
        btnPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrint.setFocusPainted(false);
        btnPrint.setFocusable(false);
        btnPrint.setPreferredSize(new java.awt.Dimension(200, 40));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel8.add(btnPrint);

        getContentPane().add(jPanel8, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = table.getSelectedRow();
        byte[] thuocImage = listCTHD.get(row).getThuoc().getHinhAnh();
        ImageIcon imageIcon = new ImageIcon(
                new ImageIcon(thuocImage).getImage().getScaledInstance(txtHinhAnh.getWidth(), txtHinhAnh.getHeight(), Image.SCALE_SMOOTH));
        txtHinhAnh.setIcon(imageIcon);
    }//GEN-LAST:event_tableMouseClicked

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        HoaDon hoaDon = listCTHD.get(0).getHoaDon();
        new WritePDF().printHoaDon(hoaDon, listCTHD);
    }//GEN-LAST:event_btnPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnPrint;
    private javax.swing.JPanel hoaDonPanel;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblThuoc;
    private javax.swing.JTable table;
    private javax.swing.JPanel tableItemPanel;
    private javax.swing.JLabel txtHinhAnh;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTong;
    // End of variables declaration//GEN-END:variables
}
