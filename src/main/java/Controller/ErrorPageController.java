package Controller;

import Enums.Page;
import PageSwitching.PageSwitcher;
import javafx.fxml.FXML;

public class ErrorPageController {

	@FXML
	private void back() {
		PageSwitcher.switchTo(Page.OVERVIEW);
	}
	
}
