package kz.mygame.tictac.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Data {
    public static final String NAME_USER = "bestuser";
    public static final String PASSWORD = "bestuser";
    public static final String URL = "jdbc:mysql://localhost:3306/my_db";
    public static Statement statement;
    public static Connection connection;


    static {
        try {
            connection = DriverManager.getConnection(URL, NAME_USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }

    }
}
