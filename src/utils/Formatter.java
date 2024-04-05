package utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author atuandev
 */
public class Formatter {

    private static final Pattern FORMAT_PATTERN = Pattern.compile("^\\d{1,3}([a-zA-Z]+|\\.\\d{1,2}[\\D]+$)");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("((^\\d{1,3})([.][\\d+]{1,2})?)(\\D+$)?");

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###.##");
    private static final List<String> FORMATS = Arrays.asList("", "K", "M", "B", "T", "Q", "QQ", "S", "SS", "OC", "N", "D", "UN", "DD", "TR", "QT", "QN");

    public static String FormatVND(double number) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(number) + "đ";
    }

    public static double unformatVND(String formattedString) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        try {
            Number number = formatter.parse(formattedString.replaceAll("[^\\d.]", ""));
            return number.doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0.0; // Return default value in case of parsing failure
        }
    }

    public static String FormatDate(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatDate.format(date);
    }
    
    public static String FormatDateExcel(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        return formatDate.format(date);
    }

    public static String FormatTime(Timestamp thoigian) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return formatDate.format(thoigian);
    }

    public static String formatNumber(double number) {
        int base = (int) Math.log10(number);
        int index = base / 3;

        if (index < 0) {
            index = 0;
        }

        number = (number / Math.pow(10, index * 3));

        String symbol = index < FORMATS.size() ? FORMATS.get(index) : "";
        return DECIMAL_FORMAT.format(number) + symbol;
    }

    public static boolean isFormatted(String string) {
        return FORMAT_PATTERN.matcher(string).matches();
    }

    public static double unformatNumber(String string) {
        if (!isFormatted(string)) {
            throw new IllegalArgumentException("the value " + string + " is not in a valid format");
        }

        try {
            Matcher matcher = NUMBER_PATTERN.matcher(string);
            if (matcher.find()) {
                String value = matcher.group(1);
                String format = matcher.group(4);

                double number = Double.parseDouble(value);
                int index = FORMATS.contains(format) ? FORMATS.indexOf(format) : 0;

                return number * Math.pow(1000, index);
            }

        } catch (NumberFormatException e) {
        }

        return 0;
    }
}
