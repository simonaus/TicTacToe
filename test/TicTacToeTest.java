import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    TicTacToe ticTacToe;
    PositionStatus[][] mockPositions;

    @BeforeEach
    public void init() {
        ticTacToe = new TicTacToe();
        mockPositions = new PositionStatus[][]{{PositionStatus.EMPTY, PositionStatus.EMPTY, PositionStatus.EMPTY},
                                                {PositionStatus.EMPTY, PositionStatus.EMPTY, PositionStatus.EMPTY},
                                                 {PositionStatus.EMPTY, PositionStatus.EMPTY, PositionStatus.EMPTY}};
    }

    @Test
    public void save_position_as_x_after_firs_move() {
        ticTacToe.play(0,0);
        mockPositions[0][0] = PositionStatus.PLAYER_1;
        assertEquals(mockPositions, ticTacToe.getPosition());
    }

    @Test
    public void save_position_as_x_after_two_moves() {
        ticTacToe.play(0,0);
        ticTacToe.play(1,0);
        mockPositions[0][0] = PositionStatus.PLAYER_1;
        mockPositions[1][0] = PositionStatus.PLAYER_2;
        assertEquals(mockPositions, ticTacToe.getPosition());
    }

    @Test
    public void save_position_as_after_three_moves() {
        ticTacToe.play(0,0);
        ticTacToe.play(1,0);
        ticTacToe.play(0,1);
        mockPositions[0][0] = PositionStatus.PLAYER_1;
        mockPositions[1][0] = PositionStatus.PLAYER_2;
        mockPositions[0][1] = PositionStatus.PLAYER_1;
        assertEquals(mockPositions, ticTacToe.getPosition());
    }

    @Test
    public void doesnt_allow_pieces_to_be_placed_in_used_positions() {
        ticTacToe.play(0,0);
        ticTacToe.play(0,0);
        mockPositions[0][0] = PositionStatus.PLAYER_1;
        assertEquals(mockPositions, ticTacToe.getPosition());
    }

    @Test
    public void check_that_x_wins_if_3_in_a_row() {
        ticTacToe.play(0,0);
        ticTacToe.play(1,0);
        ticTacToe.play(0,1);
        ticTacToe.play(1,1);
        ticTacToe.play(0,2);
        assertEquals(GameStatus.PLAYER_1_WINS, ticTacToe.getGameStatus());
    }

    @Test
    public void check_that_x_wins_if_3_in_a_row_in_second_row() {
        ticTacToe.play(1,0);
        ticTacToe.play(0,0);
        ticTacToe.play(1,1);
        ticTacToe.play(0,1);
        ticTacToe.play(1,2);
        assertEquals(GameStatus.PLAYER_1_WINS, ticTacToe.getGameStatus());
    }

    @Test
    public void check_that_x_wins_if_3_in_a_row_in_first_column() {
        ticTacToe.play(0,0);
        ticTacToe.play(0,1);
        ticTacToe.play(1,0);
        ticTacToe.play(1,1);
        ticTacToe.play(2,0);
        assertEquals(GameStatus.PLAYER_1_WINS, ticTacToe.getGameStatus());
    }

    @Test
    public void check_that_x_wins_if_3_in_a_row_in_backwards_diagonal() {
        ticTacToe.play(0,0);
        ticTacToe.play(0,1);
        ticTacToe.play(1,1);
        ticTacToe.play(1,0);
        ticTacToe.play(2,2);
        assertEquals(GameStatus.PLAYER_1_WINS, ticTacToe.getGameStatus());
    }

    @Test
    public void check_that_x_wins_if_3_in_a_row_in_forward_diagonal() {
        ticTacToe.play(0,2);
        ticTacToe.play(0,1);
        ticTacToe.play(1,1);
        ticTacToe.play(1,0);
        ticTacToe.play(2,0);
        assertEquals(GameStatus.PLAYER_1_WINS, ticTacToe.getGameStatus());
    }

    @Test
    public void check_that_0_wins_if_3_in_a_row() {
        ticTacToe.play(2,2);
        ticTacToe.play(0,0);
        ticTacToe.play(1,1);
        ticTacToe.play(0,1);
        ticTacToe.play(2,0);
        ticTacToe.play(0,2);

        assertEquals(GameStatus.PLAYER_2_WINS, ticTacToe.getGameStatus());
    }
}
