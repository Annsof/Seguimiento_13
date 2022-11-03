package com.example.seguimiento_13.control;

import com.example.seguimiento_13.HelloApplication;
import com.example.seguimiento_13.model.FileUtils;
import com.example.seguimiento_13.model.User;
import com.example.seguimiento_13.model.FIleOpenerData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LogCon implements Initializable {
    @FXML
    private HBox boxes;

    @FXML
    private Button openbt;

    @FXML
    void login(ActionEvent event) {
        StringBuilder pass = new StringBuilder();
        for(Node node : boxes.getChildren()){
            TextField tf = (TextField) node;
            pass.append(tf.getText());
        }
        pass.append("\n");
        if (FIleOpenerData.getInstance().getUser().getPassword().equals("")) {
            FIleOpenerData.getInstance().setUser(new User(pass.toString()));
            FileUtils.saveData("RicardosKey",FIleOpenerData.getInstance().getUser().getPassword());
        }
        if(pass.toString().equals(FIleOpenerData.getInstance().getUser().getPassword())){
            HelloApplication.showWindow("home.fxml");
            Stage currentStage = (Stage) boxes.getScene().getWindow();
            currentStage.hide();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Pilas");
            alert.setContentText("Escribiste mal la contraseña");
            alert.showAndWait();
        }

    }

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;

    @FXML
    private TextField tf4;

    @FXML
    private TextField tf5;

    @FXML
    private TextField tf6;

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
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FIleOpenerData.getInstance().getUser().setContent(FileUtils.readFile("RicardosSecrets"));
        FIleOpenerData.getInstance().getUser().setPassword(FileUtils.readFile("RicardosKey"));
    }
}
