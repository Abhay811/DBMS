package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView, lockImageView;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;
    public void loginButtonOnAction(ActionEvent event) {

        if (usernameTextField.getText().isBlank() == false &&
                passwordField.getText().isBlank() == false) {
            validateLogin();
        }
        else {
            loginMessageLabel.setText("please enter username and password");
        }
    }
    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Img/pharmacy-management.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile = new File("Img/lockimage.jpg");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);

    }

    public void validateLogin() {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();

        String verifyLogin = "Select count(1) from user_account where username = '"
                + usernameTextField.getText() + "'and password='"
                + passwordField.getText() + "'";

        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    loginMessageLabel.setText("Congratulations!");
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.close();
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
                    //primaryStage.setTitle("Abhay");
                    stage.setScene(new Scene(root));
                    stage.show();

                } else {
                    loginMessageLabel.setText("Invalid Login, Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
