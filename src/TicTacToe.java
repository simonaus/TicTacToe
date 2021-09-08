public class TicTacToe {
    private String[][] position = new String[3][3];
    private String currentPlayer = "x";

    public void play(int row, int column) {
        if (this.position[row][column] == null) {
            this.position[row][column] = this.currentPlayer;
            this.currentPlayer = this.currentPlayer.equals("x") ? "o" : "x";
        }
    }

    public String[][] getPosition() {
        return this.position;
    }
}
