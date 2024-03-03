package utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Anh Tuan
 */
public class MessageDialog {

    public static void info(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void warring(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Warning!", JOptionPane.WARNING_MESSAGE);
    }

    public static void error(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean confirm(Component parent, String message, String title) {
        int result = JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.OK_OPTION;
    }

    public static String prompt(Component parent, String message, String title) {
        return JOptionPane.showInputDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
