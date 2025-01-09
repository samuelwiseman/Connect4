import java.util.*;

public class HumanPlayer extends Player {

    /**
     * Constructor to create a new human player with a token and playerName.
     * 
     * @param token The token to assign to the human player.
     * @param playerName The name to assign to the human player.
     */
    public HumanPlayer(char token, String playerName) {
        super(token, playerName);
    }

    /**
     * Method for the human player to make a move on the board.
     * The player is prompted to input a column number.
     * 
     * @param board The game board.
     * @param token The player's token (e.g. 'R').
     */
    @Override
    public void makeMove(Board board, char token) {
        Scanner scanner = new Scanner(System.in);
        boolean validMove = false;
        int column;

        System.out.println(playerName + "'s token is: " + token);
        System.out.println("Enter a column number, between 1-7, to place your token");

        while (!validMove) {
            try {
                column = scanner.nextInt() - 1; // Convert 1-7 input to 0-6 for array indexing

                if (column < 0 || column >= board.getColumns()) {
                    System.out.println("Invalid input! Please enter a number between 1-7."); 
                    continue;
                }

                validMove = board.placeToken(column, token);

                if (!validMove) {
                    System.out.println("Column is full, please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1-7.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}