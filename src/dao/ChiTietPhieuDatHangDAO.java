package dao;

import connectDB.JDBCConnection;
import entity.ChiTietPhieuDatHang;
import entity.PhieuDatHang;
import entity.Thuoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChiTietPhieuDatHangDAO implements ChiTietInterfaceDAO<ChiTietPhieuDatHang, String> {

    private final String INSERT_SQL = "INSERT INTO ChiTietPhieuDatHang values (?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE ChiTietPhieuDatHang SET idThuoc=?, soLuong=?, donGia=? where idPDH=?";
    private final String DELETE_BY_ID = "DELETE from ChiTietPhieuDatHang where idPDH = ?";

    private final String SELECT_ALL_SQL = "SELECT * FROM ChiTietPhieuDatHang";
    private final String SELECT_BY_ID = "SELECT * FROM ChiTietPhieuDatHang WHERE idPDH = ?";

    @Override
    public void insert(List<ChiTietPhieuDatHang> e) {
        for (int i = 0; i < e.size(); i++) {
            JDBCConnection.update(INSERT_SQL, e.get(i).getPhieuDatHang().getId(), e.get(i).getThuoc().getId(), e.get(i).getSoLuong(), e.get(i).getDonGia());
        }
    }

    @Override
    public void update(String k, List<ChiTietPhieuDatHang> e) {
        this.deleteById(k);
        this.insert(e);
    }

    @Override
    public void deleteById(String k) {
        JDBCConnection.update(DELETE_BY_ID, k);
    }

    @Override
    public List<ChiTietPhieuDatHang> selectAllById(String k) {
        return this.selectBySql(SELECT_BY_ID);
    }

    protected List<ChiTietPhieuDatHang> selectBySql(String sql, Object... args) {
        List<ChiTietPhieuDatHang> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                ChiTietPhieuDatHang e = new ChiTietPhieuDatHang();
                e.setPhieuDatHang(new PhieuDatHang(rs.getString("idPDH")));
                e.setThuoc(new Thuoc(rs.getString("idThuoc")));
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
