package Controller;



import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainPageController extends Application {
	
	@FXML
	private Button btn_loe, btn_enter, btn_close;
	
	@FXML
	private TextField txt_user, txt_pass;
	
	
	
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
		String user = txt_user.getText();
		int pass = Integer.parseInt(txt_pass.getText());
		
		
		if(pass == 1234 && user.equals("root")){
			JOptionPane.showMessageDialog(null, "Richtiger Benutzer oder Passwort");
		}else {
			JOptionPane.showMessageDialog(null, "Falscher Benutzer oder Passwort");
		}
		
		
				
				
				
	}
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
