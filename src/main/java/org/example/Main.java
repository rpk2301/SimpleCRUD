package org.example;

import java.io.Console;
import java.sql.*;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args)  {

    String jdbcURL = "jdbc:postgresql://localhost:5432/simplecrud";
    String username = "postgres";
    System.out.println("Please enter database password");
    String password = scan.nextLine();
    try {
        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
        System.out.println("Got the connection!");
        String sql = "INSERT INTO person(firstname,gender,country,username,password,lastname)"
                + " VALUES (?,?,?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        System.out.println("Please enter the first name of the contact you wish to put in the database");
        statement.setString(1,scan.nextLine());
        System.out.println("Please enter the gender of the contact you wish to put in the database");
        statement.setString(2,scan.nextLine());
        System.out.println("Please enter the country of the contact you wish to put in the database");
        statement.setString(3,scan.nextLine());
        System.out.println("Please enter the user name of the contact you wish to put in the database");
        statement.setString(4,scan.nextLine());
        System.out.println("Please enter the password of the contact you wish to put in the database");
        statement.setString(5,scan.nextLine());
        System.out.println("Please enter the last name of the contact you wish to put in the database");
        statement.setString(6,scan.nextLine());
        int rows = statement.executeUpdate();
        if (rows > 0)
        {
            System.out.println("A new contact has been inserted into the database.");
        }
    } catch (SQLException e) {
        System.out.println("Error in connecting to PostGres.");
        System.out.println("Stack trace found at:");
        e.printStackTrace();
        System.out.println("With error code:");
        e.getErrorCode();

    }

    }
}