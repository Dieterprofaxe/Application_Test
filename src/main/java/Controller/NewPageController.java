package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import Enums.Page;
import Helper.GerichtHolder;
import PageSwitching.PageSwitcher;

public class NewPageController {
	
	//Verbindungsdaten zur Datenbank
	
    private static final String URL = "jdbc:mysql://localhost:3306/meinedb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    
    //Die verschiedenen Objekte werden initializiert
    
    @FXML
    private Button cancelButton, saveButton, next;

    @FXML
    private VBox hauptzutatenList;

    @FXML
    private TextField personenField, nameField, durationField;
    		
    		
    @FXML private TextField zutatField1, zutatField2, zutatField3, zutatField4, zutatField5,
            zutatField6, zutatField7, zutatField8, zutatField9, zutatField10,
            zutatField11, zutatField12, zutatField13, zutatField14, zutatField15,
            zutatField16, zutatField17, zutatField18, zutatField19, zutatField20,
            zutatField21, zutatField22, zutatField23, zutatField24, zutatField25,
            zutatField26, zutatField27, zutatField28, zutatField29, zutatField30;
    		
    @FXML private TextField einheitField1, einheitField2, einheitField3, einheitField4, einheitField5,
            einheitField6, einheitField7, einheitField8, einheitField9, einheitField10,
            einheitField11, einheitField12, einheitField13, einheitField14, einheitField15,
            einheitField16, einheitField17, einheitField18, einheitField19, einheitField20,
            einheitField21, einheitField22, einheitField23, einheitField24, einheitField25,
            einheitField26, einheitField27, einheitField28, einheitField29, einheitField30;
    		
    private List<TextField> zutatFields;
    private List<TextField> einheitFields;
    
    
    
    @FXML
    public void initialize() {
    	
    	next.setDisable(true);
    	
    	nameField.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
        durationField.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
        personenField.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
 
    	
    	//Array Listen werden erstellt
	
        personenField.setText("1");
        		
        		
        zutatFields = Arrays.asList(
                zutatField1, zutatField2, zutatField3, zutatField4, zutatField5,
                zutatField6, zutatField7, zutatField8, zutatField9, zutatField10,
                zutatField11, zutatField12, zutatField13, zutatField14, zutatField15,
                zutatField16, zutatField17, zutatField18, zutatField19, zutatField20,
                zutatField21, zutatField22, zutatField23, zutatField24, zutatField25,
                zutatField26, zutatField27, zutatField28, zutatField29, zutatField30
        );
        		
        einheitFields = Arrays.asList(
                einheitField1, einheitField2, einheitField3, einheitField4, einheitField5,
                einheitField6, einheitField7, einheitField8, einheitField9, einheitField10,
                einheitField11, einheitField12, einheitField13, einheitField14, einheitField15,
                einheitField16, einheitField17, einheitField18, einheitField19, einheitField20,
                einheitField21, einheitField22, einheitField23, einheitField24, einheitField25,
                einheitField26, einheitField27, einheitField28, einheitField29, einheitField30
        );
    }
    		
    
    //Wieder nur Seitenwechsel
    
    @FXML
    private void close() {
        PageSwitcher.switchTo(Page.FIRST);
    }

    @FXML
    private void next() {
        PageSwitcher.switchTo(Page.PREPARE);
    }
    
    //Der Button saveButton ist nur verfügbar wenn in den folgenden textfeldern der Richtige Datentyp steht
    
    @FXML
    private void checkFields() {
    	saveButton.setDisable(true);
    	
    	String f1 = nameField.getText();
        String durationText = durationField.getText();
        String personenText = personenField.getText();

        int f2 = 0;
        int f3 = 0;

        try {
            f2 = Integer.parseInt(durationText);
        } catch (NumberFormatException e) {
            f2 = 0;
        }

        try {
            f3 = Integer.parseInt(personenText);
        } catch (NumberFormatException e) {
            f3 = 0;
        }

        if (f1 != null && !f1.trim().isEmpty() && f2 > 0 && f3 > 0) {
            saveButton.setDisable(false);
        } else {
            saveButton.setDisable(true);
        }
    }

    
    //Hier werden die Datenbanken dann gefüllt

    @FXML
    private void show() {
    	
    	next.setDisable(true);
    	
        String sqlGericht = "INSERT INTO gerichte (name, dauer, personenanzahl) VALUES (?, ?, ?)";
        String sqlZutat = "INSERT INTO zutaten (gericht_id, bezeichnung, einheit) VALUES (?, ?, ?)";

        String name = nameField.getText();

        try {
            int dauer = Integer.parseInt(durationField.getText());
            int anzahl = Integer.parseInt(personenField.getText());

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmtGericht = conn.prepareStatement(sqlGericht, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement stmtZutat = conn.prepareStatement(sqlZutat)) {

                
                stmtGericht.setString(1, name);
                stmtGericht.setInt(2, dauer);
                stmtGericht.setInt(3, anzahl);
                stmtGericht.executeUpdate();

                
                ResultSet rs = stmtGericht.getGeneratedKeys();
                int gerichtId = -1;
                if (rs.next()) {
                    gerichtId = rs.getInt(1);
                    GerichtHolder.setGerichtId(gerichtId);
                }

               
                for (int i = 0; i < zutatFields.size(); i++) {
                    String zutat = zutatFields.get(i).getText();
                    String einheit = einheitFields.get(i).getText();

                    if (zutat != null && !zutat.trim().isEmpty()) {
                        stmtZutat.setInt(1, gerichtId);
                        stmtZutat.setString(2, zutat);
                        stmtZutat.setString(3, einheit != null ? einheit : "");
                        stmtZutat.addBatch();
                    }
                }

                stmtZutat.executeBatch();
                next.setDisable(false);
                System.out.println("Gericht und Zutaten erfolgreich gespeichert.");
                PageSwitcher.switchTo(Page.PREPARE);
                JOptionPane.showMessageDialog(null, "Erfolgreich Gespeichert");

            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Fehler beim Speichern in der Datenbank.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Bitte gültige Zahlen eingeben!");
        }
    }
}