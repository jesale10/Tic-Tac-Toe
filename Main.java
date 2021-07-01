package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Table board = new Table();
        board.show();
        int x;
        int y;
        boolean free;
        boolean winner = false;
        char player;
        do {
            System.out.print("Enter the coordinates: ");
            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    y = scanner.nextInt();
                    if (x <=3 && x >=1 && y <=3 && y >=1) {
                        x--;
                        y--;
                        free = board.add(x, y);
                        if (free) {
                            board.show();
                            player = board.checkWinner();
                            if(player == 'X') {
                                System.out.println("X wins");
                                winner = true;
                            } else if(player == 'O') {
                                System.out.println("O wins");
                                winner = true;
                            } else if (player == '_' && !board.checkEmpty()) {
                                System.out.println("Draw");
                                winner = true;
                            }
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                } else {
                    System.out.println("You should enter numbers!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
            scanner.nextLine();
        } while (!winner);
    }
}
