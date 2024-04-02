package controller;

import dao.HoaDonDAO;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import gui.page.HoaDonPage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class HoaDonController extends InterfaceController<HoaDon, String> {

    public HoaDonDAO HD_DAO = new HoaDonDAO();
    public HoaDonPage HD_GUI;

    public HoaDonController() {
    }

    public HoaDonController(HoaDonPage THUOC_GUI) {
        this.HD_GUI = THUOC_GUI;
    }

    @Override
    public void create(HoaDon e) {
        HD_DAO.create(e);
    }

    @Override
    public void update(HoaDon e) {
        HD_DAO.update(e);
    }

    @Override
    public void deleteById(String id) {
        HD_DAO.deleteById(id);
    }

    @Override
    public List<HoaDon> getAllList() {
        return HD_DAO.selectAll();
    }

    @Override
    public HoaDon selectById(String id) {
        return HD_DAO.selectById(id);
    }
    
    public double getTongTien(HoaDon hd) {
        List<ChiTietHoaDon> listCTHD = new ChiTietHoaDonController().selectAllById(hd.getId());
        double sum = 0;
        for (ChiTietHoaDon cthd : listCTHD) {
            sum += cthd.getThanhTien();
        }
        return sum;
    }

    public List<HoaDon> getSearchTable(String text, String searchType) {
        text = text.toLowerCase();
        List result = new ArrayList<HoaDon>();

        switch (searchType) {
            case "Tất cả" -> {
                for (HoaDon e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text)
                            || e.getKhachHang().getHoTen().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Mã" -> {
                for (HoaDon e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Tên khách hàng" -> {
                for (HoaDon e : this.getAllList()) {
                    if (e.getKhachHang().getHoTen().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            default ->
                throw new AssertionError();
        }

        return result;
    }

    public List<HoaDon> getFilterTable(String tenNV, double fromPrice, double toPrice) {
        List<HoaDon> result = new ArrayList<>();

        for (HoaDon e : this.getAllList()) {
            boolean match = false;

            if (e.getNhanVien().getHoTen().equals(tenNV)) {
                match = true;
            }
            
            if (match) {
                result.add(e);
            }
        }

        return result;
    }
}
