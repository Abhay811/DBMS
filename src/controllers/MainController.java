package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @FXML
    private Button customerButton;
    @FXML
    private Button dealerButton;
    @FXML
    private Button purchaseButton;
    @FXML
    private Button saleCounterButton;
    @FXML
    private Button inventoryButton;

    @FXML
    private GridPane customerGridPane;
    @FXML
    private GridPane dealerGridPane;
    @FXML
    private GridPane purchaseGridPane;
    @FXML
    private GridPane saleCounterGridPane;
    @FXML
    private GridPane inventoryGridPane;

    @FXML
    private ImageView pharmacy_logo;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

        File logoFile = new File("Img/logo_pharmacy.jpg");
        Image logoImage = new Image(logoFile.toURI().toString());
        pharmacy_logo.setImage(logoImage);
    }

    @FXML
    private void handleButtonClicks(ActionEvent event) {

        if (event.getSource() == customerButton) {
            customerGridPane.toFront();
            customerGridPane.setVisible(true);
            dealerGridPane.setVisible(false);
            purchaseGridPane.setVisible(false);
            saleCounterGridPane.setVisible(false);
            inventoryGridPane.setVisible(false);
        }

        else if (event.getSource() == dealerButton) {
            dealerGridPane.toFront();
            dealerGridPane.setVisible(true);
            customerGridPane.setVisible(false);
            purchaseGridPane.setVisible(false);
            saleCounterGridPane.setVisible(false);
            inventoryGridPane.setVisible(false);
        }
        else if (event.getSource() == purchaseButton) {
            purchaseGridPane.toFront();
            purchaseGridPane.setVisible(true);
            customerGridPane.setVisible(false);
            dealerGridPane.setVisible(false);
            saleCounterGridPane.setVisible(false);
            inventoryGridPane.setVisible(false);
        }
        else if (event.getSource() == saleCounterButton) {
            saleCounterGridPane.toFront();
            saleCounterGridPane.setVisible(true);
            customerGridPane.setVisible(false);
            dealerGridPane.setVisible(false);
            purchaseGridPane.setVisible(false);
            inventoryGridPane.setVisible(false);
        }
        else if (event.getSource() == inventoryButton) {
            inventoryGridPane.toFront();
            inventoryGridPane.setVisible(true);
            customerGridPane.setVisible(false);
            dealerGridPane.setVisible(false);
            purchaseGridPane.setVisible(false);
            saleCounterGridPane.setVisible(false);
        }
    }
}
