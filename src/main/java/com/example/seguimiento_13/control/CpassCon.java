package com.example.seguimiento_13.control;

import com.example.seguimiento_13.HelloApplication;
import com.example.seguimiento_13.model.FIleOpenerData;
import com.example.seguimiento_13.model.FileUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CpassCon {
    @FXML
    private HBox boxes;

    @FXML
    private HBox boxes1;

    @FXML
    private Button closeBT;

    @FXML
    private Button openbt;

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf12;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf22;

    @FXML
    private TextField tf3;

    @FXML
    private TextField tf32;

    @FXML
    private TextField tf4;

    @FXML
    private TextField tf42;

    @FXML
    private TextField tf5;

    @FXML
    private TextField tf52;

    @FXML
    private TextField tf6;

    @FXML
    private TextField tf62;

    @FXML
    private Button button3;

    @FXML
    void goBack(ActionEvent event) {
        HelloApplication.showWindow("home.fxml");
        Stage currentStage = (Stage) boxes.getScene().getWindow();
        currentStage.hide();
    }

    @FXML
    void changePass(ActionEvent event) {
        StringBuilder pass = new StringBuilder();
        for(Node node : boxes.getChildren()){
            TextField tf = (TextField) node;
            pass.append(tf.getText());
        }
        pass.append("\n");
        StringBuilder toChange = new StringBuilder();
        for(Node node : boxes1.getChildren()){
            TextField tf = (TextField) node;
            toChange.append(tf.getText());
        }
        if(FIleOpenerData.getInstance().getUser().getPassword().equals(pass.toString())){
            FIleOpenerData.getInstance().getUser().setPassword(toChange.toString());
            FileUtils.saveData("RicardosKey",FIleOpenerData.getInstance().getUser().getPassword());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Actualizacion");
            alert.setHeaderText("La contraseña ha sido actualizada");
            alert.showAndWait();
            HelloApplication.showWindow("home.fxml");
            Stage currentStage = (Stage) boxes.getScene().getWindow();
            currentStage.hide();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Pilas");
            alert.setContentText("Escribiste mal la contraseña");
            alert.showAndWait();
        }
    }

    @FXML
    void close(ActionEvent event) {
        HelloApplication.showWindow("log.fxml");
        Stage currentStage = (Stage) tf62.getScene().getWindow();
        currentStage.hide();
    }

    @FXML
    void onKey(KeyEvent event) {
        if(event.getSource().equals(tf1)){
            tf2.requestFocus();
        }
        if(event.getSource().equals(tf2)){
            tf3.requestFocus();
        }
        if(event.getSource().equals(tf3)){
            tf4.requestFocus();
        }
        if(event.getSource().equals(tf4)){
            tf5.requestFocus();
        }
        if(event.getSource().equals(tf5)){
            tf6.requestFocus();
        }

        if(event.getSource().equals(tf12)){
            tf22.requestFocus();
        }
        if(event.getSource().equals(tf22)){
            tf32.requestFocus();
        }
        if(event.getSource().equals(tf32)){
            tf42.requestFocus();
        }
        if(event.getSource().equals(tf42)){
            tf52.requestFocus();
        }
        if(event.getSource().equals(tf52)){
            tf62.requestFocus();
        }
    }
}
