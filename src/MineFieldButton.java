import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MineFieldButton extends JButton {



	public MineFieldButton(ActionListener actionListener) {
		
	}
	
	public void visit() {
		
	}
	
	public void addNeighbor(MineFieldButton button) {
		
	}
	
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
	
	public void activate() {
		switch (this.getNearbyMineCount()) {
			case 0:
				ACTIVE_COLOR = Color.green;
			case 1:
				ACTIVE_COLOR = Color.yellow;
			case 2:
				ACTIVE_COLOR = Color.orange;
			case 3:
				ACTIVE_COLOR = Color.red;
		}
		active = true;
	}
	
	public void deactivate() {
		if (active = true) {
			ACTIVE_COLOR = DEFAULT_COLOR;
			active = false;
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
	
	public Color getNearbyMineColor(int mineCount) {
		return Color.red;
	}
	
	
}
