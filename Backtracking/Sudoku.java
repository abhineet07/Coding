package backtracking;

public class Sudoku {
	public static int[][] grid;
	
	public boolean sudokuSolver() {
		int row;
		int col;
		int[] blankLocation = findBlankLocation();
		row = blankLocation[0];
		col = blankLocation[1];
		
		// it means the sudoku is already filled
		if(row == -1) {
			return true;
		}
		
		// if we are here, then we need to fill the sudoku
		// by trying every number in the cell
		for(int i=1; i<=9; i++) {
			// before filling the number we need to check whether it is safe to fill the number
			if(isSafe(row, col, i)) {
				// if we are here, then it is safe to fill the current cell with value i
				grid[row][col] = i;
				
				// go into recursion with remaining empty cells
				if(sudokuSolver()) {
					return true;
				}
				
				// backtracking step
				// if we are here that, we cannot solve the sudoku with current number
				// so we keep emptying the cells while going up the recursion stack again
				grid[row][col] = 0;
			}
		}
		// if we are here, then it means we cannot solve the sudoku
		return false;
		
	}
	
	public boolean isSafe(int row, int col, int n) {
		// check whether the number is present in same horizontal line
		// check whether the number is present in same vertical line
		// check whether the number is present in same 3X3 box
		if(!isUsedInRow(row, n) && !isUsedInCol(col, n) && !isUsedInBox(row, col, n)){
			return true;
		}
		return false;
	}
	
	// check whether the number is already present in the same row
	public boolean isUsedInRow(int row, int n) {
		for(int i=0; i<9; i++) {
			if(grid[row][i] == n) {
				return true;
			}
		}
		return false;
	}
	
	// check whether the number is already present in the same column
	public boolean isUsedInCol(int col, int n) {
		for(int i=0; i<9; i++) {
			if(grid[i][col] == n) {
				return true;
			}
		}
		return false;
	}
	
	// check whether the same number is present in the same box or not
	public boolean isUsedInBox(int row, int col, int n) {
		int start_i = (row/3) * 3;
		int start_j = (col/3) * 3;
		for(int i=start_i; i<start_i+3; i++) {
			for(int j=start_j; j<start_j+3; j++) {
				if(i!=row && j!=col && grid[i][j]==n) {
					return true;
				}
			}
		}
		return false;
	}
	
	// find the first cell that is blank(0) in the grid,
	// in left to right r=then top to down way
	// and return the location of the first empty cell
	// if not found any cell, then sudoku is already filled
	public int[] findBlankLocation() {
		int[] cell = new int[2];
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(grid[i][j] == 0) {
					cell[0] = i;
					cell[1] = j;
					return cell;
				}
			}
		}
		cell[0] = -1;
		cell[1] = -1;
		return cell;
	}
	
	public void print() {
		for (int row = 0; row < 9; row++) {
			if (row % 3 == 0) {
				System.out.println(); // for more readability
			}
			for (int col = 0; col < 9; col++) {
				if (col % 3 == 0) {
					System.out.print(" "); // for more readability
				}
				System.out.print(grid[row][col] + " ");

			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		grid = new int[][] { { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
			{ 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
			{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
			{ 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
			{ 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
			
		Sudoku sudoku = new Sudoku();
		if(sudoku.sudokuSolver()) {
			sudoku.print();
		}
		else {
			System.out.println("NO SOLUTION");
		}
	}
}
