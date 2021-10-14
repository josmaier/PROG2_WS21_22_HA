import java.util.Objects;

public class ConnectFour{
    private Board board;
    private String colour1;
    private String colour2;
    private boolean gameIsRunning;
    private boolean isPlayer1Playing;

    public ConnectFour(String colour1, String colour2){
        this.board = new Board();
        this.colour1 = colour1;
        this.colour2 = colour2;
        this.isPlayer1Playing = true;
        this.gameIsRunning = true;

    }


/*
    public progressGame(){
        while(gameIsRunning){
            if(isPlayer1Playing == true){
                System.out.println("Player 1, please place a piece in your desired row");
            }
        }
    }
    */


}
