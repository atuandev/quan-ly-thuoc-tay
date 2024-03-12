package dao;

import connectDB.jdbcHelper;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.VaiTro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO extends InterfaceDAO<TaiKhoan, String> {

    private final String INSERT_SQL = "INSERT INTO TaiKhoan values (?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE TaiKhoan SET username=?, password=?, idNV=?, idVT=? where idTK=?";
    private final String DELETE_BY_ID = "DELETE from TaiKhoan where idTK = ?";

    private final String SELECT_ALL_SQL = "SELECT * FROM TaiKhoan";
    private final String SELECT_BY_ID = "SELECT * FROM TaiKhoan WHERE idTK = ?";
    private final String SELECT_BY_USERNAME = "SELECT * FROM TaiKhoan WHERE username = ?";

    @Override
    public void create(TaiKhoan e) {
        jdbcHelper.update(INSERT_SQL, e.getId(), e.getUsername(), e.getPassword(), e.getNhanVien().getId(), e.getVaiTro().getId());
    }

    @Override
    public void update(TaiKhoan e) {
        jdbcHelper.update(UPDATE_SQL, e.getUsername(), e.getPassword(), e.getNhanVien().getId(), e.getVaiTro().getId(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        jdbcHelper.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> listE = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                TaiKhoan e = new TaiKhoan();
                e.setId(rs.getString("idTK"));
                e.setUsername(rs.getString("username"));
                e.setPassword(rs.getString("password"));
                e.setNhanVien(new NhanVien(rs.getString("idNV")));
                e.setVaiTro(new VaiTro(rs.getString("idVT")));
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
    public TaiKhoan selectById(String id) {
        List<TaiKhoan> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public TaiKhoan selectByUsername(String username) {
        List<TaiKhoan> list = selectBySql(SELECT_BY_USERNAME, username);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }


}
