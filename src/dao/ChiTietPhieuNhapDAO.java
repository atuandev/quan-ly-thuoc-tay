package dao;

import connectDB.JDBCConnection;
import controller.PhieuNhapController;
import controller.ThuocController;
import entities.ChiTietPhieuNhap;
import entities.PhieuNhap;
import entities.Thuoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChiTietPhieuNhapDAO implements ChiTietInterfaceDAO<ChiTietPhieuNhap, String> {

    private final String INSERT_SQL = "INSERT INTO ChiTietPhieuThu values (?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE ChiTietPhieuThu SET idThuoc=?, soLuong=?, donGia=? where idPT=?";
    private final String DELETE_BY_ID = "DELETE from ChiTietPhieuThu where idPT = ?";

    private final String SELECT_ALL_SQL = "SELECT * FROM ChiTietPhieuThu";
    private final String SELECT_BY_ID = "SELECT * FROM ChiTietPhieuThu WHERE idPT = ?";

    @Override
    public void create(List<ChiTietPhieuNhap> e) {
        for (int i = 0; i < e.size(); i++) {
            JDBCConnection.update(INSERT_SQL, e.get(i).getPhieuThu().getId(),
                    e.get(i).getThuoc().getId(), e.get(i).getSoLuong(), e.get(i).getDonGia());
        }
    }

    @Override
    public void update(String k, List<ChiTietPhieuNhap> e) {
        this.deleteById(k);
        this.create(e);
    }

    @Override
    public void deleteById(String k) {
        JDBCConnection.update(DELETE_BY_ID, k);
    }

    @Override
    public List<ChiTietPhieuNhap> selectAllById(String k) {
        return this.selectBySql(SELECT_BY_ID);
    }

    protected List<ChiTietPhieuNhap> selectBySql(String sql, Object... args) {
        List<ChiTietPhieuNhap> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                ChiTietPhieuNhap e = new ChiTietPhieuNhap();

                String idPN = rs.getString("idPT");
                e.setPhieuThu(new PhieuNhapController().selectById(idPN));

                String idThuoc = rs.getString("idThuoc");
                e.setThuoc(new ThuocController().selectById(idThuoc));
                
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
