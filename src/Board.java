import java.util.Objects;

public class Board {
    protected static final int     rows   = 6;
    protected static final int     colums = 7;
    public                 boolean gameIsRunning;
    protected              String  colour1;
    private                int     i      = 0;


    Piece[][] gameBoard = new Piece[colums][rows];


    public Board() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < colums; col++) {
                gameBoard[col][row] = null;
                gameIsRunning = true;
            }
        }
    }


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

    public void checkGamestate() {
        if(gameIsRunning) {
            this.checkHorizontal();
            this.checkVertical();
            this.checkDiagonal();
        }
    }

    public void checkHorizontal() {
        if (gameIsRunning) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < colums; col++) {
                    if (col <= 3) {
                        if (gameBoard[col][row] != null && gameBoard[col + 1][row] != null && gameBoard[col + 2][row] != null
                                && gameBoard[col + 3][row] != null) {
                            if (Objects.equals(gameBoard[col + 1][row].getColour(), gameBoard[col][row].getColour())
                                    && Objects.equals(gameBoard[col + 2][row], gameBoard[col][row])
                                    && Objects.equals(gameBoard[col + 3][row].getColour(), gameBoard[col][row].getColour())) {
                                this.gameIsRunning = false;
                                if (Objects.equals(gameBoard[col][row].getColour(), colour1)) {
                                    System.out.println("Player 1 has won the game!");
                                } else {
                                    System.out.println("Player 2 has won the game");
                                }
                            }
                        }
                        } else if (col > 3) {
                            if (gameBoard[col - 1][row] != null && gameBoard[col - 2][row] != null
                                    && gameBoard[col - 3][row] != null) {
                                if (Objects.equals(gameBoard[col - 1][row].getColour(), gameBoard[col][row].getColour())
                                        && Objects.equals(gameBoard[col - 2][row], gameBoard[col][row])
                                        && Objects.equals(gameBoard[col - 3][row].getColour(), gameBoard[col][row].getColour())) {
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


    public void checkVertical() {
        if (gameIsRunning) {
            for (int row2 = 0; row2 < rows; row2++) {
                for (int col2 = 0; col2 < colums; col2++) {
                    if (row2 < 2) {
                        if (gameBoard[col2][row2] != null && gameBoard[col2][row2 + 1] != null
                                && gameBoard[col2][row2 + 2] != null && gameBoard[col2][row2 + 3] != null) {
                            if (Objects.equals(gameBoard[col2][row2 + 1].getColour(), gameBoard[col2][row2].getColour())
                                    && Objects.equals(gameBoard[col2][row2 + 2], gameBoard[col2][row2])
                                    && Objects.equals(gameBoard[col2][row2 + 3].getColour(), gameBoard[col2][row2].getColour())) {
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
                            if (Objects.equals(gameBoard[col2][row2 - 1].getColour(), gameBoard[col2][row2].getColour())
                                    && Objects.equals(gameBoard[col2][row2 - 2], gameBoard[col2][row2])
                                    && Objects.equals(gameBoard[col2][row2 - 3].getColour(), gameBoard[col2][row2].getColour())) {
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


    public void checkDiagonal() {
        if (gameIsRunning) {
            for (int col = 0; col < colums; col++) {
                for (int row3 = 0; row3 < rows; row3++) {
                    if (gameBoard[col][row3] != null) {
                        if (col < 4 && row3 > 2) {
                            if (gameBoard[col + 1][row3 - 1] != null && gameBoard[col + 2][row3 - 2] != null
                                    && gameBoard[col + 3][row3 - 3] != null) {
                                if (gameBoard[col + 1][row3 - 1] == gameBoard[col][row3]
                                        && gameBoard[col + 2][row3 - 2] == gameBoard[col][row3]
                                        && gameBoard[col + 3][row3 - 3] == gameBoard[col][row3]) {
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
                                if (gameBoard[col - 1][row3 - 1] == gameBoard[col][row3]
                                        && gameBoard[col - 2][row3 - 2] == gameBoard[col][row3]
                                        && gameBoard[col - 3][row3 - 3] == gameBoard[col][row3]) {
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
                                if (gameBoard[col + 1][row3 + 1] == gameBoard[col][row3]
                                        && gameBoard[col + 2][row3 + 2] == gameBoard[col][row3]
                                        && gameBoard[col + 3][row3 + 3] == gameBoard[col][row3]) {
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
                                if (gameBoard[col - 1][row3 + 1] == gameBoard[col][row3]
                                        && gameBoard[col + 2][row3 - 2] == gameBoard[col][row3]
                                        && gameBoard[col - 3][row3 + 3] == gameBoard[col][row3]) {
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
}







