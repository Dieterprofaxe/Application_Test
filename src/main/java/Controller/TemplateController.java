package Controller;

import Enums.Page;
import PageSwitching.PageSwitcher;
import javafx.fxml.FXML;

public abstract class TemplateController {
	 @FXML
	 protected void onMenu() {
		 PageSwitcher.switchTo(Page.MAIN);
	 }
}
