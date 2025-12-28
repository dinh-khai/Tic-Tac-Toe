package src.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import src.Constant;

public class MenuPanel extends JPanel{
	public MenuPanel(TicTacToeUI ui) {
		setLayout(null);
        setBackground(new Color(48, 63, 159));

        JLabel title = new JLabel("Game", SwingConstants.CENTER);
        title.setBounds(50, 60, 300, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        add(title);

        add(createBtn(Constant.NEW_GAME_LABEL, 110, () -> ui.showGamePanel()));
        add(createBtn(Constant.BACK_LABEL, 180, () -> ui.showSizePanel()));
    }
	
	JButton createBtn(String text, int y, Runnable r) {
        JButton b = new JButton(text);
        b.setBounds(100, y, 200, 45);
        b.setFont(new Font("Segoe UI", Font.BOLD  , 16));
        b.addActionListener(e -> r.run());
        return b;
    }
}
