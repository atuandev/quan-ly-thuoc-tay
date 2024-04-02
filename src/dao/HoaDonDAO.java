package dao;

import connectDB.JDBCConnection;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO extends InterfaceDAO<HoaDon, String> {

    private final String INSERT_SQL = "INSERT INTO HoaDon values (?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE HoaDon SET thoiGian=?, idNV=?, idKH=?, tongTien=? WHERE idHD=?";
    private final String DELETE_BY_ID = "DELETE from HoaDon WHERE idHD = ?";

    private final String SELECT_ALL_SQL
            = "SELECT HoaDon.idHD, HoaDon.thoiGian, HoaDon.idNV, HoaDon.idKH, HoaDon.tongTien, "
            + "NhanVien.hoTen AS tenNV, NhanVien.sdt AS sdtNV, NhanVien.gioiTinh AS gioiTinhNV, NhanVien.namSinh, NhanVien.ngayVaoLam, "
            + "KhachHang.hoTen AS tenKH, KhachHang.sdt AS sdtKH, KhachHang.gioiTinh AS gioiTinhKH, KhachHang.ngayThamGia "
            + "FROM HoaDon "
            + "INNER JOIN NhanVien ON HoaDon.idNV = NhanVien.idNV "
            + "INNER JOIN KhachHang ON HoaDon.idKH = KhachHang.idKH "
            + "ORDER BY HoaDon.thoiGian ";

    private final String SELECT_BY_ID
            = "SELECT HoaDon.idHD, HoaDon.thoiGian, HoaDon.idNV, HoaDon.idKH, HoaDon.tongTien, "
            + "NhanVien.hoTen AS tenNV, NhanVien.sdt AS sdtNV, NhanVien.gioiTinh AS gioiTinhNV, NhanVien.namSinh, NhanVien.ngayVaoLam, "
            + "KhachHang.hoTen AS tenKH, KhachHang.sdt AS sdtKH, KhachHang.gioiTinh AS gioiTinhKH, KhachHang.ngayThamGia "
            + "FROM HoaDon "
            + "INNER JOIN NhanVien ON HoaDon.idNV = NhanVien.idNV "
            + "INNER JOIN KhachHang ON HoaDon.idKH = KhachHang.idKH "
            + "WHERE idHD = ? "
            + "ORDER BY HoaDon.thoiGian ";

    @Override
    public void create(HoaDon e) {
        JDBCConnection.update(INSERT_SQL, e.getId(), e.getThoiGian(), e.getNhanVien().getId(), e.getKhachHang().getId(), e.getTongTien());
    }

    @Override
    public void update(HoaDon e) {
        JDBCConnection.update(UPDATE_SQL, e.getThoiGian(), e.getNhanVien().getId(), e.getKhachHang().getId(), e.getTongTien(), e.getId());
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
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getString("idHD"));
                hoaDon.setThoiGian(rs.getTimestamp("thoiGian"));

                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getString("idNV"));
                nhanVien.setHoTen(rs.getString("tenNV"));
                nhanVien.setSdt(rs.getString("sdtNV"));
                nhanVien.setGioiTinh(rs.getString("gioiTinhNV"));
                nhanVien.setNamSinh(rs.getInt("namSinh"));
                nhanVien.setNgayVaoLam(rs.getDate("ngayVaoLam"));

                hoaDon.setNhanVien(nhanVien);

                KhachHang khachHang = new KhachHang();
                khachHang.setId(rs.getString("idKH"));
                khachHang.setHoTen(rs.getString("tenKH"));
                khachHang.setSdt(rs.getString("sdtKH"));
                khachHang.setGioiTinh(rs.getString("gioiTinhKH"));
                khachHang.setNgayThamGia(rs.getDate("ngayThamGia"));

                hoaDon.setKhachHang(khachHang);

                hoaDon.setTongTien(rs.getDouble("tongTien"));

                listE.add(hoaDon);
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
