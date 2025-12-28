package src;

import javax.swing.SwingUtilities;

import src.ui.TicTacToeUI;

public class Main {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
            new TicTacToeUI().setVisible(true);
        });
    }
}
