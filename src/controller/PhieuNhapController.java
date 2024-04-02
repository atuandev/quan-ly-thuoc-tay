package controller;

import dao.PhieuNhapDAO;
import entities.PhieuNhap;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class PhieuNhapController extends InterfaceController<PhieuNhap, String> {

    public PhieuNhapDAO PN_DAO = new PhieuNhapDAO();

    public PhieuNhapController() {
    }

    @Override
    public void create(PhieuNhap e) {
        PN_DAO.create(e);
    }

    @Override
    public void update(PhieuNhap e) {
        PN_DAO.update(e);
    }

    @Override
    public void deleteById(String id) {
        PN_DAO.deleteById(id);
    }

    @Override
    public List<PhieuNhap> getAllList() {
        return PN_DAO.selectAll();
    }

    @Override
    public PhieuNhap selectById(String id) {
        return PN_DAO.selectById(id);
    }

    public List<PhieuNhap> getSearchTable(String text, String searchType) {
        text = text.toLowerCase();
        List result = new ArrayList<PhieuNhap>();

        switch (searchType) {
            case "Tất cả" -> {
                for (PhieuNhap e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text)
                            || e.getNcc().getTen().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Mã" -> {
                for (PhieuNhap e : this.getAllList()) {
                    if (e.getId().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            case "Tên nhà cung cấp" -> {
                for (PhieuNhap e : this.getAllList()) {
                    if (e.getNcc().getTen().toLowerCase().contains(text)) {
                        result.add(e);
                    }
                }
            }
            default ->
                throw new AssertionError();
        }

        return result;
    }

    public List<PhieuNhap> getFilterTable(String tenNV, double fromPrice, double toPrice) {
        List<PhieuNhap> result = new ArrayList<>();

        for (PhieuNhap e : this.getAllList()) {
            boolean match = false;

            if (e.getNhanVien().getHoTen().equals(tenNV)) {
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
