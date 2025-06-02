package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

import Enums.Page;
import PageSwitching.PageSwitcher;

public class PreparePageController {
	
	private int zutatCounter = 3;
	
	@FXML
	private Button add, delete, btn_last, btn_save, btn_delete;
	
	@FXML
	private TextField PrepareField;
	
	@FXML
	int schritt = 2;
	
	@FXML
	private int alt;
	
	@FXML
	private String name;
	
	@FXML
	private void close() {
		PageSwitcher.switchTo(Page.NEW);
	}
	
	
	
	@FXML
    private VBox stepsContainer;

    @FXML
    public void addRow() {
        TextField newField = new TextField();
        newField.setPromptText("Zubereitungsschritt: " + schritt);
        newField.getStyleClass().add("text-field");
        stepsContainer.getChildren().add(newField);
        schritt++;
    }

    @FXML
    public void removeRow() {
        int count = stepsContainer.getChildren().size();
        if (count > 0) {
            stepsContainer.getChildren().remove(count - 1);
        }
    }
    @FXML
    private void show() {
        String sql = "SELECT * FROM gerichte";

        try (Connection conn = DBConnection.getConnection();
   
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
        	
        	while (rs.next()) {
        	     alt = rs.getInt("alt");  // nicht 'int alt', sondern 'alt ='
        	     name = rs.getString("name");

        	    System.out.println("ID: " + alt + ", Name: " + name + ", Dauer: ");
        	}

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void text() {
        PrepareField.setText(String.valueOf(name));
        System.out.println(name);
    }
   
}