package dao;

import connectDB.jdbcHelper;
import entity.DanhMuc;
import entity.DonViTinh;
import entity.Thuoc;
import entity.XuatXu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ThuocDAO extends InterfaceDAO<Thuoc, String> {

    private final String INSERT_SQL = "INSERT INTO Thuoc values (?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE Thuoc SET tenThuoc=?, hinhAnh=?, thanhPhan=?, idDonViTinh=?, idDanhMuc=?, idXuatXu=?, soLuongTon=?, giaNhap=?, donGia=? where idThuoc=?";
    private final String DELETE_BY_ID = "DELETE from Thuoc where idThuoc = ?";

    private final String SELECT_ALL_SQL = "SELECT * FROM Thuoc";
    private final String SELECT_BY_ID = "SELECT * FROM Thuoc WHERE idThuoc = ?";

    private final String UPDATE_SO_LUONG = "UPDATE Thuoc SET soLuongTon=? WHERE idThuoc = ?";

    @Override
    public void create(Thuoc e) {
        jdbcHelper.update(INSERT_SQL, e.getId(), e.getTen(), e.getHinhAnh(), e.getThanhPhan(), e.getDonViTinh().getId(),
                e.getDanhMuc().getId(), e.getXuatXu().getId(), e.getSoLuongTon(), e.getGiaNhap(), e.getDonGia());
    }

    @Override
    public void update(Thuoc e) {
        jdbcHelper.update(UPDATE_SQL, e.getTen(), e.getHinhAnh(), e.getThanhPhan(), e.getDonViTinh().getId(),
                e.getDanhMuc().getId(), e.getXuatXu().getId(), e.getSoLuongTon(), e.getGiaNhap(), e.getDonGia(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        jdbcHelper.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<Thuoc> selectBySql(String sql, Object... args) {
        List<Thuoc> listE = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Thuoc e = new Thuoc();
                e.setId(rs.getString("idThuoc"));
                e.setTen(rs.getString("tenThuoc"));
                e.setHinhAnh(rs.getString("hinhAnh"));
                e.setThanhPhan(rs.getString("thanhPhan"));
                e.setDonViTinh(new DonViTinh(rs.getString("idDonViTinh")));
                e.setDanhMuc(new DanhMuc(rs.getString("idDanhMuc")));
                e.setXuatXu(new XuatXu(rs.getString("idXuatXu")));
                e.setSoLuongTon(rs.getInt("soLuongTon"));
                e.setGiaNhap(rs.getDouble("giaNhap"));
                e.setDonGia(rs.getDouble("donGia"));
                listE.add(e);
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

    public void updateSoLuongTon(String id, int soLuong) {
        Thuoc thuoc = this.selectById(id);
        int updatedSL = thuoc.getSoLuongTon() + soLuong;
        jdbcHelper.update(UPDATE_SO_LUONG, updatedSL, thuoc.getId());
        
        System.out.println("Update:" + updatedSL);
    }

}
