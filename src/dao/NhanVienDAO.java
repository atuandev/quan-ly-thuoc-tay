package dao;

import connectDB.jdbcHelper;
import entity.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends InterfaceDAO<NhanVien, String> {

    private String INSERT_SQL_NV = "insert NhanVien values (?,?,?,?,?,?,?)";
    private String UPDATE_SQL = "update NhanVien set ho=?, ten=?, tuoi=?, phai=?, maPhong=?, tienLuong=? where maNV=?";
    private String DELETE_SQL = "delete from NhanVien where maNV = ?";
    private String SELECT_ALL_SQL = "SELECT * FROM NhanVien";

    private String SELECT_BY_ID = "SELECT * FROM NhanVien WHERE maNV = ?";
    private String SELECT_BY_KEY = "SELECT * FROM NhanVien WHERE name LIKE ? ";

    @Override
    public void insert(NhanVien e) {
        jdbcHelper.update(INSERT_SQL_NV, e.getId(), e.getHoTen(), e.getSdt(), e.isGioiTinh(), e.getEmail());
    }

    @Override
    public void update(NhanVien e) {
        jdbcHelper.update(UPDATE_SQL, e.getHoTen(), e.getSdt(), e.isGioiTinh(), e.getEmail(), e.getId());
    }

    @Override
    public void delete(String k) {
        jdbcHelper.update(DELETE_SQL, k);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> listE = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien e = new NhanVien();
//                e.setMaNV(rs.getString("maNV"));
//                e.setHo(rs.getString("ho"));
//                e.setTen(rs.getString("ten"));
//                e.setTuoi(rs.getInt("tuoi"));
//                e.setPhai(rs.getBoolean("phai"));
//                e.setTienLuong(rs.getDouble("tienLuong"));
//                e.setPhong(new PhongBan(rs.getString("maPhong")));
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
    public NhanVien selectById(String k) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<NhanVien> selectByKey(String k) {
        return selectBySql(SELECT_BY_KEY, "%" + k + "%");
    }

}
