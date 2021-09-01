package edu.strathmore.dsassignment;

import edu.strathmore.dsassignment.SocketClient;

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
import java.util.HashMap;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    private Label errorText, successText;
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
            successText.setText("Sending...");

            HashMap<String,String> map=new HashMap<String,String>();//Creating HashMap
            map.put("studentNumber", studentNumberField.getText());  //Put elements in Map
            map.put("studentName", studentNameField.getText());
            map.put("Faculty", facultyField.getText());
            map.put("Message", messageField.getText());


            SocketClient.socketClient(map);
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