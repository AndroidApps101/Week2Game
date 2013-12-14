package codeguru.connect4;

public class Board {

	public enum State { EMPTY, PLAYER1, PLAYER2};
	public static int ROW_COUNT = 6;
	public static int COL_COUNT = 7;
	
	private State[][] board = new State[ROW_COUNT][COL_COUNT];
	private int[] next = new int[COL_COUNT];
	
	public Board() {
		for (int i = 0; i < ROW_COUNT; ++i) {
			for (int j = 0; j < COL_COUNT; ++j) {
				this.board[i][j] = State.EMPTY;
			}
		}
	}
	
	public State getState(int row, int col) {
		return board[row][col];
	}
}
