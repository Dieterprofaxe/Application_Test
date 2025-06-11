package Controller;

import Model.Gericht;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.DocFlavor.URL;

public class OverviewPageController {
	
	
	private static final String URL = "jdbc:mysql://localhost:3306/meinedb?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD ="";

    @FXML
    private TableView<Gericht> gerichtTable;

    @FXML
    private TableColumn<Gericht, String> nameColumn;

    @FXML
    private TableColumn<Gericht, Integer> dauerColumn;

    @FXML
    private TableColumn<Gericht, Integer> personenColumn;

    @FXML
    private void view() {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM gerichte";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Verbindung erfolgreich hergestellt");

            while (rs.next()) {
                System.out.println(rs.getString("name") + ": " + rs.getString("dauer") + ": " + rs.getString("personenanzahl"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Fehler beim Herstellen der Verbindung: " + e.getMessage());
        }
    }

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Gericht, String>("name"));
        dauerColumn.setCellValueFactory(new PropertyValueFactory<Gericht, Integer>("dauer"));
        personenColumn.setCellValueFactory(new PropertyValueFactory<Gericht, Integer>("personenanzahl"));
        
        loadGerichte();
    }

    private void loadGerichte() {
        ObservableList<Gericht> gerichte = FXCollections.observableArrayList();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, dauer, personenanzahl FROM gerichte")) {

            while (rs.next()) {
                gerichte.add(new Gericht(
                        rs.getString("name"),
                        rs.getInt("dauer"),
                        rs.getInt("personenanzahl")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        gerichtTable.setItems(gerichte);
    }
    
    
    
    @FXML
    private void delete() {
    	Gericht ausgewählt = gerichtTable.getSelectionModel().getSelectedItem();
    	if (ausgewählt == null) {
    	    System.out.println("Keine Zeile ausgewählt.");
    	    return;
    	}

    	String name = ausgewählt.getName();
    	
    	String sqlzu = "DELETE FROM zutaten WHERE gericht_id = ?";
    	String sqlzub = "DELETE FROM zubreitungsschritte WHERE gericht_id = ?";
    	String sql = "DELETE FROM gerichte WHERE name = ?";

    	try (Connection conn = DBConnection.getConnection();
    		 PreparedStatement stmt1 = conn.prepareStatement(sqlzu);
    		 PreparedStatement stmt2 = conn.prepareStatement(sqlzub);
    	     PreparedStatement stmt = conn.prepareStatement(sql)) {

    	    stmt.setString(1, name);
    	    stmt1.setString(1, sql);
    	    int affectedRows = stmt.executeUpdate();

    	    if (affectedRows > 0) {
    	        System.out.println("Gericht mit Name '" + name + "' wurde gelöscht.");
    	        loadGerichte();  
    	    } else {
    	        System.out.println("Kein Gericht mit Name '" + name + "' gefunden.");
    	    }

    	} catch (SQLException e) {
    	    e.printStackTrace();
    	    System.err.println("Fehler beim Löschen des Datensatzes.");
    	}
}
    }