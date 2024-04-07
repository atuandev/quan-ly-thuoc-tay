package utils;

import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author atuandev
 */
public class Validation {

    public static Boolean isEmpty(String input) {
        if (input.trim() == null) {
            return true;
        }
        return input.trim().equals("");
    }

    public static Boolean isEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

    public static boolean isNumber(String num) {
        if (num == null) {
            return false;
        }
        try {
            long k = Long.parseLong(num);
            if (k < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isPhoneNumber(String str) {
        str = str.replaceAll("\\s+", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\-", "");

        if (str.matches("\\d{10}")) {
            return true;
        } else if (str.matches("\\d{3}-\\d{3}-\\d{4}")) {
            return true;
        } else {
            return str.matches("\\(\\d{3}\\)\\d{3}-\\d{4}");
        }
    }

    public static void resetTextfield(JTextField textField) {
        textField.setText("");
        textField.requestFocus();
    }

    public static void selectAllTextfield(JTextField textField) {
        textField.requestFocus();
        textField.selectAll();
    }
}
