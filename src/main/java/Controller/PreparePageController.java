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

import javax.swing.JOptionPane;

import java.sql.DriverManager;

import Enums.Page;
import PageSwitching.PageSwitcher;

public class PreparePageController {
	
	private int zutatCounter = 3;
	
	@FXML
	private Button add, delete, btn_last, btn_save, btn_delete;
	
	@FXML
	private TextField PrepareField, stepField1, stepField2, stepField3, stepField4, stepField5, stepField6, stepField7, stepField8, stepField9, stepField10, stepField11, stepField12, stepField13, stepField14, stepField15, stepField16, stepField17, stepField18, stepField19, stepField20, stepField21, stepField22, stepField23, stepField24, stepField25, stepField26, stepField27, stepField28, stepField29, stepField30;
	
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
    private void insert() {
    
    String Field1 = stepField1.getText();
    String Field2 = stepField1.getText();
    String Field3 = stepField1.getText();
    String Field4 = stepField1.getText();
    String Field5 = stepField1.getText();
    String Field6 = stepField1.getText();
    String Field7 = stepField1.getText();
    String Field8 = stepField1.getText();
    String Field9 = stepField1.getText();
    String Field10 = stepField1.getText();
    String Field11 = stepField1.getText();
    String Field12 = stepField1.getText();
    String Field13 = stepField1.getText();
    String Field14 = stepField1.getText();
    String Field15 = stepField1.getText();
    String Field16 = stepField1.getText();
    String Field17 = stepField1.getText();
    String Field18 = stepField1.getText();
    String Field19 = stepField1.getText();
    String Field20 = stepField1.getText();
    String Field21 = stepField1.getText();
    String Field22 = stepField1.getText();
    String Field23 = stepField1.getText();
    String Field24 = stepField1.getText();
    String Field25 = stepField1.getText();
    String Field26 = stepField1.getText();
    String Field27 = stepField1.getText();
    String Field28 = stepField1.getText();
    String Field29 = stepField1.getText();
    String Field30 = stepField1.getText();
    
    	if(Field1.isEmpty() && Field2.isEmpty() && Field3 == null && Field4 == null && Field5 == null && Field6 == null && Field7 == null && Field8 == null && Field9 == null && Field10 == null && Field11 == null && Field12 == null && Field13 == null && Field14 == null && Field15 == null && Field16 == null && Field17 == null && Field18 == null && Field19 == null && Field20 == null  && Field21 == null  && Field22 == null && Field23 == null && Field24 == null && Field25 == null && Field26 == null && Field27 == null && Field28 == null && Field29 == null && Field30 == null) {
    		
    		JOptionPane.showMessageDialog(null, "Bitte alle Felder ausfüllen");
    		
    	}
    
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
        	     alt = rs.getInt("alt");  
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