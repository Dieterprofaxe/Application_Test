package Application;

import Enums.Page;
import PageSwitching.PageSwitcher;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;


public class Main extends Application {
	
	public void start(Stage stage) throws Exception{
		
		Scene scene = new Scene(new Pane());
		PageSwitcher.setScene(scene);
		PageSwitcher.switchTo(Page.NEW);
		
		stage.setTitle("Essen Application");
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) throws Exception{
		launch(args);
	}
	
}
