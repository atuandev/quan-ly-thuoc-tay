package controller;

import dao.TaiKhoanDAO;
import entities.NhanVien;
import entities.TaiKhoan;
import entities.VaiTro;
import gui.page.TaiKhoanPage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class TaiKhoanController extends InterfaceController<TaiKhoan, String> {

    public TaiKhoanDAO TK_DAO = new TaiKhoanDAO();
    public TaiKhoanPage TK_GUI;

    public TaiKhoanController() {
    }

    public TaiKhoanController(TaiKhoanPage NV_GUI) {
        this.TK_GUI = NV_GUI;
    }

    @Override
    public void create(TaiKhoan e) {
        TK_DAO.create(e);
    }

    @Override
    public void update(TaiKhoan e) {
        TK_DAO.update(e);
    }

    @Override
    public void deleteById(String id) {
        TK_DAO.deleteById(id);
    }

    @Override
    public List<TaiKhoan> getAllList() {
        return TK_DAO.selectAll();
    }

    public List<NhanVien> getListNV() {
        List<NhanVien> result = new ArrayList<>();

        this.getAllList().forEach(e -> {
            result.add(e.getNhanVien());
        });

        return result;
    }

    @Override
    public TaiKhoan selectById(String id) {
        return TK_DAO.selectById(id);
    }

    public TaiKhoan selectByUsername(String username) {
        return TK_DAO.selectByUsername(username);
    }

    public List<TaiKhoan> getSearchTable(String text, String searchType) {
        text = text.toLowerCase();
        List result = new ArrayList<TaiKhoan>();

        switch (searchType) {
            case "Tất cả" -> {
                for (TaiKhoan e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text)
                            || e.getUsername().toLowerCase().contains(text)
                            || e.getNhanVien().getHoTen().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Username" -> {
                for (TaiKhoan e : this.getAllList()) {
                    if (e.getUsername().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Tên nhân viên" -> {
                for (TaiKhoan e : this.getAllList()) {
                    if (e.getNhanVien().getHoTen().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            default ->
                throw new AssertionError();
        }

        return result;
    }

    public List<TaiKhoan> getFilterTable(String tenVT) {
        List<TaiKhoan> result = new ArrayList<>();

        for (TaiKhoan e : this.getAllList()) {
            boolean match = false;

            if (e.getVaiTro().getTen().equals(tenVT)) {
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
                    String username = excelRow.getCell(1).getStringCellValue();
                    String password = excelRow.getCell(2).getStringCellValue();
                    String idNV = excelRow.getCell(3).getStringCellValue();
                    String idVT = excelRow.getCell(4).getStringCellValue();

                    // Validate row cell
                    if (Validation.isEmpty(id) || Validation.isEmpty(username) || Validation.isEmpty(password)
                            || Validation.isEmpty(idNV) || Validation.isEmpty(idVT)) {
                        check += 1;
                    } else {
                        TaiKhoan tk = new TaiKhoan(id, username, password, new NhanVien(idNV), new VaiTro(idVT));
                        TK_DAO.create(tk);
                        TK_GUI.loadTable(this.getAllList());
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
            MessageDialog.error(null, "Có " + check + " dữ liệu không được thêm vào!");
        }
    }

}
