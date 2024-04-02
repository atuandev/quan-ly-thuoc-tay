package dao;

import connectDB.JDBCConnection;
import entities.DanhMuc;
import entities.DonViTinh;
import entities.Thuoc;
import entities.XuatXu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ThuocDAO extends InterfaceDAO<Thuoc, String> {

    private final String INSERT_SQL = "INSERT INTO Thuoc values (?,?,?,?,?,?,?,?,?,?,?)";

    private final String UPDATE_SQL
            = "UPDATE Thuoc SET tenThuoc = ?, hinhAnh = ?, thanhPhan = ?, idDVT = ?, idDM = ?, idXX = ?,soLuongTon = ?, giaNhap = ?, donGia = ?, hanSuDung = ? "
            + "WHERE idThuoc = ?";

    private final String DELETE_BY_ID = "DELETE from Thuoc where idThuoc = ?";

    private final String SELECT_ALL_SQL = "SELECT Thuoc.*, "
            + "DonViTinh.idDVT, DonViTinh.ten AS tenDVT, "
            + "DanhMuc.idDM, DanhMuc.ten AS tenDM, "
            + "XuatXu.idXX, XuatXu.ten AS tenXX "
            + "FROM Thuoc "
            + "INNER JOIN DonViTinh ON Thuoc.idDVT = DonViTinh.idDVT "
            + "INNER JOIN DanhMuc ON Thuoc.idDM = DanhMuc.idDM "
            + "INNER JOIN XuatXu ON Thuoc.idXX = XuatXu.idXX";

    private final String SELECT_BY_ID = "SELECT Thuoc.*, "
            + "DonViTinh.idDVT, DonViTinh.ten AS tenDVT, "
            + "DanhMuc.idDM, DanhMuc.ten AS tenDM, "
            + "XuatXu.idXX, XuatXu.ten AS tenXX "
            + "FROM Thuoc "
            + "INNER JOIN DonViTinh ON Thuoc.idDVT = DonViTinh.idDVT "
            + "INNER JOIN DanhMuc ON Thuoc.idDM = DanhMuc.idDM "
            + "INNER JOIN XuatXu ON Thuoc.idXX = XuatXu.idXX "
            + "WHERE Thuoc.idThuoc = ?";

    private final String UPDATE_SO_LUONG = "UPDATE Thuoc SET soLuongTon=? WHERE idThuoc = ?";

    @Override
    public void create(Thuoc e) {
        JDBCConnection.update(INSERT_SQL, e.getId(), e.getTenThuoc(), e.getHinhAnh(), e.getThanhPhan(), e.getDonViTinh().getId(),
                e.getDanhMuc().getId(), e.getXuatXu().getId(), e.getSoLuongTon(), e.getGiaNhap(), e.getDonGia(), e.getHanSuDung());
    }

    @Override
    public void update(Thuoc e) {
        JDBCConnection.update(UPDATE_SQL, e.getTenThuoc(), e.getHinhAnh(), e.getThanhPhan(), e.getDonViTinh().getId(),
                e.getDanhMuc().getId(), e.getXuatXu().getId(), e.getSoLuongTon(), e.getGiaNhap(), e.getDonGia(), e.getHanSuDung(), e.getId());
    }

    public void updateSoLuongTon(Thuoc e, int soLuong) {
        JDBCConnection.update(UPDATE_SO_LUONG, soLuong, e.getId());
    }

    @Override
    public void deleteById(String id) {
        JDBCConnection.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<Thuoc> selectBySql(String sql, Object... args) {
        List<Thuoc> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                Thuoc thuoc = new Thuoc();
                thuoc.setId(rs.getString("idThuoc"));
                thuoc.setTen(rs.getString("tenThuoc"));
                thuoc.setHinhAnh(rs.getBytes("hinhAnh"));
                thuoc.setThanhPhan(rs.getString("thanhPhan"));

                // Create DonViTinh object
                DonViTinh donViTinh = new DonViTinh();
                donViTinh.setId(rs.getString("idDVT"));
                donViTinh.setTen(rs.getString("tenDVT"));
                thuoc.setDonViTinh(donViTinh);

                // Create DanhMuc object
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setId(rs.getString("idDM"));
                danhMuc.setTen(rs.getString("tenDM"));
                thuoc.setDanhMuc(danhMuc);

                // Create XuatXu object
                XuatXu xuatXu = new XuatXu();
                xuatXu.setId(rs.getString("idXX"));
                xuatXu.setTen(rs.getString("tenXX"));
                thuoc.setXuatXu(xuatXu);

                thuoc.setSoLuongTon(rs.getInt("soLuongTon"));
                thuoc.setGiaNhap(rs.getDouble("giaNhap"));
                thuoc.setDonGia(rs.getDouble("donGia"));
                thuoc.setHanSuDung(rs.getDate("hanSuDung"));

                listE.add(thuoc);
            }
            rs.getStatement().getConnection().close();
            return listE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Thuoc> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Thuoc selectById(String id) {
        List<Thuoc> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
