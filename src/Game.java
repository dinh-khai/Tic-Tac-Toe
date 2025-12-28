package src;

import java.util.Scanner;

public class Game {

//    private Board board = new Board();
//    private AIPlayer ai = new AIPlayer();
//    private Scanner sc = new Scanner(System.in);
//
//    // ------------------------------------------------------
//    // MAIN MENU WITH REPLAY SUPPORT
//    // ------------------------------------------------------
//    public void mainMenu() {
//
//        while (true) {
//            System.out.println("=== TIC TAC TOE ===");
//            System.out.println("1. Player vs Player");
//            System.out.println("2. Player vs AI");
//            System.out.println("3. Exit");
//            System.out.print("Enter choice: ");
//
//            int choice = sc.nextInt();
//
//            if (choice == 3) {
//                System.out.println("Goodbye!");
//                break;
//            }
//
//            if (choice == 1)
//                startPVP();
//            else
//                startAI();
//
//            if (!askReplay()) {
//                System.out.println("Thanks for playing!");
//                break;
//            }
//
//            board.reset(); // reset board for next play
//        }
//    }
//
//    private boolean askReplay() {
//        System.out.print("\nPlay again? (y/n): ");
//        char c = sc.next().toLowerCase().charAt(0);
//        System.out.println();
//        return c == 'y';
//    }
//
//    // ------------------------------------------------------
//    // PLAYER VS PLAYER MODE
//    // ------------------------------------------------------
//    private void startPVP() {
//        char current = 'X';
//
//        while (true) {
//            board.print();
//            System.out.println("Player " + current + ", enter row & column (0-2):");
//
//            int r = sc.nextInt();
//            int c = sc.nextInt();
//
//            if (!board.makeMove(r, c, current)) {
//                System.out.println("Invalid move. Try again.");
//                continue;
//            }
//
//            if (board.hasWon(current)) {
//                board.print();
//                System.out.println("Player " + current + " wins!");
//                break;
//            }
//
//            if (board.isFull()) {
//                board.print();
//                System.out.println("It's a draw!");
//                break;
//            }
//
//            current = (current == 'X') ? 'O' : 'X';
//        }
//    }

    // ------------------------------------------------------
    // PLAYER VS AI MODE
    // ------------------------------------------------------
//    private void startAI() {
//
//        // Difficulty selection
//        System.out.println("\nChoose AI Difficulty:");
//        System.out.println("1. Easy (Random)");
//        System.out.println("2. Medium (Win/Block)");
//        System.out.println("3. Hard (Unbeatable)");
//        System.out.print("Enter choice: ");
//        int level = sc.nextInt();
//        ai.setDifficulty(level);
//
//        // Who starts?
//        System.out.println("\nWho should start first?");
//        System.out.println("1. You (X)");
//        System.out.println("2. AI (O)");
//        System.out.print("Choose: ");
//        int starter = sc.nextInt();
//        char current = (starter == 1) ? 'X' : 'O';
//
//        System.out.println("\n=== GAME START ===");
//
//        while (true) {
//            board.print();
//
//            if (current == 'X') {
//                System.out.println("Your turn. Enter row & column (0-2):");
//                int r = sc.nextInt();
//                int c = sc.nextInt();
//
//                if (!board.makeMove(r, c, 'X')) {
//                    System.out.println("Invalid move. Try again.");
//                    continue;
//                }
//            } else {
//                System.out.println("AI is thinking...");
//                int[] move = ai.getBestMove(board);
//                board.makeMove(move[0], move[1], 'O');
//            }
//
//            if (board.hasWon(current)) {
//                board.print();
//                System.out.println((current == 'X') ? "You win!" : "AI wins!");
//                break;
//            }
//
//            if (board.isFull()) {
//                board.print();
//                System.out.println("It's a draw!");
//                break;
//            }
//
//            current = (current == 'X') ? 'O' : 'X';
//        }
//    }
}
