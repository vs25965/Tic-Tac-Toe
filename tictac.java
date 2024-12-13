import java.util.Random;
import java.util.Scanner;

public class tictac {

    char board[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    char player1Mark = 'X';
    char player2Mark = 'O';

    public static void main(String[] args) {

        tictac db = new tictac();
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("\n\n**Welcome to Tic Tac Toe Game**");
        System.out.println("\n\nChoose game mode: Human vs Human type (1) or (2) for Human vs Console\n");
        String gameModeT = scanner.next().trim();
        String gameMode = db.validator(gameModeT, "2", "1");
        boolean playWithComputer = (gameMode.equals("2"));

        // Get custom marks from players
        db.getCustomMarks();

        while (playAgain) {

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
            String responseT = scanner.nextLine().trim().toLowerCase();
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
        char playerSymbol = (turn == 0) ? player2Mark : player1Mark;
        Scanner scanner = new Scanner(System.in);
    
        if (playWithComputer && turn == 0) {
            Random random = new Random();
            while (true) {
                int move = random.nextInt(9) + 1;
                if (board[move] != player1Mark && board[move] != player2Mark) {
                    board[move] = playerSymbol;
                    displayboard();
                    break;
                }
            }
        } else {
            while (true) {
                boolean validMove = false;
                System.out.println("\nChoose a number from the board = ");
                String input = scanner.nextLine().trim();
                if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
                    char number = input.charAt(0);
                    int move = Character.getNumericValue(number);
                    if (move >= 1 && move <= 9) {
                        if (board[move] != player1Mark && board[move] != player2Mark) {
                            board[move] = playerSymbol;
                            displayboard();
                            validMove = true;
                        } else {
                            System.out.println("Spot already taken. Choose another spot.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number 1-9.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number 1-9.");
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
                if (board[pos[0]] == player2Mark) {
                    System.out.println("\n\nPlayer " + player2Mark + " won with row " + pos[0] + " - " + pos[1] + " - " + pos[2] + "\n   END OF GAME\n");
                } else if (board[pos[0]] == player1Mark) {
                    System.out.println("\n\nPlayer " + player1Mark + " won with row " + pos[0] + " - " + pos[1] + " - " + pos[2] + "\n   END OF GAME\n");
                }
                return 1;
            }
        }
        return 3;
    }

    public String validator(String userI, String opt1, String opt2) {
        Scanner scanner = new Scanner(System.in);
        boolean validates = false;
        while (!validates) {
            if (!userI.equals(opt1) && !userI.equals(opt2)) {
                System.out.println("\nNo valid input, Try again:\n");
                String newI = scanner.next().trim();
                userI = newI;
            } else {
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

    public void getCustomMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1, choose your mark (one character): ");
        player1Mark = getValidMark(scanner);
        System.out.println("Player 2, choose your mark (one character): ");
        player2Mark = getValidMark(scanner);
    }

    public char getValidMark(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.length() == 1 && isValidCharacter(input.charAt(0))) {
                return input.charAt(0);
            }
             else {
                System.out.println("Invalid mark. Please enter a single character (A-Z, a-z, 0-9, or special characters).");
            }
        }
    }

    public boolean isValidCharacter(char c) {
        return Character.isLetterOrDigit(c) || "!@#$%^&*()_+-=[]{}|;:'\",.<>?/".indexOf(c) >= 0;
    }
}