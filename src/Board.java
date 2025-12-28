package src;

public class Board {
	private char[][] board;
	private int size = Constant.SMALL_SIZE;

	public Board(int size) {
		this.size = size;
		this.board = new char[size][size];
		this.reset();
	}

	public void reset() {
		for (int r = 0; r < this.size; r++)
			for (int c = 0; c < this.size; c++)
				board[r][c] = ' ';
	}

	public char[][] get() {
		return board;
	}

	public void makeMove(int row, int col, char p) {
		board[row][col] = p;
	}

	public boolean isFull() {
		for (char[] row : board)
			for (char cell : row)
				if (cell == ' ')
					return false;
		return true;
	}

	public boolean hasWon(char p) {
		boolean hasWon = true;
		// rows + cols
		for (int i = 0; i < size; i++) {
			hasWon = true;
			for (int j = 0; j < size; j++) {
				if (board[i][j] != p) {
					hasWon = false;
					break;
				}
			}

			if (hasWon) {
				return hasWon;
			}

			hasWon = true;
			for (int j = 0; j < size; j++) {
				if (board[j][i] != p) {
					hasWon = false;
					break;
				}
			}

			if (hasWon) {
				return hasWon;
			}
		}

		// diagonals
		hasWon = true;
		for (int i = 0; i < size; i++) {
			if (board[i][i] != p) {
				hasWon = false;
				break;
			}
		}

		if (hasWon) {
			return hasWon;
		}

		hasWon = true;
		for (int i = 0; i < size; i++) {
			if (board[i][size - 1 - i] != p) {
				hasWon = false;
				break;
			}
		}

		return hasWon;
	}
}
