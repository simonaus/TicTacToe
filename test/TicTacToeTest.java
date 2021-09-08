import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    @Test
    public void save_position_as_x_after_firs_move() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(0,0);
        String[][] mockPositions = new String[3][3];
        mockPositions[0][0] = "x";
        assertEquals(mockPositions, ticTacToe.getPosition());
    }

    @Test
    public void save_position_as_x_after_two_moves() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(0,0);
        ticTacToe.play(1,0);
        String[][] mockPositions = new String[3][3];
        mockPositions[0][0] = "x";
        mockPositions[1][0] = "o";
        assertEquals(mockPositions, ticTacToe.getPosition());
    }

    @Test
    public void save_position_as_after_three_moves() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(0,0);
        ticTacToe.play(1,0);
        ticTacToe.play(0,1);
        String[][] mockPositions = new String[3][3];
        mockPositions[0][0] = "x";
        mockPositions[1][0] = "o";
        mockPositions[0][1] = "x";
        assertEquals(mockPositions, ticTacToe.getPosition());
    }

    @Test
    public void save_position_as_after_four_moves() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(0,0);
        ticTacToe.play(0,0);
        String[][] mockPositions = new String[3][3];
        mockPositions[0][0] = "x";
        assertEquals(mockPositions, ticTacToe.getPosition());
    }

    @Test
    public void save_position_as_after_four_moves() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(0,0);
        ticTacToe.play(0,0);
        String[][] mockPositions = new String[3][3];
        mockPositions[0][0] = "x";
        assertEquals(mockPositions, ticTacToe.getPosition());
    }
}
