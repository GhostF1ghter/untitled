package kz.mygame.tictac.database;

import kz.mygame.tictac.saves.Step;

import java.sql.*;
import java.util.ArrayList;

public class SaveService {

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

    public void saveGame(Step step) {

        String query = "INSERT INTO steps (player, inrow, incolumn) VALUES (?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, step.getPlayer());
            preparedStatement.setString(2, step.getRow());
            preparedStatement.setString(3, step.getColumn()); //322 228 667 '1000-7'

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}