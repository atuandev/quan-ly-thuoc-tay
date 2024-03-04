package dao;

import connectDB.jdbcHelper;
import entity.ChiTietPhieuThu;
import entity.PhieuThu;
import entity.Thuoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChiTietPhieuThuDAO implements ChiTietInterface<ChiTietPhieuThu, String> {

    private String INSERT_SQL = "INSERT INTO ChiTietPhieuThu values (?,?,?,?)";
    private String UPDATE_SQL = "UPDATE ChiTietPhieuThu SET idThuoc=?, soLuong=?, donGia=? where idPT=?";
    private String DELETE_BY_ID = "DELETE from ChiTietPhieuThu where idPT = ?";

    private String SELECT_ALL_SQL = "SELECT * FROM ChiTietPhieuThu";
    private String SELECT_BY_ID = "SELECT * FROM ChiTietPhieuThu WHERE idPT = ?";

    @Override
    public void insert(List<ChiTietPhieuThu> e) {
        for (int i = 0; i < e.size(); i++) {
            jdbcHelper.update(INSERT_SQL, e.get(i).getPhieuThu().getId(), e.get(i).getThuoc().getId(), e.get(i).getSoLuong(), e.get(i).getDonGia());
        }
    }

    @Override
    public void update(String k, List<ChiTietPhieuThu> e) {
        this.deleteById(k);
        this.insert(e);
    }

    @Override
    public void deleteById(String k) {
        jdbcHelper.update(DELETE_BY_ID, k);
    }

    @Override
    public List<ChiTietPhieuThu> selectAllById(String k) {
        return this.selectBySql(SELECT_BY_ID);
    }

    protected List<ChiTietPhieuThu> selectBySql(String sql, Object... args) {
        List<ChiTietPhieuThu> listE = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                ChiTietPhieuThu e = new ChiTietPhieuThu();
                e.setPhieuThu(new PhieuThu(rs.getString("idPT")));
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
