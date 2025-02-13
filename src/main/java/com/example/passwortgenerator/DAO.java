package com.example.passwortgenerator;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DAO {

    private ArrayList<Generate> logList;

    private final String FILE_PATH = "src/main/resources/com/example/passwortgenerator/log.csv";
    private final String SEPARATOR = ",";


    public DAO() {
        logList = loadLogList();
    }


    public void saveData() {
        FileWriter writer = null;

        try {
//            String path = getClass().getResource(FILE_PATH).getPath();
            writer = new FileWriter(FILE_PATH);

            for (var item : logList) {
                if (item != null) { // Objekt gültig?
                    String line = item.getPassword() + SEPARATOR;
//                            item.getTimestamp() + SEPARATOR;
                    System.out.println(line);
                    writer.write(line);
                }
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());

        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        }
    }


    private ArrayList<Generate> loadLogList() {

        var logList = new ArrayList<Generate>();

        FileReader reader = null;

        try {
//            String path = getClass().getResource(FILE_PATH).getPath();
            reader = new FileReader(FILE_PATH);

            BufferedReader buffer = new BufferedReader(reader);
            String line;
            logList.clear();

            while ((line = buffer.readLine()) != null) {

                String[] data = line.split(SEPARATOR);

                //ToDo Problem behandeln Choicebox
//                int securityLevel = Integer.parseInt(data[0]);
                String password = data[0];
//                LocalDateTime timestamp = LocalDateTime.parse(data[1]);
//
//
              Generate generate = new Generate( password);
                logList.add(generate);
            }


        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error" + e.getMessage());
                }
            }
        }

        return logList;
    }
    //hhh


    public ArrayList<Generate> getLogList() {
        return logList;
    }



    public boolean addGenerateToLog(String password) {
        var generate = new Generate(password);
        return logList.add(generate);
    }


//private ArrayList<Generate> generatesList;
//
//public DAO() {
//    generatesList = new ArrayList<>();
//}
//
//public void setGenerate(int securityLevel, String password) {
//
//    Generate generate = new Generate(securityLevel, password);
//    generatesList.add(generate);
//}

}
