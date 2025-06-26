package Enums;

import javafx.scene.control.Alert;

public enum Alert_Type {
    None(Alert.AlertType.NONE),
    INFO(Alert.AlertType.INFORMATION),
    WARN(Alert.AlertType.WARNING),
    ERROR(Alert.AlertType.ERROR),
    CONFIRM(Alert.AlertType.CONFIRMATION);

    private final Alert.AlertType type;

    // Constructor to associate Alert.AlertType with the enum
    Alert_Type(Alert.AlertType type) {
        this.type = type;
    }

    // Getter for Alert.AlertType
    public Alert.AlertType getType() {
        return type;
    }
}
