package src.ui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import src.Constant;

public class TicTacToeUI extends JFrame {
	CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);
    int boardSize = Constant.SMALL_SIZE;
    int level = Constant.HARD_LEVEL;
    private final String LEVEL_PANEL = "LEVEL";
    private final String SIZE_PANEL = "SIZE";
    private final String MENU_PANEL = "MENU";
    private final String GAME_PANEL = "GAME";

    public TicTacToeUI() {
        setTitle(Constant.MAIN_FRAME_TITLE);
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        LevelPanel levelPanel = new LevelPanel(this);
        SizePanel sizePanel = new SizePanel(this);
        MenuPanel menuPanel = new MenuPanel(this);
        GamePanel playPanel = new GamePanel(this);

        mainPanel.add(levelPanel, LEVEL_PANEL);
        mainPanel.add(sizePanel, SIZE_PANEL);
        mainPanel.add(menuPanel, MENU_PANEL);
        mainPanel.add(playPanel, GAME_PANEL);

        add(mainPanel);
        cardLayout.show(mainPanel, "LEVEL");
    }
    
    public void setBoardSize(int size) {
    	this.boardSize = size;
    }
    
    public int getBoardSize() {
    	return boardSize;
    }
    
    public void setLevel(int level) {
    	this.level = level;
    }
    
    public int getLevel() {
    	return level;
    }
    
    public void showLevelPanel() {
    	this.cardLayout.show(mainPanel, LEVEL_PANEL);
    }
    
    public void showSizePanel() {
    	this.cardLayout.show(mainPanel, SIZE_PANEL);
    }
    
    public void showMenuPanel() {
    	this.cardLayout.show(mainPanel, MENU_PANEL);
    }
    
    public void showGamePanel() {
    	this.cardLayout.show(mainPanel, GAME_PANEL);
    }
    
    public void close() {
    	this.dispose();
    }
}
