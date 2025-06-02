package Controller;

import Enums.Page;
import PageSwitching.PageSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;

public class ViewPageController {

    @FXML
    private FlowPane dishContainer; // aus FXML referenziert
    
    @FXML
    private void close() {
    	PageSwitcher.switchTo(Page.FIRST);
    }

}