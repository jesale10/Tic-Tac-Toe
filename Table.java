package tictactoe;

public class Table {

    private final char[][] cells = new char[3][3];
    private char turn = 'X';

    Table() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public boolean checkEmpty () {
        boolean check = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

    public boolean add(int x, int y) {
        boolean result = false;
        if (cells[x][y] == ' ') {
            cells[x][y] = turn;
            if (turn == 'X') {
                turn = 'O';
            } else {
                turn = 'X';
            }
            result = true;
        }
        return result;
    }

    public char checkWinner() {
        char winner = '_';
        int[][][] combinations = {
                {{0, 0}, {0, 1}, {0, 2}},
                {{1, 0}, {1, 1}, {1, 2}},
                {{2, 0}, {2, 1}, {2, 2}},
                {{0, 0}, {1, 0}, {2, 0}},
                {{0, 1}, {1, 1}, {2, 1}},
                {{0, 2}, {1, 2}, {2, 2}},
                {{0, 0}, {1, 1}, {2, 2}},
                {{0, 2}, {1, 1}, {2, 0}}
        };

        for (int i = 0; i < 8; i++) {
            if (cells[combinations[i][0][0]][combinations[i][0][1]]
                    == cells[combinations[i][1][0]][combinations[i][1][1]]
                    && cells[combinations[i][1][0]][combinations[i][1][1]]
                    == cells[combinations[i][2][0]][combinations[i][2][1]]) {
                    winner = cells[combinations[i][0][0]][combinations[i][0][1]];
                    break;
            }
        }
        return winner;
    }

    public void show () {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
