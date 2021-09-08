public class TicTacToe {
    private PositionStatus[][] position = {{PositionStatus.EMPTY,PositionStatus.EMPTY,PositionStatus.EMPTY},
                                            {PositionStatus.EMPTY,PositionStatus.EMPTY,PositionStatus.EMPTY},
                                             {PositionStatus.EMPTY,PositionStatus.EMPTY,PositionStatus.EMPTY}};
    private PositionStatus currentPlayer = PositionStatus.PLAYER_1;
    private GameStatus gameStatus = GameStatus.IN_PROGRESS;

    public void play(int row, int column) {
        if (this.position[row][column] == PositionStatus.EMPTY) {
            this.position[row][column] = this.currentPlayer;
            check_for_win(row, column);
            if (this.position[1][1] != PositionStatus.EMPTY)
                check_diagonals_for_win();
            this.currentPlayer = this.currentPlayer == PositionStatus.PLAYER_1 ? PositionStatus.PLAYER_2 : PositionStatus.PLAYER_1;
        }
    }

    private void check_diagonals_for_win() {
        if (this.position[0][0].equals(this.position[1][1]) && this.position[1][1].equals(this.position[2][2])) {
            this.gameStatus = this.currentPlayer == PositionStatus.PLAYER_1 ? GameStatus.PLAYER_1_WINS : GameStatus.PLAYER_2_WINS;
        }
        if (this.position[0][2].equals(this.position[1][1]) && this.position[1][1].equals(this.position[2][0])) {
            this.gameStatus = this.currentPlayer == PositionStatus.PLAYER_1 ? GameStatus.PLAYER_1_WINS : GameStatus.PLAYER_2_WINS;
        }
    }

    private void check_for_win(int row, int column) {
        if (this.position[row][0].equals(this.position[row][1]) && this.position[row][1].equals(this.position[row][2])) {
            this.gameStatus = this.currentPlayer == PositionStatus.PLAYER_1 ? GameStatus.PLAYER_1_WINS : GameStatus.PLAYER_2_WINS;
        }
        if (this.position[0][column].equals(this.position[1][column]) && this.position[1][column].equals(this.position[2][column])) {
            this.gameStatus = this.currentPlayer == PositionStatus.PLAYER_1 ? GameStatus.PLAYER_1_WINS : GameStatus.PLAYER_2_WINS;
        }
    }

    public PositionStatus[][] getPosition() {
        return this.position;
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }
}


