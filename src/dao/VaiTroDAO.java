package dao;

import connectDB.jdbcHelper;
import entity.VaiTro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VaiTroDAO extends InterfaceDAO<VaiTro, String> {

    private String INSERT_SQL = "INSERT INTO VaiTro values (?,?)";
    private String UPDATE_SQL = "UPDATE VaiTro SET ten=? where id=?";
    private String DELETE_BY_ID = "DELETE from VaiTro where id = ?";

    private String SELECT_ALL_SQL = "SELECT * FROM VaiTro";
    private String SELECT_BY_ID = "SELECT * FROM VaiTro WHERE id = ?";

    @Override
    public void create(VaiTro e) {
        jdbcHelper.update(INSERT_SQL, e.getId(), e.getTen());
    }

    @Override
    public void update(VaiTro e) {
        jdbcHelper.update(UPDATE_SQL, e.getTen(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        jdbcHelper.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<VaiTro> selectBySql(String sql, Object... args) {
        List<VaiTro> listE = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                VaiTro e = new VaiTro();
                e.setId(rs.getString("id"));
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
