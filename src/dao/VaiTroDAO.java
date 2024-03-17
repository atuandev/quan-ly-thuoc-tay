package dao;

import connectDB.JDBCConnection;
import entities.VaiTro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VaiTroDAO extends InterfaceDAO<VaiTro, String> {

    private final String INSERT_SQL = "INSERT INTO VaiTro values (?,?)";
    private final String UPDATE_SQL = "UPDATE VaiTro SET ten=? where idVT=?";
    private final String DELETE_BY_ID = "DELETE from VaiTro where idVT = ?";

    private final String SELECT_ALL_SQL = "SELECT * FROM VaiTro";
    private final String SELECT_BY_ID = "SELECT * FROM VaiTro WHERE idVT= ?";

    @Override
    public void create(VaiTro e) {
        JDBCConnection.update(INSERT_SQL, e.getId(), e.getTen());
    }

    @Override
    public void update(VaiTro e) {
        JDBCConnection.update(UPDATE_SQL, e.getTen(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        JDBCConnection.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<VaiTro> selectBySql(String sql, Object... args) {
        List<VaiTro> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                VaiTro e = new VaiTro();
                e.setId(rs.getString("idVT"));
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
    public List<VaiTro> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public VaiTro selectById(String id) {
        List<VaiTro> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
