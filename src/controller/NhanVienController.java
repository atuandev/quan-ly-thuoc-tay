/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.NhanVienDAO;
import entity.NhanVien;
import gui.page.NhanVienPage;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.MessageDialog;

/**
 *
 * @author HP
 */
public class NhanVienController extends InterfaceController<NhanVien, String>{

    NhanVienDAO NV_DAO = new NhanVienDAO();
    NhanVienPage NV_GUI;

    public NhanVienController() {
    }

    public NhanVienController(NhanVienPage NV_GUI) {
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
        cell.setCellValue(nv.getNgayVaoLam().toString());
    }

}
