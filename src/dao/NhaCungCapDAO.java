package dao;

import connectDB.JDBCConnection;
import entities.NhaCungCap;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO extends InterfaceDAO<NhaCungCap, String> {

    private final String INSERT_SQL = "INSERT INTO NhaCungCap values(?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE NhaCungCap SET tenNCC=?, sdt=?, diaChi=? where idNCC=?";
    private final String DELETE_BY_ID = "DELETE from NhaCungCap where idNCC = ?";

    private final String SELECT_ALL_SQL = "SELECT * FROM NhaCungCap";
    private final String SELECT_BY_ID = "SELECT * FROM NhaCungCap WHERE idNCC = ?";

    @Override
    public void create(NhaCungCap e) {
        JDBCConnection.update(INSERT_SQL, e.getId(), e.getTen(), e.getSdt(), e.getDiaChi());
    }

    @Override
    public void update(NhaCungCap e) {
        JDBCConnection.update(UPDATE_SQL, e.getTen(), e.getSdt(), e.getDiaChi(), e.getId());
    }

    @Override
    public void deleteById(String id) {
        JDBCConnection.update(DELETE_BY_ID, id);
    }

    @Override
    protected List<NhaCungCap> selectBySql(String sql, Object... args) {
        List<NhaCungCap> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                NhaCungCap e = new NhaCungCap();
                e.setId(rs.getString("idNCC"));
                e.setTen(rs.getString("tenNCC"));
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
    public List<NhaCungCap> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhaCungCap selectById(String id) {
        List<NhaCungCap> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
