import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MineWalkerPanel extends JPanel {

	private int currentLiveAmount = 5;
	double maxPoints;
	private int livesPerMine = -1;
	private int pointsPerMine = -5;
	private int pointsPerStep = -1;
	
	int lives = 5;
	int score;
	
	
	MineFieldPanel mineFieldPanel;
	
	
	JPanel scorePanel;
	JLabel scoreLabel;
	JPanel keyPanel;
	JPanel controlPanel;
	JButton showMines;
	JLabel winText;
	JLabel livesLabel;
	
	public MineWalkerPanel() {
		newGame();
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
			mineFieldPanel.showMines();
			
		}
	}



	public void addMineFieldPanel() {
		mineFieldPanel = new MineFieldPanel(15, new ButtonActionListener());
		this.add(mineFieldPanel);
	}
	
	

	public void addScorePanel() {
		scorePanel = new JPanel();
		scorePanel.setLayout(new GridLayout(2, 1, 10, 10));
		scoreLabel = new JLabel();
		livesLabel = new JLabel();
		setMaxPoints();
		score = (int) maxPoints;
		scoreLabel.setText("Score: " + score);
		livesLabel.setText("Lives: " + lives);
		scorePanel.add(scoreLabel);
		scorePanel.add(livesLabel);
		this.add(scorePanel);
	}
	
	public void updateScorePanel() {
		scorePanel.remove(scoreLabel);
		scorePanel.remove(livesLabel);
		System.out.println("Entered UpdateScorePanel()");
		scoreLabel = new JLabel();
		livesLabel = new JLabel();
		scoreLabel.setText("Score: " + score);
		livesLabel.setText("Lives: " + lives);
		scorePanel.add(scoreLabel);
		scorePanel.add(livesLabel);
		
		scorePanel.revalidate();
	}
	
	public void addKeyPanel() {
		keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(5, 1));
		keyPanel.setPreferredSize(new Dimension(150,300));
		JButton zeroMines = new JButton();
		zeroMines.setBackground(Color.GREEN);
		zeroMines.setText("0 Mines Nearby");
		JButton oneMine = new JButton();
		oneMine.setBackground(Color.yellow);
		oneMine.setText("1 Mine Nearby");
		JButton twoMine = new JButton();
		twoMine.setBackground(Color.orange);
		twoMine.setText("2 Mine Nearby");
		JButton threeMine = new JButton();
		threeMine.setBackground(Color.red);
		threeMine.setText("3 Mine Nearby");
		JButton mine = new JButton();
		mine.setBackground(Color.black);
		mine.setText("Exploded Mine");
		keyPanel.add(zeroMines);
		keyPanel.add(oneMine);
		keyPanel.add(twoMine);
		keyPanel.add(threeMine);
		keyPanel.add(mine);
		this.add(keyPanel);
    }
	
	public void addControlPanel() {
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
		this.removeAll();
		// Basic setup process
		addMineFieldPanel();
		addScorePanel();
		addKeyPanel();
		addControlPanel();
		
		this.revalidate();
	}
	
	public void giveUp() {
		System.out.println("Abel is a quitter");
		
	}
	
	public void win() {
		winText = new JLabel();
		winText.setText("Abel is Gay");
		this.add(winText);
		this.revalidate();
	}
	
	private void setMaxPoints() {
		
		int gridSize = mineFieldPanel.getGridSize();
		maxPoints = Math.pow(gridSize, 2) - mineFieldPanel.getNumberOfMines();
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
	
	private class ButtonActionListener implements ActionListener {
		

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MineFieldButton button = (MineFieldButton) arg0.getSource();
				
				if(button.hasActive()) {
					if(button.isMine()) {
						button.setColor(Color.black);
						lives--;
						updateScorePanel();
					}else {
						Color buttonColor = button.getNearbyMineColor();
						button.setColor(buttonColor);
						button.activate();
						score--;
						updateScorePanel();
					}
				}
				
			}
	}
	

}