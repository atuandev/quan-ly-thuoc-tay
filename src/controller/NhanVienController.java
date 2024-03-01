/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import dao.NhanVienDAO;
import entity.NhanVien;
import gui.page.NhanVienPage;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.Formatter;
import utils.MessageDialog;
import utils.Validation;

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
    public List<NhanVien> getList() {
        return NV_DAO.selectAll();
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
                for (NhanVien nv : this.getList()) {
                    if (nv.getId().toLowerCase().contains(text) || nv.getHoTen().toLowerCase().contains(text) || nv.getSdt().toLowerCase().contains(text) || String.valueOf(nv.getNamSinh()).toLowerCase().contains(text)) {
                        result.add(nv);
                    }
                }
            }
            case "Mã" -> {
                for (NhanVien nv : this.getList()) {
                    if (nv.getId().toLowerCase().contains(text)) {
                        result.add(nv);
                    }
                }
            }
            case "Tên" -> {
                for (NhanVien nv : this.getList()) {
                    if (nv.getHoTen().toLowerCase().contains(text)) {
                        result.add(nv);
                    }
                }
            }
            case "Số điện thoại" -> {
                for (NhanVien nv : this.getList()) {
                    if (nv.getGioiTinh().toLowerCase().contains(text)) {
                        result.add(nv);
                    }
                }
            }
            case "Năm sinh" -> {
                for (NhanVien nv : this.getList()) {
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
                            || Validation.isEmpty(sdt)
                            || Validation.isEmpty(gioitinh) || !isPhoneNumber(sdt)
                            || sdt.length() != 10 || Validation.isEmpty(ns) || Validation.isEmpty(ngayVaoLam.toString())) {
                        check += 1;
                    } else {
                        // Add NhanVien to database
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

    public static boolean isPhoneNumber(String str) {
        str = str.replaceAll("\\s+", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\-", "");

        if (str.matches("\\d{10}")) {
            return true;
        } else if (str.matches("\\d{3}-\\d{3}-\\d{4}")) {
            return true;
        } else return str.matches("\\(\\d{3}\\)\\d{3}-\\d{4}");
    }

    public void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            MessageDialog.error(NV_GUI, "Lỗi mở file!");
        }
    }

    public void exportExcel(List<NhanVien> list, String[] header) {
        try {
            if (!list.isEmpty()) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showSaveDialog(NV_GUI);
                File saveFile = jFileChooser.getSelectedFile();
                if (saveFile != null) {
                    saveFile = new File(saveFile.toString() + ".xlsx");
                    Workbook wb = new XSSFWorkbook();
                    Sheet sheet = wb.createSheet("Nhân viên");

                    writeHeader(header, sheet, 0);
                    int rowIndex = 1;
                    for (NhanVien nv : list) {
                        Row row = sheet.createRow(rowIndex++);
                        writeNhanVien(nv, row);
                    }
                    FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                    wb.write(out);
                    wb.close();
                    out.close();
                    openFile(saveFile.toString());
                }
            }
        } catch (HeadlessException | IOException e) {
            MessageDialog.error(NV_GUI, "Lỗi xuất file!");
        }
    }

    private static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

    private static void writeHeader(String[] list, Sheet sheet, int rowIndex) {
        CellStyle cellStyle = createStyleForHeader(sheet);
        Row row = sheet.createRow(rowIndex);
        Cell cell;
        for (int i = 0; i < list.length; i++) {
            cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(list[i]);
            sheet.autoSizeColumn(i);
        }
    }

    private static void writeNhanVien(NhanVien nv, Row row) {
        CellStyle cellStyleFormatNumber = null;
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workbook.createDataFormat();
            // short format = df.getFormat("#,##0");

            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }

        Cell cell = row.createCell(0);
        cell.setCellValue(nv.getId());

        cell = row.createCell(1);
        cell.setCellValue(nv.getHoTen());

        cell = row.createCell(2);
        cell.setCellValue(nv.getSdt());

        cell = row.createCell(3);
        cell.setCellValue(nv.getGioiTinh());

        cell = row.createCell(4);
        cell.setCellValue(nv.getNamSinh() + "");

        cell = row.createCell(5);
        cell.setCellValue(Formatter.FormatDateExcel(nv.getNgayVaoLam()));
    }

}
