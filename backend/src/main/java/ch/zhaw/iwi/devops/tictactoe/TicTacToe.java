package ch.zhaw.iwi.devops.tictactoe;

public class TicTacToe {
    private char[][] board;

    public TicTacToe() {
        board = new char[3][3];
        // Initialisiere das Board mit Leerzeichen
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public char getMarkAt(int row, int col) {
        return board[row][col];
    }
}
