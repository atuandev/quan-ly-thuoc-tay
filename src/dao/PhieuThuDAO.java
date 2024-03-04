package dao;

import connectDB.jdbcHelper;
import entity.PhieuThu;
import entity.NhaSanXuat;
import entity.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhieuThuDAO extends InterfaceDAO<PhieuThu, String> {

    private String INSERT_SQL = "INSERT INTO PhieuThu values (?,?,?,?)";
    private String UPDATE_SQL = "UPDATE PhieuThu SET thoiGian=?, idNV=?, idNSX=? where id=?";
    private String DELETE_BY_ID = "DELETE from PhieuThu where id = ?";

    private String SELECT_ALL_SQL = "SELECT * FROM PhieuThu";
    private String SELECT_BY_ID = "SELECT * FROM PhieuThu WHERE id = ?";

    @Override
    public void create(PhieuThu e) {
        jdbcHelper.update(INSERT_SQL, e.getId(), e.getThoiGian(), e.getNhanVien().getId(), e.getNxs().getId());
    }

    @Override
    public void update(PhieuThu e) {
        jdbcHelper.update(UPDATE_SQL, e.getThoiGian(), e.getNhanVien().getId(), e.getNxs().getId(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        jdbcHelper.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<PhieuThu> selectBySql(String sql, Object... args) {
        List<PhieuThu> listE = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                PhieuThu e = new PhieuThu();
                e.setId(rs.getString("id"));
                e.setThoiGian(rs.getTimestamp("thoiGian"));
                e.setNhanVien(new NhanVien(rs.getString("idNV")));
                e.setNxs(new NhaSanXuat(rs.getString("idNSX")));
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
