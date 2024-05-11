package ch.zhaw.iwi.devops.tictactoe;

import java.util.Arrays;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        resetBoard();
    }

    public void makeMove(int row, int col) {
        if (board[row][col] == EMPTY) {
            board[row][col] = currentPlayer;
            togglePlayer();
        }
    }

    private void togglePlayer() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char getMarkAt(int row, int col) {
        return board[row][col];
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], EMPTY);
        }
        currentPlayer = PLAYER_X;
    }

    public boolean hasWinner() {
        return checkWin(PLAYER_X) || checkWin(PLAYER_O);
    }

    private boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (checkRowColDiag(player, i)) return true;
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private boolean checkRowColDiag(char player, int index) {
        return (board[index][0] == player && board[index][1] == player && board[index][2] == player) ||
               (board[0][index] == player && board[1][index] == player && board[2][index] == player);
    }

    public boolean isDraw() {
        if (hasWinner()) {
            return false; // Wenn es einen Gewinner gibt, kann es kein Unentschieden sein
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == EMPTY) {
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