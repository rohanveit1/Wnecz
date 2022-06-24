package me.poilet.wnecz.server;

import me.poilet.wnecz.client.objects.AuthenticatedUser;
import me.poilet.wnecz.server.objects.Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WneczServer {

    private HashMap<Socket, AuthenticatedUser> connectedClients;
    private ServerSocket serverSocket;

    public WneczServer() {
        this.connectedClients = new HashMap<>();
        try {
            this.serverSocket = new ServerSocket(4999);
        } catch (IOException e) {
            System.err.printf("Error starting server\n");
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.printf("Server started!\n");
        waitForConnections();
    }

    public static void main(String[] args) {
        new WneczServer();
    }

    public void waitForConnections(){
        System.out.printf("Waiting for players.. %s/%s", connectedClients.size(), Game.MAX_PLAYERS);
        //Wait for client connection thread
        new Thread(() -> {
            while(connectedClients.size() < Game.MAX_PLAYERS) {

                try {
                    Socket newSocket = serverSocket.accept();
                    this.connectedClients.put(newSocket, null);
                    System.out.printf("Client connected.. waiting for user details.\n");
                } catch (IOException e) {
                    System.err.printf("Error connecting client\n");
                    e.printStackTrace();
                }


            }
            System.out.printf("All clients connected!\n");
        }).start();
    }

}
