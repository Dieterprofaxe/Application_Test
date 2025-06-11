package Controller;

import Enums.Page;
import PageSwitching.PageSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;

public class ViewPageController {

    @FXML
    Button btn_back, btn_edit, btn_save;
    
    
    
    
    
    @FXML
    private void close() {
    	PageSwitcher.switchTo(Page.FIRST);
    }

}