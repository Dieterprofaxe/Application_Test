package Controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Enums.Page;
import PageSwitching.PageSwitcher;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

public class NewPageController {

	
	@FXML
	private Button cancelButton, saveButton;
	
	
	
	
	
	
	@FXML
	private void close() {
		PageSwitcher.switchTo(Page.FIRST);
	}
	
	
	
}
