package controllers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
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
}
