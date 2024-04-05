package controller;

import dao.ThongKeDAO;
import entities.ThongKe;
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
}
