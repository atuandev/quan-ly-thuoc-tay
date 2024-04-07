package dao;

import connectDB.JDBCConnection;
import java.sql.ResultSet;
import entities.ThongKe;
import entities.ThongKeTheoNam;
import entities.ThongKeTheoThang;
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
                                            COALESCE(SUM(ChiTietHoaDon.soLuong * Thuoc.donGia), 0) AS doanhthu,
                                            COALESCE(SUM(ChiTietHoaDon.soLuong * Thuoc.giaNhap), 0) AS chiphi
                                        FROM dates
                                        LEFT JOIN HoaDon ON CONVERT(DATE, HoaDon.thoiGian) = CONVERT(DATE, dates.date)
                                        LEFT JOIN ChiTietHoaDon ON ChiTietHoaDon.idHD = HoaDon.idHD
                                        LEFT JOIN Thuoc ON Thuoc.idThuoc = ChiTietHoaDon.idThuoc
                                        GROUP BY dates.date
                                        ORDER BY dates.date;
                                        """;

    private final String SELECT_FROM_YEAR_TO_YEAR = """
                                                    DECLARE @start_year INT = ?;
                                                    DECLARE @end_year INT = ?;
                                                                                                        
                                                    WITH years(year) AS (
                                                        SELECT @start_year
                                                        UNION ALL
                                                        SELECT year + 1
                                                        FROM years
                                                        WHERE year < @end_year
                                                    )
                                                    SELECT 
                                                        years.year AS nam,
                                                        COALESCE(SUM(ChiTietHoaDon.soLuong * Thuoc.donGia), 0) AS doanhthu,
                                                        COALESCE(SUM(ChiTietHoaDon.soLuong * Thuoc.giaNhap), 0) AS chiphi
                                                    FROM years
                                                    LEFT JOIN HoaDon ON YEAR(HoaDon.thoiGian) = years.year
                                                    LEFT JOIN ChiTietHoaDon ON HoaDon.idHD = ChiTietHoaDon.idHD
                                                    LEFT JOIN Thuoc ON Thuoc.idThuoc = ChiTietHoaDon.idThuoc
                                                    GROUP BY years.year
                                                    ORDER BY years.year;
                                                    """;

    public List<ThongKe> select7DaysAgo() {
        return this.selectBySql(SELECT_7_DAYS_AGO);
    }

    public List<ThongKeTheoNam> selectByYear(int fromYear, int toYear) {
        return this.selectBySqlTheoNam(SELECT_FROM_YEAR_TO_YEAR, fromYear, toYear);
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

    protected List<ThongKeTheoNam> selectBySqlTheoNam(String sql, Object... args) {
        List<ThongKeTheoNam> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                ThongKeTheoNam e = new ThongKeTheoNam();
                e.setNam(rs.getInt("nam"));
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

    protected List<ThongKeTheoThang> selectBySqlTheoThang(String sql, Object... args) {
        List<ThongKeTheoThang> listE = new ArrayList<>();
        try {
            ResultSet rs = JDBCConnection.query(sql, args);
            while (rs.next()) {
                ThongKeTheoThang e = new ThongKeTheoThang();
                e.setThoiGian(rs.getInt("thang"));
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
