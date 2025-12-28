package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIPlayer {

	private char ai = 'O';
	private char human = 'X';
	private int MAX_DEPTH;
	private Random rand = new Random();

	private int difficulty = Constant.HARD_LEVEL; // default Hard
	private int boardSize = Constant.SMALL_SIZE;

	public AIPlayer(char ai, char human, int difficulty, int boardSize) {
		this.ai = ai;
		this.human = human;
		this.difficulty = difficulty;
		this.boardSize = boardSize;
		if (boardSize == 3)
			MAX_DEPTH = 9;
		else if (boardSize == 4)
			MAX_DEPTH = 5;
		else
			MAX_DEPTH = 3;

	}

	public void setDifficulty(int level) {
		this.difficulty = level;
	}
	
	public void setCharAi(char c) {
		this.ai = c;
	}
	
	public void setCharHuman(char c) {
		this.human = c;
	}

	// -------------------------
	// PUBLIC: choose best move
	// -------------------------
	public int[] getBestMove(Board board) {

		switch (difficulty) {

		case 1: // EASY
			return randomMove(board);

		case 2: // MEDIUM
			int[] clever = smartMove(board);
			if (clever != null)
				return clever;
			return randomMove(board);

		case 3: // HARD (minimax)
		default:
			return minimaxMove(board);
		}
	}

	// -------------------------
	// EASY MODE → RANDOM MOVE
	// -------------------------
	private int[] randomMove(Board board) {
		List<int[]> moves = new ArrayList<>();
		char[][] b = board.get();

		for (int r = 0; r < boardSize; r++)
			for (int c = 0; c < boardSize; c++)
				if (b[r][c] == ' ')
					moves.add(new int[] { r, c });

		return moves.get(rand.nextInt(moves.size()));
	}

	// -------------------------
	// MEDIUM MODE → WIN OR BLOCK
	// -------------------------
	private int[] smartMove(Board board) {
		char[][] b = board.get();

		// 1. AI CAN WIN → take winning move
		for (int r = 0; r < boardSize; r++)
			for (int c = 0; c < boardSize; c++)
				if (b[r][c] == ' ') {
					b[r][c] = ai;
					if (board.hasWon(ai)) {
						b[r][c] = ' ';
						return new int[] { r, c };
					}
					b[r][c] = ' ';
				}

		// 2. AI BLOCK PLAYER
		for (int r = 0; r < boardSize; r++)
			for (int c = 0; c < boardSize; c++)
				if (b[r][c] == ' ') {
					b[r][c] = human;
					if (board.hasWon(human)) {
						b[r][c] = ' ';
						return new int[] { r, c };
					}
					b[r][c] = ' ';
				}

		return null;
	}

	// -------------------------
	// HARD MODE → MINIMAX
	// -------------------------
	private int[] minimaxMove(Board board) {
		int bestScore = Integer.MIN_VALUE;
		int[] bestMove = { -1, -1 };

		char[][] b = board.get();

		for (int r = 0; r < boardSize; r++)
			for (int c = 0; c < boardSize; c++)
				if (b[r][c] == ' ') {
					b[r][c] = ai;
					int score = minimax(board, 0, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
					b[r][c] = ' ';

					if (score > bestScore) {
						bestScore = score;
						bestMove[0] = r;
						bestMove[1] = c;
					}
				}

		return bestMove;
	}

	private int minimax(Board board, int depth, boolean maximize, int alpha, int beta) {

		if (board.hasWon(ai))
			return 100 - depth;
		if (board.hasWon(human))
			return depth - 100;
		if (board.isFull() || depth == MAX_DEPTH)
			return evaluate(board);

		char[][] b = board.get();

		if (maximize) {
			int best = Integer.MIN_VALUE;

			for (int r = 0; r < boardSize; r++)
				for (int c = 0; c < boardSize; c++)
					if (b[r][c] == ' ') {
						b[r][c] = ai;
						int val = minimax(board, depth + 1, false, alpha, beta);
						b[r][c] = ' ';

						best = Math.max(best, val);
						alpha = Math.max(alpha, best);
						if (beta <= alpha)
							return best;
					}
			return best;

		} else {
			int best = Integer.MAX_VALUE;

			for (int r = 0; r < boardSize; r++)
				for (int c = 0; c < boardSize; c++)
					if (b[r][c] == ' ') {
						b[r][c] = human;
						int val = minimax(board, depth + 1, true, alpha, beta);
						b[r][c] = ' ';

						best = Math.min(best, val);
						beta = Math.min(beta, best);
						if (beta <= alpha)
							return best;
					}
			return best;
		}
	}

	private int evaluate(Board board) {
		int score = 0;
		score += countLines(board, ai);
		score -= countLines(board, human);
		return score;
	}

	private int countLines(Board board, char player) {
		int count = 0;
		return count;
	}
}
