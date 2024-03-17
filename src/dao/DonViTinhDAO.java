package dao;

import connectDB.JDBCConnection;
import entities.DonViTinh;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DonViTinhDAO extends InterfaceDAO<DonViTinh, String> {

    private final String INSERT_SQL = "INSERT INTO DonViTinh values (?,?)";
    private final String UPDATE_SQL = "UPDATE DonViTinh SET ten=? where idDVT=?";
    private final String DELETE_BY_ID = "DELETE from DonViTinh where idDVT = ?";

    private final String SELECT_ALL_SQL = "SELECT * FROM DonViTinh";
    private final String SELECT_BY_ID = "SELECT * FROM DonViTinh WHERE idDVT = ?";

    @Override
    public void create(DonViTinh e) {
        JDBCConnection.update(INSERT_SQL, e.getId(), e.getTen());
    }

    @Override
    public void update(DonViTinh e) {
        JDBCConnection.update(UPDATE_SQL, e.getTen(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        JDBCConnection.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<DonViTinh> selectBySql(String sql, Object... args) {
        List<DonViTinh> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                DonViTinh e = new DonViTinh();
                e.setId(rs.getString("idDVT"));
                e.setTen(rs.getString("ten"));
                listE.add(e);
            }
            rs.getStatement().getConnection().close();
            return listE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DonViTinh> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public DonViTinh selectById(String id) {
        List<DonViTinh> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
