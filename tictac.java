import java.util.Random;
import java.util.Scanner;

public class tictac {

    char board[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    char number = '1';

    public static void main(String[] args) {

        tictac db = new tictac();
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("\n\n**Welcome to Tic Tac Toe Game**");
        System.out.println("\n\nChoose game mode: Human vs Human type 1 or 2 for Human vs Console\n");
        String gameModeT = scanner.next().trim();
        //createas a boolean to play with the console and sets it to 2 (which is true)
        String gameMode = db.validator(gameModeT,"2","1");
        boolean playWithComputer = (gameMode.equals("2"));

        while(playAgain){

            db.displayboard();
            for (int i = 1; i <= 5; i++) {
                db.win();
                db.choose(1, false); // Player 1 is always human
                if (db.win() == 1) {
                    break;
                }
                if (i == 5 && db.win() == 3) {
                    System.out.println("\n\tNo winner - tie!\n\t***END OF GAME***");
                    break;
                }
                db.choose(0, playWithComputer); // Player 2 can be human or computer
                if (db.win() == 1) {
                    break;
                }
            }

            System.out.println("Do you want to play again? (yes/no)");
            Scanner scanner1 = new Scanner(System.in);
            String responseT = scanner1.nextLine().trim().toLowerCase();
            String response = db.validator(responseT, "yes", "no");
            playAgain = response.equals("yes");
            db.resetBoard();
        }
        
        System.out.println("Thanks for playing!");
    }

    public void displayboard() {
        System.out.println("\n\t    *TTT Board *");
        System.out.println("\t___________________");
        System.out.print("\t|                 |");
        System.out.print("\n\t|  " + board[1] + "  |  " + board[2] + "  |  " + board[3] + "  |\n");
        System.out.print("\t|_________________|");
        System.out.print("\n\t|                 |");
        System.out.println("\n\t|  " + board[4] + "  |  " + board[5] + "  |  " + board[6] + "  |");
        System.out.print("\t|_________________|\n");
        System.out.print("\t|                 |");
        System.out.print("\n\t|  " + board[7] + "  |  " + board[8] + "  |  " + board[9] + "  |\n");
        System.out.print("\t|_________________|");
    }

    public void choose(int turn, boolean playWithComputer) {
        char playerSymbol = (turn == 0) ? 'O' : 'X';
        Scanner scanner = new Scanner(System.in);

        //conditional checks if playWithComputer (true) and if its turn (O)
        if (playWithComputer && turn == 0) {
            Random random = new Random();
            while (true) {
                //generates a move between 1-9 (within the index from original board)
                int move = random.nextInt(9) + 1;
                if (board[move] != 'O' && board[move] != 'X') {
                    board[move] = playerSymbol;
                    displayboard();
                    break;
                }
            }
        } else {
            while (true) {
                boolean validMove = false;
                System.out.println("\nChoose a number from the board = ");
                String input = scanner.nextLine().trim(); // Remove leading and trailing whitespace
                if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
                    number = input.charAt(0);
                    for (int i = 1; i <= 9; i++) {
                        if (number == board[i]) {
                            board[i] = playerSymbol;
                            displayboard();
                            validMove = true;
                            break;
                        }
                    }
                } else {
                    System.out.println("Invalid input. Please enter a single digit.");
                    validMove = false;
                }

                if (validMove) {
                    break;
                } 
            }
        }
    }

    public int win() {
        int[][] winPositions = {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, // Rows
            {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, // Columns
            {1, 5, 9}, {3, 5, 7}             // Diagonals
        };

        for (int[] pos : winPositions) {
            if (board[pos[0]] == board[pos[1]] && board[pos[1]] == board[pos[2]]) {
                if (board[pos[0]] == 'O') {
                    System.out.println("\n\nPlayer O won with row " + pos[0] + " - " + pos[1] + " - " + pos[2] + "\n   END OF GAME\n");
                } else if (board[pos[0]] == 'X') {
                    System.out.println("\n\nPlayer X won with row " + pos[0] + " - " + pos[1] + " - " + pos[2] + "\n   END OF GAME\n");
                }
                return 1;
            }
        }
        return 3;
    }

    public String validator(String userI, String opt1, String opt2)
    { 
        Scanner scanner = new Scanner(System.in);
        boolean validates = false;
        while(!validates)
        {
            if (!userI.equals(opt1) && !userI.equals(opt2))
            {
                System.out.println("\nNo valid input, Try again:\n");
                String newI = scanner.next().trim();
                userI = newI; 
            }
            else{
                validates = true;
            }
            
        }
        
         return userI; 
    }
    public void resetBoard() {
        for (int i = 1; i < board.length; i++) {
            board[i] = String.valueOf(i).charAt(0);
        }
    }
}
