package edu.strathmore.dsassignment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
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
    protected void onSendButtonClick() {
        errorText.setText("");
        if(basicInputValidation()) {
            sendingProgress.setVisible(true);
            successText.setText("Sending...");
        }
    }


    //checks for blank input fields
    private boolean basicInputValidation() {
        String errors = "Error: ";
        Boolean validation = true;
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


        if(validation == false){
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