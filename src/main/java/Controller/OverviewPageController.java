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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.TextField;
import javax.print.DocFlavor.URL;

import Enums.Page;

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
    private TextField searchField;

    private ObservableList<Gericht> gerichte = FXCollections.observableArrayList();
    private FilteredList<Gericht> filteredGerichte;

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

    @FXML
    private void initialize() {
    	
    	searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredGerichte.setPredicate(gericht -> {
                // Wenn Suchfeld leer -> alles anzeigen
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
    	gerichte.clear(); // Wichtig: Liste leeren, sonst doppelt geladen

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
    
    
    
    @FXML
    private void delete() {
        Gericht ausgewählt = gerichtTable.getSelectionModel().getSelectedItem();
        if (ausgewählt == null) {
            System.out.println("Keine Zeile ausgewählt.");
            return;
        }

        int id = ausgewählt.getId();

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
    }