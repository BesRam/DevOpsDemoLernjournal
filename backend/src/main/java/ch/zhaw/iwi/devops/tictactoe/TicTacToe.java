package ch.zhaw.iwi.devops.tictactoe;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X'; // X beginnt das Spiel
        resetBoard(); // Initialisiert das Board beim Erstellen einer neuen Instanz
    }

    public void makeMove(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            togglePlayer();
        }
    }

    private void togglePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char getMarkAt(int row, int col) {
        return board[row][col];
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X'; // Setzt den aktuellen Spieler auf X zurück
    }

    public boolean hasWinner() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != ' ' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return true;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != ' ' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }
        // Prüfung der Hauptdiagonale
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        // Prüfung der Nebendiagonale
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    public boolean isDraw() {
        if (hasWinner()) {
            return false; // Wenn es einen Gewinner gibt, kann es kein Unentschieden sein
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false; // Wenn ein Feld leer ist, ist das Spiel noch nicht vorbei
                }
            }
        }
        return true; // Keine leeren Felder und kein Gewinner = Unentschieden
    }

    public boolean isInProgress() {
        return !hasWinner() && !isDraw();
    }
}
