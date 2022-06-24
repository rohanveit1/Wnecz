package me.poilet.wnecz.client.engine;

import me.poilet.wnecz.client.WneczClient;
import me.poilet.wnecz.client.objects.AuthenticatedUser;

import java.util.Scanner;

public class MenuEngine {


    private static final Scanner scan = new Scanner(System.in);

    public static void menu() {

        String response = registerLogin();

        String[] userPass = getUserPass();
        String email = userPass[0];
        String pass = userPass[1];



        if(response.equals("L")) {

            if(WneczClient.INSTANCE.getDbEngine().doesUserExist(email, pass)) {
                AuthenticatedUser authUser = new AuthenticatedUser(email);
                WneczClient.INSTANCE.setAuthUser(authUser);
                System.out.printf("Welcome back!\n");
            } else {
                System.out.printf("Incorrect username or password!\n");
            }

        } else if(response.equals("R")) {

            if(WneczClient.INSTANCE.getDbEngine().doesUserExist(email)) {
                System.out.printf("An account already exists with that email.\n");
            } else {
                System.out.printf("Creating account...\n");
                WneczClient.INSTANCE.getDbEngine().createUser(email, pass);
                System.out.printf("User created!\n");
            }
            menu();

        } else {
            System.err.printf("How did you get here");
            System.exit(-1);
        }
    }

    private static String[] getUserPass() {
        String[] out = new String[2];
        System.out.printf("Please enter your username.\n");
        out[0] = scan.next();
        System.out.printf("Please enter your password.\n");
        out[1] = scan.next();
        return out;
    }

    private static String registerLogin() {
        String response = null;
        do {
            System.out.printf("Register[R] or Login[L]\n");
            response = scan.next().toUpperCase();
        } while (!response.equals("R") && !response.equals("L"));
        return response;
    }

    public static String[] getServerCreds() {
        String[] out = new String[2];
        System.out.printf("Enter ip of server: ");
        out[0] = scan.next();
        System.out.printf("\nEnter port of server: ");
        out[1] = scan.next();
        System.out.printf("\n");
        return out;
    }
}
