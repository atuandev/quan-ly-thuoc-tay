package dao;

import connectDB.jdbcHelper;
import entity.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends InterfaceDAO<NhanVien, String> {

    private String INSERT_SQL = "insert NhanVien values (?,?,?,?,?,?)";
    private String UPDATE_SQL = "update NhanVien set hoTen=?, sdt=?, gioiTinh=?, namSinh=?, ngayVaoLam=? where id=?";
    private String DELETE_BY_ID = "delete from NhanVien where id = ?";

    private String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    private String SELECT_BY_ID = "SELECT * FROM NhanVien WHERE id = ?";
    private String SELECT_BY_HO_TEN = "SELECT * FROM NhanVien WHERE hoTen LIKE ? ";
    private String SELECT_BY_SDT = "SELECT * FROM NhanVien WHERE sdt LIKE ? ";

    @Override
    public void create(NhanVien e) {
        jdbcHelper.update(INSERT_SQL, e.getId(), e.getHoTen(), e.getSdt(), e.getGioiTinh(), e.getNamSinh(), e.getNgayVaoLam());
    }

    @Override
    public void update(NhanVien e) {
        jdbcHelper.update(UPDATE_SQL, e.getHoTen(), e.getSdt(), e.getGioiTinh(), e.getNamSinh(), e.getNgayVaoLam(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        jdbcHelper.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> listE = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien e = new NhanVien();
                e.setId(rs.getString("id"));
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

//    public List<NhanVien> selectByHoTen(String k) {
//        return selectBySql(SELECT_BY_HO_TEN, "%" + k + "%");
//    }
//    
//    public List<NhanVien> selectBySDT(String k) {
//        return selectBySql(SELECT_BY_SDT, "%" + k + "%");
//    }

}
