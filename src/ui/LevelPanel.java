package src.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import src.Constant;
public class LevelPanel extends JPanel {
	private TicTacToeUI ui;
	public LevelPanel(TicTacToeUI ui) {
		this.ui = ui;
        
        setLayout(null);
        setBackground(new Color(48, 63, 159));

        JLabel title = new JLabel("Level", SwingConstants.CENTER);
        title.setBounds(50, 60, 300, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        add(title);

        add(createBtn(Constant.EASY_LEVEL_LABEL, 110, () -> this.chooseLevel(Constant.EASY_LEVEL)));
        
        add(createBtn(Constant.MEDIUM_LEVEL_LABEL, 180, () -> this.chooseLevel(Constant.MEDIUM_LEVEL)));
        
        add(createBtn(Constant.HARD_LEVEL_LABEL, 250, () -> this.chooseLevel(Constant.HARD_LEVEL)));
        
        add(createBtn(Constant.QUIT_LABEL, 320, () -> ui.close()));
    }
	
	JButton createBtn(String text, int y, Runnable r) {
        JButton b = new JButton(text);
        b.setBounds(100, y, 200, 45);
        b.setFont(new Font("Segoe UI", Font.BOLD  , 16));
        b.addActionListener(e -> r.run());
        return b;
    }

	private void chooseLevel(int level) {
		ui.setLevel(level);
		ui.showSizePanel();
	}
}
