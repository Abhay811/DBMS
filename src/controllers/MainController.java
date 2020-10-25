package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

    private void loadStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    @FXML
    private void handleButtonClicks(ActionEvent event) {
        if (event.getSource() == customerButton) {
            loadStage("/fxml/Customer.fxml");
        }

        else if (event.getSource() == dealerButton) {
            loadStage("/fxml/Dealer.fxml");
        }
        else if (event.getSource() == purchaseButton) {
            loadStage("/fxml/Purchase.fxml");
        }
        else if (event.getSource() == saleCounterButton) {
            loadStage("/fxml/SaleCounter.fxml");
        }
        else if (event.getSource() == inventoryButton) {
            loadStage("/fxml/Inventory.fxml");
        }
    }
}
