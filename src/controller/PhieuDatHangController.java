package controller;

import dao.PhieuDatHangDAO;
import entities.PhieuDatHang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class PhieuDatHangController extends InterfaceController<PhieuDatHang, String> {

    public PhieuDatHangDAO PDH_DAO = new PhieuDatHangDAO();

    public PhieuDatHangController() {
    }

    @Override
    public void create(PhieuDatHang e) {
        PDH_DAO.create(e);
    }

    @Override
    public void update(PhieuDatHang e) {
        PDH_DAO.update(e);
    }

    @Override
    public void deleteById(String id) {
        PDH_DAO.deleteById(id);
    }

    @Override
    public List<PhieuDatHang> getAllList() {
        return PDH_DAO.selectAll();
    }

    @Override
    public PhieuDatHang selectById(String id) {
        return PDH_DAO.selectById(id);
    }

    public List<PhieuDatHang> getSearchTable(String text, String searchType) {
        text = text.toLowerCase();
        List result = new ArrayList<PhieuDatHang>();

        switch (searchType) {
            case "Tất cả" -> {
                for (PhieuDatHang e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text)
                            || e.getKhachHang().getHoTen().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Mã" -> {
                for (PhieuDatHang e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Tên khách hàng" -> {
                for (PhieuDatHang e : this.getAllList()) {
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

    public List<PhieuDatHang> getFilterTable(String trangThai, String hinhThucThanhToan, double fromPrice, double toPrice) {
        List<PhieuDatHang> result = new ArrayList<>();

        for (PhieuDatHang e : this.getAllList()) {
            boolean match = false;

            if (e.getTrangThai().equals(trangThai)) {
                match = true;
            } else if (e.getHinhThucThanhToan().equals(hinhThucThanhToan)) {
                match = true;
            } else if (e.getTongTien() >= fromPrice && e.getTongTien() <= toPrice) {
                match = true;
            }

            if (match) {
                result.add(e);
            }
        }

        return result;
    }
}
