package src.ui;

import javax.swing.*;

import src.AIPlayer;
import src.Board;
import src.Constant;

import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {
	private JButton[][] buttons;
	private Board board;
    private AIPlayer aiPlayer;
    private final int SIZE_UNIT = 150;
    private TicTacToeUI ui;
    private char aiChar = 'O';
    private char humanChar = 'X';

	public GamePanel(TicTacToeUI ui) {
		this.ui = ui;
	}

	private void handleMove(JButton btn, int row, int col) {
		if (!btn.getText().equals(""))
			return;

		btn.setText(humanChar + "");
		board.makeMove(row, col, humanChar);
		if (board.hasWon(humanChar)) {
			this.showDialog(Constant.MESSAGE_WIN);
			return;
        }

		if (board.isFull()) {
			this.showDialog(Constant.MESSAGE_DRAW);
            return;
        }
		
		int[] move = aiPlayer.getBestMove(board);
		board.makeMove(move[0], move[1], aiChar);
		buttons[move[0]][move[1]].setText(aiChar + "");
		if (board.hasWon(aiChar)) {
			this.showDialog(Constant.MESSAGE_LOSS);
			return;
        }
		
		if (board.isFull()) {
			this.showDialog(Constant.MESSAGE_DRAW);
            return;
        }
	}
	
	@Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);

        if (visible) {
            onShow();
        }
    }
	
	private void onShow() {
		int boardSize = ui.getBoardSize();
		int level = ui.getLevel();
		this.board = new Board(boardSize);
		this.aiPlayer = new AIPlayer(aiChar, humanChar, level, boardSize);
		this.buttons = new JButton[boardSize][boardSize];

		setSize(SIZE_UNIT * boardSize, SIZE_UNIT * boardSize);
		setLayout(new GridLayout(boardSize, boardSize));
		

		Font font = new Font("Arial", Font.BOLD, 60);

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				int r = i;
				int c = j;
				JButton btn = new JButton("");
				btn.setFont(font);
				buttons[i][j] = btn;
				add(btn);

				btn.addActionListener(e -> handleMove(btn, r, c));
			}
		}
	}
	
	private void showDialog(String message) {
		JOptionPane.showMessageDialog(this, message);
		this.closeDialogHandle();
	}
	
	private void closeDialogHandle() {
		ui.showMenuPanel();
		removeAll();
		revalidate();
		repaint();
	}
}