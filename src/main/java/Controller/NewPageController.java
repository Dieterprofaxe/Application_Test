package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Enums.Page;
import PageSwitching.PageSwitcher;

public class NewPageController {

    @FXML
    private Button cancelButton, saveButton;

    @FXML
    private VBox zutatenContainer;

    @FXML
    private VBox zutatenList;

    
    private int zutatCounter = 3; 

    @FXML
    private void close() {
        PageSwitcher.switchTo(Page.FIRST);
    }

    @FXML
    private void addZutatRow() {
        HBox row = new HBox(5);
        for (int i = 0; i < 2; i++) {
            TextField tf = new TextField();
            tf.setPromptText("Zutat " + zutatCounter++);
            tf.setPrefWidth(150);
            row.getChildren().add(tf);
        }
        zutatenList.getChildren().add(row);
    }
    
    @FXML
    private void deleteZutatRow() {
    	
    }
    
    
    
}