import java.awt.Color;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MineFieldButton extends JButton {

	//missing the variables. I'm sorry.
	private final Color START_COLOR;
	private final Color DESTINATION_COLOR;
	private final Color DEFAULT_COLOR;
	private final Color ACTIVE_COLOR;
	private final Color MINE_COLOR;
	private final Color PATH_COLOR;
	private final Color[] NEARBY_COLORS;
	
	private boolean mineShowing;
	private boolean pathShowing;
	private boolean visited;
	private boolean active;
	private boolean onPath;
	private boolean isMine;
	private boolean isStart;
	private boolean isEnd;

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
		return true;

	}
	
	public void setIsEnd(boolean newEnd) {
		isEnd = newEnd;
	}
	
	public boolean isEnd() {
		return false;

	}
	
	public void setIsMine(boolean newMine) {
		isMine = newMine;
	}
	
	public boolean isMine() {

		return false;

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
