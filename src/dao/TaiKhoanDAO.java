package dao;

import connectDB.jdbcHelper;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.VaiTro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO extends InterfaceDAO<TaiKhoan, String> {

    private String INSERT_SQL = "INSERT INTO TaiKhoan values (?,?,?,?)";
    private String UPDATE_SQL = "UPDATE TaiKhoan SET password=?, idNV=?, idVaiTro=? where username=?";
    private String DELETE_BY_ID = "DELETE from TaiKhoan where username = ?";

    private String SELECT_ALL_SQL = "SELECT * FROM TaiKhoan";
    private String SELECT_BY_ID = "SELECT * FROM TaiKhoan WHERE username = ?";

    @Override
    public void create(TaiKhoan e) {
        jdbcHelper.update(INSERT_SQL, e.getUsername(), e.getPassword(), e.getNhanVien().getId(), e.getVaiTro().getId());
    }

    @Override
    public void update(TaiKhoan e) {
        jdbcHelper.update(UPDATE_SQL, e.getPassword(), e.getNhanVien().getId(), e.getVaiTro().getId(), e.getUsername());
    }

    @Override
    public void deleteById(String username) {
        jdbcHelper.update(DELETE_BY_ID, username);
    }

    @Override
    protected List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> listE = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                TaiKhoan e = new TaiKhoan();
                e.setUsername(rs.getString("username"));
                e.setPassword(rs.getString("password"));
                e.setNhanVien(new NhanVien(rs.getString("idNV")));
                e.setVaiTro(new VaiTro(rs.getString("idVaiTro")));
                listE.add(e);
            }
            rs.getStatement().getConnection().close();
            return listE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TaiKhoan> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public TaiKhoan selectById(String username) {
        List<TaiKhoan> list = selectBySql(SELECT_BY_ID, username);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
