package Controller;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.Desktop;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import Enums.Page;
import PageSwitching.PageSwitcher;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

public class FirstPageController {
	
	@FXML
	private Button btn_close, btn_logOut, hiddenButton;
	
	
	
	
	@FXML
	private void logOut() {
		PageSwitcher.switchTo(Page.MAIN);
	}
	@FXML
	private void close() {
		System.exit(0);
	}
	@FXML
	private void new_() {
		PageSwitcher.switchTo(Page.NEW);
	}
	@FXML
	private void edit() {
		PageSwitcher.switchTo(Page.EDIT);
	}
	@FXML
	private void view() {
		PageSwitcher.switchTo(Page.VIEW);
	}
	
	

}
