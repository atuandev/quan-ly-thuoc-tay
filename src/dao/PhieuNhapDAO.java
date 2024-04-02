package dao;

import connectDB.JDBCConnection;
import controller.NhaCungCapController;
import controller.NhanVienController;
import entities.PhieuNhap;
import entities.NhaCungCap;
import entities.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhapDAO extends InterfaceDAO<PhieuNhap, String> {

    private final String INSERT_SQL = "INSERT INTO PhieuThu values (?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE PhieuThu SET thoiGian=?, idNV=?, idNCC=? where idPT=?";
    private final String DELETE_BY_ID = "DELETE from PhieuThu where idPT = ?";

    private final String SELECT_ALL_SQL = """
        SELECT PT.idPT, PT.thoiGian, 
               NV.hoTen AS tenNV, NV.sdt AS sdtNV, NV.gioiTinh, NV.namSinh, NV.ngayVaoLam, 
               NCC.tenNCC, NCC.sdt AS sdtNCC, NCC.diaChi 
        FROM PhieuThu PT 
        JOIN NhanVien NV ON PT.idNV = NV.idNV 
        JOIN NhaCungCap NCC ON PT.idNCC = NCC.idNCC 
        ORDER BY PhieuThu.thoiGian ; """;
    
    private final String SELECT_BY_ID = """
        SELECT PT.idPT, PT.thoiGian, 
                NV.idNV, NV.hoTen AS tenNV, NV.sdt AS sdtNV, NV.gioiTinh, NV.namSinh, NV.ngayVaoLam, 
                NCC.idNCC, NCC.tenNCC, NCC.sdt AS sdtNCC, NCC.diaChi 
        FROM PhieuThu PT 
        JOIN NhanVien NV ON PT.idNV = NV.idNV 
        JOIN NhaCungCap NCC ON PT.idNCC = NCC.idNCC 
        WHERE idPT = ? 
        ORDER BY PhieuThu.thoiGian;""";

    @Override
    public void create(PhieuNhap e) {
        JDBCConnection.update(INSERT_SQL, e.getId(), e.getThoiGian(), e.getNhanVien().getId(), e.getNcc().getId());
    }

    @Override
    public void update(PhieuNhap e) {
        JDBCConnection.update(UPDATE_SQL, e.getThoiGian(), e.getNhanVien().getId(), e.getNcc().getId(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        JDBCConnection.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<PhieuNhap> selectBySql(String sql, Object... args) {
        List<PhieuNhap> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                PhieuNhap e = new PhieuNhap();
                e.setId(rs.getString("idPT"));
                e.setThoiGian(rs.getTimestamp("thoiGian"));
                
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getString("idNV"));
                nhanVien.setHoTen(rs.getString("tenNV"));
                nhanVien.setSdt(rs.getString("sdtNV"));
                nhanVien.setGioiTinh(rs.getString("gioiTinh"));
                nhanVien.setNamSinh(rs.getInt("namSinh"));
                nhanVien.setNgayVaoLam(rs.getDate("ngayVaoLam"));
                e.setNhanVien(nhanVien);
                
                NhaCungCap ncc = new NhaCungCapController().selectById(rs.getString("idNCC"));
                e.setNcc(ncc);
                listE.add(e);
            }
            rs.getStatement().getConnection().close();
            return listE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PhieuNhap> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public PhieuNhap selectById(String id) {
        List<PhieuNhap> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
