
import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	private ActionListener actionListener;

	Random rand = new Random();
	public int lives = 5;

	public MineFieldPanel(ActionListener actionListener) {
		this.actionListener = actionListener;
		gridSize = DEFAULT_GRID_SIZE;
		grid = new MineFieldButton[gridSize][gridSize];
		
		//Sets the size of the grid and the number of buttons in a row.
		this.setLayout(new GridLayout(grid.length, grid[0].length, 1, 1));
		this.setPreferredSize(new Dimension(500, 500));
		
		// Creates each button, adds an action listener to them, and adds them to the panel 
		// And adds mines and all neighbors
		goThroughGrid(0);
		createPath();
		setNumberOfMInes(DEFAULT_MINE_PERCENT);
		setMines();
		addAllNeighbors();
		createStartAndEndPoint();
	}
	
	public MineFieldPanel(int gridSize, ActionListener actionListener) {
		this.actionListener = actionListener;
		this.gridSize = gridSize;
		grid = new MineFieldButton[gridSize][gridSize];
		
		//Sets the size of the grid and the number of buttons in a row.
		this.setLayout(new GridLayout(grid.length, grid[0].length, 1, 1));
		this.setPreferredSize(new Dimension(500, 500));
		
		// Creates each button, adds an action listener to them, and adds them to the panel					
		goThroughGrid(0);
		createPath();
		setNumberOfMInes(DEFAULT_MINE_PERCENT);
		setMines();
		addAllNeighbors();
		createStartAndEndPoint();
	}
	
	
	private void goThroughGrid(int flagInt) {
		for (int i = 0; i < grid.length; i++) {
			int amountOfMinesPerRow = 5;
			
			for (int j = 0; j < grid[0].length; j++) {
				
						
				switch(flagInt) {
				case 0:
					MineFieldButton button = new MineFieldButton();
					button.addActionListener(actionListener);
					grid[i][j] = button;
					this.add(grid[i][j]);
					break;
				
				case 1:
					grid[i][j].hideMine();
					break;
				
				case 2:
					if(grid[i][j].isMine()) {
						grid[i][j].showMine();
					}
					break;
				
				case 3:
					grid[i][j].hidePath();
					break;
					
				case 4:
					if(grid[i][j].isOnPath()) {
						grid[i][j].showPath();
						grid[i][j].visit();
					}
					break;
					
				case 5: 
					grid[i][j].deactivate();
					break;
					
				case 6:
					if (numMines > 0 && grid[i][j].isOnPath() == false && rand.nextInt(100) <= DEFAULT_MINE_PERCENT
					&& grid[i][j].isMine() == false && amountOfMinesPerRow != 0) {
						
						grid[i][j].setIsMine(true);
						numMines--;
						amountOfMinesPerRow--;
					}
					break;
					
				case 7:
					if (i - 1 >= 0) 
						grid[i][j].addNeighbor(grid[i - 1][j]);
					
					if(i + 1 < grid.length) 
						grid[i][j].addNeighbor(grid[i + 1][j]);
					
					if(j - 1 >= 0) 
						grid[i][j].addNeighbor(grid[i][j - 1]);
					
					if(j + 1 < grid.length ) 
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
	
	public void createStartAndEndPoint() {
		System.out.println("Entered createStartPoint");
		MineFieldButton startButton = grid[gridSize-1][0];
		MineFieldButton endButton = grid[0][gridSize-1];
		startButton.activate();
		startButton.setColor(Color.blue);
		endButton.setColor(Color.pink);
		
	}

	public void createPath() {
		MineFieldButton Start = grid[gridSize - 1][0];
		MineFieldButton End = grid[0][gridSize - 1];
		int x = gridSize - 1;
		int y = 0;
		Random rand = new Random();
		
		Start.setOnPath(true);
		End.setOnPath(true);
		End.setIsEnd(true);
		while (grid[x][y] != End) {
			if (rand.nextBoolean() == true && x != 0) {
				x = x - 1;
			}
			else if (y != gridSize -1){
				y = y + 1;
			}
			grid[x][y].setOnPath(true);}
		}
		
		
	}
	
	
	
	
	
