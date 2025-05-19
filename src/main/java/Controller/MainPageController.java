package Controller;



import javax.swing.JOptionPane;

import Enums.Page;
import PageSwitching.PageSwitcher;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;


public class MainPageController extends Application {
	
	@FXML
	private Button btn_loe, btn_enter, btn_close;
	
	@FXML
	private TextField txt_user;
	
	@FXML 
	private PasswordField txt_pass;
	
	
	private final String user1 = "admin";
    private final String pass1 = "1234";

    private final String user2 = "user";
    private final String pass2 = "1234";

    private final String user3 = "guest";
    private final String pass3 = "1234";
	
	
	
	@FXML
	public void delet() {
		txt_user.setText("");
		txt_pass.setText("");
		
	}
	
	@FXML
	public void close() {
		System.exit(0);
	}
	
	@FXML
    public void check_user() {
        String username = txt_user.getText();
        String password = txt_pass.getText();

        if (username.equals(user1) && password.equals(pass1)) {
            JOptionPane.showMessageDialog(null, "Willkommen Admin!");
            PageSwitcher.switchTo(Page.FIRST);
            
        } else if (username.equals(user2) && password.equals(pass2)) {
            JOptionPane.showMessageDialog(null, "Willkommen User!");
            PageSwitcher.switchTo(Page.FIRST);
            
        } else if (username.equals(user3) && password.equals(pass3)) {
            JOptionPane.showMessageDialog(null, "Willkommen Gast!");
            PageSwitcher.switchTo(Page.FIRST);
            
        } else {
            JOptionPane.showMessageDialog(null, "Benutzername oder Passwort falsch!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
	}

	

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
