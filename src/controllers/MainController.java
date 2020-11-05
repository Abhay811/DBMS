package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private TextField txt_customerName;

    @FXML
    private TextField txt_customerContact;

    @FXML
    private TextArea txt_customerAddress;

    @FXML
    private TableView<Customers> table_customers;

    @FXML
    private TableColumn<Customers, String> col_customerName;

    @FXML
    private TableColumn<Customers, String> col_customerContact;

    @FXML
    private TableColumn<Customers, String> col_customerAddress;

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

    @FXML
    private Button addCustomersButton;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public void addCustomers (ActionEvent event) {
        DatabaseConnection connection = new DatabaseConnection();
        conn = connection.getConnection();
        String sql = "insert into customer_table (CustomerName, CustomerContact, CustomerAddress) values (?, ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_customerName.getText());
            pst.setString(2, txt_customerContact.getText());
            pst.setString(3, txt_customerAddress.getText());
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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

            customerButton.setStyle("-fx-background-color: #3083b3;");
            dealerButton.setStyle("-fx-background-color: #96d8e9;");
            purchaseButton.setStyle("-fx-background-color: #96d8e9;");
            saleCounterButton.setStyle("-fx-background-color: #96d8e9;");
            inventoryButton.setStyle("-fx-background-color: #96d8e9;");
        }

        else if (event.getSource() == dealerButton) {
            dealerGridPane.toFront();
            dealerGridPane.setVisible(true);
            customerGridPane.setVisible(false);
            purchaseGridPane.setVisible(false);
            saleCounterGridPane.setVisible(false);
            inventoryGridPane.setVisible(false);

            customerButton.setStyle("-fx-background-color: #96d8e9;");
            dealerButton.setStyle("-fx-background-color: #3083b3;");
            purchaseButton.setStyle("-fx-background-color: #96d8e9;");
            saleCounterButton.setStyle("-fx-background-color: #96d8e9;");
            inventoryButton.setStyle("-fx-background-color: #96d8e9;");
        }
        else if (event.getSource() == purchaseButton) {
            purchaseGridPane.toFront();
            purchaseGridPane.setVisible(true);
            customerGridPane.setVisible(false);
            dealerGridPane.setVisible(false);
            saleCounterGridPane.setVisible(false);
            inventoryGridPane.setVisible(false);

            customerButton.setStyle("-fx-background-color: #96d8e9;");
            dealerButton.setStyle("-fx-background-color: #96d8e9;");
            purchaseButton.setStyle("-fx-background-color: #3083b3;");
            saleCounterButton.setStyle("-fx-background-color: #96d8e9;");
            inventoryButton.setStyle("-fx-background-color: #96d8e9;");
        }
        else if (event.getSource() == saleCounterButton) {
            saleCounterGridPane.toFront();
            saleCounterGridPane.setVisible(true);
            customerGridPane.setVisible(false);
            dealerGridPane.setVisible(false);
            purchaseGridPane.setVisible(false);
            inventoryGridPane.setVisible(false);

            customerButton.setStyle("-fx-background-color: #96d8e9;");
            dealerButton.setStyle("-fx-background-color: #96d8e9;");
            purchaseButton.setStyle("-fx-background-color: #96d8e9;");
            saleCounterButton.setStyle("-fx-background-color: #3083b3;");
            inventoryButton.setStyle("-fx-background-color: #96d8e9;");

        }
        else if (event.getSource() == inventoryButton) {
            inventoryGridPane.toFront();
            inventoryGridPane.setVisible(true);
            customerGridPane.setVisible(false);
            dealerGridPane.setVisible(false);
            purchaseGridPane.setVisible(false);
            saleCounterGridPane.setVisible(false);

            customerButton.setStyle("-fx-background-color: #96d8e9;");
            dealerButton.setStyle("-fx-background-color: #96d8e9;");
            purchaseButton.setStyle("-fx-background-color: #96d8e9;");
            saleCounterButton.setStyle("-fx-background-color: #96d8e9;");
            inventoryButton.setStyle("-fx-background-color: #3083b3;");
        }
    }


}
