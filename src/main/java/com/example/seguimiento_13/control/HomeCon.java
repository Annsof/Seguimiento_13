package com.example.seguimiento_13.control;

import com.example.seguimiento_13.HelloApplication;
import com.example.seguimiento_13.model.FIleOpenerData;
import com.example.seguimiento_13.model.FileUtils;
import com.example.seguimiento_13.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeCon implements Initializable {@FXML
private TextArea textAreaContent;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    void change(ActionEvent event) {
        HelloApplication.showWindow("cPass.fxml");
        FIleOpenerData.getInstance().getUser().setContent(textAreaContent.getText());
        FileUtils.saveData("RicardosSecrets",FIleOpenerData.getInstance().getUser().getContent());
        Stage currentStage = (Stage) button1.getScene().getWindow();
        currentStage.hide();
    }

    @FXML
    void close(ActionEvent event) {
        HelloApplication.showWindow("log.fxml");
        FIleOpenerData.getInstance().getUser().setContent(textAreaContent.getText());
        FileUtils.saveData("RicardosSecrets",FIleOpenerData.getInstance().getUser().getContent());
        Stage currentStage = (Stage) button1.getScene().getWindow();
        currentStage.hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textAreaContent.setText(FIleOpenerData.getInstance().getUser().getContent());
    }
}
