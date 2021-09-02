package edu.strathmore.dsassignment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class ClientProtocol implements Initializable {
    @FXML
    private Label errorText;
    @FXML
    private Label successText;
    @FXML
    private ImageView logoView;
    @FXML
    private TextField studentNumberField, studentNameField, facultyField, messageField;
    @FXML
    private ProgressIndicator sendingProgress;


    @FXML
    protected void onSendButtonClick() throws IOException, ClassNotFoundException, InterruptedException {
        errorText.setText("");
        if(basicInputValidation()) {
            sendingProgress.setVisible(true);
            successText.setText(SocketClient.feedback);

            LinkedHashMap<String,String> map= new LinkedHashMap<>();//Creating HashMap
            map.put("studentNumber", studentNumberField.getText());  //Put elements in Map
            map.put("studentName", studentNameField.getText());
            map.put("Faculty", facultyField.getText());
            map.put("Message", messageField.getText());

            /* Creates a new instance of socket client and runs the socketClient method*/
            SocketClient socketClient = new SocketClient();
            if(socketClient.socketClient(map)){
                successText.setText(SocketClient.feedback);
            }
        }
    }



    //checks for blank input fields
    private boolean basicInputValidation() {
        String errors = "Error: ";
        boolean validation = true;
        if(studentNumberField.getText().isBlank()){
            errors = errors + " Student Number";
            validation = false;
        }
        else if(studentNameField.getText().isBlank()){
            errors = errors + " Student Name";
            validation = false;
        }
        else if(facultyField.getText().isBlank()){
            errors = errors + " Faculty/School";
            validation = false;
        }
        else if(messageField.getText().isBlank()){
            errors = errors + " Message";
            validation = false;
        }

        if(!validation){
            errorText.setText(errors + " cannot be empty!");
        }

        return validation;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File logoFile = new File("images/strathLogo.png");
        Image logo = new Image(logoFile.toURI().toString());
        logoView.setImage(logo);
    }
}