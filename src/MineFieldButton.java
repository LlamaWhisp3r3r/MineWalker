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
		
	}
	
	public boolean isStart() {
		return true;
		
	}
	
	public void setIsEnd(boolean newEnd) {
		
	}
	
	public boolean isEnd() {
		return false;
		
	}
	
	public void setIsMine(boolean newMine) {
		
	}
	
	public boolean isMine() {
		return true;
		
	}
	
	public void setOnPath(boolean newPath) {
		
	}
	
	public boolean isOnPath() {
		return true;
		
	}
	
	public void showMine() {
		
	}
	
	public void hideMine() {
		
	}
	
	public void showPath() {
		
	}
	
	public void hidePath() {
		
	}
	
	public void activate() {
		
	}
	
	public void deactivate() {
		
	}
	
	
	// I don't know if these were supposed to be private.
	public void setCurrentLocationText(boolean current) {
		
	}
	
	public int getNearbyMineCount() {
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
