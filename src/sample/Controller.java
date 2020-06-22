package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField x11;
    @FXML
    private TextField x12;
    @FXML
    private TextField x13;
    @FXML
    private TextField x14;
    @FXML
    private TextField x15;
    @FXML
    private TextField x16;
    @FXML
    private TextField x17;
    @FXML
    private TextField x18;
    @FXML
    private TextField x19;

    @FXML
    private TextField x21;
    @FXML
    private TextField x22;
    @FXML
    private TextField x23;
    @FXML
    private TextField x24;
    @FXML
    private TextField x25;
    @FXML
    private TextField x26;
    @FXML
    private TextField x27;
    @FXML
    private TextField x28;
    @FXML
    private TextField x29;

    @FXML
    private TextField x31;
    @FXML
    private TextField x32;
    @FXML
    private TextField x33;
    @FXML
    private TextField x34;
    @FXML
    private TextField x35;
    @FXML
    private TextField x36;
    @FXML
    private TextField x37;
    @FXML
    private TextField x38;
    @FXML
    private TextField x39;

    @FXML
    private TextField x41;
    @FXML
    private TextField x42;
    @FXML
    private TextField x43;
    @FXML
    private TextField x44;
    @FXML
    private TextField x45;
    @FXML
    private TextField x46;
    @FXML
    private TextField x47;
    @FXML
    private TextField x48;
    @FXML
    private TextField x49;

    @FXML
    private TextField x51;
    @FXML
    private TextField x52;
    @FXML
    private TextField x53;
    @FXML
    private TextField x54;
    @FXML
    private TextField x55;
    @FXML
    private TextField x56;
    @FXML
    private TextField x57;
    @FXML
    private TextField x58;
    @FXML
    private TextField x59;

    @FXML
    private TextField x61;
    @FXML
    private TextField x62;
    @FXML
    private TextField x63;
    @FXML
    private TextField x64;
    @FXML
    private TextField x65;
    @FXML
    private TextField x66;
    @FXML
    private TextField x67;
    @FXML
    private TextField x68;
    @FXML
    private TextField x69;

    @FXML
    private TextField x71;
    @FXML
    private TextField x72;
    @FXML
    private TextField x73;
    @FXML
    private TextField x74;
    @FXML
    private TextField x75;
    @FXML
    private TextField x76;
    @FXML
    private TextField x77;
    @FXML
    private TextField x78;
    @FXML
    private TextField x79;

    @FXML
    private TextField x81;
    @FXML
    private TextField x82;
    @FXML
    private TextField x83;
    @FXML
    private TextField x84;
    @FXML
    private TextField x85;
    @FXML
    private TextField x86;
    @FXML
    private TextField x87;
    @FXML
    private TextField x88;
    @FXML
    private TextField x89;

    @FXML
    private TextField x91;
    @FXML
    private TextField x92;
    @FXML
    private TextField x93;
    @FXML
    private TextField x94;
    @FXML
    private TextField x95;
    @FXML
    private TextField x96;
    @FXML
    private TextField x97;
    @FXML
    private TextField x98;
    @FXML
    private TextField x99;

    @FXML
    private Button resoudre;

    List<TextField> textFields;

    List<Boolean> isFull = new ArrayList<>();

    public void resoudre(ActionEvent actionEvent) {
        List<String> list = getListX();
        if (!conditionNonEmptyFields(list)) {
            Util.showAlert(Alert.AlertType.WARNING, "Sudoku", "Attention: ", "Vous devez saisir au moins remplir 17 cases.");
            return;
        }
        boolean resultatVerification = verifyNumbers(list);
        if (resultatVerification) {
            list = Sodoku.sodoku(list);
            if (list == null) {
                Util.showAlert(Alert.AlertType.WARNING, "Sudoku", "Attention: ", "Aucune solution n'a été toruvée:");
            } else {
                for (int i = 0; i < textFields.size(); i++) {
                    textFields.get(i).setText(list.get(i));
                    if (isFull.get(i)){
                        textFields.get(i).setStyle("-fx-background-color: #4f6bff");
                    }
                }
            }
        }

    }

    public void vider(ActionEvent actionEvent) {
        for (TextField textField : textFields
        ) {
            textField.setText("");
            textField.setStyle("-fx-background-color: white");
        }
        resoudre.setDisable(false);
        isFull = new ArrayList<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTextFieldList();
    }

    private List<String> getListX() {
        List<String> list = new ArrayList<String>();
        for (TextField textField : textFields) {
            list.add(textField.getText());
        }
        return list;
    }

    private boolean conditionNonEmptyFields(List<String> list) {
        int i = 0;
        for (String s : list) {
            if (s != null && !s.isEmpty()) i++;
        }
        if (i < 17) {
            return false;
        } else {
            return true;
        }
    }


    private List<TextField> initTextFieldList() {
        textFields = new ArrayList<TextField>();
        textFields.add(x11);
        textFields.add(x12);
        textFields.add(x13);
        textFields.add(x14);
        textFields.add(x15);
        textFields.add(x16);
        textFields.add(x17);
        textFields.add(x18);
        textFields.add(x19);

        textFields.add(x21);
        textFields.add(x22);
        textFields.add(x23);
        textFields.add(x24);
        textFields.add(x25);
        textFields.add(x26);
        textFields.add(x27);
        textFields.add(x28);
        textFields.add(x29);

        textFields.add(x31);
        textFields.add(x32);
        textFields.add(x33);
        textFields.add(x34);
        textFields.add(x35);
        textFields.add(x36);
        textFields.add(x37);
        textFields.add(x38);
        textFields.add(x39);

        textFields.add(x41);
        textFields.add(x42);
        textFields.add(x43);
        textFields.add(x44);
        textFields.add(x45);
        textFields.add(x46);
        textFields.add(x47);
        textFields.add(x48);
        textFields.add(x49);

        textFields.add(x51);
        textFields.add(x52);
        textFields.add(x53);
        textFields.add(x54);
        textFields.add(x55);
        textFields.add(x56);
        textFields.add(x57);
        textFields.add(x58);
        textFields.add(x59);

        textFields.add(x61);
        textFields.add(x62);
        textFields.add(x63);
        textFields.add(x64);
        textFields.add(x65);
        textFields.add(x66);
        textFields.add(x67);
        textFields.add(x68);
        textFields.add(x69);

        textFields.add(x71);
        textFields.add(x72);
        textFields.add(x73);
        textFields.add(x74);
        textFields.add(x75);
        textFields.add(x76);
        textFields.add(x77);
        textFields.add(x78);
        textFields.add(x79);

        textFields.add(x81);
        textFields.add(x82);
        textFields.add(x83);
        textFields.add(x84);
        textFields.add(x85);
        textFields.add(x86);
        textFields.add(x87);
        textFields.add(x88);
        textFields.add(x89);

        textFields.add(x91);
        textFields.add(x92);
        textFields.add(x93);
        textFields.add(x94);
        textFields.add(x95);
        textFields.add(x96);
        textFields.add(x97);
        textFields.add(x98);
        textFields.add(x99);
        return textFields;
    }

    private boolean verifyNumbers(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null || list.get(i).isEmpty()) {
                list.remove(i);
                list.add(i, "_");
                isFull.add(false);
            } else if (!Util.isValidNumber(list.get(i))) {
                Util.showAlert(Alert.AlertType.ERROR, "Erreur", "Erreur d'ensertion", "L'element de la case " + (i + 1) + " n'est pas un chiffre valide . Veuillez saisir un chiffre de 1 à 9.");
                isFull = new ArrayList<>();
                return false;
            } else {
                //textFields.get(i).setStyle("-fx-background-color: red");
                isFull.add(true);
            }
        }
        return true;
    }


}
