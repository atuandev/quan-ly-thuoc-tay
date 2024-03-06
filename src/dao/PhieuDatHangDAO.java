package dao;

import connectDB.jdbcHelper;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhieuDatHangDAO extends InterfaceDAO<PhieuDatHang, String> {

    private String INSERT_SQL = "INSERT INTO PhieuDatHang values (?,?,?,?,?,?)";
    private String UPDATE_SQL = "UPDATE PhieuDatHang SET thoiGian=?, idKH=?, diaChi=?, phuongThucThanhToan=?, trangThai=? where idPDH=?";
    private String DELETE_BY_ID = "DELETE from PhieuDatHang where idPDH = ?";

    private String SELECT_ALL_SQL = "SELECT * FROM PhieuDatHang";
    private String SELECT_BY_ID = "SELECT * FROM PhieuDatHang WHERE idPDH = ?";

    @Override
    public void create(PhieuDatHang e) {
        jdbcHelper.update(INSERT_SQL, e.getId(), e.getThoiGian(), e.getKhachHang().getId(), e.getDiaChi(), e.getHinhThucThanhToan(), e.getTrangThai());
    }

    @Override
    public void update(PhieuDatHang e) {
        jdbcHelper.update(UPDATE_SQL, e.getThoiGian(), e.getKhachHang().getId(), e.getDiaChi(), e.getHinhThucThanhToan(), e.getTrangThai(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        jdbcHelper.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<PhieuDatHang> selectBySql(String sql, Object... args) {
        List<PhieuDatHang> listE = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                PhieuDatHang e = new PhieuDatHang();
                e.setId(rs.getString("idPDH"));
                e.setThoiGian(rs.getTimestamp("thoiGian"));
                e.setKhachHang(new KhachHang(rs.getString("idKH")));
                e.setDiaChi(rs.getString("diaChi"));
                e.setHinhThucThanhToan(rs.getString("phuongThucThanhToan"));
                e.setTrangThai(rs.getString("trangThai"));
                listE.add(e);
            }
            rs.getStatement().getConnection().close();
            return listE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PhieuDatHang> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public PhieuDatHang selectById(String id) {
        List<PhieuDatHang> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
