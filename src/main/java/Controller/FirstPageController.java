package Controller;
import javafx.scene.control.Button;
import Enums.Page;
import PageSwitching.PageSwitcher;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

public class FirstPageController {
	
	@FXML
	private Button btn_logOut;
	
	
	
	
	
	public void logOut() {
		PageSwitcher.switchTo(Page.MAIN);
	}
	
	

}
