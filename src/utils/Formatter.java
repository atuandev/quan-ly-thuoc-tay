package utils;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author atuandev
 */
public class Formatter {

    public static String FormatVND(double number) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(number);
    }
    
    public static String FormatDate(Timestamp date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
        return formatDate.format(date);
    }
}
