package controller;

import dao.ChiTietHoaDonDAO;
import entities.ChiTietHoaDon;
import java.util.List;

/**
 *
 * @author HP
 */
public class ChiTietHoaDonController extends ChiTietInterfaceController<ChiTietHoaDon, String> {

    public ChiTietHoaDonDAO CTHD_DAO = new ChiTietHoaDonDAO();

    public ChiTietHoaDonController() {
    }

    @Override
    public void create(List<ChiTietHoaDon> e) {
        CTHD_DAO.create(e);
    }

    @Override
    public void update(String id, List<ChiTietHoaDon> e) {
        CTHD_DAO.update(id, e);
    }

    @Override
    public void deleteById(String id) {
        CTHD_DAO.deleteById(id);
    }

    @Override
    public List<ChiTietHoaDon> selectAllById(String id) {
        return CTHD_DAO.selectAllById(id);
    }
}
