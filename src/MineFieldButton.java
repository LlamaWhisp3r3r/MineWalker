import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MineFieldButton extends JButton {

/* I believe I won't be able to make it to tomorrow's meeting. I would notify
 * Mr. Endicott, but I personally have no access to my phone, and I don't know exactly
 * when I will get access. I will try my best to show up, but I cannot promise much.
 * I apologize and I hope you guys understand.
 * 	-- Koen Webb
 */
	
	public MineFieldButton(ActionListener actionListener) {
		ActionListener listen = actionListener;
	}
	
	public void visit() {
		visited = true;
	}
	
	public void addNeighbor(MineFieldButton button) {
		
	}
	
	//You should know what these do... Maybe.
	public void setIsStart(boolean newStart) {
		isStart = newStart;
	}
	
	public boolean isStart() {
		return isStart;
	}
	
	public void setIsEnd(boolean newEnd) {
		isEnd = newEnd;
	}
	
	public boolean isEnd() {
		return isEnd;
	}
	
	public void setIsMine(boolean newMine) {
		isMine = newMine;
	}
	
	public boolean isMine() {
		return isMine;
	}
	
	public void setOnPath(boolean newPath) {
		isOnPath = newPath;
	}
	
	public boolean isOnPath() {
		return isOnPath;
	}
	
	public void showMine() {
		if (isMine = true) {
			ACTIVE_COLOR = MINE_COLOR;
			mineShowing = true;
		}
	}
	
	public void hideMine() {
		if (mineShowing = true) {
			ACTIVE_COLOR = DEFAULT_COLOR;
			mineShowing = false;
		}
	}
	
	public void showPath() {
		if (isOnPath = true) {
			ACTIVE_COLOR = PATH_COLOR;
			pathShowing = true;
		}
	}
	
	public void hidePath() {
		if (pathShowing = true) {
			ACTIVE_COLOR = DEFAULT_COLOR;
			pathShowing = false;
		}
	}
	
	/* Sets the mine's active status to true.
	 * It also sets the color to the respective color.
	 */
	public void activate() {
		active = true;
	}
	
	//Sets the mine's active state to false.
	public void deactivate() {
		if (active = true) {
			active = false;
		} else if (active - false) {
			System.out.println("No action done: Already deactive.");
		} else {
			System.out.println("I don't have a clue how you managed to do that.");
		}
	}
	
	
	
	public void setCurrentLocationText(boolean current) {
		
	}
	
	private int getNearbyMineCount() {
		return 1;
	}
	
	public void activateNeighbors() {
		
	}
	
	public void deactivateNeighbors() {
		
	}
	
	public void deactivateNeighborsOfNeighbors() {
		
	}
	
	//Gets the color for the mine count.
	public Color getNearbyMineColor(int mineCount) {
		Color temp = Color.green;
		switch (this.getNearbyMineCount()) {
			case 0:
				temp = Color.green;
			case 1:
				temp = Color.yellow;
			case 2:
				temp = Color.orange;
			case 3:
				temp = Color.red;
		}
		return temp;
	}
}
