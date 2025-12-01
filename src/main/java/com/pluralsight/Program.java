package com.pluralsight;

import java.sql.*;

public class Program {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sakila";
        String username = "root";
        String password = "yearup";


        Connection connection;
        connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        String query = " SELECT title FROM film";

        ResultSet results = statement.executeQuery(query);

        while (results.next()) {
            String film = results.getString("title");
            System.out.println(film);
        }
        connection.close();
    }
}
