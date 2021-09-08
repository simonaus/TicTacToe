import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    @Test
    public void save_position_as_x_after_firs_move() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(0,0);
        String[][] mockPositions = {{"","",""},{"","",""},{"","",""}};
        mockPositions[0][0] = "x";
        assertEquals(mockPositions, ticTacToe.getPosition());
    }

    @Test
    public void save_position_as_x_after_two_moves() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(0,0);
        ticTacToe.play(1,0);
        String[][] mockPositions = {{"","",""},{"","",""},{"","",""}};
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
        String[][] mockPositions = {{"","",""},{"","",""},{"","",""}};
        mockPositions[0][0] = "x";
        mockPositions[1][0] = "o";
        mockPositions[0][1] = "x";
        assertEquals(mockPositions, ticTacToe.getPosition());
    }

    @Test
    public void doesnt_allow_pieces_to_be_placed_in_used_positions() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(0,0);
        ticTacToe.play(0,0);
        String[][] mockPositions = {{"","",""},{"","",""},{"","",""}};
        mockPositions[0][0] = "x";
        assertEquals(mockPositions, ticTacToe.getPosition());
    }

    @Test
    public void check_that_x_wins_if_3_in_a_row() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(0,0);
        ticTacToe.play(1,0);
        ticTacToe.play(0,1);
        ticTacToe.play(1,1);
        ticTacToe.play(0,2);
        assertEquals(GameStatus.PLAYER_1_WINS, ticTacToe.getGameStatus());
    }

    @Test
    public void check_that_x_wins_if_3_in_a_row_in_second_row() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(1,0);
        ticTacToe.play(0,0);
        ticTacToe.play(1,1);
        ticTacToe.play(0,1);
        ticTacToe.play(1,2);
        assertEquals(GameStatus.PLAYER_1_WINS, ticTacToe.getGameStatus());
    }

    @Test
    public void check_that_x_wins_if_3_in_a_row_in_first_column() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(0,0);
        ticTacToe.play(0,1);
        ticTacToe.play(1,0);
        ticTacToe.play(1,1);
        ticTacToe.play(2,0);
        assertEquals(GameStatus.PLAYER_1_WINS, ticTacToe.getGameStatus());
    }
}
