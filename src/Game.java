import java.util.*;

public class Game extends GameBoard {

    private ArrayList<Integer> playerPosition = new ArrayList<>();
    private ArrayList<Integer> cpuPosition = new ArrayList<>();
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);


    public void markPosition(char[][] gameBoard, int position, String user) {

        char symbol = 'X';

        if (user.equals("cpu")) {
            symbol = 'O';
            cpuPosition.add(position);
        } else {
            playerPosition.add(position);
        }


        this.gameBoard = gameBoard;
        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
        printGameBoard(gameBoard);
    }

    public void start() {
        while (hasEmptySpace()) {


            int position = scanner.nextInt();

            while(playerPosition.contains(position) || cpuPosition.contains(position)){
                System.out.println("Position taken, select another position");
                position = scanner.nextInt();
            }


            markPosition(gameBoard, position, "player");
            System.out.println();
            if (checkWinner()) {
                break;
            }

           int  cpuPos = random.nextInt(9) + 1;
            while(playerPosition.contains(cpuPos) || cpuPosition.contains(cpuPos)){
                cpuPos = random.nextInt(9) + 1;
            }
            markPosition(gameBoard, cpuPos, "cpu");
            System.out.println();
            if (checkWinner()) {
                break;
            }
        }
    }

    public boolean checkWinner() {

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<>();

        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (playerPosition.containsAll(l)) {
                System.out.println("Congratulation You won!!!");
                return true;
            } else if (cpuPosition.containsAll(l)) {
                System.out.println("You lose :( try again.");
                return true;
            } else if (!playerPosition.containsAll(l) && !cpuPosition.containsAll(l) && !hasEmptySpace()) {
                System.out.println("CAT");
                return true;
            }
        }
        return false;
    }
}