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


	
	private class showMinesListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			mineFieldPanel.showMines();
			
		}
	}



	public void addMineFieldPanel() {
		mineFieldPanel = new MineFieldPanel(5, new ButtonActionListener());
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
		showMines.setText("show Mines");
		
		scorePanel.add(timerTime);
		scorePanel.add(scoreLabel);
		scorePanel.add(livesLabel);
		scorePanel.add(resetBut);
		scorePanel.add(showMines);
		this.add(scorePanel);
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
	
	
	public void newGame() {
		this.removeAll();
		// Basic setup process
		addMineFieldPanel();
		addScorePanel();
		addKeyPanel();
		
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
					}else {
						Color buttonColor = button.getNearbyMineColor();
						button.setColor(buttonColor);
						button.activate();
						score--;
					}
				}
				
			}
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
				scorePanel.remove(resetBut);
				scorePanel.remove(showMines);
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
				scorePanel.add(showMines);
				scorePanel.revalidate();
				pastFlag = !pastFlag;
		}
			
		
	}
	

}