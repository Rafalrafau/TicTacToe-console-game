
public class GameBoard {

    public char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};


    public void printGameBoard(char [] [] gameBoard){
        for(char [] row: gameBoard){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public boolean space(char [] [] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                if (c == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasEmptySpace(){
        return space(gameBoard);
    }

    public char[][] getGameBoard() {
        return gameBoard;
    }
}
