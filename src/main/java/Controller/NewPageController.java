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
        
        if(zutatCounter < 11) {
        
        for (int i = 0; i < 1; i++) {
            TextField tf = new TextField();
            TextField tf2 = new TextField();
            tf.setPromptText("Zutat " + zutatCounter++);
            tf2.setPromptText("Einheit");
            tf.setPrefWidth(150);
            row.getChildren().add(tf);
            row.getChildren().add(tf2);
        }
        zutatenList.getChildren().add(row);
    }
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
            zutatCounter -= 2; // Da jede Reihe 2 Zutaten enthält
            if (zutatCounter < 1) zutatCounter = 1;
        }
    }
    
    @FXML private VBox hauptzutatenList;
    @FXML private VBox zusatzzutatenList;

    @FXML
    private void addHauptzutatRow() {
        hauptzutatenList.getChildren().add(createZutatRow());
    }

    @FXML
    private void deleteHauptzutatRow() {
        int count = hauptzutatenList.getChildren().size();
        if (count > 0) hauptzutatenList.getChildren().remove(count - 1);
    }

    @FXML
    private void addZusatzzutatRow() {
        zusatzzutatenList.getChildren().add(createZutatRow());
    }

    @FXML
    private void deleteZusatzzutatRow() {
        int count = zusatzzutatenList.getChildren().size();
        if (count > 0) zusatzzutatenList.getChildren().remove(count - 1);
    }

    private HBox createZutatRow() {
        HBox row = new HBox(5);
        TextField zutat = new TextField();
        zutat.setPromptText("Zutat");
        zutat.setPrefWidth(150);
        TextField einheit = new TextField();
        einheit.setPromptText("Einheit");
        einheit.setPrefWidth(150);
        row.getChildren().addAll(zutat, einheit);
        return row;
    }
    
    
    
}