package Controller;

import Enums.Page;
import PageSwitching.PageSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class PreparePageController {

    private static final String URL = "jdbc:mysql://localhost:3306/meinedb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private int gerichtId;

    public void setGerichtId(int id) {
        this.gerichtId = id;
    }

    @FXML
    private VBox stepsContainer;

    @FXML private TextField stepField1, stepField2, stepField3, stepField4, stepField5,
            stepField6, stepField7, stepField8, stepField9, stepField10,
            stepField11, stepField12, stepField13, stepField14, stepField15,
            stepField16, stepField17, stepField18, stepField19, stepField20,
            stepField21, stepField22, stepField23, stepField24, stepField25,
            stepField26, stepField27, stepField28, stepField29, stepField30;

    private List<TextField> stepFields;

    @FXML
    public void initialize() {
        
        stepFields = Arrays.asList(
                stepField1, stepField2, stepField3, stepField4, stepField5,
                stepField6, stepField7, stepField8, stepField9, stepField10,
                stepField11, stepField12, stepField13, stepField14, stepField15,
                stepField16, stepField17, stepField18, stepField19, stepField20,
                stepField21, stepField22, stepField23, stepField24, stepField25,
                stepField26, stepField27, stepField28, stepField29, stepField30
        );
        	this.gerichtId = Helper.GerichtHolder.getGerichtId();
        	System.out.println("Gericht ID erhalte: " + gerichtId);
    
    }

    @FXML
    private void close() {
        PageSwitcher.switchTo(Page.NEW);
    }

    @FXML
    private void show() {
        PageSwitcher.switchTo(Page.FIRST);
    }

    @FXML
    private void insert() {
        String insertSql = "INSERT INTO zubereitungsschritte (gericht_id, schritt_nr, beschreibung) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(insertSql)) {

            for (int i = 0; i < stepFields.size(); i++) {
                String beschreibung = stepFields.get(i).getText();
                if (beschreibung != null && !beschreibung.trim().isEmpty()) {
                    stmt.setInt(1, gerichtId);
                    stmt.setInt(2, i + 1); 
                    stmt.setString(3, beschreibung.trim());
                    stmt.addBatch();
                }
            }
            stmt.executeBatch();
            System.out.println("Zubereitungsschritte erfolgreich gespeichert.");
            PageSwitcher.switchTo(Page.FIRST); 


        } catch (SQLException e) {
            System.err.println("Fehler beim Speichern der Zubereitungsschritte:");
            e.printStackTrace();
        }
    }
}