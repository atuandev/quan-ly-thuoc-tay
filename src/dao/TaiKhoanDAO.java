package dao;

import connectDB.JDBCConnection;
import entities.NhanVien;
import entities.TaiKhoan;
import entities.VaiTro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO extends InterfaceDAO<TaiKhoan, String> {

    private final String INSERT_SQL = "INSERT INTO TaiKhoan values (?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE TaiKhoan SET username=?, password=?, idNV=?, idVT=? where idTK=?";
    private final String DELETE_BY_ID = "DELETE from TaiKhoan where idTK = ?";

    private final String SELECT_ALL_SQL
            = "SELECT tk.*, nv.hoTen, nv.sdt, nv.gioiTinh, nv.namSinh, nv.ngayVaoLam, vt.ten as tenVT "
            + "FROM TaiKhoan tk "
            + "INNER JOIN NhanVien nv ON tk.idNV = nv.idNV "
            + "INNER JOIN VaiTro vt ON tk.idVT = vt.idVT";
    
    private final String SELECT_BY_ID = "SELECT tk.*, nv.hoTen, nv.sdt, nv.gioiTinh, nv.namSinh, nv.ngayVaoLam, vt.ten as tenVT "
            + "FROM TaiKhoan tk "
            + "INNER JOIN NhanVien nv ON tk.idNV = nv.idNV "
            + "INNER JOIN VaiTro vt ON tk.idVT = vt.idVT "
            + "WHERE tk.idTK = ?";
    
    private final String SELECT_BY_USERNAME = "SELECT tk.*, nv.hoTen, nv.sdt, nv.gioiTinh, nv.namSinh, nv.ngayVaoLam, vt.ten as tenVT "
            + "FROM TaiKhoan tk "
            + "INNER JOIN NhanVien nv ON tk.idNV = nv.idNV "
            + "INNER JOIN VaiTro vt ON tk.idVT = vt.idVT "
            + "WHERE tk.username = ?";

    @Override
    public void create(TaiKhoan e) {
        JDBCConnection.update(INSERT_SQL, e.getId(), e.getUsername(), e.getPassword(), e.getNhanVien().getId(), e.getVaiTro().getId());
    }

    @Override
    public void update(TaiKhoan e) {
        JDBCConnection.update(UPDATE_SQL, e.getUsername(), e.getPassword(), e.getNhanVien().getId(), e.getVaiTro().getId(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        JDBCConnection.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setId(rs.getString("idTK"));
                taiKhoan.setUsername(rs.getString("username"));
                taiKhoan.setPassword(rs.getString("password"));

                // Create NhanVien object
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getString("idNV"));
                nhanVien.setHoTen(rs.getString("hoTen"));
                nhanVien.setSdt(rs.getString("sdt"));
                nhanVien.setGioiTinh(rs.getString("gioiTinh"));
                nhanVien.setNamSinh(rs.getInt("namSinh"));
                nhanVien.setNgayVaoLam(rs.getDate("ngayVaoLam"));
                taiKhoan.setNhanVien(nhanVien);

                // Create VaiTro object
                VaiTro vaiTro = new VaiTro();
                vaiTro.setId(rs.getString("idVT"));
                vaiTro.setTen(rs.getString("tenVT"));
                taiKhoan.setVaiTro(vaiTro);

                listE.add(taiKhoan);
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
