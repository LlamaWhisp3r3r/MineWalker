import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class MineFieldButton extends JButton {

	private final Color START_COLOR;
	private final Color DESTINATION_COLOR;
	private final Color DEFAULT_COLOR;
	private Color ACTIVE_COLOR;
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
	private ArrayList<MineFieldButton> nieghbors = new ArrayList<MineFieldButton>();
	
	public MineFieldButton() {
		START_COLOR = Color.blue;
		DESTINATION_COLOR = Color.magenta;
		DEFAULT_COLOR = Color.white;
		ACTIVE_COLOR = Color.gray;
		MINE_COLOR = Color.black;
		PATH_COLOR = Color.blue;
		NEARBY_COLORS = new Color[1];
		
	}
	
	public void visit() {
		visited = true;
	}
	public boolean hasActive() {
		for(MineFieldButton button : nieghbors) {
			if(button.isActive()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setColor(Color color) {
		this.setBackground(color);
	}
	
	public void addNeighbor(MineFieldButton button) {
		nieghbors.add(button);
		
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
		onPath = newPath;
	}
	
	public boolean isOnPath() {
		return onPath;
	}
	
	public void showMine() {
		if (isMine = true) {
			setColor(Color.BLACK);;
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
		if (onPath = true) {
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
		} else if (active = false) {
			System.out.println("No action done: Already deactive.");
		} else {
			System.out.println("I don't have a clue how you managed to do that.");
		}
	}
	
	
	
	public void setCurrentLocationText(boolean current) {
		
	}
	
	private int getNearbyMineCount() {
		int mineCount = 0;
		for(MineFieldButton button : nieghbors) {
			if(button.isMine()) {
				mineCount++;
			}
		}
		return mineCount;
	}
	
	public void activateNeighbors() {
		
	}
	
	public void deactivateNeighbors() {
		
	}
	
	public void deactivateNeighborsOfNeighbors() {
		
	}
	
	//Gets the color for the mine count.
	public Color getNearbyMineColor() {
		
		Color temp;
		switch (getNearbyMineCount()) {
			case 0:
				temp = Color.green;
				break;
			case 1:
				temp = Color.yellow;
				break;
			case 2:
				temp = Color.orange;
				break;
			case 3:
				temp = Color.red;
				break;
			default:
				temp = Color.green;
		}
		return temp;
	}
}
