package com.example.passwortgenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Random;

public class Controller {
    private DAO dao;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextField passwordTf;


    @FXML
public void initialize() {
    choiceBox.getItems().add("schwach"); // 6 Zeichen
    choiceBox.getItems().add("mittel");  // 8 Zeichen
    choiceBox.getItems().add("stark");   // 10 zeichen

    dao = new DAO();
}

@FXML
protected void onGenerateClick() {


    String upperCase         = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCase         = "abcdefghijklmnopqrstuvwxyz";
    String numbers           = "0123456789";
    String specialCharacters = "!§$%&@?";

    String alphaNumeric = upperCase + lowerCase + numbers + specialCharacters;

    StringBuilder sb = new StringBuilder();
    Random random = new Random();

    int lenght = 0;

    if (choiceBox.getSelectionModel().getSelectedIndex() == 0) {
        lenght = 6;
    } else if (choiceBox.getSelectionModel().getSelectedIndex() == 1) {
        lenght = 8;
    } else if (choiceBox.getSelectionModel().getSelectedIndex() == 2) {
        lenght = 10;
    }


    for (int i = 0; i < lenght; i++) {

        int caracterIndex = random.nextInt(alphaNumeric.length());
        char randomChar = alphaNumeric.charAt(caracterIndex);
        sb.append(randomChar);
    }

    String password = sb.toString();

    System.out.println(password);


 passwordTf.setText(password);

 String text = getGenerateText(password);

 //Todo

showInfoWindow( "Passwort; " + text);

// int securityLevel = choiceBox.getSelectionModel().getSelectedIndex();

 boolean succes = dao.addGenerateToLog(password);

 if (succes) {
     dao.saveData();
 }

}

@FXML
protected void onLogClick() {
        var logList = dao.getLogList();

        String text = "LOG----->\n";

        for (var log : logList) {
          text += log.getPassword();

            text += "\n\n";
        }

        showInfoWindow("LOG", text);

}

private void showInfoWindow(String title, String message) {
    Alert window = new Alert(Alert.AlertType.INFORMATION);
    window.setTitle(title);
    window.setHeaderText(null);
    window.setContentText(message);
    window.showAndWait();
}

private String getGenerateText(String password) {
        String text = "Es wurde folgendes Passwort generiert:\n";
        text+= " Passwort" + password + "\n";

        return text;
}









































//    @FXML
//    private ChoiceBox<String> choiceBox;
//
//    @FXML TextField passwordTf;
//
//    //Elemente der ChoiceBox müssen mit der initialize Methode initialisiert werden!!
//
//    public void initialize() {
//        choiceBox.getItems().add("Geht so (6 Zeichen)");
//        choiceBox.getItems().add("Gut (8 Zeichen)");
//        choiceBox.getItems().add("Sehr gut (10 Zeichen)");
//
//        //Standardwert
//        choiceBox.setValue("Geht so (6 Zeichen)");
//    }
//
//    String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//    String caracterslowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
//    String caractersUppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    String caractersNumbers = "0123456789";
//
//
//    @FXML
//    protected void generate() {
//
//        int passwordLength = 0; // Variable außerhalb der Bedingung deklarieren
//
//
//        // Index aus der ChoiceBox lesen
//        int selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
//
//        if (selectedIndex == 0) {
//            passwordLength = 6;
//        } else if (selectedIndex == 1) {
//            passwordLength = 8;
//        } else if (selectedIndex == 2) {
//            passwordLength = 10;
//        }
//
//        // Jetzt die passwordLength-Variable für die Passwortgenerierung verwenden
//
//        System.out.println("Passwortlänge: " + passwordLength);
//
//        String password = "";
//
//        for (int i = 0; i < passwordLength / 3; i++) {
//            // Zufallszahl im Bereich von 0 bis characters.length() - 1
//            int randomIndexLowerCase = (int) (Math.random() * caracterslowercaseLetters.length());
//            int randomIndexUppercase = (int) (Math.random() * caractersUppercaseLetters.length());
//            int randomIndexNumbers = (int) (Math.random() * caractersNumbers.length());
//
//            // Zufälliges Zeichen aus dem characters-String
////            char randomCharLower = caracterslowercaseLetters.charAt(randomIndexLowerCase);
////            char randomCharUpper = caractersUppercaseLetters.charAt(randomIndexUppercase);
////            char randomCharNumber = caractersNumbers.charAt(randomIndexNumbers);
//
//            // Füge das zufällige Zeichen dem Passwort hinzu
//            password += caracterslowercaseLetters.charAt(randomIndexLowerCase);
//            password += caractersUppercaseLetters.charAt(randomIndexUppercase);
//            password += caractersNumbers.charAt(randomIndexNumbers);
//        }
//        System.out.println("Passwort: " + password);
//
//    }






//@FXML
//    private ChoiceBox<String> choiceBoxSecurityLevel;
//
//@FXML
//    private Button generateBtn;
//
//@FXML
//    private TextField password;
//
//
//private DAO dao;
//
//@FXML
//    private void initialize() {
//    choiceBoxSecurityLevel.getItems().add("schwach");
//    choiceBoxSecurityLevel.getItems().add("mittel");
//    choiceBoxSecurityLevel.getItems().add("stark");
////    dao = new DAO();
//}
//
////@FXML
////    protected void Choice(ActionEvent event) {
////    String selectedChoice = choiceBox.getSelectionModel().getSelectedItem();
////
////
////}
//
//
//@FXML
//    protected void securityLevel() {
//
//
//}
//
//
//@FXML
//    protected void generate() {
//
////    dao.setGenerate( int securityLevel, String password);
//}




































//    @FXML
//    private ChoiceBox<String> securityLevel;
//
//
//    @FXML
//    private Button generateBtn;
//
//
//
//    @FXML
//    private TextField password;
//
//
//
//    private final Generate generate = new Generate();
//
//    @FXML
//    private void initialize(){
//        securityLevel.getItems().add("Schwach");
//        securityLevel.getItems().add("Mittel");
//    }
//
//    @FXML
//    protected void choice(ActionEvent event){
//
//        var box = (ChoiceBox) event.getTarget();
//        int index = box.getSelectionModel().getSelectedIndex();
//
//        System.out.println("Eingabe:" + index);
//    }
//
//    @FXML
//    protected void generate(){

        // Bestimmen der Passwortlänge basierend auf dem Sicherheitslevel
//        int length = 6; // Standardlänge
//
//        switch (securityLevel.getValue()) {
//            case "Schwach":
//                length = 6;
//                break;
//            case "Mittel":
//                length = 8;
//                break;
//            case "Stark":
//                length = 10;
//                break;
//        }
//
//        // Passwort generieren und im TextField anzeigen
//        String generatedPassword = generate.generate(length);
//        password.setText(generatedPassword);
//    }

    }
