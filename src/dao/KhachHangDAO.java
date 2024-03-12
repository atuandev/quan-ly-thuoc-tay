package dao;

import connectDB.jdbcHelper;
import entity.KhachHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO extends InterfaceDAO<KhachHang, String> {

    private final String INSERT_SQL = "INSERT INTO KhachHang values (?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE KhachHang SET hoTen=?, sdt=?, gioiTinh=?, ngayThamGia=? where idKH=?";
    private final String DELETE_BY_ID = "DELETE from KhachHang where idKH = ?";

    private final String SELECT_ALL_SQL = "SELECT * FROM KhachHang";
    private final String SELECT_BY_ID = "SELECT * FROM KhachHang WHERE idKH = ?";

    @Override
    public void create(KhachHang e) {
        jdbcHelper.update(INSERT_SQL, e.getId(), e.getHoTen(), e.getSdt(), e.getGioiTinh(), e.getNgayThamGia());
    }

    @Override
    public void update(KhachHang e) {
        jdbcHelper.update(UPDATE_SQL, e.getHoTen(), e.getSdt(), e.getGioiTinh(), e.getNgayThamGia(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        jdbcHelper.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> listE = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                KhachHang e = new KhachHang();
                e.setId(rs.getString("idKH"));
                e.setHoTen(rs.getString("hoTen"));
                e.setSdt(rs.getString("sdt"));
                e.setGioiTinh(rs.getString("gioiTinh"));
                e.setNgayThamGia(rs.getDate("ngayThamGia"));
                listE.add(e);
            }
            rs.getStatement().getConnection().close();
            return listE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<KhachHang> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhachHang selectById(String id) {
        List<KhachHang> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
