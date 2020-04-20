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
		}
	}
	
	public void hideMine() {
		if (isMine = true) {
			ACTIVE_COLOR = DEFAULT_COLOR;
		}
	}
	
	public void showPath() {
		if (isOnPath = true) {
			ACTIVE_COLOR = PATH_COLOR;
		}
	}
	
	public void hidePath() {
		if (isOnPath = true) {
			
		}
	}
	
	public void activate() {
		
	}
	
	public void deactivate() {
		
	}
	
	
	
	public void setCurrentLocationText(boolean current) {
		
	}
	
	public int getNearbyMineCount() {
		return 0;
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
