package me.poilet.wnecz.server.objects;

import me.poilet.wnecz.client.objects.AuthenticatedUser;

public class Game {

    //TODO: NOTE - This is just prototype naughts and crosses logic

    /**
     * ROUND LOGIC
     *     Choose first player
     *     Wait for their move (move request packet)
     *     When their move arrives
     *     If valid
     *     Send board update packet to all players (inlcuding who just moved [move confirmation])
     *     repeat and alternate player users[turnCount % 2]
     */

    public static final int MAX_PLAYERS = 2;
    private char[][] board;
    private int turnCount;
    private AuthenticatedUser[] users;

    public Game() {
        this.users = new AuthenticatedUser[2];
        this.board = new char[3][3];
    }



}
