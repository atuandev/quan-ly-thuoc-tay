package gui.dialog;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.DanhMucController;
import controller.DonViTinhController;
import controller.ThuocController;
import controller.XuatXuController;
import entities.DanhMuc;
import entities.DonViTinh;
import entities.Thuoc;
import entities.XuatXu;
import gui.page.ThuocPage;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import utils.MessageDialog;
import utils.Validation;

/**
 *
 * @author atuandev
 */
public class UpdateThuocDialog extends javax.swing.JDialog {

    private final ThuocController THUOC_CON = new ThuocController();
    private ThuocPage THUOC_GUI;
    private Thuoc thuoc;
    private byte[] thuocImage;

    private final List<DanhMuc> listDM = new DanhMucController().getAllList();
    private final List<DonViTinh> listDVT = new DonViTinhController().getAllList();
    private final List<XuatXu> listXX = new XuatXuController().getAllList();

    public UpdateThuocDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public UpdateThuocDialog(java.awt.Frame parent, boolean modal, ThuocPage THUOC_GUI, Thuoc thuoc) {
        super(parent, modal);
        initComponents();
        this.THUOC_GUI = THUOC_GUI;
        this.thuoc = thuoc;
        fillCombobox();
        fillInput();
    }

    private void fillCombobox() {
        for (DanhMuc vt : listDM) {
            cboxDanhMuc.addItem(vt.getTen());
        }

        for (DonViTinh vt : listDVT) {
            cboxDonViTinh.addItem(vt.getTen());
        }

        for (XuatXu vt : listXX) {
            cboxXuatXu.addItem(vt.getTen());
        }
    }

    private void fillInput() {
        txtTenThuoc.setText(thuoc.getTenThuoc());
        thuocImage = thuoc.getHinhAnh();
        ImageIcon imageIcon = new ImageIcon(
                new ImageIcon(thuocImage).getImage().getScaledInstance(txtHinhAnh.getWidth(), txtHinhAnh.getHeight(), Image.SCALE_SMOOTH));
        txtHinhAnh.setIcon(imageIcon);
        txtThanhPhan.setText(thuoc.getThanhPhan());
        cboxDanhMuc.setSelectedItem(thuoc.getDanhMuc().getTen());
        cboxDonViTinh.setSelectedItem(thuoc.getDonViTinh().getTen());
        cboxXuatXu.setSelectedItem(thuoc.getXuatXu().getTen());
        txtSoLuong.setText(String.valueOf(thuoc.getSoLuongTon()));
        txtGiaNhap.setText(String.valueOf(thuoc.getGiaNhap()));
        txtDonGia.setText(String.valueOf(thuoc.getDonGia()));
        txtHanSuDung.setDate(thuoc.getHanSuDung());
    }

    private boolean isValidateFields() {
        if (Validation.isEmpty(txtTenThuoc.getText().trim())) {
            MessageDialog.warring(this, "Tên thuốc không được rỗng!");
            txtTenThuoc.requestFocus();
            return false;
        }

        if (txtHinhAnh.getIcon() == null) {
            MessageDialog.warring(this, "Hình ảnh không được rỗng!");
            txtHinhAnh.requestFocus();
            return false;
        }

        if (Validation.isEmpty(txtThanhPhan.getText().trim())) {
            MessageDialog.warring(this, "Thành phần không được để trống!");
            txtThanhPhan.requestFocus();
            return false;
        }

        if (Validation.isEmpty(txtSoLuong.getText().trim())) {
            MessageDialog.warring(this, "Số lượng không để trống!");
            txtSoLuong.requestFocus();
            return false;
        } else {
            try {
                int sl = Integer.parseInt(txtSoLuong.getText());
                if (sl < 0) {
                    MessageDialog.warring(this, "Số lượng phải >= 0");
                    txtSoLuong.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                MessageDialog.warring(this, "Số lượng phải là số!");
                txtSoLuong.requestFocus();
                return false;
            }
        }

        if (Validation.isEmpty(txtGiaNhap.getText().trim())) {
            MessageDialog.warring(this, "Giá nhập không được để trống!");
            txtGiaNhap.requestFocus();
            return false;
        } else {
            try {
                double gn = Double.parseDouble(txtGiaNhap.getText());
                if (gn < 0) {
                    MessageDialog.warring(this, "Giá nhập phải >= 0");
                    txtGiaNhap.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                MessageDialog.warring(this, "Giá nhập phải là số!");
                txtGiaNhap.requestFocus();
                return false;
            }
        }

        if (Validation.isEmpty(txtDonGia.getText().trim())) {
            MessageDialog.warring(this, "Đơn giá không được để trống!");
            txtDonGia.requestFocus();
            return false;
        } else {
            try {
                double gn = Double.parseDouble(txtGiaNhap.getText());
                double dg = Double.parseDouble(txtDonGia.getText());
                if (dg < 0) {
                    MessageDialog.warring(this, "Đơn giá phải >= 0");
                    txtDonGia.requestFocus();
                    return false;
                } else if (dg < gn) {
                    MessageDialog.warring(this, "Đon giá phải lớn hơn giá nhập!");
                    txtDonGia.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                MessageDialog.warring(this, "Đơn giá phải là số!");
                txtDonGia.requestFocus();
                return false;
            }
        }
        
        if (txtHanSuDung.getDate() == null || !txtHanSuDung.getDateFormatString().equals("dd/MM/yyyy")) {
            MessageDialog.warring(this, "Hạn sử dụng không được để trống và có kiểu dd/MM/yyyy");
            return false;
        } else if (txtHanSuDung.getDate().before(new Date())) {
            MessageDialog.warring(this, "Hạn sử dụng phải sau ngày hiện tại");
            return false;
        }

        return true;
    }

    private Thuoc getInputFields() {
        String id = thuoc.getId();
        String tenThuoc = txtTenThuoc.getText().trim();
        byte[] hinhAnh = thuocImage;
        String thanhPhan = txtThanhPhan.getText().trim();
        String idDVT = listDVT.get(cboxDonViTinh.getSelectedIndex()).getId();
        DonViTinh donViTinh = new DonViTinhController().selectById(idDVT);
        String idDM = listDM.get(cboxDanhMuc.getSelectedIndex()).getId();
        DanhMuc danhMuc = new DanhMucController().selectById(idDM);
        String idXX = listXX.get(cboxXuatXu.getSelectedIndex()).getId();
        XuatXu xuatXu = new XuatXuController().selectById(idXX);
        int soLuongTon = Integer.parseInt(txtSoLuong.getText());
        double giaNhap = Double.parseDouble(txtGiaNhap.getText().trim());
        double donGia = Double.parseDouble(txtDonGia.getText().trim());
        Date hanSuDung = txtHanSuDung.getDate();

        return new Thuoc(id, tenThuoc, hinhAnh, thanhPhan, donViTinh, danhMuc, xuatXu, soLuongTon, giaNhap, donGia, hanSuDung);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtHinhAnh = new javax.swing.JLabel();
        btnChooseImage = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lblHoTen = new javax.swing.JLabel();
        txtTenThuoc = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtThanhPhan = new javax.swing.JTextArea();
        jPanel21 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cboxDanhMuc = new javax.swing.JComboBox<>();
        jPanel23 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        cboxXuatXu = new javax.swing.JComboBox<>();
        jPanel24 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cboxDonViTinh = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtHanSuDung = new com.toedter.calendar.JDateChooser();
        jPanel26 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel15.setBackground(new java.awt.Color(0, 153, 153));
        jPanel15.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel15.setPreferredSize(new java.awt.Dimension(500, 50));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CẬP NHẬP THUỐC");
        jLabel8.setPreferredSize(new java.awt.Dimension(149, 40));
        jPanel15.add(jLabel8, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel15, java.awt.BorderLayout.NORTH);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 100));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 237, 237), 2, true));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 300));
        jPanel4.setLayout(new java.awt.BorderLayout());

        txtHinhAnh.setBackground(new java.awt.Color(255, 255, 255));
        txtHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtHinhAnh.setIcon(new FlatSVGIcon("./icon/image.svg"));
        txtHinhAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtHinhAnh.setPreferredSize(new java.awt.Dimension(200, 100));
        jPanel4.add(txtHinhAnh, java.awt.BorderLayout.CENTER);

        btnChooseImage.setText("Chọn ảnh");
        btnChooseImage.setPreferredSize(new java.awt.Dimension(100, 30));
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(btnChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 16));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 500));
        jPanel1.setLayout(new java.awt.GridLayout(5, 2, 16, 8));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        lblHoTen.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblHoTen.setText("Tên thuốc");
        lblHoTen.setMaximumSize(new java.awt.Dimension(44, 40));
        lblHoTen.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel18.add(lblHoTen);

        txtTenThuoc.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTenThuoc.setToolTipText("");
        txtTenThuoc.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel18.add(txtTenThuoc);

        jPanel1.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel12.setText("Thành phần");
        jLabel12.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel12.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel19.add(jLabel12);

        jScrollPane1.setMaximumSize(new java.awt.Dimension(300, 70));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 50));

        txtThanhPhan.setColumns(20);
        txtThanhPhan.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtThanhPhan.setLineWrap(true);
        txtThanhPhan.setRows(4);
        txtThanhPhan.setPreferredSize(new java.awt.Dimension(252, 50));
        jScrollPane1.setViewportView(txtThanhPhan);

        jPanel19.add(jScrollPane1);

        jPanel1.add(jPanel19);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel14.setText("Danh mục");
        jLabel14.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel14.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel21.add(jLabel14);

        cboxDanhMuc.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel21.add(cboxDanhMuc);

        jPanel1.add(jPanel21);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel23.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel16.setText("Xuất xứ");
        jLabel16.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel16.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel23.add(jLabel16);

        cboxXuatXu.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel23.add(cboxXuatXu);

        jPanel1.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel24.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel17.setText("Đơn vị tính");
        jLabel17.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel17.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel24.add(jLabel17);

        cboxDonViTinh.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel24.add(cboxDonViTinh);

        jPanel1.add(jPanel24);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel15.setText("Hạn sử dụng");
        jLabel15.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel15.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel22.add(jLabel15);

        txtHanSuDung.setBackground(new java.awt.Color(255, 255, 255));
        txtHanSuDung.setDateFormatString("dd/MM/yyyy");
        txtHanSuDung.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel22.add(txtHanSuDung);

        jPanel1.add(jPanel22);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel26.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel19.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel19.setText("Giá nhập");
        jLabel19.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel19.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel26.add(jLabel19);

        txtGiaNhap.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtGiaNhap.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel26.add(txtGiaNhap);

        jPanel1.add(jPanel26);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel25.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel18.setText("Đơn giá");
        jLabel18.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel18.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel25.add(jLabel18);

        txtDonGia.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDonGia.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel25.add(txtDonGia);

        jPanel1.add(jPanel25);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel13.setText("Số lượng");
        jLabel13.setMaximumSize(new java.awt.Dimension(44, 40));
        jLabel13.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel20.add(jLabel13);

        txtSoLuong.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtSoLuong.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel20.add(txtSoLuong);

        jPanel1.add(jPanel20);

        jPanel2.add(jPanel1);

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

        btnAdd.setBackground(new java.awt.Color(0, 204, 102));
        btnAdd.setFont(new java.awt.Font("Roboto Mono Medium", 0, 16)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("CẬP NHẬP");
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
            Thuoc e = getInputFields();
            THUOC_CON.update(e);
            this.dispose();
            MessageDialog.info(this, "Cập nhập thành công!");
            THUOC_GUI.loadTable(THUOC_CON.getAllList());
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filename = selectedFile.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename)
                    .getImage()
                    .getScaledInstance(txtHinhAnh.getWidth(), txtHinhAnh.getHeight(), Image.SCALE_SMOOTH));
            txtHinhAnh.setIcon(imageIcon);

            try {
                FileInputStream fis = new FileInputStream(new File(filename));
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                }
                thuocImage = bos.toByteArray();

            } catch (FileNotFoundException ex) {
                MessageDialog.error(this, "Lỗi nhập file!");
            } catch (IOException ex) {
                MessageDialog.error(this, "Lỗi nhập file!");
            }
        }
    }//GEN-LAST:event_btnChooseImageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnHuy;
    private javax.swing.JComboBox<String> cboxDanhMuc;
    private javax.swing.JComboBox<String> cboxDonViTinh;
    private javax.swing.JComboBox<String> cboxXuatXu;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGiaNhap;
    private com.toedter.calendar.JDateChooser txtHanSuDung;
    private javax.swing.JLabel txtHinhAnh;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenThuoc;
    private javax.swing.JTextArea txtThanhPhan;
    // End of variables declaration//GEN-END:variables
}
