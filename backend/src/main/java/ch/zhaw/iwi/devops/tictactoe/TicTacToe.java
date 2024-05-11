package ch.zhaw.iwi.devops.tictactoe;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X'; // X beginnt das Spiel
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void makeMove(int row, int col) {
        if (board[row][col] == ' ') { // Prüft, ob das Feld leer ist
            board[row][col] = currentPlayer; // Setzt den Markierungswert des aktuellen Spielers
            togglePlayer(); // Wechselt den Spieler
        }
    }

    private void togglePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getMarkAt(int row, int col) {
        return board[row][col];
    }
}
