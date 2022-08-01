package com.example.javafx1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField txtNumberOne;

    @FXML
    private TextField txtNumberTwo;

    @FXML
    private Label labelResult;

    @FXML
    private Button btSum;
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//        AlertsUtil.showAlert("AlertT title", null, "Hello", Alert.AlertType.WARNING);
    @FXML
    public void onBtSumAction(){
        try {
            Locale.setDefault(Locale.US);
            double numberOne = Double.parseDouble(txtNumberOne.getText());
            double numberTwo = Double.parseDouble(txtNumberTwo.getText());
            double sum = numberOne + numberTwo;
            labelResult.setText(String.format("%.2f", sum));
        }catch (NumberFormatException e){
            AlertsUtil.showAlert("Error", "Parse error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constrains.setTextFieldDouble(txtNumberOne);
        Constrains.setTextFieldDouble(txtNumberTwo);
        Constrains.setTextFieldMaxLength(txtNumberOne,12);
        Constrains.setTextFieldMaxLength(txtNumberTwo, 12);
    }
}