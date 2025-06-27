package Controller;

import Model.Gericht;
import PageSwitching.PageSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.transformation.FilteredList;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.TextField;
import javax.print.DocFlavor.URL;
import javax.swing.JOptionPane;

import Enums.Page;
	
public class OverviewPageController {
	
	
	private static final String URL = "jdbc:mysql://localhost:3306/meinedb?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD ="";

	//Die verschiedenen Objekte werden initializiert
	
    @FXML
    private TableView<Gericht> gerichtTable;

    @FXML
    private TableColumn<Gericht, String> nameColumn;

    @FXML
    private TableColumn<Gericht, Integer> dauerColumn;

    @FXML
    private TableColumn<Gericht, Integer> personenColumn;
    
    @FXML
    private TextField searchField;

    private ObservableList<Gericht> gerichte = FXCollections.observableArrayList();
    private FilteredList<Gericht> filteredGerichte;

    
    //Verbindung zur Datenbank wird erstellt die Daten aus der Datenbank werden angezeigt
    
    @FXML
    private void view() {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM gerichte";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Verbindung erfolgreich hergestellt");

            while (rs.next()) {
                System.out.println(rs.getString("name") + ": " + rs.getInt("dauer") + ": " + rs.getInt("personenanzahl"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Fehler beim Herstellen der Verbindung: " + e.getMessage());
        }
    }

    //Das ist die Suchfunktion
    
    @FXML
    private void initialize() {
    	
    	searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredGerichte.setPredicate(gericht -> {
                
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                return gericht.getName().toLowerCase().contains(lowerCaseFilter);
            });
        });
    	
    	
        nameColumn.setCellValueFactory(new PropertyValueFactory<Gericht, String>("name"));
        dauerColumn.setCellValueFactory(new PropertyValueFactory<Gericht, Integer>("dauer"));
        personenColumn.setCellValueFactory(new PropertyValueFactory<Gericht, Integer>("personenanzahl"));
        
        loadGerichte();
    }
    
    
   
    
    @FXML
    private void loadGerichte() {
    	gerichte.clear(); 
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, dauer, personenanzahl FROM gerichte")) {
            while (rs.next()) {
                gerichte.add(new Gericht(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("dauer"),
                    rs.getInt("personenanzahl")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        filteredGerichte = new FilteredList<>(gerichte, p -> true);
        gerichtTable.setItems(filteredGerichte);
    }
    
    
    //Das Gericht welches ausgewählt ist wird gelöscht mit dne folgenden SQL-Befehlen
    @FXML
    private void delete() {
        Gericht ausgewählt = gerichtTable.getSelectionModel().getSelectedItem();
        if (ausgewählt == null) {
        	JOptionPane.showMessageDialog(null, "Wählen sie eine Zeile aus!", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println("Keine Zeile ausgewählt.");
            return;
        }

        int id = ausgewählt.getId();
        System.out.println(ausgewählt);

        String sqlZutaten = "DELETE FROM zutaten WHERE gericht_id = ?";
        String sqlZubereitung = "DELETE FROM zubereitungsschritte WHERE gericht_id = ?";
        String sqlGerichte = "DELETE FROM gerichte WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmtZutaten = conn.prepareStatement(sqlZutaten);
             PreparedStatement stmtZubereitung = conn.prepareStatement(sqlZubereitung);
             PreparedStatement stmtGerichte = conn.prepareStatement(sqlGerichte)) {

            stmtZutaten.setInt(1, id);
            stmtZutaten.executeUpdate();

            stmtZubereitung.setInt(1, id);
            stmtZubereitung.executeUpdate();

            
            
            stmtGerichte.setInt(1, id);
            int affectedRows = stmtGerichte.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Gericht erfolgreich gelöscht.");
                JOptionPane.showMessageDialog(null, "Eintrag erfolgreich gelöscht!", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
                loadGerichte();
            } else {
                System.out.println("Kein Gericht mit dieser ID gefunden.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Fehler beim Löschen des Datensatzes.");
        }
    }
    
    
    @FXML
    private void back() {
    	PageSwitcher.switchTo(Page.FIRST);
    }
    
    
    @FXML
    private void edit() throws IOException {
    	Gericht ausgewählt = gerichtTable.getSelectionModel().getSelectedItem();
    	
    	if(ausgewählt == null) {
    		JOptionPane.showMessageDialog(null, "Wählen sie eine Zeile aus!", "ERROR", JOptionPane.ERROR_MESSAGE);
    		System.out.println("Es wrude keine Zeile ausgewählt");
    	}
    	
    	int id = ausgewählt.getId();
    	
    	System.out.println("Zu bearbeitende ID: " + id);
    	
    	PageSwitcher.switch_with_id(Page.BEARBEITEN, id);
//    	PageSwitcher.switchTo(Page.BEARBEITEN);
    	
    		
    }
    
    //Hat keine Auswirkung fürs Programm. Wird verwendet falls ich das Programm mal erweitern möchte 
    @FXML
    private void start(int gerichtID) throws IOException{
    	
    	int d = 5;
    	
    	if(d > 0) {
    		System.out.println("Es wird direkt gestartet");
    		
    	}else {
    	
    	
    	Gericht ausgewählt = gerichtTable.getSelectionModel().getSelectedItem();
    	
    	if(ausgewählt == null) {
    		System.out.println("Es wurde keine Zeile ausgewählt");
    	}
    	
    	int id = ausgewählt.getId();
    	
    	gerichtID = id;
    	
    	System.out.println("Zu bearbeitende ID: " + id);
    	
    	PageSwitcher.switch_with_id(Page.START, id);
    	
    	}
    }
    
    
    
    
    
    
    }