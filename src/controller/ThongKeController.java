package controller;

import dao.ThongKeDAO;
import entities.ThongKe;
import entities.ThongKeTheoNam;
import entities.ThongKeTheoThang;
import java.util.List;

/**
 *
 * @author HP
 */
public class ThongKeController {
    private final ThongKeDAO TK_DAO = new ThongKeDAO();
    
    public List<ThongKe> getStatistic7DaysAgo() {
        return TK_DAO.select7DaysAgo();
    }
    
    public List<ThongKe> getStatisticDaysByMonthYear(int month, int year) {
        return TK_DAO.selectDaysByMonthYear(month, year);
    }
    
    public List<ThongKeTheoNam> getStatisticFromYearToYear(int fromYear, int toYear) {
        return TK_DAO.selectFromYearToYear(fromYear, toYear);
    }
    
    public List<ThongKeTheoThang> getStatisticMonthByYear(int year) {
        return TK_DAO.selectMounthsByYear(year);
    }
}
