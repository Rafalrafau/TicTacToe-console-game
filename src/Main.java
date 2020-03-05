
public class Main {


    public static void main(String[] args) {

        GameBoard gameBoard = new GameBoard();

        char [][] ourGameBoard = gameBoard.getGameBoard();

        gameBoard.printGameBoard(ourGameBoard);

        System.out.println("Enter your placement (1-9):");

        Game game = new Game();

        game.start();

    }
}
