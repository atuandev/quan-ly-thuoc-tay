package controller;

import dao.ChiTietPhieuDatHangDAO;
import entities.ChiTietPhieuDatHang;
import java.util.List;

/**
 *
 * @author HP
 */
public class ChiTietPhieuDatHangController extends ChiTietInterfaceController<ChiTietPhieuDatHang, String> {

    public ChiTietPhieuDatHangDAO CTPDH_DAO = new ChiTietPhieuDatHangDAO();

    public ChiTietPhieuDatHangController() {
    }

    @Override
    public void create(List<ChiTietPhieuDatHang> e) {
        CTPDH_DAO.create(e);
    }

    @Override
    public void update(String id, List<ChiTietPhieuDatHang> e) {
        CTPDH_DAO.update(id, e);
    }

    @Override
    public void deleteById(String id) {
        CTPDH_DAO.deleteById(id);
    }

    @Override
    public List<ChiTietPhieuDatHang> selectAllById(String id) {
        return CTPDH_DAO.selectAllById(id);
    }
}
