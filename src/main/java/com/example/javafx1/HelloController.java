package com.example.javafx1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.security.auth.callback.Callback;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

//    @FXML
//    private TextField txtNumberOne;
//
//    @FXML
//    private TextField txtNumberTwo;
//
//    @FXML
//    private Label labelResult;
//
//    @FXML
//    private Button btSum;
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//        AlertsUtil.showAlert("AlertT title", null, "Hello", Alert.AlertType.WARNING);
//    @FXML
//    public void onBtSumAction(){
//        try {
//            Locale.setDefault(Locale.US);
//            double numberOne = Double.parseDouble(txtNumberOne.getText());
//            double numberTwo = Double.parseDouble(txtNumberTwo.getText());
//            double sum = numberOne + numberTwo;
//            labelResult.setText(String.format("%.2f", sum));
//        }catch (NumberFormatException e){
//            AlertsUtil.showAlert("Error", "Parse error", e.getMessage(), Alert.AlertType.ERROR);
//        }
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Constrains.setTextFieldDouble(txtNumberOne);
//        Constrains.setTextFieldDouble(txtNumberTwo);
//        Constrains.setTextFieldMaxLength(txtNumberOne,12);
//        Constrains.setTextFieldMaxLength(txtNumberTwo, 12);
//    }
    @FXML
    private ComboBox<Person> personComboBox;

    private ObservableList<Person> obsList;

    @FXML
    private Button btAll;

    @FXML
    public void onBtAllAction(){
        for (Person person : personComboBox.getItems()){
            System.out.println(person);
        }
    }


    @FXML
    public void onPersonComboBoxAction() {
        Person person = personComboBox.getSelectionModel().getSelectedItem();
        System.out.println(person);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Maria", "maria@gmail.com"));
        list.add(new Person(2, "Alex", "alex@gmail.com"));
        list.add(new Person(3, "João", "joao@gmail.com"));
        obsList = FXCollections.observableArrayList(list);
        personComboBox.setItems(obsList);

        javafx.util.Callback<ListView<Person>, ListCell<Person>>factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person person, boolean b) {
                super.updateItem(person, b);
                setText(b ? "" : person.getName());
            }
        };

        personComboBox.setCellFactory(factory);
        personComboBox.setButtonCell(factory.call(null));
    }



}