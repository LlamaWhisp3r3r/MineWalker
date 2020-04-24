import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class MineFieldPanel extends JPanel {

	private final int DEFAULT_GRID_SIZE = 10;
	private final double MIN_MINE_PERCENT = 0;
	private final double DEFAULT_MINE_PERCENT = 0;
	private final double MAX_MINE_PERCENT = 0;
	private int gridSize;
	private MineFieldButton[][] grid;
	
	public MineFieldPanel(ActionListener listener) {
		
		gridSize = DEFAULT_GRID_SIZE;
		grid = new MineFieldButton[gridSize][gridSize];
		
		//Sets the size of the grid and the number of buttons in a row.
		this.setLayout(new GridLayout(grid.length, grid[0].length, 1, 1));
		this.setPreferredSize(new Dimension(1, 1));
		
		// Creates each button, adds an action listener to them, and adds them to the panel
		for (int i = 0; i < grid.length; i++) {
				
			for (int j = 0; j < grid[0].length; j++) {
						
				grid[i][j] = new MineFieldButton(listener);
				this.add(grid[i][j]);
			}	
		}
	}
	
	public MineFieldPanel(int gridSize, ActionListener listener) {
		
		this.gridSize = gridSize;
		grid = new MineFieldButton[this.gridSize][this.gridSize];
		
		//Sets the size of the grid and the number of buttons in a row.
		this.setLayout(new GridLayout(grid.length, grid[0].length, 1, 1));
		this.setPreferredSize(new Dimension(1, 1));
		
		// Creates each button, adds an action listener to them, and adds them to the panel
		for (int i = 0; i < grid.length; i++) {
				
			for (int j = 0; j < grid[0].length; j++) {
						
				grid[i][j] = new MineFieldButton(listener);
				this.add(grid[i][j]);
			}		
		}
	}
	
	public int getGridSize() {
		return gridSize;
	}
	
	public void hideMines() {
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[0].length; j++) {
						
				grid[i][j].hideMine();
				this.add(grid[i][j]);
			}		
		}
	}
	
	public void showMines() {
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[0].length; j++) {
						
				grid[i][j].showMine();
				this.add(grid[i][j]);
			}		
		}
	}
	
	public void hidePath() {
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[0].length; j++) {
						
				grid[i][j].hidePath();
				this.add(grid[i][j]);
			}		
		}
	}
	
	public void showPath() {
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[0].length; j++) {
						
				grid[i][j].showPath();
				this.add(grid[i][j]);
			}		
		}
	}
	
	public void deactivate() {
	
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[0].length; j++) {
						
				grid[i][j].deactivate();
				this.add(grid[i][j]);
			}		
		}
	}
	
	private void setMines(double something) {
		
	}
	
	private void addAllNeighbors() {
		
	}
	
	private void addNeighbor(int a, int b, int c, int d) {
		
	}
}


