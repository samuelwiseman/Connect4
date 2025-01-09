public abstract class Player {

    protected char token;
    protected String playerName;

    /**
     * Constructor to create a new player with a token and playerName.
     * 
     * @param token The token to assign to the player.
     * @param playerName The name to assign to the player.
     */
    public Player(char token, String playerName) {
        this.token = token;
        this.playerName = playerName;
    }

    /**
     * Method to return the player's token.
     * 
     * @return the players token.
     */
    public char getToken() {
        return token;
    }

    /**
     * Method to return the player's name.
     * 
     * @return the player's name.
     */
    public String getName() {
        return playerName;
    }

    /**
     * Abstract method to make a move on the board.
     * 
     * @param board The game board.
     * @param token The players token.
     */
    public abstract void makeMove(Board board, char token);
}
