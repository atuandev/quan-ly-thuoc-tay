package controller;

import dao.XuatXuDAO;
import entities.XuatXu;
import gui.dialog.ThuocTinhXuatXuDialog;
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
public class XuatXuController extends InterfaceController<XuatXu, String> {

    XuatXuDAO XX_DAO = new XuatXuDAO();
    ThuocTinhXuatXuDialog XX_GUI;

    public XuatXuController() {
    }

    public XuatXuController(ThuocTinhXuatXuDialog XX_GUI) {
        this.XX_GUI = XX_GUI;
    }

    @Override
    public void create(XuatXu e) {
        XX_DAO.create(e);
    }

    @Override
    public void update(XuatXu e) {
        XX_DAO.update(e);
    }

    @Override
    public void deleteById(String id) {
        XX_DAO.deleteById(id);
    }

    @Override
    public List<XuatXu> getAllList() {
        return XX_DAO.selectAll();
    }

    @Override
    public XuatXu selectById(String id) {
        return XX_DAO.selectById(id);
    }

    public List<XuatXu> getSearchTable(String text, String searchType) {
        text = text.toLowerCase();
        List result = new ArrayList<XuatXu>();

        switch (searchType) {
            case "Tất cả" -> {
                for (XuatXu e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text) || e.getTen().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Mã" -> {
                for (XuatXu e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Tên" -> {
                for (XuatXu e : this.getAllList()) {
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
                        XuatXu e = new XuatXu(id, ten);
                        XX_DAO.create(e);
                        XX_GUI.loadTable();
                    }

                }
                MessageDialog.info(XX_GUI, "Nhập dữ liệu thành công!");

            } catch (FileNotFoundException ex) {
                MessageDialog.error(XX_GUI, "Lỗi đọc file");
            } catch (IOException ex) {
                MessageDialog.error(XX_GUI, "Lỗi đọc file");
            }
        }
        if (check != 0) {
            MessageDialog.error(XX_GUI, "Có " + check + " dòng dữ liệu không được thêm vào!");
        }
    }

}
