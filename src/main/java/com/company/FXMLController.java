package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController {
    private ObservableList<String> firstListView = FXCollections.observableArrayList();
    private ObservableList<String> secondListView = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button executeBtn;

    @FXML
    private ListView<String> firstList;

    @FXML
    private ListView<String> secondList;

    @FXML
    private Button clearBtn;

    @FXML
    private TextField inputElementField;

    @FXML
    private Button addBtn;

    @FXML
    private CheckBox deleteCheckBox;

    @FXML
    private CheckBox transferCheckBox;

    @FXML
    void addBtnAction(ActionEvent event) {
        firstListView.add(inputElementField.getText().trim());
        firstList.setItems(firstListView);
        inputElementField.setText("");
    }

    @FXML
    void clearBtnAction(ActionEvent event) {
        secondList.setItems(FXCollections.observableArrayList());
    }

    @FXML
    void executeBtnAction(ActionEvent event) {
        if (transferCheckBox.isSelected()) transferElements();
        if (deleteCheckBox.isSelected()) deleteElements();
    }

    @FXML
    void initialize() {

    }

    private void deleteElements() {
        ObservableList<String> tempList = FXCollections.observableArrayList();
        for (int i = 1; i <= firstListView.size(); i++) {
            if (i % 2 == 0)
                tempList.add(firstListView.get(i - 1));
        }
        firstListView.clear();
        firstListView.setAll(tempList);
        firstList.setItems(tempList);
    }

    private void transferElements() {
        secondListView.clear();
        for (int i = 1; i <= firstListView.size(); i++) {
            if (i % 2 == 0)
                secondListView.add(firstListView.get(i - 1));
        }
        secondList.setItems(secondListView);
    }
}
