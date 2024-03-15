package controller;

import dao.ThuocDAO;
import entity.DanhMuc;
import entity.DonViTinh;
import entity.Thuoc;
import entity.XuatXu;
import gui.page.ThuocPage;
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
public class ThuocController extends InterfaceController<Thuoc, String> {

    public ThuocDAO THUOC_DAO = new ThuocDAO();
    public DanhMucController DM_DAO = new DanhMucController();
    public DonViTinhController DVT_DAO = new DonViTinhController();
    public XuatXuController XX_DAO = new XuatXuController();
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

    @Override
    public Thuoc selectById(String id) {
        return THUOC_DAO.selectById(id);
    }

    public DanhMuc getDanhMucByThuoc(Thuoc e) {
        return DM_DAO.selectById(e.getDanhMuc().getId());
    }

    public DonViTinh getDonViTinhByThuoc(Thuoc e) {
        return DVT_DAO.selectById(e.getDonViTinh().getId());
    }

    public XuatXu getXuatXuByThuoc(Thuoc e) {
        return XX_DAO.selectById(e.getXuatXu().getId());
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
                    DonViTinhController DVT_CON = new DonViTinhController();
                    DonViTinh donViTinh = DVT_CON.selectById(idDVT);

                    String idDM = excelRow.getCell(5).getStringCellValue();
                    DanhMucController DM_CON = new DanhMucController();
                    DanhMuc danhMuc = DM_CON.selectById(idDM);

                    String idXX = excelRow.getCell(6).getStringCellValue();
                    XuatXuController XX_CON = new XuatXuController();
                    XuatXu xuatXu = XX_CON.selectById(idXX);

                    String sl = excelRow.getCell(7).getStringCellValue();
                    int soLuong = Integer.parseInt(sl);
                    String gn = excelRow.getCell(8).getStringCellValue();
                    double giaNhap = Double.parseDouble(gn);
                    String dg = excelRow.getCell(9).getStringCellValue();
                    double donGia = Double.parseDouble(dg);

                    // Validate row cell
                    if (Validation.isEmpty(id) || Validation.isEmpty(tenThuoc) || Validation.isEmpty(image)
                            || Validation.isEmpty(thanhPhan) || Validation.isEmpty(idDVT) || Validation.isEmpty(idDM)
                            || Validation.isEmpty(idXX) || Validation.isEmpty(sl) || Validation.isEmpty(gn) || Validation.isEmpty(dg)) {
                        check += 1;
                    } else {
                        Thuoc e = new Thuoc(id, tenThuoc, hinhAnh, thanhPhan, donViTinh, danhMuc, xuatXu, soLuong, giaNhap, donGia);
                        THUOC_DAO.create(e);
                        THUOC_GUI.loadTable();
                    }

                }
                MessageDialog.info(THUOC_GUI, "Nhập dữ liệu thành công!");

            } catch (FileNotFoundException ex) {
                MessageDialog.error(THUOC_GUI, "Lỗi đọc file");
            } catch (IOException ex) {
                MessageDialog.error(THUOC_GUI, "Lỗi đọc file");
            }
        }
        if (check != 0) {
            MessageDialog.error(THUOC_GUI, "Có " + check + " dòng dữ liệu không được thêm vào!");
        }
    }

}
