package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;

public class ViewPageController {

    @FXML
    private FlowPane dishContainer; // aus FXML referenziert

    @FXML
    public void initialize() {
        // Beispielkarte erzeugen
        VBox card = new VBox();
        card.getStyleClass().add("dish-card");

        Label title = new Label("Pizza Margherita");
        title.getStyleClass().add("dish-title");

        Label info = new Label("Dauer: 20 Min\nZutaten: Teig, Tomaten, Mozzarella");
        info.getStyleClass().add("dish-info");

        card.getChildren().addAll(title, info);

        dishContainer.getChildren().add(card);
    }
}