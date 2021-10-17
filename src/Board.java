import java.util.Objects;

public class Board {
    /**
     * Initialising variables needed for class, rows and colums for size of the grid, GameIsRunning to check if
     * a player has won yet, Colour1 to determine the colour of player 1 and i which is needed to set the colour for
     * colour 1
     */
    protected static final int     rows   = 6;
    protected static final int     colums = 7;
    public                 boolean gameIsRunning;
    protected              String  colour1;
    private                int     i      = 0;


    /**
     * Creating array gameBoard which saves what pieces are at what place in the board.
     * The array contains entries of the class piece
     */
    Piece[][] gameBoard = new Piece[colums][rows];


    /**
     * Filling the array with null entries in the constructor
     */
    public Board() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < colums; col++) {
                gameBoard[col][row] = null;
                gameIsRunning = true;
            }
        }
    }

    /**
     * Function to add a piece. It first determines if the colum you want to add a piece to is full, if that is not the
     * case it will add it into the first available slot counting from the bottom to the top.
     * @param colAdd    Variable that saves what colum the player wants to add his piece too
     * @param colour    Colour of the piece that the player wants to add
     */
    public void addPiece(int colAdd, String colour) {
        colAdd--;
        if (colAdd <= rows) {
            if (gameBoard[colAdd][0] == null) {
                for (int row = 5; row < rows; row--) {
                    if (gameBoard[colAdd][row] == null) {
                        gameBoard[colAdd][row] = new Piece();
                        gameBoard[colAdd][row].setColour(colour);
                        if (i < 1) {
                            colour1 = gameBoard[colAdd][row].getColour();
                            i++;
                        }
                        break;
                    }
                }
            } else {
                System.out.print("You are trying to add a piece to a row that is full");
                System.out.println();
            }
        } else {
            System.out.print("You are trying to add a piece to a row that does not exist");
            System.out.println();
        }
    }

    /**
     * Function to draw the board, it draws vertical lines and fills the spaces inbetween with either the colour,
     * which in this case is a String (could also be char in hindsight). If the entry is null it will just draw a
     * horizontal line.
     */
    public void outputBoard() {
        for (int row = 0; row < rows; row++) {
            System.out.print("|");
            for (int col = 0; col < colums; col++) {
                if (gameBoard[col][row] == null) {
                    System.out.print("-");
                } else {
                    System.out.print(gameBoard[col][row].getColour());
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Function ot check if a player has won the game yet. It calls three different functions from this class.
     */
    public void checkGamestate() {
        if(gameIsRunning) {
            this.checkHorizontal();
            this.checkVertical();
            this.checkDiagonal();
        }
    }

    /**
     * This function checks if one of the players has fulfilled one of the three possible requirements to win the game,
     * having 4 pieces of his colour in a horizontal line. It has a if statement to avoid NullPointerExceptions
     * before each of the two checking statements. It determines which player has won by comparing the colour of the
     * array entry that leads the winning line with the colour that was associated with player 1 in the add piece
     * function. This does not use the Objectequals() feature as that did lead to the if statements not getting resolved
     * correctly
     */
    public void checkHorizontal() {
        if (gameIsRunning) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < colums; col++) {
                    if (col <= 3) {
                        if (gameBoard[col][row] != null && gameBoard[col + 1][row] != null && gameBoard[col + 2][row] != null
                                && gameBoard[col + 3][row] != null) {
                            if (gameBoard[col + 1][row].getColour() == gameBoard[col][row].getColour()
                                    && gameBoard[col + 2][row].getColour() == gameBoard[col][row].getColour()
                                    && gameBoard[col + 3][row].getColour() == gameBoard[col][row].getColour()) {
                                this.gameIsRunning = false;
                                if (Objects.equals(gameBoard[col][row].getColour(), colour1)) {
                                    System.out.println("Player 1 has won the game!");
                                } else {
                                    System.out.println("Player 2 has won the game");
                                }
                            }
                        }
                        } else if (col > 3) {
                            if (gameBoard[col][row] != null && gameBoard[col - 1][row] != null
                                    && gameBoard[col - 2][row] != null
                                    && gameBoard[col - 3][row] != null) {
                                if (gameBoard[col - 1][row].getColour() == gameBoard[col][row].getColour()
                                        && gameBoard[col - 2][row].getColour() == gameBoard[col][row].getColour()
                                        && gameBoard[col - 3][row].getColour() == gameBoard[col][row].getColour()) {
                                    this.gameIsRunning = false;
                                    if (Objects.equals(gameBoard[col][row].getColour(), colour1)) {
                                        System.out.println("Player 1 has won the game!");
                                    } else {
                                        System.out.println("Player 2 has won the game");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    /**
     * This function checks if one of the players has fulfilled one of the three possible requirements to win the game,
     * having 4 pieces of his colour in a vertical line. It has a if statement to avoid NullPointerExceptions
     * before each of the two checking statements. It determines which player has won by comparing the colour of the
     * array entry that leads the winning line with the colour that was associated with player 1 in the add piece
     * function. This does not use the Objectequals() feature as that did lead to the if statements not getting resolved
     * correctly
     */
    public void checkVertical() {
        if (gameIsRunning) {
            for (int row2 = 0; row2 < rows; row2++) {
                for (int col2 = 0; col2 < colums; col2++) {
                    if (row2 < 2) {
                        if (gameBoard[col2][row2] != null && gameBoard[col2][row2 + 1] != null
                                && gameBoard[col2][row2 + 2] != null && gameBoard[col2][row2 + 3] != null) {
                            if (gameBoard[col2][row2 + 1].getColour() == gameBoard[col2][row2].getColour()
                                    && gameBoard[col2][row2 + 2].getColour() == gameBoard[col2][row2].getColour()
                                    && gameBoard[col2][row2 + 3].getColour() == gameBoard[col2][row2].getColour()) {
                                this.gameIsRunning = false;
                                if (gameBoard[col2][row2].getColour() == colour1) {
                                    System.out.println("Player 1 has won the game!");
                                } else {
                                    System.out.println("Player 2 has won the game");
                                }
                            }
                        }
                    } else {
                        if (gameBoard[col2][row2] != null && gameBoard[col2][row2 - 1] != null
                                && gameBoard[col2][row2 - 2] != null && gameBoard[col2][row2 - 3] != null) {
                            if (gameBoard[col2][row2 - 1].getColour() == gameBoard[col2][row2].getColour()
                                    && gameBoard[col2][row2 - 2].getColour() == gameBoard[col2][row2].getColour()
                                    && gameBoard[col2][row2 - 3].getColour() == gameBoard[col2][row2].getColour()) {
                                this.gameIsRunning = false;
                                if (gameBoard[col2][row2].getColour() == colour1) {
                                    System.out.println("Player 1 has won the game!");
                                } else {
                                    System.out.println("Player 2 has won the game");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * This function checks if one of the players has fulfilled one of the three possible requirements to win the game,
     * having 4 pieces of his colour in a diagonal line. It has a if statement to avoid NullPointerExceptions
     * before each of the two checking statements. It determines which player has won by comparing the colour of the
     * array entry that leads the winning line with the colour that was associated with player 1 in the add piece
     * function. This does not use the Objectequals() feature as that did lead to the if statements not getting resolved
     * correctly
     */
    public void checkDiagonal() {
        if (gameIsRunning) {
            for (int col = 0; col < colums; col++) {
                for (int row3 = 0; row3 < rows; row3++) {
                    if (gameBoard[col][row3] != null) {
                        if (col < 4 && row3 > 2) {
                            if (gameBoard[col + 1][row3 - 1] != null && gameBoard[col + 2][row3 - 2] != null
                                    && gameBoard[col + 3][row3 - 3] != null) {
                                if (gameBoard[col + 1][row3 - 1].getColour() == gameBoard[col][row3].getColour()
                                        && gameBoard[col + 2][row3 - 2].getColour() == gameBoard[col][row3].getColour()
                                        && gameBoard[col + 3][row3 - 3].getColour() == gameBoard[col][row3].getColour()) {
                                    if (gameBoard[col][row3].getColour() == colour1) {
                                        System.out.println("Player 1 has won the game!");
                                    } else {
                                        System.out.println("Player 2 has won the game!");
                                    }
                                }
                            }
                        } else if (col > 2 && row3 > 2) {
                            if (gameBoard[col - 1][row3 - 1] != null && gameBoard[col - 2][row3 - 2] != null
                                    && gameBoard[col - 3][row3 - 3] != null) {
                                if (gameBoard[col - 1][row3 - 1].getColour() == gameBoard[col][row3].getColour()
                                        && gameBoard[col - 2][row3 - 2].getColour() == gameBoard[col][row3].getColour()
                                        && gameBoard[col - 3][row3 - 3].getColour() == gameBoard[col][row3].getColour()) {
                                    if (gameBoard[col][row3].getColour() == colour1) {
                                        System.out.println("Player 1 has won the game!");
                                    } else {
                                        System.out.println("Player 2 has won the game!");
                                    }
                                }
                            }
                        } else if (col < 4 && row3 < 3) {
                            if (gameBoard[col + 1][row3 + 1] != null && gameBoard[col + 2][row3 + 2] != null
                                    && gameBoard[col + 3][row3 + 3] != null) {
                                if (gameBoard[col + 1][row3 + 1].getColour() == gameBoard[col][row3].getColour()
                                        && gameBoard[col + 2][row3 + 2].getColour() == gameBoard[col][row3].getColour()
                                        && gameBoard[col + 3][row3 + 3].getColour() == gameBoard[col][row3].getColour()) {
                                    if (gameBoard[col][row3].getColour() == colour1) {
                                        System.out.println("Player 1 has won the game!");
                                    } else {
                                        System.out.println("Player 2 has won the game!");
                                    }
                                }
                            }
                        } else if (col > 2 && row3 < 3) {
                            if (gameBoard[col - 1][row3 + 1] != null && gameBoard[col - 2][row3 + 2] != null
                                    && gameBoard[col - 3][row3 + 3] != null) {
                                if (gameBoard[col - 1][row3 + 1].getColour() == gameBoard[col][row3].getColour()
                                        && gameBoard[col + 2][row3 - 2].getColour() == gameBoard[col][row3].getColour()
                                        && gameBoard[col - 3][row3 + 3].getColour() == gameBoard[col][row3].getColour()) {
                                    if (gameBoard[col][row3].getColour() == colour1) {
                                        System.out.println("Player 1 has won the game!");
                                    } else {
                                        System.out.println("Player 2 has won the game!");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Getter for the variable GameIsRunning
     *
     * @return  boolean
     */
    public boolean getGameIsRunning() {
        return gameIsRunning;
    }
}







