package me.poilet.wnecz.client.objects;

import me.poilet.wnecz.client.WneczClient;

import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticatedUser {

    private Socket socket;
    private String user;
    private int id;
    private int wins, losses;

    public AuthenticatedUser(String email) {
        ResultSet userStats = WneczClient.INSTANCE.getDbEngine().getUser(email);
        try {
            if(userStats.next()) {
                this.id = userStats.getInt(1);
                this.user = userStats.getString(2);
                this.wins = userStats.getInt(3);
                this.losses = userStats.getInt(4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
