import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;

public class MineFieldPanel extends JPanel {

	private final int DEFAULT_GRID_SIZE = 10;
	//private final double MIN_MINE_PERCENT = 20;
	private final double DEFAULT_MINE_PERCENT = 25;
	//private final double MAX_MINE_PERCENT = 35;
	public int gridSize;
	private MineFieldButton[][] grid;
	private int numMines;
	Random rand = new Random();
	
	public MineFieldPanel() {
		grid = new MineFieldButton[DEFAULT_GRID_SIZE][DEFAULT_GRID_SIZE];
		
		//Sets the size of the grid and the number of buttons in a row.
		this.setLayout(new GridLayout(grid.length, grid[0].length, 1, 1));
		this.setPreferredSize(new Dimension(1, 1));
		
		// Creates each button, adds an action listener to them, and adds them to the panel 
		// And adds mines and all neighbors
		goThroughGrid(0);
		setNumberOfMInes(DEFAULT_MINE_PERCENT);
		setMines();
		addAllNeighbors();
	}
	
	public MineFieldPanel(int gridSize) {
		this.gridSize = gridSize;
		grid = new MineFieldButton[this.gridSize][this.gridSize];
		
		//Sets the size of the grid and the number of buttons in a row.
		this.setLayout(new GridLayout(grid.length, grid[0].length, 1, 1));
		this.setPreferredSize(new Dimension(1, 1));
		
		// Creates each button, adds an action listener to them, and adds them to the panel					
		goThroughGrid(0);
		setNumberOfMInes(DEFAULT_MINE_PERCENT);
		setMines();
		addAllNeighbors();
	}
	
	private void goThroughGrid(int flagInt) {
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[0].length; j++) {
						
				switch(flagInt) {
				case 0:
					grid[i][j] = new MineFieldButton(listener);
					this.add(grid[i][j]);
					break;
				
				case 1:
					grid[i][j].hideMine();
					break;
				
				case 2:
					grid[i][j].showMine();
					break;
				
				case 3:
					grid[i][j].hidePath();
					break;
					
				case 4:
					grid[i][j].showPath();
					break;
					
				case 5: 
					grid[i][j].deactivate();
					break;
					
				case 6:
					if (numMines > 0 && grid[i][j].isOnPath() == false && rand.nextInt(100) <= DEFAULT_MINE_PERCENT && grid[i][j].isMine() == false) {
						grid[i][j].setIsMine(true);
						numMines--;
					}
					break;
					
				case 7:
					if (i - 1 >= 0) 
						grid[i][j].addNeighbor(grid[i - 1][j]);
					
					if(i + 1 <= grid.length) 
						grid[i][j].addNeighbor(grid[i + 1][j]);
					
					if(j - 1 >= 0) 
						grid[i][j].addNeighbor(grid[i][j - 1]);
					
					if(j + 1 <= grid.length ) 
						grid[i][j].addNeighbor(grid[i][j + 1]);
					
					break;
				}
			}		
		}
	}
	
	public void hideMines() {
		goThroughGrid(1);
	}
	
	public void showMines() {
		goThroughGrid(2);
	}
	
	public void hidePath() {
		goThroughGrid(3);
	}
	
	public void showPath() {
		goThroughGrid(4);
	}
	
	public void deactivate() {
		goThroughGrid(5);
	}
	
	private void setMines() {
		setNumberOfMInes(DEFAULT_MINE_PERCENT);
		do {
			goThroughGrid(6);	
		}
		while (numMines > 0);
	}
	
	private void addAllNeighbors() {
		goThroughGrid(7);
	}
	
	// I have no Idea what to do with this method so i'll coomment it out for now.
	//private void addNeighbor(int a, int b, int c, int d) {
	//
	//}
	
	public void setNumberOfMInes(double minePercent) {
		numMines = (int) Math.pow(gridSize, 2);
		numMines = numMines - (gridSize * 2 - 1);
		numMines = (int) (numMines * (minePercent / 100));
	}
	
	public int getNumberOfMines() {
		return numMines;
	}
	
	public int getGridSize() {
		return gridSize;
	}
}
	
	
	
	
