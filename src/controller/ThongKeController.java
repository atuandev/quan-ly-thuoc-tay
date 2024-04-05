package controller;

import dao.ThongKeDAO;
import entities.ThongKe;
import entities.ThongKeTheoNam;
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
    
    public List<ThongKeTheoNam> getStatisticByYear(int fromYear, int toYear) {
        return TK_DAO.selectByYear(fromYear, toYear);
    }
}
