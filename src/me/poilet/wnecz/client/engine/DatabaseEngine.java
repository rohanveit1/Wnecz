package me.poilet.wnecz.client.engine;

import java.sql.*;

public class DatabaseEngine {

    private Connection con;

    private final String conString = "jdbc:mysql://167.99.196.133/wnecz";
    private final String user = "rohan";
    private final String pass = "testp@ss123";

    public DatabaseEngine() {
        try {
            this.con = DriverManager.getConnection(conString, user, pass);
            System.out.printf("Connected to database.\n");
        } catch(SQLException e) {
            System.out.printf("Error connecting to database.\n");
            e.printStackTrace();
        }
    }

    public void createUser(String email, String pass) {
        String query = "INSERT INTO users(email, password) VALUES (?, ?);";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, pass);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean doesUserExist(String email) {
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                return (result.getInt(1) > 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean doesUserExist(String email, String pass) {
        String query = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, pass);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                return (result.getInt(1) > 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet getUser(String email) {
        String query = "SELECT userId, email, wins, losses FROM users WHERE email = ?";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
