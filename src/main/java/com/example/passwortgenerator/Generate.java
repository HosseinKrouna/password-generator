package com.example.passwortgenerator;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Locale;

public class Generate {

// private ChoiceBox<String> choiceBox;
 private String password;
 private LocalDateTime timestamp;

    public Generate( String password) {
        this.password = password;
//        this.choiceBox = choiceBox;
        timestamp = LocalDateTime.now();
    }

    public Generate( String password , LocalDateTime timestamp) {
        this.password = password;
//        this.choiceBox = choiceBox;
        this.timestamp = timestamp;
    }


    public String getPassword() {
        return password;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

//    public ChoiceBox<String> getChoiceBox() {
//        return choiceBox;
//    }

//    public void setChoiceBox(ChoiceBox<String> choiceBox) {
//        this.choiceBox = choiceBox;
//    }






































//
//        public String generate(int length) {
//            // Zeichen, die für das Passwort verwendet werden sollen
//            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//            StringBuilder password = new StringBuilder(length);
//            SecureRandom random = new SecureRandom();
//
//            // Generiere das Passwort Zeichen für Zeichen
//            for (int i = 0; i < length; i++) {
//                int randomIndex = random.nextInt(characters.length());
//                password.append(characters.charAt(randomIndex));
//            }
//
//            return password.toString();


}

//}
