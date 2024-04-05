package controller;

import dao.ThuocDAO;
import entities.DanhMuc;
import entities.DonViTinh;
import entities.Thuoc;
import entities.XuatXu;
import gui.page.CreateHoaDonPage;
import gui.page.ThuocPage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.MessageDialog;
import utils.Validation;

/**
 *
 * @author HP
 */
public class ThuocController extends InterfaceController<Thuoc, String> {

    public ThuocDAO THUOC_DAO = new ThuocDAO();
    public ThuocPage THUOC_GUI;

    public ThuocController() {
    }

    public ThuocController(ThuocPage THUOC_GUI) {
        this.THUOC_GUI = THUOC_GUI;
    }

    @Override
    public void create(Thuoc e) {
        THUOC_DAO.create(e);
    }

    @Override
    public void update(Thuoc e) {
        THUOC_DAO.update(e);
    }

    @Override
    public void deleteById(String id) {
        THUOC_DAO.deleteById(id);
    }

    @Override
    public List<Thuoc> getAllList() {
        return THUOC_DAO.selectAll();
    }

    public int getSoLuongThuoc() {
        return this.getAllList().size();
    }

    @Override
    public Thuoc selectById(String id) {
        return THUOC_DAO.selectById(id);
    }

    public void updateSoLuongTon(Thuoc e, int soLuong) {
        THUOC_DAO.updateSoLuongTon(e, soLuong);
    }

    public List<Thuoc> getSearchTable(String text, String searchType) {
        text = text.toLowerCase();
        List result = new ArrayList<Thuoc>();

        switch (searchType) {
            case "Tất cả" -> {
                for (Thuoc e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text)
                            || e.getTenThuoc().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Mã" -> {
                for (Thuoc e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Tên" -> {
                for (Thuoc e : this.getAllList()) {
                    if (e.getTenThuoc().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            default ->
                throw new AssertionError();
        }

        return result;
    }

    public List<Thuoc> getFilterTable(String tenDM, String tenDVT, String tenXX, long hanSuDung) {
        List<Thuoc> result = new ArrayList<>();

        for (Thuoc e : this.getAllList()) {
            boolean match = false;
            long timeHSD = e.getHanSuDung().getTime() - new Date().getTime();
            long dateHSD = TimeUnit.MILLISECONDS.toDays(timeHSD);

            if (e.getXuatXu().getTen().equals(tenXX)) {
                match = true;
            } else if (e.getDanhMuc().getTen().equals(tenDM)) {
                match = true;
            } else if (e.getDonViTinh().getTen().equals(tenDVT)) {
                match = true;
            } else if (dateHSD < hanSuDung) {
                match = true;
            }

            if (match) {
                result.add(e);
            }
        }

        return result;
    }

    public void importExcel() {
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelJTableImport = null;
        JFileChooser jf = new JFileChooser();
        jf.setDialogTitle("Open file");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        jf.setFileFilter(fnef);
        int result = jf.showOpenDialog(null);

        int check = 0;
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = jf.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelJTableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);

                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);

                    // Select row cell
                    String id = excelRow.getCell(0).getStringCellValue();
                    String tenThuoc = excelRow.getCell(1).getStringCellValue();
                    String image = excelRow.getCell(2).getStringCellValue();
                    byte[] hinhAnh = image.getBytes();
                    String thanhPhan = excelRow.getCell(3).getStringCellValue();

                    String idDVT = excelRow.getCell(4).getStringCellValue();
                    DonViTinh donViTinh = new DonViTinhController().selectById(idDVT);

                    String idDM = excelRow.getCell(5).getStringCellValue();
                    DanhMuc danhMuc = new DanhMucController().selectById(idDM);

                    String idXX = excelRow.getCell(6).getStringCellValue();
                    XuatXu xuatXu = new XuatXuController().selectById(idXX);

                    String sl = excelRow.getCell(7).getStringCellValue();
                    int soLuong = Integer.parseInt(sl);
                    String gn = excelRow.getCell(8).getStringCellValue();
                    double giaNhap = Double.parseDouble(gn);
                    String dg = excelRow.getCell(9).getStringCellValue();
                    double donGia = Double.parseDouble(dg);
                    String hsd = excelRow.getCell(10).getStringCellValue();
                    Date hanSuDung = new Date(hsd);

                    // Validate row cell
                    if (Validation.isEmpty(id) || Validation.isEmpty(tenThuoc) || Validation.isEmpty(image)
                            || Validation.isEmpty(thanhPhan) || Validation.isEmpty(idDVT) || Validation.isEmpty(idDM)
                            || Validation.isEmpty(idXX) || Validation.isEmpty(sl) || Validation.isEmpty(gn) || Validation.isEmpty(dg)) {
                        check += 1;
                    } else {
                        Thuoc e = new Thuoc(id, tenThuoc, hinhAnh, thanhPhan, donViTinh, danhMuc, xuatXu, soLuong, giaNhap, donGia, hanSuDung);
                        THUOC_DAO.create(e);
                        THUOC_GUI.loadTable(this.getAllList());
                    }

                }
                MessageDialog.info(null, "Nhập dữ liệu thành công!");

            } catch (FileNotFoundException ex) {
                MessageDialog.error(null, "Lỗi đọc file");
            } catch (IOException ex) {
                MessageDialog.error(null, "Lỗi đọc file");
            }
        }
        if (check != 0) {
            MessageDialog.error(null, "Có " + check + " dòng dữ liệu không được thêm vào!");
        }
    }

}
