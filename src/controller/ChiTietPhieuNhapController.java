package controller;

import dao.ChiTietPhieuNhapDAO;
import entities.ChiTietPhieuNhap;
import java.util.List;

/**
 *
 * @author HP
 */
public class ChiTietPhieuNhapController extends ChiTietInterfaceController<ChiTietPhieuNhap, String> {

    public ChiTietPhieuNhapDAO CTHD_DAO = new ChiTietPhieuNhapDAO();

    public ChiTietPhieuNhapController() {
    }

    @Override
    public void create(List<ChiTietPhieuNhap> e) {
        CTHD_DAO.create(e);
    }

    @Override
    public void update(String id, List<ChiTietPhieuNhap> e) {
        CTHD_DAO.update(id, e);
    }

    @Override
    public void deleteById(String id) {
        CTHD_DAO.deleteById(id);
    }

    @Override
    public List<ChiTietPhieuNhap> selectAllById(String id) {
        return CTHD_DAO.selectAllById(id);
    }
}
