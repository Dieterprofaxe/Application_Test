package Controller;

import Enums.Page;
import PageSwitching.PageSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class PreparePageController {
	
    private static final String URL = "jdbc:mysql://localhost:3306/meinedb?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
    private static final String PASSWORD = "";

    
  //Die verschiedenen Objekte werden initializiert
    
    @FXML
    private Button btn_last, btn_save; 
    
    
    @FXML
    private int gerichtId;

    @FXML
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
    	btn_last.setDisable(true);
    	
    	
    	 btn_save.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 System.out.println("Button wurde geklickt!");
                 insert();
                 btn_last.setDisable(false);
             }
         });
    	
        
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

    
    //Wieder nur die Seitenwechsel
    
    @FXML
    private void close() {
        PageSwitcher.switchTo(Page.NEW);
    }

    @FXML
    private void show() {
        PageSwitcher.switchTo(Page.FIRST);
    }

    //Hier werden die Zubereitungsschritte gespeichert
    @FXML
    private void insert(){
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
            JOptionPane.showMessageDialog(null, "Rezept wurde erfolgreich angelegt!", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
            PageSwitcher.switchTo(Page.FIRST); 


        } catch (SQLException e) {
            System.err.println("Fehler beim Speichern der Zubereitungsschritte:");
            e.printStackTrace();
        }
    }
}