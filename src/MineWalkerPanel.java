import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MineWalkerPanel extends JPanel {

	
	private static final String Add = null;
	int MAXLIVES = 3;
	int MAXPOINTS = 999999999;
	int LivesPerMine = 1;
	int PointsPerMine = 10000;
	int PointsPerStep = 100000000;
	
	int Lives;
	int score;
	
	
	MineWalkerPanel fieldPanel;
	MineFieldPanel MineFieldPanel;
	
	JPanel scorePanel;
	JLabel scoreLabel;
	
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
	


	private class FieldPanelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//when fieldpanel is clicked
		}
	}


	public void addMineFieldPanel() {
		MineFieldPanel = new MineFieldPanel();
		this.add(MineFieldPanel);
	}
	
	public void ScorePanel() {
		scorePanel = new JPanel();
		scoreLabel = new JLabel();
		scoreLabel.setText("hello");
		scorePanel.add(scoreLabel);
		this.add(scorePanel);
	}
	
	public void KeyPanel() {
		
    }
	
	public void ControlPanel() {
		
	}
	
	public void newGame() {
		//clear MineWalkerPanel
		
	}
	
	public void giveUp() {
		
	}
	
	public void win() {
		System.out.println("You win");
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