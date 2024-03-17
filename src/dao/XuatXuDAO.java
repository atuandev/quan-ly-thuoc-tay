package dao;

import connectDB.JDBCConnection;
import entities.XuatXu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class XuatXuDAO extends InterfaceDAO<XuatXu, String> {

    private final String INSERT_SQL = "INSERT INTO XuatXu values (?,?)";
    private final String UPDATE_SQL = "UPDATE XuatXu SET ten=? where idXX=?";
    private final String DELETE_BY_ID = "DELETE from XuatXu where idXX = ?";

    private final String SELECT_ALL_SQL = "SELECT * FROM XuatXu";
    private final String SELECT_BY_ID = "SELECT * FROM XuatXu WHERE idXX = ?";

    @Override
    public void create(XuatXu e) {
        JDBCConnection.update(INSERT_SQL, e.getId(), e.getTen());
    }

    @Override
    public void update(XuatXu e) {
        JDBCConnection.update(UPDATE_SQL, e.getTen(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        JDBCConnection.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<XuatXu> selectBySql(String sql, Object... args) {
        List<XuatXu> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                XuatXu e = new XuatXu();
                e.setId(rs.getString("idXX"));
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
    public List<XuatXu> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public XuatXu selectById(String id) {
        List<XuatXu> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
