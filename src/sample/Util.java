package sample;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class Util {
    private static List<String> validNumbers=new ArrayList<>();
    static {
        validNumbers.add("1");
        validNumbers.add("2");
        validNumbers.add("3");
        validNumbers.add("4");
        validNumbers.add("5");
        validNumbers.add("6");
        validNumbers.add("7");
        validNumbers.add("8");
        validNumbers.add("9");
    }


    public static void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static boolean isValidNumber(String element){
        return validNumbers.contains(element);
    }
}
