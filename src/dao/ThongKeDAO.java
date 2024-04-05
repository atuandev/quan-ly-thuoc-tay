package dao;

import connectDB.JDBCConnection;
import java.sql.ResultSet;
import entities.ThongKe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ThongKeDAO {

    private final String SELECT_7_DAYS_AGO = """
                                        WITH dates AS (
                                            SELECT DATEADD(DAY, -6, GETDATE()) AS date
                                            UNION ALL
                                            SELECT DATEADD(DAY, 1, date)
                                            FROM dates
                                            WHERE date < CAST(GETDATE() AS DATE)
                                        )
                                        SELECT 
                                            dates.date AS ngay,
                                            COALESCE(SUM(HoaDon.tongTien), 0) AS doanhthu,
                                            COALESCE(SUM(ChiTietHoaDon.soLuong * Thuoc.giaNhap), 0) AS chiphi
                                        FROM dates
                                        LEFT JOIN HoaDon ON CONVERT(DATE, HoaDon.thoiGian) = CONVERT(DATE, dates.date)
                                        LEFT JOIN ChiTietHoaDon ON HoaDon.idHD = ChiTietHoaDon.idHD
                                        LEFT JOIN Thuoc ON Thuoc.idThuoc = ChiTietHoaDon.idThuoc
                                        GROUP BY dates.date
                                        ORDER BY dates.date;
                                        """;

    public List<ThongKe> select7DaysAgo() {
        return this.selectBySql(SELECT_7_DAYS_AGO);
    }

    protected List<ThongKe> selectBySql(String sql, Object... args) {
        List<ThongKe> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                ThongKe e = new ThongKe();
                e.setThoiGian(rs.getDate("ngay"));
                e.setDoanhThu(rs.getDouble("doanhthu"));
                e.setChiPhi(rs.getDouble("chiphi"));
                listE.add(e);
            }
            rs.getStatement().getConnection().close();
            return listE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
