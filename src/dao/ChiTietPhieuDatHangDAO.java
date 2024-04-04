package dao;

import connectDB.JDBCConnection;
import controller.PhieuDatHangController;
import controller.ThuocController;
import entities.ChiTietPhieuDatHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChiTietPhieuDatHangDAO implements ChiTietInterfaceDAO<ChiTietPhieuDatHang, String> {

    private final String INSERT_SQL = "INSERT INTO ChiTietPhieuDatHang values (?,?,?,?)";
    private final String DELETE_BY_ID = "DELETE from ChiTietPhieuDatHang where idPDH = ?";
    private final String SELECT_BY_ID = "SELECT * FROM ChiTietPhieuDatHang WHERE idPDH = ?";

    @Override
    public void create(List<ChiTietPhieuDatHang> list) {
        for (ChiTietPhieuDatHang e : list) {
            JDBCConnection.update(INSERT_SQL, e.getPhieuDatHang().getId(), e.getThuoc().getId(), e.getSoLuong(), e.getDonGia());
        }
    }

    @Override
    public void update(String k, List<ChiTietPhieuDatHang> e) {
        this.deleteById(k);
        this.create(e);
    }

    @Override
    public void deleteById(String k) {
        JDBCConnection.update(DELETE_BY_ID, k);
    }

    @Override
    public List<ChiTietPhieuDatHang> selectAllById(String k) {
        return this.selectBySql(SELECT_BY_ID, k);
    }

    protected List<ChiTietPhieuDatHang> selectBySql(String sql, Object... args) {
        List<ChiTietPhieuDatHang> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                ChiTietPhieuDatHang e = new ChiTietPhieuDatHang();
                
                String idPDH = rs.getString("idPDH");
                e.setPhieuDatHang(new PhieuDatHangController().selectById(idPDH));
                
                String idThuoc = rs.getString("idThuoc");
                e.setThuoc(new ThuocController().selectById(idThuoc));
                
                e.setSoLuong(rs.getInt("soLuong"));
                e.setDonGia(rs.getDouble("donGia"));
                listE.add(e);
            }
            rs.getStatement().getConnection().close();
            return listE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
