import javax.swing.JPanel;

public class MineWalkerPanel extends JPanel {

	
	int MAXLIVES = 3;
	int MAXPOINTS = 999999999;
	int LivesPerMine = 1;
	int PointsPerMine = 10000;
	int PointsPerStep = 100000000;
	
	int Lives;
	int score;
	
	
	MineWalkerPanel fieldPanel;
	
	
	public MineWalkerPanel() {
		FieldPanel();
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
	





	public void FieldPanel() {
	} 
	public void ScorePanel() {
	}
	public void KeyPanel() {
    }
	public void ControlPanel() {
	}
	public void newGame() {
	}
	public void giveUp() {
	}
	public void win() {
	}
	public void lose() {
	}
	public void GameOver(byte... VariableDeclaratorId) {
	}
	public void resetScore() {
	}
	
	boolean isGameOver() {
		return true;
	}
	public void addPoints(byte... VariableDeclaratorId) {
	}
	public void addLives(byte... VariableDeclaratorId) {
	}
	int getGridSizeInput() {
		return 1;
	}
}

