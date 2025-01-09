import java.util.*;

public class GameController {

    private Board board;
    private List<Player> players;
    private boolean gameWon;
    private boolean boardFull;

    /**
     * Constructor to create a new GameController.
     * 
     */
    public GameController() {
        this.board = new Board();
        this.players = new ArrayList<>();
        this.gameWon = false;
        this.boardFull = false;
    }

    /**
     * Method to start and control the flow of the game. 
     * Selects a random player from the players list to start.
     * If the current player has not won, and the board is not full following the current player's move, switch players.
     * 
     */
    public void startGame() {
        if (players.isEmpty()) {
            System.out.println("No players available to start the game.");
            return;
        }

        Random rand = new Random();
        int currentPlayerIndex = rand.nextInt(getPlayersCount());

        startGameText(players.get(currentPlayerIndex).getName());

        while (!gameWon && !boardFull) {
            Player currentPlayer = players.get(currentPlayerIndex);
            printFormatting();
            System.out.println(currentPlayer.getName() + "'s turn");

            currentPlayer.makeMove(board, currentPlayer.getToken());
            board.displayBoard();

            if (board.checkWin(currentPlayer.getToken())) {
                gameWon = true;
                gameWon(currentPlayer.getName());
            } else if (board.isBoardFull()) {
                boardFull = true;
                gameDrawn();
            } else {
                currentPlayerIndex = (currentPlayerIndex + 1) % getPlayersCount(); // If no win or draw, switch to the next player
            }
        }
    }

    /**
     * Method to add a new player to the game. If a player exists already with the new player's credentials, the new player won't be added.
     * 
     * @param player The player to add to the players list.
     */
    public void addPlayer(Player player) {
        for (Player p : players) {
            if (p.getToken() == player.getToken() || p.getName().equals(player.getName())) {
                System.out.println();
                System.out.println("Caution, a player was not added! A player may already exist with the token: '" + player.getToken() + "' or the name: '" + player.getName() + "'");
                System.out.println();
                return;
            }
        }

        players.add(player);
    }
    

    /**
     * Method to return the number of players stored in the players list.
     * 
     * @return the number of players in the game.
     */
    private int getPlayersCount() {
        return players.size();
    }

    /**
     * Method to print a line which is used separate different parts of the game.
     * 
     */
    private void printFormatting() {
        System.out.println("--------------------------------------------------------");
        System.out.println();
    }

    /**
     * Method to print the start game text.
     * 
     */
    private void startGameText(String startingPlayersName) {
        printFormatting();
        System.out.println("Welcome to Connect 4!");
        System.out.println("To play the game, type in the number of the column you want to drop your counter in.");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally.");
        System.out.println();
        System.out.println("You are playing with " + getPlayersCount() + " players.");
        System.out.println();
        System.out.println("Below is the starting board.");
        board.displayBoard();
        System.out.println();
        System.out.println("The player chosen to start is: '" + startingPlayersName + "'");
    }

    /**
     * Method to print to the user that the game has ended a draw.
     * 
     */
    private void gameDrawn() {
        printFormatting();
        System.out.println("The board is full! It's a draw!");
        board.displayBoard();
    }

    /**
     * Method to print to the user that the game has ended with the currentPlayer winning.
     * 
     * @param currentPlayersName
     */
    private void gameWon(String currentPlayersName) {
        printFormatting();
        System.out.println(currentPlayersName + " wins!");
        board.displayBoard();
    }
}