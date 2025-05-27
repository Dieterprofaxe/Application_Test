package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ChoiceBox;
import Enums.Page;
import PageSwitching.PageSwitcher;

public class NewPageController {

    @FXML
    private Button cancelButton, saveButton;

    @FXML
    private VBox zutatenContainer;

    @FXML
    private VBox zutatenList;
    
    @FXML
    private TextField personenField;

    
    private int zutatCounter = 3; 
    
    
    @FXML
    private ChoiceBox<String> personenChoiceBox;

    @FXML
    public void initialize() {
        for (int i = 1; i <= 10; i++) {
            personenChoiceBox.getItems().add(String.valueOf(i));
        }
        personenChoiceBox.setValue("1"); // Optional: Standardwert
    }

    @FXML
    private void close() {
        PageSwitcher.switchTo(Page.FIRST);
    }
    
    @FXML
    private void next() {
    	PageSwitcher.switchTo(Page.PREPARE);
    }
    
    
    @FXML
    private void deleteZutatRow() {
        int count = zutatenList.getChildren().size();
        
        if (count > 0) {
            zutatenList.getChildren().remove(count - 1);
            zutatCounter -= 2;
            if (zutatCounter < 1) zutatCounter = 1;
        }
    }
    
    @FXML private VBox hauptzutatenList;
    

    @FXML
    private void addHauptzutatRow() {
        hauptzutatenList.getChildren().add(createZutatRow());
    }

    @FXML
    private void deleteHauptzutatRow() {
        int count = hauptzutatenList.getChildren().size();
        if (count > 0) hauptzutatenList.getChildren().remove(count - 1);
    }


    private HBox createZutatRow() {
        HBox row = new HBox(50);
        TextField zutat = new TextField();
        zutat.setPromptText("Zutat");
        zutat.setPrefWidth(300);
        TextField einheit = new TextField();
        einheit.setPromptText("Einheit");
        einheit.setPrefWidth(200);
        row.getChildren().addAll(zutat, einheit);
        return row;
    }
    
    
    
}