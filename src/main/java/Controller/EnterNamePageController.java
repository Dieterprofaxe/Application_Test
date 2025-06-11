package Controller;

import Enums.Page;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EnterNamePageController {

	@FXML
	Button btn_continue;

	@FXML
	TextField nameInputField;
	
    private static final String URL = "jdbc:mysql://localhost:3306/meinedb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";
	
	
	@FXML
	private void getName() {
	String gericht = btn_continue.getText();
	
		String sqlStatement = "SELECT * FROM gerichte WHERE name = gericht";
		
	}

}
