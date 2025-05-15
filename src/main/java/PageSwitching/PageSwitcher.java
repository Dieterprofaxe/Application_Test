package PageSwitching;


import Enums.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class PageSwitcher {
	private static Scene scene;
	public static void setScene(Scene scene) {
		PageSwitcher.scene = scene;
	}
	
	public static void switchTo(Page page) {
		if(scene == null) {
			System.out.println("No Page set");
			return;
		}
		
		try {
			FXMLLoader loader = new FXMLLoader(PageSwitcher.class.getResource(page.getFilename()));
			Parent root = loader.load();
			scene.setRoot(root);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
