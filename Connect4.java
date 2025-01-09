public class Connect4 {

    /**
     * Main method to start the Connect4 game.
     * 
     * @param args
     */
    public static void main(String[] args) {
        GameController gameController = new GameController();

        gameController.addPlayer(new HumanPlayer('R', "Human Player 1"));
        gameController.addPlayer(new HumanPlayer('Y', "Human Player 2"));

        gameController.startGame();
    }
}