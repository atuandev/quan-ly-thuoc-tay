package dao;

import connectDB.jdbcHelper;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Thuoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonDAO implements ChiTietInterfaceDAO<ChiTietHoaDon, String> {

    private String INSERT_SQL = "INSERT INTO ChiTietHoaDon values (?,?,?,?)";
    private String UPDATE_SQL = "UPDATE ChiTietHoaDon SET idThuoc=?, soLuong=?, donGia=? where idHD=?";
    private String DELETE_BY_ID = "DELETE from ChiTietHoaDon where idHD = ?";

    private String SELECT_ALL_SQL = "SELECT * FROM ChiTietHoaDon";
    private String SELECT_BY_ID = "SELECT * FROM ChiTietHoaDon WHERE idHD = ?";

    @Override
    public void insert(List<ChiTietHoaDon> e) {
        for (int i = 0; i < e.size(); i++) {
            jdbcHelper.update(INSERT_SQL, e.get(i).getHoaDon().getId(), e.get(i).getThuoc().getId(), e.get(i).getSoLuong(), e.get(i).getDonGia());
        }
    }

    @Override
    public void update(String k, List<ChiTietHoaDon> e) {
        this.deleteById(k);
        this.insert(e);
    }

    @Override
    public void deleteById(String k) {
        jdbcHelper.update(DELETE_BY_ID, k);
    }

    @Override
    public List<ChiTietHoaDon> selectAllById(String k) {
        return this.selectBySql(SELECT_BY_ID);
    }

    protected List<ChiTietHoaDon> selectBySql(String sql, Object... args) {
        List<ChiTietHoaDon> listE = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                ChiTietHoaDon e = new ChiTietHoaDon();
                e.setHoaDon(new HoaDon(rs.getString("idHD")));
                e.setThuoc(new Thuoc(rs.getString("idThuoc")));
                e.setSoLuong(rs.getInt("soLuong"));
                e.setDonGia(rs.getDouble("donGia"));
                listE.add(e);
            }
            rs.getStatement().getConnection().close();
            return listE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
