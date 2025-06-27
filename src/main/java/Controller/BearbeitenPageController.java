package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Enums.Page;
import PageSwitching.PageSwitcher;

public class BearbeitenPageController implements Initializable {

    @FXML private TextField name;
    @FXML private TextField durationField;
    @FXML private TextField personenField;

    @FXML private TextField[] zutatFields;
    @FXML private TextField[] einheitFields;
    @FXML private TextField[] stepFields;

    @FXML private Button btn_cancel;
    @FXML private Button btn_save;

    // Einzelne Felder für Zutaten und Einheiten (30 Stück)
    @FXML private TextField zutatField1; @FXML private TextField einheitField1;
    @FXML private TextField zutatField2; @FXML private TextField einheitField2;
    @FXML private TextField zutatField3; @FXML private TextField einheitField3;
    @FXML private TextField zutatField4; @FXML private TextField einheitField4;
    @FXML private TextField zutatField5; @FXML private TextField einheitField5;
    @FXML private TextField zutatField6; @FXML private TextField einheitField6;
    @FXML private TextField zutatField7; @FXML private TextField einheitField7;
    @FXML private TextField zutatField8; @FXML private TextField einheitField8;
    @FXML private TextField zutatField9; @FXML private TextField einheitField9;
    @FXML private TextField zutatField10; @FXML private TextField einheitField10;
    @FXML private TextField zutatField11; @FXML private TextField einheitField11;
    @FXML private TextField zutatField12; @FXML private TextField einheitField12;
    @FXML private TextField zutatField13; @FXML private TextField einheitField13;
    @FXML private TextField zutatField14; @FXML private TextField einheitField14;
    @FXML private TextField zutatField15; @FXML private TextField einheitField15;
    @FXML private TextField zutatField16; @FXML private TextField einheitField16;
    @FXML private TextField zutatField17; @FXML private TextField einheitField17;
    @FXML private TextField zutatField18; @FXML private TextField einheitField18;
    @FXML private TextField zutatField19; @FXML private TextField einheitField19;
    @FXML private TextField zutatField20; @FXML private TextField einheitField20;
    @FXML private TextField zutatField21; @FXML private TextField einheitField21;
    @FXML private TextField zutatField22; @FXML private TextField einheitField22;
    @FXML private TextField zutatField23; @FXML private TextField einheitField23;
    @FXML private TextField zutatField24; @FXML private TextField einheitField24;
    @FXML private TextField zutatField25; @FXML private TextField einheitField25;
    @FXML private TextField zutatField26; @FXML private TextField einheitField26;
    @FXML private TextField zutatField27; @FXML private TextField einheitField27;
    @FXML private TextField zutatField28; @FXML private TextField einheitField28;
    @FXML private TextField zutatField29; @FXML private TextField einheitField29;
    @FXML private TextField zutatField30; @FXML private TextField einheitField30;

    // 30 Textfelder für Zubereitungsschritte
    @FXML private TextField stepField1;
    @FXML private TextField stepField2;
    @FXML private TextField stepField3;
    @FXML private TextField stepField4;
    @FXML private TextField stepField5;
    @FXML private TextField stepField6;
    @FXML private TextField stepField7;
    @FXML private TextField stepField8;
    @FXML private TextField stepField9;
    @FXML private TextField stepField10;
    @FXML private TextField stepField11;
    @FXML private TextField stepField12;
    @FXML private TextField stepField13;
    @FXML private TextField stepField14;
    @FXML private TextField stepField15;
    @FXML private TextField stepField16;
    @FXML private TextField stepField17;
    @FXML private TextField stepField18;
    @FXML private TextField stepField19;
    @FXML private TextField stepField20;
    @FXML private TextField stepField21;
    @FXML private TextField stepField22;
    @FXML private TextField stepField23;
    @FXML private TextField stepField24;
    @FXML private TextField stepField25;
    @FXML private TextField stepField26;
    @FXML private TextField stepField27;
    @FXML private TextField stepField28;
    @FXML private TextField stepField29;
    @FXML private TextField stepField30;

    private int gerichtID;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        zutatFields = new TextField[] {
            zutatField1, zutatField2, zutatField3, zutatField4, zutatField5,
            zutatField6, zutatField7, zutatField8, zutatField9, zutatField10,
            zutatField11, zutatField12, zutatField13, zutatField14, zutatField15,
            zutatField16, zutatField17, zutatField18, zutatField19, zutatField20,
            zutatField21, zutatField22, zutatField23, zutatField24, zutatField25,
            zutatField26, zutatField27, zutatField28, zutatField29, zutatField30
        };

        einheitFields = new TextField[] {
            einheitField1, einheitField2, einheitField3, einheitField4, einheitField5,
            einheitField6, einheitField7, einheitField8, einheitField9, einheitField10,
            einheitField11, einheitField12, einheitField13, einheitField14, einheitField15,
            einheitField16, einheitField17, einheitField18, einheitField19, einheitField20,
            einheitField21, einheitField22, einheitField23, einheitField24, einheitField25,
            einheitField26, einheitField27, einheitField28, einheitField29, einheitField30
        };

        stepFields = new TextField[] {
            stepField1, stepField2, stepField3, stepField4, stepField5,
            stepField6, stepField7, stepField8, stepField9, stepField10,
            stepField11, stepField12, stepField13, stepField14, stepField15,
            stepField16, stepField17, stepField18, stepField19, stepField20,
            stepField21, stepField22, stepField23, stepField24, stepField25,
            stepField26, stepField27, stepField28, stepField29, stepField30
        };
    }

    public void page_loader(int gerichtID) {
        this.gerichtID = gerichtID;
        try (Connection conn = DBConnection.getConnection()) {
            ladeGericht(conn);
            ladeZutaten(conn);
            ladeZubereitung(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void ladeGericht(Connection conn) throws SQLException {
        String sql = "SELECT name, dauer, personenanzahl FROM gerichte WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, gerichtID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                name.setText(rs.getString("name"));
                durationField.setText(String.valueOf(rs.getInt("dauer")));
                personenField.setText(String.valueOf(rs.getInt("personenanzahl")));
            }
        }
    }

    private void ladeZutaten(Connection conn) throws SQLException {
        String sql = "SELECT bezeichnung, einheit FROM zutaten WHERE gericht_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, gerichtID);
            ResultSet rs = pstmt.executeQuery();
            int index = 0;
            while (rs.next() && index < zutatFields.length) {
                zutatFields[index].setText(rs.getString("bezeichnung"));
                einheitFields[index].setText(rs.getString("einheit"));
                index++;
            }
        }
    }

    private void ladeZubereitung(Connection conn) throws SQLException {
        String sql = "SELECT beschreibung FROM zubereitungsschritte WHERE gericht_id = ? ORDER BY schritt_nr ASC";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, gerichtID);
            ResultSet rs = pstmt.executeQuery();
            int index = 0;
            while (rs.next() && index < stepFields.length) {
                stepFields[index].setText(rs.getString("beschreibung"));
                index++;
            }
        }
    }

    @FXML
    private void back(ActionEvent event) {
        PageSwitcher.switchTo(Page.OVERVIEW);
    }
    
   

    	@FXML
    	private void save(ActionEvent event) {
    	    try (Connection conn = DBConnection.getConnection()) {
    	        updateGericht(conn);
    	        updateZutaten(conn);
    	        updateZubereitung(conn);
    	        JOptionPane.showMessageDialog(null, "Erfolgreich gespeichert!", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	}
    	
    	private void updateGericht(Connection conn) throws SQLException {
    	    String sql = "UPDATE gerichte SET name = ?, dauer = ?, personenanzahl = ? WHERE id = ?";
    	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
    	        pstmt.setString(1, name.getText());
    	        pstmt.setInt(2, Integer.parseInt(durationField.getText()));
    	        pstmt.setInt(3, Integer.parseInt(personenField.getText()));
    	        pstmt.setInt(4, gerichtID);
    	        pstmt.executeUpdate();
    	    }
    	}
    	@FXML
    	private void updateZutaten(Connection conn) throws SQLException {
    	    
    	    String deleteSql = "DELETE FROM zutaten WHERE gericht_id = ?";
    	    try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
    	        deleteStmt.setInt(1, gerichtID);
    	        deleteStmt.executeUpdate();
    	    }

    	    
    	    String insertSql = "INSERT INTO zutaten (gericht_id, bezeichnung, einheit) VALUES (?, ?, ?)";
    	    try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
    	        for (int i = 0; i < zutatFields.length; i++) {
    	            String zutat = zutatFields[i].getText();
    	            String einheit = einheitFields[i].getText();
    	            if (zutat != null && !zutat.isEmpty()) {
    	                insertStmt.setInt(1, gerichtID);
    	                insertStmt.setString(2, zutat);
    	                insertStmt.setString(3, einheit);
    	                insertStmt.addBatch();
    	            }
    	        }
    	        insertStmt.executeBatch();
    	    }
    	}
    	@FXML
    	private void updateZubereitung(Connection conn) throws SQLException {
    	    String deleteSql = "DELETE FROM zubereitungsschritte WHERE gericht_id = ?";
    	    try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
    	        deleteStmt.setInt(1, gerichtID);
    	        deleteStmt.executeUpdate();
    	    }

    	    
    	    String insertSql = "INSERT INTO zubereitungsschritte (gericht_id, schritt_nr, beschreibung) VALUES (?, ?, ?)";
    	    try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
    	        for (int i = 0; i < stepFields.length; i++) {
    	            String schritt = stepFields[i].getText();
    	            if (schritt != null && !schritt.isEmpty()) {
    	                insertStmt.setInt(1, gerichtID);
    	                insertStmt.setInt(2, i + 1);
    	                insertStmt.setString(3, schritt);
    	                insertStmt.addBatch();
    	            }
    	        }
    	        insertStmt.executeBatch();
    	    }
    	}
    
}