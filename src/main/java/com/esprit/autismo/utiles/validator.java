package com.esprit.autismo.utiles;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class validator {
    public static boolean isNonEmpty(TextField textField) {
        return !textField.getText().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        String valideEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(valideEmail);
    }

    public static boolean isNumeric(String input) {
        return input.matches("\\d+");
    }

    public static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
