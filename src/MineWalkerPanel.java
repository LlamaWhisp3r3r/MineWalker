import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
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
	private int secretNumber = 0;
	private int extraSecretNumber = 0;
	private Timer timer = new Timer();
	
	int lives = 5;
	int score;
	
	
	MineFieldPanel mineFieldPanel;
	
	
	JPanel scorePanel;
	JLabel scoreLabel;
	JPanel keyPanel;
	JPanel controlPanel;
	JButton showMines;
	JButton resetBut;
	JLabel winText;
	JLabel livesLabel;
	JLabel timerTime;
	JButton zeroMines;
	JButton oneMine;
	JButton twoMine;
	JButton threeMine;
	JButton mine;
	int minutes = 0;
	int seconds = 0;
	boolean pastFlag = false;
	
	
	public MineWalkerPanel() {
		newGame();
		TimerTask updateTimer = new UpdateTimer();
		timer.scheduleAtFixedRate(updateTimer, 1000, 1000);
		}
	
	
	private class resetButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			newGame();
			
		}
	}
	
	private class ShowPathListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			mineFieldPanel.showPath();
			
		}
	}
	
	private class HiddenSecretThing implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			secretNumber++;
			if(secretNumber == 5) {
				mineFieldPanel.showMines();
				secretNumber = 0;
			}
		}
		
	}
	
	private class ExtraHiddenSecretThing implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			extraSecretNumber++;
			if(extraSecretNumber == 5) {
				mineFieldPanel.showPath();
				extraSecretNumber = 0;
			}
		}
	}



	public void addMineFieldPanel() {
		mineFieldPanel = new MineFieldPanel(10, new ButtonActionListener());
		this.add(mineFieldPanel);
	}
	
	

	public void addScorePanel() {
		minutes = 0;
		seconds = 0;
		lives = 5;
		scorePanel = new JPanel();
		scorePanel.setLayout(new GridLayout(5, 1, 10, 10));
		scoreLabel = new JLabel();
		livesLabel = new JLabel();
		timerTime = new JLabel();
		setMaxPoints();
		score = (int) maxPoints;
		scoreLabel.setText("Score: " + score);
		livesLabel.setText("Lives: " + lives);
		timerTime.setText("Time: 00.00");
		
		resetBut = new JButton();
		resetBut.setText("Reset");
		resetBut.addActionListener(new resetButtonListener());
		showMines = new JButton();
//		showMines.setText("show Mines");
		
		scorePanel.add(timerTime);
		scorePanel.add(scoreLabel);
		scorePanel.add(livesLabel);
		scorePanel.add(resetBut);
//		scorePanel.add(showMines);
		this.add(scorePanel);
	}
	
	public void addKeyPanel() {
		keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(5, 1));
		keyPanel.setPreferredSize(new Dimension(150,300));
		zeroMines = new JButton();
		zeroMines.setBackground(Color.GREEN);
		zeroMines.setText("0 Mines Nearby");
		oneMine = new JButton();
		oneMine.setBackground(Color.yellow);
		oneMine.setText("1 Mine Nearby");
		twoMine = new JButton();
		twoMine.setBackground(Color.orange);
		twoMine.setText("2 Mine Nearby");
		twoMine.addActionListener(new ExtraHiddenSecretThing());
		threeMine = new JButton();
		threeMine.setBackground(Color.red);
		threeMine.setText("3 Mine Nearby");
		mine = new JButton();
		mine.setBackground(Color.black);
		mine.setText("Exploded Mine");
		mine.addActionListener(new HiddenSecretThing());
		keyPanel.add(zeroMines);
		keyPanel.add(oneMine);
		keyPanel.add(twoMine);
		keyPanel.add(threeMine);
		keyPanel.add(mine);
		this.add(keyPanel);
    }
	
	
	public void newGame() {
		this.removeAll();
		// Basic setup process
		addMineFieldPanel();
		addScorePanel();
		addKeyPanel();
		
		this.updateUI();
	}
	
	public void giveUp() {
		System.out.println("Abel is a quitter");
		
	}
	
	public void win() {
		System.out.println("Removed All");
		this.remove(keyPanel);
		this.remove(scorePanel);
		JPanel panelDude = new JPanel();
		panelDude.setLayout(new GridLayout(4, 1, 10, 10));
		JLabel winText = new JLabel();
		JLabel minutesLabel = new JLabel();
		JLabel secondsLabel = new JLabel();
		JButton restartButton = new JButton();
		restartButton.setText("Restart Game");
		restartButton.addActionListener(new resetButtonListener());
		secondsLabel.setText("            Seconds: " + seconds);
		minutesLabel.setText("            Minutes: " + minutes);
		winText.setText("====Yay You Won!=====");
		panelDude.add(winText);
		panelDude.add(minutesLabel);
		panelDude.add(secondsLabel);
		panelDude.add(restartButton);
		this.add(panelDude);
		this.updateUI();
	}
	
	private void setMaxPoints() {
		
		int gridSize = mineFieldPanel.getGridSize();
		maxPoints = Math.pow(gridSize, 2) - mineFieldPanel.getNumberOfMines();
	}
	
	public void lose() {
		System.out.println("Removed All");
		this.remove(keyPanel);
		this.remove(scorePanel);
		JPanel panelDude = new JPanel();
		panelDude.setLayout(new GridLayout(4, 1, 10, 10));
		JLabel winText = new JLabel();
		JLabel minutesLabel = new JLabel();
		JLabel secondsLabel = new JLabel();
		JButton resetButton = new JButton();
		secondsLabel.setText("            Seconds: " + seconds);
		minutesLabel.setText("            Minutes: " + minutes);
		winText.setText("You Lost... You Only Lasted:");
		resetButton.setText("Restart");
		resetButton.addActionListener(new resetButtonListener());
		panelDude.add(winText);
		panelDude.add(minutesLabel);
		panelDude.add(secondsLabel);
		panelDude.add(resetButton);
		this.add(panelDude);
		this.updateUI();
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
				
				if(button.isEnd() && button.hasActive()) {
					win();
				}else {
				
				if(button.hasActive()) {
					if(button.isMine()) {
						button.setColor(Color.black);
						lives--;
						if(lives == 0) {
							lose();
						}
					}else {
						Color buttonColor = button.getNearbyMineColor();
						button.setColor(buttonColor);
						button.activate();
						score--;
					}
				}
				}
				updateScorePanel();
				
			}
	}
	
	public void updateScorePanel() {
		scorePanel.remove(resetBut);
//		scorePanel.remove(showMines);
		scorePanel.remove(timerTime);
		scorePanel.remove(scoreLabel);
		scorePanel.remove(livesLabel);
		resetBut = new JButton();
		timerTime = new JLabel();
		scoreLabel = new JLabel();
		livesLabel = new JLabel();
		resetBut.setText("Reset");
		resetBut.addActionListener(new resetButtonListener());
		showMines = new JButton();
		showMines.addActionListener(new ShowMinesListener());
		showMines.setText("Show Mines");
		timerTime.setText("Time: " + minutes + ":" + seconds);
		scoreLabel.setText("Score: " + score);
		livesLabel.setText("Lives: " + lives);
		scorePanel.add(timerTime);
		scorePanel.add(scoreLabel);
		scorePanel.add(livesLabel);
		scorePanel.add(resetBut);
//		scorePanel.add(showMines);
		scorePanel.updateUI();
	}
	
	private class ShowMinesListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mineFieldPanel.showMines();
		}
		
	}
	
	private class UpdateTimer extends TimerTask {

		@Override
		public void run() {
				seconds++;
				if(seconds == 60) {
					seconds = 0;
					minutes++;
				}
				updateScorePanel();
		}
			
		
	}
	

}