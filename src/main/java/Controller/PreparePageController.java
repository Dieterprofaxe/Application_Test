package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Enums.Page;
import PageSwitching.PageSwitcher;

public class PreparePageController {
	
	private int zutatCounter = 3;
	
	@FXML
	private Button add, delete, btn_last, btn_save, btn_delete;
	
	@FXML
	private TextField PrepareField;
	
	
	
	@FXML
	private void close() {
		PageSwitcher.switchTo(Page.NEW);
	}
	
	
	
	@FXML
    private VBox stepsContainer;

    @FXML
    public void addRow() {
        TextField newField = new TextField();
        newField.setPromptText("Zubereitungsschritt");
        newField.getStyleClass().add("text-field");
        stepsContainer.getChildren().add(newField);
    }

    @FXML
    public void removeRow() {
        int count = stepsContainer.getChildren().size();
        if (count > 0) {
            stepsContainer.getChildren().remove(count - 1);
        }
    }
}