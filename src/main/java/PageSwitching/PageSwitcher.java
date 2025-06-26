package PageSwitching;


import java.io.IOException;

import Controller.BearbeitenPageController;
import Controller.StartPageController;
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
	
	
	
	public static void switch_with_id(Page page, int id) throws IOException {
	    FXMLLoader loader = new FXMLLoader(PageSwitcher.class.getResource(page.getFilename()));
	    Parent root = loader.load();

	    Object controller = loader.getController();

	    if (controller instanceof BearbeitenPageController) {
	        ((BearbeitenPageController) controller).page_loader(id);
	    } else {
	        System.err.println("Warnung: Controller ist nicht vom Typ BearbeitenPageController!");
	    }

	    scene.setRoot(root);
	}

	
	public static void switch_with_id_1(Page page, int id) throws IOException{
		FXMLLoader loader = new FXMLLoader(PageSwitcher.class.getResource(page.getFilename()));
		Parent root = loader.load();
		
		Object controller = loader.getController();
		
		if(controller instanceof StartPageController) {
			((StartPageController) controller).page_Loader(id);
		}else {
			System.err.println("Warnung: Controoler ist nicht vom Typ StartPageController");
			
		}
	}
	
}
