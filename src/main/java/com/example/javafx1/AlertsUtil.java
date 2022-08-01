package com.example.javafx1;

import javafx.scene.control.Alert;

public class AlertsUtil {
    public static void showAlert(String title, String header, String content, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }
}
