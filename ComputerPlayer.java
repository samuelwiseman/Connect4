import java.util.*;

public class ComputerPlayer extends Player {

    /**
     * Constructor to create a new computer player with a token and playerName.
     * 
     * @param token The token to assign to the computer player.
     * @param playerName The name to assign to the computer player.
     */
    public ComputerPlayer(char token, String playerName) {
        super(token, playerName);
    }

    /**
     * Method for the computer player to make a move on the board.
     * The computer randomly selects a column to drop its token into.
     * 
     * @param board The game board.
     * @param token The player's token (e.g. 'R').
     */
    @Override
    public void makeMove(Board board, char token) {
        Random rand = new Random();
        boolean validMove = false; 
        int column;

        System.out.println(playerName +  "'s token is: " + token);

        while (!validMove) {
            column = rand.nextInt(7);
            validMove = board.placeToken(column, token);   
        }
    }
}