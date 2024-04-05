package controller;

import dao.KhachHangDAO;
import entities.KhachHang;
import gui.page.KhachHangPage;
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
public class KhachHangController extends InterfaceController<KhachHang, String> {

    public KhachHangDAO KH_DAO = new KhachHangDAO();
    public KhachHangPage KH_GUI;

    public KhachHangController() {
    }

    public KhachHangController(KhachHangPage KH_GUI) {
        this.KH_GUI = KH_GUI;
    }

    @Override
    public void create(KhachHang e) {
        KH_DAO.create(e);
    }

    @Override
    public void update(KhachHang e) {
        KH_DAO.update(e);
    }

    @Override
    public void deleteById(String id) {
        KH_DAO.deleteById(id);
    }

    @Override
    public List<KhachHang> getAllList() {
        return KH_DAO.selectAll();
    }
    
    public int getSoLuongKH() {
        return this.getAllList().size();
    }

    @Override
    public KhachHang selectById(String id) {
        return KH_DAO.selectById(id);
    }
    
    public KhachHang selectBySdt(String sdt) {
        return KH_DAO.selectBySdt(sdt);
    }

    public List<KhachHang> getSearchTable(String text, String searchType) {
        text = text.toLowerCase();
        List result = new ArrayList<KhachHang>();

        switch (searchType) {
            case "Tất cả" -> {
                for (KhachHang e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text)
                            || e.getHoTen().toLowerCase().contains(text)
                            || e.getSdt().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Mã" -> {
                for (KhachHang e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Tên" -> {
                for (KhachHang e : this.getAllList()) {
                    if (e.getHoTen().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
             case "Số điện thoại" -> {
                for (KhachHang e : this.getAllList()) {
                    if (e.getSdt().toLowerCase().contains(text)) {
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
                    String hoTen = excelRow.getCell(1).getStringCellValue();
                    String sdt = excelRow.getCell(2).getStringCellValue();
                    String gioitinh = excelRow.getCell(3).getStringCellValue();
                    String ngay = excelRow.getCell(4).getStringCellValue();
                    Date ngayThamGia = new Date(ngay);

                    // Validate row cell
                    if (Validation.isEmpty(id) || Validation.isEmpty(hoTen)
                            || Validation.isEmpty(sdt) || !isPhoneNumber(sdt)
                            || Validation.isEmpty(gioitinh)
                            || Validation.isEmpty(ngayThamGia.toString())) {
                        check += 1;
                    } else {
                        KhachHang kh = new KhachHang(id, hoTen, sdt, gioitinh, ngayThamGia);
                        KH_DAO.create(kh);
                        KH_GUI.loadTable();
                    }

                }
                MessageDialog.info(KH_GUI, "Nhập dữ liệu thành công!");

            } catch (FileNotFoundException ex) {
                MessageDialog.error(KH_GUI, "Lỗi đọc file");
            } catch (IOException ex) {
                MessageDialog.error(KH_GUI, "Lỗi đọc file");
            }
        }
        if (check != 0) {
            MessageDialog.error(KH_GUI, "Có " + check + " dòng dữ liệu không được thêm vào!");
        }
    }

}
