package controller;

import dao.DanhMucDAO;
import entities.DanhMuc;
import gui.dialog.ThuocTinhDanhMucDialog;
import gui.dialog.ThuocTinhDonViTinhDialog;
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
public class DanhMucController extends InterfaceController<DanhMuc, String> {

    DanhMucDAO DM_DAO = new DanhMucDAO();
    ThuocTinhDanhMucDialog DM_GUI;

    public DanhMucController() {
    }

    public DanhMucController(ThuocTinhDanhMucDialog DM_GUI) {
        this.DM_GUI = DM_GUI;
    }

    @Override
    public void create(DanhMuc e) {
        DM_DAO.create(e);
    }

    @Override
    public void update(DanhMuc e) {
        DM_DAO.update(e);
    }

    @Override
    public void deleteById(String id) {
        DM_DAO.deleteById(id);
    }

    @Override
    public List<DanhMuc> getAllList() {
        return DM_DAO.selectAll();
    }

    @Override
    public DanhMuc selectById(String id) {
        return DM_DAO.selectById(id);
    }

    public List<DanhMuc> getSearchTable(String text, String searchType) {
        text = text.toLowerCase();
        List result = new ArrayList<DanhMuc>();

        switch (searchType) {
            case "Tất cả" -> {
                for (DanhMuc e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text) || e.getTen().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Mã" -> {
                for (DanhMuc e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Tên" -> {
                for (DanhMuc e : this.getAllList()) {
                    if (e.getTen().toLowerCase().contains(text)) {
                        result.add(e);
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
                    String ten = excelRow.getCell(1).getStringCellValue();

                    // Validate row cell
                    if (Validation.isEmpty(id) || Validation.isEmpty(ten)) {
                        check += 1;
                    } else {
                        DanhMuc e = new DanhMuc(id, ten);
                        DM_DAO.create(e);
                        DM_GUI.loadTable();
                    }

                }
                MessageDialog.info(DM_GUI, "Nhập dữ liệu thành công!");

            } catch (FileNotFoundException ex) {
                MessageDialog.error(DM_GUI, "Lỗi đọc file");
            } catch (IOException ex) {
                MessageDialog.error(DM_GUI, "Lỗi đọc file");
            }
        }
        if (check != 0) {
            MessageDialog.error(DM_GUI, "Có " + check + " dòng dữ liệu không được thêm vào!");
        }
    }

}
