public class TicTacToe {
    private PositionStatus[][] position = {{PositionStatus.EMPTY,PositionStatus.EMPTY,PositionStatus.EMPTY},
                                            {PositionStatus.EMPTY,PositionStatus.EMPTY,PositionStatus.EMPTY},
                                             {PositionStatus.EMPTY,PositionStatus.EMPTY,PositionStatus.EMPTY}};
    private PositionStatus currentPlayer = PositionStatus.PLAYER_1;
    private GameStatus gameStatus = GameStatus.IN_PROGRESS;

    public void play(int row, int column) {
        if (this.position[row][column] == PositionStatus.EMPTY) {
            this.position[row][column] = this.currentPlayer;
            this.currentPlayer = this.currentPlayer == PositionStatus.PLAYER_1 ? PositionStatus.PLAYER_2 : PositionStatus.PLAYER_1;
            if (this.position[row][0].equals(this.position[row][1]) && this.position[row][1].equals(this.position[row][2])) {
                this.gameStatus = GameStatus.PLAYER_1_WINS;
            }
            if (this.position[0][column].equals(this.position[1][column]) && this.position[1][column].equals(this.position[2][column])) {
                this.gameStatus = GameStatus.PLAYER_1_WINS;
            }
        }
    }

    public PositionStatus[][] getPosition() {
        return this.position;
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }
}


