package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnection {
    private static Connection databaseLink;


    public static Connection getConnection() {
        String databaseName = "pharmacy";
        String databaseUser = "root";
        String databasePassword = "HSbF6#";
        String url = "jdbc:mysql://localhost:3306/"+ databaseName + "?autoReconnect=true&useSSL=false";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }

    public static ObservableList<Customers> getDataCustomers() {
        Connection conn = getConnection();
        ObservableList<Customers> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("Select * from customer_table");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Customers(Integer.parseInt(rs.getString("id")),
                        rs.getString("customerName"), rs.getString("customerContact"),
                        rs.getString("customerAddress")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<Dealers> getDataDealers() {
        Connection conn = getConnection();
        ObservableList<Dealers> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("Select * from dealer_table");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Dealers(Integer.parseInt(rs.getString("id")),
                        rs.getString("dealerName"), rs.getString("dealerContact"),
                        rs.getString("dealerAddress")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<Purchases> getDataPurchases() {
        Connection conn = getConnection();
        ObservableList<Purchases> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("Select * from purchasetable");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Purchases(Integer.parseInt(rs.getString("id")),
                        rs.getString("medicineName"), rs.getString("dealerName"),
                        rs.getString("batchNumber"), rs.getString("quantity"),
                        rs.getString("purchaseDate"), rs.getString("purchaseRate"),
                        rs.getString("sellingRate"), rs.getString("expiryDate")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
