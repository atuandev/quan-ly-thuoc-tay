package controller;

import dao.NhanVienDAO;
import entity.NhanVien;
import gui.page.NhanVienPage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.MessageDialog;
import utils.Validation;
import static utils.Validation.isPhoneNumber;

/**
 *
 * @author HP
 */
public class NhanVienController extends InterfaceController<NhanVien, String> {

    NhanVienDAO NV_DAO;
    NhanVienPage NV_GUI;

    public NhanVienController() {
        this.NV_DAO = new NhanVienDAO();
        this.NV_GUI = new NhanVienPage();
    }

    public NhanVienController(NhanVienPage NV_GUI) {
        this.NV_DAO = new NhanVienDAO();
        this.NV_GUI = NV_GUI;
    }

    @Override
    public void create(NhanVien e) {
        NV_DAO.create(e);
    }

    @Override
    public void update(NhanVien e) {
        NV_DAO.update(e);
    }

    @Override
    public void deleteById(String id) {
        NV_DAO.deleteById(id);
    }

    @Override
    public List<NhanVien> getListNV() {
        return NV_DAO.selectAll();
    }

    public List<String> getListSdt() {
        List<NhanVien> listNV = this.getListNV();
        List<String> result = new ArrayList<>();

        listNV.forEach(nv -> {
            result.add(nv.getSdt());
        });

        return result;
    }

    @Override
    public NhanVien selectById(String id) {
        return NV_DAO.selectById(id);
    }

    public List<NhanVien> getSearchTable(String text, String searchType) {
        text = text.toLowerCase();
        List result = new ArrayList<NhanVien>();

        switch (searchType) {
            case "Tất cả" -> {
                for (NhanVien nv : this.getListNV()) {
                    if (nv.getId().toLowerCase().contains(text) || nv.getHoTen().toLowerCase().contains(text) || nv.getSdt().toLowerCase().contains(text) || String.valueOf(nv.getNamSinh()).toLowerCase().contains(text)) {
                        result.add(nv);
                    }
                }
            }
            case "Mã" -> {
                for (NhanVien nv : this.getListNV()) {
                    if (nv.getId().toLowerCase().contains(text)) {
                        result.add(nv);
                    }
                }
            }
            case "Tên" -> {
                for (NhanVien nv : this.getListNV()) {
                    if (nv.getHoTen().toLowerCase().contains(text)) {
                        result.add(nv);
                    }
                }
            }
            case "Số điện thoại" -> {
                for (NhanVien nv : this.getListNV()) {
                    if (nv.getGioiTinh().toLowerCase().contains(text)) {
                        result.add(nv);
                    }
                }
            }
            case "Năm sinh" -> {
                for (NhanVien nv : this.getListNV()) {
                    if (String.valueOf(nv.getNamSinh()).toLowerCase().contains(text)) {
                        result.add(nv);
                    }
                }
            }
            default ->
                throw new AssertionError();
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
                    String hoTen = excelRow.getCell(1).getStringCellValue();
                    String sdt = excelRow.getCell(2).getStringCellValue();
                    String gioitinh = excelRow.getCell(3).getStringCellValue();
                    String ns = excelRow.getCell(4).getStringCellValue();
                    int namSinh = Integer.parseInt(ns);
                    String ngay = excelRow.getCell(5).getStringCellValue();
                    Date ngayVaoLam = new Date(ngay);

                    // Validate row cell
                    if (Validation.isEmpty(id) || Validation.isEmpty(hoTen)
                            || Validation.isEmpty(sdt) || !isPhoneNumber(sdt)
                            || Validation.isEmpty(gioitinh) || Validation.isEmpty(ns)
                            || Validation.isEmpty(ngayVaoLam.toString())) {
                        check += 1;
                    } else {
                        // Add NhanVien to databasef
                        NhanVien nv = new NhanVien(id, hoTen, sdt, gioitinh, namSinh, ngayVaoLam);
                        NV_DAO.create(nv);
                        NV_GUI.loadTableNhanVien();
                    }

                }
                MessageDialog.info(NV_GUI, "Nhập dữ liệu thành công!");

            } catch (FileNotFoundException ex) {
                MessageDialog.error(NV_GUI, "Lỗi đọc file");
            } catch (IOException ex) {
                MessageDialog.error(NV_GUI, "Lỗi đọc file");
            }
        }
        if (check != 0) {
            MessageDialog.error(NV_GUI, "Có " + check + " dòng dữ liệu không được thêm vào!");
        }
    }


}
