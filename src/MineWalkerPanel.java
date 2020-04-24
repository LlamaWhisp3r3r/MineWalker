import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MineWalkerPanel extends JPanel {

	
	private static final 
	int MAXLIVES = 1;
	int MAXPOINTS = 999999999;
	int LivesPerMine = 1;
	int PointsPerMine = 10000;
	int PointsPerStep = 100000000;
	
	int Lives;
	int score;
	
	
	
	MineFieldPanel MineFieldPanel;
	
	
	JPanel scorePanel;
	JLabel scoreLabel;
	JPanel keyPanel;
	JPanel controlPanel;
	JButton showMines;
	
	public MineWalkerPanel() {
		addMineFieldPanel();
		ScorePanel();
		KeyPanel();
		ControlPanel();
		newGame();
		giveUp();
		win();
		lose();
		String GameOver;
		resetScore();
		int addPoints;
		int addLives;
		}
	
	
	private class resetButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			newGame();
			
		}
	}


	
	private class showMinesListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			MineFieldPanel.showMines();
			
		}
	}

	private class FieldPanelListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//when fieldpanel is clicked
		}
	}


	public void addMineFieldPanel() {
		MineFieldPanel = new MineFieldPanel(ActionListener);
		this.add(MineFieldPanel);
	}
	
	

	public void ScorePanel() {
		scorePanel = new JPanel();
		scoreLabel = new JLabel();
		scoreLabel.setText("678656578");
		scorePanel.add(scoreLabel);
		this.add(scorePanel);
	}
	
	public void KeyPanel() {
		JButton zeroMines = new JButton();
		zeroMines.setBackground(Color.GREEN);
		zeroMines.setText("0 mines nearby");
		zeroMines.setSize(20, 20);
		keyPanel.add(zeroMines);
		this.add(keyPanel);
    }
	
	public void ControlPanel() {
		controlPanel = new JPanel();
		
		JButton resetBut = new JButton();
		resetBut.setText("Reset");
		resetBut.addActionListener(new resetButtonListener());
		showMines = new JButton();
		showMines.setText("show Mines");
		
		controlPanel.add(resetBut);
		this.add(controlPanel);
				
	}
	
	public void newGame() {
		//clear MineWalkerPanel
		
	}
	
	public void giveUp() {
		
	}
	
	public void win() {
		
	}
	
	public void lose() {
		
	}
	
	public void GameOver() {
		
	}
	
	public void resetScore() {
		
	}
	
	boolean isGameOver() {
		return true;
	}
	
	public void addPoints(int AmountOfPoints) {
		
	}
	
	public void addLives(int AmountOfLives) {
		
	}
	
	int getGridSizeInput() {
		return 1;
	}
	
}