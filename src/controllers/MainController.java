package controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TextField txt_dealerName;
    @FXML
    private TextField txt_dealerContact;
    @FXML
    private TextArea txt_dealerAddress;
    @FXML
    private TableView<Dealers> table_dealers;
    @FXML
    private TableColumn<Dealers, String> col_dealerName;
    @FXML
    private TableColumn<Dealers, String> col_dealerContact;
    @FXML
    private TableColumn<Dealers, String> col_dealerAddress;

    @FXML
    private GridPane purchaseGridPane;
    @FXML
    private DatePicker txt_purchaseDate;
    @FXML
    private TextField txt_medicineName;
    @FXML
    private TextField txt_batchNumber;
    @FXML
    private TextField txt_purchaseRate;
    @FXML
    private DatePicker txt_expiryDate;
    @FXML
    private TextField txt_sellingRate;
    @FXML
    private TextField txt_quantity;
    @FXML
    private TableView<Purchases> table_purchases;
    @FXML
    private TableColumn<Purchases, String> col_medicineName;
    @FXML
    private TableColumn<Purchases, String> col_batchNumber;
    @FXML
    private TableColumn<Purchases, String> col_quantity;
    @FXML
    private TableColumn<Purchases, String> col_purchaseDate;
    @FXML
    private TableColumn<Purchases, String> col_purchaseRate;
    @FXML
    private TableColumn<Purchases, String> col_sellingRate;
    @FXML
    private TableColumn<Purchases, String> col_expiryDate;

    @FXML
    private GridPane saleCounterGridPane;

    @FXML
    private GridPane inventoryGridPane;

    @FXML
    private ImageView pharmacy_logo;

    ObservableList<Customers> listCustomer;
    ObservableList<Dealers> listDealers;
    ObservableList<Purchases> listPurchases;
    int ind = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public void addCustomers () {
        conn = DatabaseConnection.getConnection();
        String sql = "insert into customer_table (CustomerName, CustomerContact," +
                     " CustomerAddress) values (?, ?, ?)";
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

    public void addDealer() {
        conn = DatabaseConnection.getConnection();
        String sql = "insert into dealer_table (DealerName, DealerContact, " +
                     "DealerAddress) values (?, ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_dealerName.getText());
            pst.setString(2, txt_dealerContact.getText());
            pst.setString(3, txt_dealerAddress.getText());
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPurchase() {
        conn = DatabaseConnection.getConnection();
        String sql = "insert into purchasetable (MedicineName, DealerName, " +
                     "BatchNumber, Quantity, PurchaseDate, PurchaseRate, " +
                     "SellingRate, ExpiryDate) values (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_medicineName.getText());
            pst.setString(2, txt_dealerName.getText());
            pst.setString(3, txt_batchNumber.getText());
            pst.setString(4, txt_quantity.getText());
//            pst.setString(5, txt_purchaseDate.getText());
            pst.setString(6, txt_purchaseRate.getText());
            pst.setString(7, txt_sellingRate.getText());
//            pst.setString(8, txt_expiryDate.getText());
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        File logoFile = new File("Img/logo_pharmacy.jpg");
        Image logoImage = new Image(logoFile.toURI().toString());
        pharmacy_logo.setImage(logoImage);

        col_customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        col_customerContact.setCellValueFactory(new PropertyValueFactory<>("customerContact"));
        col_customerAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        listCustomer = DatabaseConnection.getDataCustomers();
        table_customers.setItems(listCustomer);

        col_dealerName.setCellValueFactory(new PropertyValueFactory<>("DealerName"));
        col_dealerContact.setCellValueFactory(new PropertyValueFactory<>("DealerContact"));
        col_dealerAddress.setCellValueFactory(new PropertyValueFactory<>("DealerAddress"));
        listDealers = DatabaseConnection.getDataDealers();
        table_dealers.setItems(listDealers);

        col_medicineName.setCellValueFactory(new PropertyValueFactory<>("MedicineName"));
        col_dealerName.setCellValueFactory(new PropertyValueFactory<>("DealerName"));
        col_batchNumber.setCellValueFactory(new PropertyValueFactory<>("BatchNumber"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        col_purchaseDate.setCellValueFactory(new PropertyValueFactory<>("PurchaseDate"));
        col_purchaseRate.setCellValueFactory(new PropertyValueFactory<>("PurchaseRate"));
        col_sellingRate.setCellValueFactory(new PropertyValueFactory<>("SellingRate"));
        col_expiryDate.setCellValueFactory(new PropertyValueFactory<>("ExpiryDate"));
        listPurchases = DatabaseConnection.getDataPurchases();
        table_purchases.setItems(listPurchases);

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
