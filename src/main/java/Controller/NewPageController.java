package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Enums.Page;
import PageSwitching.PageSwitcher;

public class NewPageController {
    private static final String URL = "jdbc:mysql://localhost:3306/meinedb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    @FXML
    private Button cancelButton, saveButton;

    @FXML
    private VBox zutatenContainer, zutatenList, hauptzutatenList;

    @FXML
    private TextField personenField, nameField, durationField;

    private int zutatCounter = 3;

    @FXML
    public void initialize() {
        personenField.setText("1");
    }

    @FXML
    private void close() {
        PageSwitcher.switchTo(Page.FIRST);
    }

    @FXML
    private void next() {
        PageSwitcher.switchTo(Page.PREPARE);
    }

    @FXML
    private void deleteZutatRow() {
        int count = zutatenList.getChildren().size();
        if (count > 0) {
            zutatenList.getChildren().remove(count - 1);
            zutatCounter -= 2;
            if (zutatCounter < 1) zutatCounter = 1;
        }
    }

    @FXML
    private void addHauptzutatRow() {
        hauptzutatenList.getChildren().add(createZutatRow());
    }

    @FXML
    private void deleteHauptzutatRow() {
        int count = hauptzutatenList.getChildren().size();
        if (count > 0) hauptzutatenList.getChildren().remove(count - 1);
    }

    @FXML
    private HBox createZutatRow() {
        HBox row = new HBox(50);
        TextField zutat = new TextField();
        zutat.setPromptText("Zutat");
        zutat.setPrefWidth(300);
        TextField einheit = new TextField();
        einheit.setPromptText("Einheit");
        einheit.setPrefWidth(200);
        row.getChildren().addAll(zutat, einheit);
        return row;
    }

    @FXML
    private void show() {
        String sql = "INSERT INTO gerichte (name, dauer, personenanzahl) VALUES (?, ?, ?)";

        String name = nameField.getText();
        try {
            int dauer = Integer.parseInt(durationField.getText());
            int anzahl = Integer.parseInt(personenField.getText());

            try (Connection conn = java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, name);
                stmt.setInt(2, dauer);
                stmt.setInt(3, anzahl);

                stmt.executeUpdate();
                System.out.println("Gericht gespeichert.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            System.out.println("Bitte gültige Zahlen eingeben!");
        }
    }
    
}