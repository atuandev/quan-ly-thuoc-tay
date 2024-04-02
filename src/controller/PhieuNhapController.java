package controller;

import dao.PhieuNhapDAO;
import entities.ChiTietPhieuNhap;
import entities.PhieuNhap;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class PhieuNhapController extends InterfaceController<PhieuNhap, String> {

    public PhieuNhapDAO HD_DAO = new PhieuNhapDAO();
//    public HoaDonPage HD_GUI;

    public PhieuNhapController() {
    }

//    public PhieuNhapController(HoaDonPage THUOC_GUI) {
//        this.HD_GUI = THUOC_GUI;
//    }

    @Override
    public void create(PhieuNhap e) {
        HD_DAO.create(e);
    }

    @Override
    public void update(PhieuNhap e) {
        HD_DAO.update(e);
    }

    @Override
    public void deleteById(String id) {
        HD_DAO.deleteById(id);
    }

    @Override
    public List<PhieuNhap> getAllList() {
        return HD_DAO.selectAll();
    }

    @Override
    public PhieuNhap selectById(String id) {
        return HD_DAO.selectById(id);
    }
    
//    public double getTongTien(PhieuNhap hd) {
//        List<ChiTietPhieuNhap> listCTHD = new ChiTietHoaDonController().selectAllById(hd.getId());
//        double sum = 0;
//        for (ChiTietPhieuNhap cthd : listCTHD) {
//            sum += cthd.getThanhTien();
//        }
//        return sum;
//    }

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
            }
            
            // TODO: filter by price
            
            if (match) {
                result.add(e);
            }
        }

        return result;
    }
}
