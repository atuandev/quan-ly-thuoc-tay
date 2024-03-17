package dao;

import connectDB.JDBCConnection;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO extends InterfaceDAO<HoaDon, String> {

    private final String INSERT_SQL = "INSERT INTO HoaDon values (?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE HoaDon SET thoiGian=?, idNV=?, idKH=? where idHD=?";
    private final String DELETE_BY_ID = "DELETE from HoaDon where idHD = ?";

    private final String SELECT_ALL_SQL = "SELECT * FROM HoaDon";
    private final String SELECT_BY_ID = "SELECT * FROM HoaDon WHERE idHD = ?";

    @Override
    public void create(HoaDon e) {
        JDBCConnection.update(INSERT_SQL, e.getId(), e.getThoiGian(), e.getNhanVien().getId(), e.getKhachHang().getId());
    }

    @Override
    public void update(HoaDon e) {
        JDBCConnection.update(UPDATE_SQL, e.getThoiGian(), e.getNhanVien().getId(), e.getKhachHang().getId(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        JDBCConnection.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                HoaDon e = new HoaDon();
                e.setId(rs.getString("idHD"));
                e.setThoiGian(rs.getTimestamp("thoiGian"));
                e.setNhanVien(new NhanVien(rs.getString("idNV")));
                e.setKhachHang(new KhachHang(rs.getString("idKH")));
                listE.add(e);
            }
            rs.getStatement().getConnection().close();
            return listE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public HoaDon selectById(String id) {
        List<HoaDon> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
