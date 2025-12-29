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
		// kiểm tra theo hàng và cột
		for (int i = 0; i < size; i++) {
	        boolean row = true, col = true;
	        for (int j = 0; j < size; j++) {
	            row &= board[i][j] == p;
	            col &= board[j][i] == p;
	        }
	        if (row || col) return true;
	    }
		
		// kiểm tra đường chéo
		boolean diag1 = true, diag2 = true;
	    for (int i = 0; i < size; i++) {
	        diag1 &= board[i][i] == p;
	        diag2 &= board[i][size - 1 - i] == p;
	    }
		
		return diag1 || diag2;
	}
}
