package controller;

import dao.VaiTroDAO;
import entity.VaiTro;
import gui.page.VaiTroPage;
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
public class VaiTroController extends InterfaceController<VaiTro, String> {

    VaiTroDAO VT_DAO;
    VaiTroPage VT_GUI;

    public VaiTroController() {
        this.VT_DAO = new VaiTroDAO();
        this.VT_GUI = new VaiTroPage();
    }

    public VaiTroController(VaiTroPage VT_GUI) {
        this.VT_DAO = new VaiTroDAO();
        this.VT_GUI = VT_GUI;
    }

    @Override
    public void create(VaiTro e) {
        for (VaiTro vt : this.getAllList()) {
            if (vt.getId().equals(e.getId())) {
                MessageDialog.error(VT_GUI, "Trùng mã!");
            }
        }
        VT_DAO.create(e);
    }

    @Override
    public void update(VaiTro e) {
        VT_DAO.update(e);
    }

    @Override
    public void deleteById(String id) {
        VT_DAO.deleteById(id);
    }

    @Override
    public List<VaiTro> getAllList() {
        return VT_DAO.selectAll();
    }

    public List<String> getAllListId() {
        List<String> result = new ArrayList<>();

        this.getAllList().forEach(e -> {
            result.add(e.getId());
        });

        return result;
    }

    public String[] getArrayTenVaiTro() {
        int size = this.getAllList().size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = this.getAllList().get(i).getTen();
        }
        return result;
    }

    @Override
    public VaiTro selectById(String id) {
        return VT_DAO.selectById(id);
    }

    public String getTenVaiTroById(String id) {
        return VT_DAO.selectById(id).getTen();
    }

    public List<VaiTro> getSearchTable(String text, String searchType) {
        text = text.toLowerCase();
        List result = new ArrayList<VaiTro>();

        switch (searchType) {
            case "Tất cả" -> {
                for (VaiTro e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text) || e.getTen().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Mã" -> {
                for (VaiTro e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Tên" -> {
                for (VaiTro e : this.getAllList()) {
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
                        // Add NhanVien to databasef
                        VaiTro nv = new VaiTro(id, ten);
                        VT_DAO.create(nv);
                        VT_GUI.loadTable();
                    }

                }
                MessageDialog.info(VT_GUI, "Nhập dữ liệu thành công!");

            } catch (FileNotFoundException ex) {
                MessageDialog.error(VT_GUI, "Lỗi đọc file");
            } catch (IOException ex) {
                MessageDialog.error(VT_GUI, "Lỗi đọc file");
            }
        }
        if (check != 0) {
            MessageDialog.error(VT_GUI, "Có " + check + " dòng dữ liệu không được thêm vào!");
        }
    }

}
