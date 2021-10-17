import java.util.Scanner;

public class Connect4Test {
    public static void main(String[] args){

        Board gameBoard = new Board();
        int y = 0;
        Scanner input = new Scanner(System.in);

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
    }
}
