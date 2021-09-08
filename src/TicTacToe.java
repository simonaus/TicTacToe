public class TicTacToe {
    private PositionStatus[][] board = {{PositionStatus.EMPTY,PositionStatus.EMPTY,PositionStatus.EMPTY},
                                            {PositionStatus.EMPTY,PositionStatus.EMPTY,PositionStatus.EMPTY},
                                             {PositionStatus.EMPTY,PositionStatus.EMPTY,PositionStatus.EMPTY}};
    private PositionStatus currentPlayer = PositionStatus.PLAYER_1;
    private GameStatus gameStatus = GameStatus.IN_PROGRESS;

    public void play(int row, int column) {
            boolean isWon = false;
        if (this.board[row][column] == PositionStatus.EMPTY) {
            this.board[row][column] = this.currentPlayer;
            if (check_for_win(row, column)) this.gameStatus = this.currentPlayer == PositionStatus.PLAYER_1 ? GameStatus.PLAYER_1_WINS : GameStatus.PLAYER_2_WINS;;
//            if (this.board[1][1] != PositionStatus.EMPTY) check_diagonals_for_win();
            checkForDraw();
            this.currentPlayer = this.currentPlayer == PositionStatus.PLAYER_1 ? PositionStatus.PLAYER_2 : PositionStatus.PLAYER_1;
        }
    }

//    private void check_diagonals_for_win() {
//        if (this.board[0][0].equals(this.board[1][1]) && this.board[1][1].equals(this.board[2][2])) {
//            this.gameStatus = this.currentPlayer == PositionStatus.PLAYER_1 ? GameStatus.PLAYER_1_WINS : GameStatus.PLAYER_2_WINS;
//        }
//        if (this.board[0][2].equals(this.board[1][1]) && this.board[1][1].equals(this.board[2][0])) {
//            this.gameStatus = this.currentPlayer == PositionStatus.PLAYER_1 ? GameStatus.PLAYER_1_WINS : GameStatus.PLAYER_2_WINS;
//        }
//    }

    private boolean check_for_win(int row, int column) {
//        if (this.board[row][0].equals(this.board[row][1]) && this.board[row][1].equals(this.board[row][2])) {
//            this.gameStatus = this.currentPlayer == PositionStatus.PLAYER_1 ? GameStatus.PLAYER_1_WINS : GameStatus.PLAYER_2_WINS;
//        }
//        if (this.board[0][column].equals(this.board[1][column]) && this.board[1][column].equals(this.board[2][column])) {
//            this.gameStatus = this.currentPlayer == PositionStatus.PLAYER_1 ? GameStatus.PLAYER_1_WINS : GameStatus.PLAYER_2_WINS;
//        }
//        if (checkIf3PositionsMatch(new int[] {row, 0},new int[] {row, 1}, new int[] {row, 2})) return true;
//        if (checkIf3PositionsMatch(new int[] {0, column},new int[] {1, column}, new int[] {2, column})) return true;
        boolean isRowMatch = checkIf3PositionsMatch(new int[] {row, 0},new int[] {row, 1}, new int[] {row, 2});
        boolean isColumnMatch = checkIf3PositionsMatch(new int[] {0, column},new int[] {1, column}, new int[] {2, column});
        boolean isBackwardsDiagonalMatch = false;
        boolean isForwardsDiagonalMatch = false;
        if (this.board[1][1] != PositionStatus.EMPTY) {
//            if (checkIf3PositionsMatch(new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 2})) return true;
//            if (checkIf3PositionsMatch(new int[]{0, 2}, new int[]{1, 1}, new int[]{2, 0})) return true;
            isBackwardsDiagonalMatch = checkIf3PositionsMatch(new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 2});
            isForwardsDiagonalMatch = checkIf3PositionsMatch(new int[]{0, 2}, new int[]{1, 1}, new int[]{2, 0});
        }
        return (isRowMatch || isColumnMatch || isBackwardsDiagonalMatch || isForwardsDiagonalMatch);
    }

    private boolean checkIf3PositionsMatch(int[] position1, int[] position2 ,int[] position3) {
        return this.board[position1[0]][position1[1]].equals(this.board[position2[0]][position2[1]]) && this.board[position2[0]][position2[1]].equals(this.board[position3[0]][position3[1]]);
    }

    private void checkForDraw() {
        for (PositionStatus[] row: board) {
            for (PositionStatus positionSpot: row) {
                if (positionSpot.equals(PositionStatus.EMPTY)) return;
            }
        }
        this.gameStatus = GameStatus.DRAW;
    }

    public PositionStatus[][] getPosition() {
        return this.board;
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }
}


