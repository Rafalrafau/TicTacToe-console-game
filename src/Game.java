import java.util.*;

public class Game extends GameBoard{

    private ArrayList<Integer> playerPosition = new ArrayList<>();
    private ArrayList<Integer> cpuPosition = new ArrayList<>();

    private  Scanner scanner = new Scanner(System.in);

    private int position;

    public void markPosition(char [] [] gameBoard, int position, String user){

        this.position=position;

        char symbol = 'X';

        if(user.equals("cpu")){
            symbol = 'O';
            cpuPosition.add(position);
        }
        playerPosition.add(position);

        this.gameBoard = gameBoard;
        switch (position){
            case 1:
                gameBoard [0] [0] = symbol;
                break;
            case 2:
                gameBoard [0] [2] = symbol;
                break;
            case 3:
                gameBoard [0] [4] = symbol;
                break;
            case 4:
                gameBoard [2] [0] = symbol;
                break;
            case 5:
                gameBoard [2] [2] = symbol;
                break;
            case 6:
                gameBoard [2] [4] = symbol;
                break;
            case 7:
                gameBoard [4] [0] = symbol;
                break;
            case 8:
                gameBoard [4] [2] = symbol;
                break;
            case 9:
                gameBoard [4] [4] = symbol;
                break;
            default:
                break;
        }
        printGameBoard(gameBoard);
    }

    public void start(){
        while(hasEmptySpace()){
            position = scanner.nextInt();
            markPosition(gameBoard, position, "player");
            System.out.println();
            Random random = new Random();
            int cpuPos = random.nextInt(9)+1;
            markPosition(gameBoard, cpuPos, "cpu");
        }
    }

    public String checkWinner() {

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List winning = new ArrayList<List>();

        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        
        return " ";
    }
}
