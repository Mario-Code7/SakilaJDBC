package com.pluralsight;

import java.sql.*;

public class Program {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sakila";
        String username = args[0];
        String password = args[1];


        Connection connection;
        connection = DriverManager.getConnection(url, username, password);

        String query = """
                
                SELECT title, description, release_year, length
                FROM film
                WHERE title LIKE ?
                """;
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, "%AIR%");

        ResultSet results = statement.executeQuery();

        while (results.next()) {
            String title = results.getString(1);
            String description = results.getString(2);
            int releaseYear = results.getInt(3);
            int length = results.getInt(4);
            System.out.println(title);
            System.out.println(description);
            System.out.println(releaseYear);
            System.out.println(length);
            System.out.println("---------------");
        }
        results.close();
        statement.close();
        connection.close();
    }
}
