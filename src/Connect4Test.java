import java.util.Scanner;

public class Connect4Test {
    public static void main(String[] args){

        /*
         * Initialising game, scanner and needed variables
         */
        Board gameBoard = new Board();
        int y = 0;
        Scanner input = new Scanner(System.in);

        /*
         * While loop for running the game, depends on the "GameIsRunning" boolean variable which chnages to no
         * if one of the players wins the game
         */
        while(gameBoard.getGameIsRunning()){
            if(y == 0){
                System.out.println("Player 1 please input what row you want to put your Piece:");
                gameBoard.addPiece(input.nextInt(),"x");
                gameBoard.outputBoard();
                gameBoard.checkGamestate();
                y = 1;
            } else {
                System.out.println("Player 2 please input what row you want to put your next Piece:");
                gameBoard.addPiece(input.nextInt(),"o");
                gameBoard.outputBoard();
                gameBoard.checkGamestate();
                y = 0;
            }
        }
        input.close();
    }
}
