public class Board {

    private char[][] grid;
    private final int rows = 6;
    private final int columns = 7;

    /**
     * Constructor to create a Board.
     * 
     */
    public Board() {
        grid = new char[rows][columns];
        initialiseBoard();
    }

    /**
     * Method to initialise the board with empty cells.
     * Assigns '-' a grid position, indicating an empty cell.
     * 
     */
    private void initialiseBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = '-';
            }
        }
    }

    /**
     * Method to display the current state of the board.
     * 
     */
    public void displayBoard() {
        System.out.println("             ");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("             ");
        System.out.println("1 2 3 4 5 6 7");
        System.out.println("             ");
    }

    /**
     * Method to place a token in the given column.
     * Tokens are placed from the bottom of the column upwards.
     * 
     * @param column The column where the token is to be placed.
     * @param token  The token to place (e.g. 'R').
     * @return true if the token was placed successfully, false if the column is full.
     */
    public boolean placeToken(int column, char token) {
        for (int i = rows - 1; i >= 0; i--) {
            if (grid[i][column] == '-') {
                grid[i][column] = token;
                return true;
            }
        }

        return false;
    }

    /**
     * Method to check if a player has won the game.
     * 
     * @param token The token of the current player.
     * @return true if the player with the provided token has won, false otherwise.
     */
    public boolean checkWin(char token) {
        if (horizontalWinCheck(token) || verticalWinCheck(token) || diagonalWinCheck(token)) {
            return true;
        }

        return false;
    }

    /**
     * Method to check if the win condition has been met horizontally.
     * 
     * @param token
     * @return true if 4 tokens match in a row, false otherwise.
     */
    private boolean horizontalWinCheck(char token) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 3; j++) {
                if (grid[i][j] == token &&
                        grid[i][j + 1] == token &&
                        grid[i][j + 2] == token &&
                        grid[i][j + 3] == token) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Method to check if the win condition has been met vertically.
     * 
     * @param token
     * @return true if 4 tokens match in a column, false otherwise.
     */
    private boolean verticalWinCheck(char token) {
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == token &&
                        grid[i + 1][j] == token &&
                        grid[i + 2][j] == token &&
                        grid[i + 3][j] == token) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Method to check if the win condition has been met diagonally, both left to
     * right and right to left.
     * 
     * @param token
     * @return true if 4 tokens diagonally match, false otherwise.
     */
    private boolean diagonalWinCheck(char token) {
        // Diagonal checks left to right
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns - 3; j++) {
                if (grid[i][j] == token &&
                        grid[i + 1][j + 1] == token &&
                        grid[i + 2][j + 2] == token &&
                        grid[i + 3][j + 3] == token) {
                    return true;
                }
            }
        }

        // Diagonal checks right to left
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 3; j < columns; j++) {
                if (grid[i][j] == token &&
                        grid[i + 1][j - 1] == token &&
                        grid[i + 2][j - 2] == token &&
                        grid[i + 3][j - 3] == token) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Method to get the number of rows in the board.
     * 
     * @return the number of columns.
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Method to check if the board is full.
     * If the top row contains any empty cell indicators ('-'), the board is not yet full.
     * 
     * @return true if the board is full, false otherwise.
     */
    public boolean isBoardFull() {
        for (int i = 0; i < columns; i++) {
            if (grid[0][i] == '-') {
                return false;
            }
        }

        return true;
    }
}