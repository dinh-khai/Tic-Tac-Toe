package src.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import src.Constant;

public class SizePanel extends JPanel {
	private TicTacToeUI ui;
	public SizePanel(TicTacToeUI ui) {
		this.ui = ui;
        setLayout(null);
        setBackground(new Color(48, 63, 159));

        JLabel title = new JLabel("BOARD SIZE", SwingConstants.CENTER);
        title.setBounds(50, 60, 300, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        add(title);

        String smallSizeLabel = this.getSizeLabel(Constant.SMALL_SIZE);
        add(createBtn(smallSizeLabel, 110, () -> this.chooseSize(Constant.SMALL_SIZE)));
        
        String mediumSizeLabel = this.getSizeLabel(Constant.MEDIUM_SIZE);
        add(createBtn(mediumSizeLabel, 180, () -> this.chooseSize(Constant.MEDIUM_SIZE)));
        
        String bigSizeLabel = this.getSizeLabel(Constant.BIG_SIZE);
        add(createBtn(bigSizeLabel, 250, () -> this.chooseSize(Constant.BIG_SIZE)));
        
        add(createBtn(Constant.BACK_LABEL, 320, () -> ui.showLevelPanel()));
    }

    JButton createBtn(String text, int y, Runnable r) {
        JButton b = new JButton(text);
        b.setBounds(100, y, 200, 45);
        b.setFont(new Font("Segoe UI", Font.BOLD  , 16));
        b.addActionListener(e -> r.run());
        return b;
    }
    
    private void chooseSize(int size) {
    	ui.setBoardSize(size);
    	ui.cardLayout.show(ui.mainPanel, "MENU");
    }
    
    private String getSizeLabel(int size) {
    	return size + " x " + size;
    }
}
