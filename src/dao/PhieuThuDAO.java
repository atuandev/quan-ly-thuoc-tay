package dao;

import connectDB.JDBCConnection;
import entity.PhieuThu;
import entity.NhaCungCap;
import entity.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhieuThuDAO extends InterfaceDAO<PhieuThu, String> {

    private final String INSERT_SQL = "INSERT INTO PhieuThu values (?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE PhieuThu SET thoiGian=?, idNV=?, idNCC=? where idPT=?";
    private final String DELETE_BY_ID = "DELETE from PhieuThu where idPT = ?";

    private final String SELECT_ALL_SQL = "SELECT * FROM PhieuThu";
    private final String SELECT_BY_ID = "SELECT * FROM PhieuThu WHERE idPT = ?";

    @Override
    public void create(PhieuThu e) {
        JDBCConnection.update(INSERT_SQL, e.getId(), e.getThoiGian(), e.getNhanVien().getId(), e.getNxs().getId());
    }

    @Override
    public void update(PhieuThu e) {
        JDBCConnection.update(UPDATE_SQL, e.getThoiGian(), e.getNhanVien().getId(), e.getNxs().getId(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        JDBCConnection.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<PhieuThu> selectBySql(String sql, Object... args) {
        List<PhieuThu> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                PhieuThu e = new PhieuThu();
                e.setId(rs.getString("idPT"));
                e.setThoiGian(rs.getTimestamp("thoiGian"));
                e.setNhanVien(new NhanVien(rs.getString("idNV")));
                e.setNxs(new NhaCungCap(rs.getString("idNCC")));
                listE.add(e);
            }
            rs.getStatement().getConnection().close();
            return listE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PhieuThu> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public PhieuThu selectById(String id) {
        List<PhieuThu> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
