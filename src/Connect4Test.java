public class Connect4Test {
    public static void main(String[] args){

        Board gameBoard = new Board();
        gameBoard.addPiece(3,"x");
        gameBoard.outputBoard();
        gameBoard.addPiece(5,"x");
        gameBoard.outputBoard();
        gameBoard.addPiece(7,"x");
        gameBoard.outputBoard();
        gameBoard.checkGamestate();

    }
}
