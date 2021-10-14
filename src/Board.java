import java.util.Objects;

public class Board{
    protected static final int rows = 6;
    protected static final int colums = 7;
    public boolean gameIsRunning;
    protected String colour1;
    private int i = 0;


    Piece [][]gameBoard = new Piece[colums][rows];




     public Board(){
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < colums; col++){
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
                        if(i < 1) {
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

    public void outputBoard(){
        for(int row = 0; row < rows; row++){
            System.out.print("|");
            for(int col = 0; col < colums; col++){
                if(gameBoard[col][row] == null){
                    System.out.print("-");
                } else{
                    System.out.print(gameBoard[col][row].getColour());
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void checkGamestate() {
        if (gameIsRunning) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < colums; col++) {
                    if (gameBoard[col][row] != null) {
                        if (col <= 3) {
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
                        } else {
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
                for (int col = 0; col < colums; col++) {
                    if (gameBoard[col][row] != null) {
                        if (row < 2) {
                            if (Objects.equals(gameBoard[col][row + 1].getColour(), gameBoard[col][row].getColour())
                                    && Objects.equals(gameBoard[col][row + 2], gameBoard[col][row])
                                    && Objects.equals(gameBoard[col][row + 3].getColour(), gameBoard[col][row].getColour())) {
                                this.gameIsRunning = false;
                                if (gameBoard[col][row].getColour() == colour1) {
                                    System.out.println("Player 1 has won the game!");
                                } else {
                                    System.out.println("Player 2 has won the game");
                                }
                            }
                        } else if (row > 2) {
                            if (Objects.equals(gameBoard[col][row - 1].getColour(), gameBoard[col][row].getColour())
                                    && Objects.equals(gameBoard[col][row - 2], gameBoard[col][row])
                                    && Objects.equals(gameBoard[col][row - 3].getColour(), gameBoard[col][row].getColour())) {
                                this.gameIsRunning = false;
                                if (gameBoard[col][row].getColour() == colour1) {
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
}



/*
    public boolean checkGamestate(){
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < colums; col++){
                if(gameBoard[col][row] != null){
                    if(gameBoard[col+1][row] && )
                }
            }
        }
    }
*/


