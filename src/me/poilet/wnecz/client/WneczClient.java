package me.poilet.wnecz.client;

import me.poilet.wnecz.client.engine.DatabaseEngine;
import me.poilet.wnecz.client.engine.MenuEngine;
import me.poilet.wnecz.client.objects.AuthenticatedUser;

import java.io.IOException;
import java.net.Socket;

public class WneczClient {

    public static WneczClient INSTANCE;

    private DatabaseEngine dbEngine;
    private AuthenticatedUser authUser;
    private Socket socket;

    public WneczClient() {
        INSTANCE = this;
        this.dbEngine = new DatabaseEngine();
    }

    public static void main(String[] args) {
        /**WneczClient client = new WneczClient();
        MenuEngine.menu();
        String[] connectionDetails = MenuEngine.getServerCreds();
        client.connect(connectionDetails[0], Integer.valueOf(connectionDetails[1]));**/
        WneczGUI gui = new WneczGUI(INSTANCE);
    }

    public DatabaseEngine getDbEngine() {
        return this.dbEngine;
    }

    public void setAuthUser(AuthenticatedUser user) {
        this.authUser = user;
    }

    public void connect(String ip, int port) {
        try {
            this.socket = new Socket(ip, port);
        } catch (IOException e) {
            System.out.printf("Error connecting to server\n");
            e.printStackTrace();
        }
        System.out.printf("Connected to server!\n");
    }

    public void startListeningThread() {

    }

}
