package ch.zhaw.iwi.devops.tictactoe;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

    @Test
    public void testWinByDiagonal() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(1, 1); // X
        game.makeMove(0, 2); // O
        game.makeMove(2, 2); // X gewinnt durch Hauptdiagonale
        assertTrue(game.hasWinner());
    }

    @Test
    public void testGameDraw() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 1); // X
        game.makeMove(0, 2); // O
        game.makeMove(2, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(1, 2); // X
        game.makeMove(2, 1); // O
        game.makeMove(2, 2); // X
        assertFalse(game.hasWinner());
        assertTrue(game.isDraw());
    }

    @Test
    public void testInvalidMoveOnTakenSquare() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0); // X macht den ersten Zug
        game.makeMove(0, 0); // O versucht, auf das gleiche Feld zu ziehen
        assertEquals('X', game.getMarkAt(0, 0)); // Das Feld sollte immer noch von X besetzt sein
    }

    @Test
    public void testCurrentPlayerDisplay() {
        TicTacToe game = new TicTacToe();
        assertEquals('X', game.getCurrentPlayer()); // X beginnt
        game.makeMove(0, 0); // X zieht
        assertEquals('O', game.getCurrentPlayer()); // Nun sollte O am Zug sein
        game.makeMove(0, 1); // O zieht
        assertEquals('X', game.getCurrentPlayer()); // Wechsel zurück zu X
    }

    @Test
    public void testResetBoard() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0); // X macht einen Zug
        game.makeMove(1, 1); // O macht einen Zug
        game.resetBoard();   // Setzt das Spielfeld zurück
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertEquals(' ', game.getMarkAt(row, col)); // Alle Felder sollten leer sein
            }
        }
    }

    @Test
    public void testGameInProgress() {
        TicTacToe game = new TicTacToe();
        assertTrue(game.isInProgress()); // Das Spiel sollte aktiv sein, da noch kein Zug gemacht wurde

        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(0, 2); // X
        assertTrue(game.isInProgress()); // Das Spiel sollte immer noch aktiv sein

        game.makeMove(1, 0); // O
        game.makeMove(1, 1); // X
        game.makeMove(1, 2); // O
        game.makeMove(2, 0); // X
        game.makeMove(2, 1); // O
        game.makeMove(2, 2); // X
        assertFalse(game.isInProgress()); // Das Spiel sollte nicht mehr aktiv sein, da alle Felder besetzt sind
    }
}
