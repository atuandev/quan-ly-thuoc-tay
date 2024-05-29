package dao;

import connectDB.JDBCConnection;
import entities.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends InterfaceDAO<NhanVien, String> {

    private final String INSERT_SQL = "INSERT INTO NhanVien values (?,?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE NhanVien SET hoTen=?, sdt=?, gioiTinh=?, namSinh=?, ngayVaoLam=? where idNV=?";
    private final String DELETE_BY_ID = "DELETE from NhanVien where idNV = ?";

    private final String SELECT_ALL_SQL = "SELECT * FROM NhanVien ORDER BY ngayVaoLam";
    private final String SELECT_BY_ID = "SELECT * FROM NhanVien WHERE idNV = ?";

    @Override
    public void create(NhanVien e) {
        JDBCConnection.update(INSERT_SQL, e.getId(), e.getHoTen(), e.getSdt(), e.getGioiTinh(), e.getNamSinh(), e.getNgayVaoLam());
    }

    @Override
    public void update(NhanVien e) {
        JDBCConnection.update(UPDATE_SQL, e.getHoTen(), e.getSdt(), e.getGioiTinh(), e.getNamSinh(), e.getNgayVaoLam(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        JDBCConnection.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                NhanVien e = new NhanVien();
                e.setId(rs.getString("idNV"));
                e.setHoTen(rs.getString("hoTen"));
                e.setSdt(rs.getString("sdt"));
                e.setGioiTinh(rs.getString("gioiTinh"));
                e.setNamSinh(rs.getInt("namSinh"));
                e.setNgayVaoLam(rs.getDate("ngayVaoLam"));
                listE.add(e);
            }
            rs.getStatement().getConnection().close();
            return listE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
