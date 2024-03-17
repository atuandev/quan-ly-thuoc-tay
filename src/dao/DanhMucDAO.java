package dao;

import connectDB.JDBCConnection;
import entities.DanhMuc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DanhMucDAO extends InterfaceDAO<DanhMuc, String> {

    private final String INSERT_SQL = "INSERT INTO DanhMuc values (?,?)";
    private final String UPDATE_SQL = "UPDATE DanhMuc SET ten=? where idDM=?";
    private final String DELETE_BY_ID = "DELETE from DanhMuc where idDM = ?";

    private final String SELECT_ALL_SQL = "SELECT * FROM DanhMuc";
    private final String SELECT_BY_ID = "SELECT * FROM DanhMuc WHERE idDM = ?";

    @Override
    public void create(DanhMuc e) {
        JDBCConnection.update(INSERT_SQL, e.getId(), e.getTen());
    }

    @Override
    public void update(DanhMuc e) {
        JDBCConnection.update(UPDATE_SQL, e.getTen(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        JDBCConnection.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<DanhMuc> selectBySql(String sql, Object... args) {
        List<DanhMuc> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                DanhMuc e = new DanhMuc();
                e.setId(rs.getString("idDM"));
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
    public List<DanhMuc> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public DanhMuc selectById(String id) {
        List<DanhMuc> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
