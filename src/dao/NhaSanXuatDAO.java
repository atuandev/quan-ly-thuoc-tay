package dao;

import connectDB.jdbcHelper;
import entity.NhaSanXuat;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhaSanXuatDAO extends InterfaceDAO<NhaSanXuat, String> {

    private String INSERT_SQL = "INSERT INTO NhaSanXuat values (?,?,?,?)";
    private String UPDATE_SQL = "UPDATE NhaSanXuat SET ten=?, sdt=?, diaChi=? where id=?";
    private String DELETE_BY_ID = "DELETE from NhaSanXuat where id = ?";

    private String SELECT_ALL_SQL = "SELECT * FROM NhaSanXuat";
    private String SELECT_BY_ID = "SELECT * FROM NhaSanXuat WHERE id = ?";

    @Override
    public void create(NhaSanXuat e) {
        jdbcHelper.update(INSERT_SQL, e.getId(), e.getTen(), e.getSdt(), e.getDiaChi());
    }

    @Override
    public void update(NhaSanXuat e) {
        jdbcHelper.update(UPDATE_SQL, e.getTen(), e.getSdt(), e.getDiaChi(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        jdbcHelper.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<NhaSanXuat> selectBySql(String sql, Object... args) {
        List<NhaSanXuat> listE = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                NhaSanXuat e = new NhaSanXuat();
                e.setId(rs.getString("id"));
                e.setTen(rs.getString("ten"));
                e.setSdt(rs.getString("sdt"));
                e.setDiaChi(rs.getString("diaChi"));
                listE.add(e);
            }
            rs.getStatement().getConnection().close();
            return listE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<NhaSanXuat> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhaSanXuat selectById(String id) {
        List<NhaSanXuat> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
