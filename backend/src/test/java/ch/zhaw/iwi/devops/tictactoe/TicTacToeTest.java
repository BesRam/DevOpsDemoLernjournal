package ch.zhaw.iwi.devops.tictactoe;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testBoardIsInitiallyEmpty() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertEquals(' ', game.getMarkAt(row, col));
            }
        }
    }

    @Test
    public void testPlayersAlternateTurns() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0); // Spieler X macht einen Zug
        assertEquals('X', game.getMarkAt(0, 0));
        game.makeMove(0, 1); // Spieler O macht den nächsten Zug
        assertEquals('O', game.getMarkAt(0, 1));
        game.makeMove(1, 0); // Spieler X ist wieder dran
        assertEquals('X', game.getMarkAt(1, 0));
    }

    @Test
    public void testWinByRow() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X gewinnt auf der obersten Reihe
        assertTrue(game.hasWinner());
    }

    @Test
    public void testWinByColumn() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(1, 0); // X
        game.makeMove(1, 1); // O
        game.makeMove(2, 0); // X gewinnt durch die erste Spalte
        assertTrue(game.hasWinner());
    }
}
