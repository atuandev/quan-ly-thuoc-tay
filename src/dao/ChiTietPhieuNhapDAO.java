package dao;

import connectDB.JDBCConnection;
import controller.PhieuNhapController;
import controller.ThuocController;
import entities.ChiTietPhieuNhap;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChiTietPhieuNhapDAO implements ChiTietInterfaceDAO<ChiTietPhieuNhap, String> {

    private final String INSERT_SQL = "INSERT INTO ChiTietPhieuNhap values (?,?,?,?)";
    private final String DELETE_BY_ID = "DELETE from ChiTietPhieuNhap where idPN = ?";
    private final String SELECT_BY_ID = "SELECT * FROM ChiTietPhieuNhap WHERE idPN = ?";

    @Override
    public void create(List<ChiTietPhieuNhap> list) {
        for (ChiTietPhieuNhap e : list) {
            JDBCConnection.update(INSERT_SQL, e.getPhieuNhap().getId(), e.getThuoc().getId(), e.getSoLuong(), e.getDonGia());
        }
    }

    @Override
    public void update(String k, List<ChiTietPhieuNhap> e) {
        this.deleteById(k);
        this.create(e);
    }

    @Override
    public void deleteById(String k) {
        JDBCConnection.update(DELETE_BY_ID, k);
    }

    @Override
    public List<ChiTietPhieuNhap> selectAllById(String k) {
        return this.selectBySql(SELECT_BY_ID, k);
    }

    protected List<ChiTietPhieuNhap> selectBySql(String sql, Object... args) {
        List<ChiTietPhieuNhap> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                ChiTietPhieuNhap e = new ChiTietPhieuNhap();

                String idPN = rs.getString("idPN");
                e.setPhieuNhap(new PhieuNhapController().selectById(idPN));

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
