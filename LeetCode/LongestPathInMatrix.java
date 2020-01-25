package leetcode;

/*
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */

public class LongestPathInMatrix {
	int[][] distanceMatrix;
	int longestPath = 0;
	public int longestIncreasingPath(int[][] matrix) {
        int max = 1;
        int rows = matrix.length;
        
        int cols = matrix[0].length;
        distanceMatrix = new int[rows][cols];
        for(int i=0; i<rows; i++) {
        	for(int j=0; j<cols; j++) {
        		if(distanceMatrix[i][j] == 0) {
        			// rows -> i, cols -> j
        			dfs(matrix, i, j, rows, cols, 0);
        		}
        	}
        }
        // printMatrix(distanceMatrix);
        return longestPath;
    }
	
	public void dfs(int[][] matrix, int y, int x, int rows, int cols, int pathLen) {
		int[] xdir = {1, 0, -1, 0};
		int[] ydir = {0, 1, 0, -1};
		distanceMatrix[y][x] = pathLen+1;
		if(distanceMatrix[y][x] > longestPath) {
			longestPath = distanceMatrix[y][x];
		}
		for(int i=0; i<4; i++) {
			// rows -> y, cols -> x
			int y_new = y+ydir[i];
			int x_new = x+xdir[i];
			if(y_new>=0 && y_new<rows && x_new>=0 && x_new<cols && 
					matrix[y_new][x_new] > matrix[y][x] &&
					distanceMatrix[y_new][x_new]<=distanceMatrix[y][x]) {
				dfs(matrix, y_new, x_new, rows, cols, pathLen+1);
			}
		}
	}
	
	public boolean isValid(int y, int x, int rows, int cols) {
		if(y>=0 && y<rows && x>=0 && y<cols && distanceMatrix[y][x]==0) 
			return true;
		return false;
	}
	
	public void printMatrix(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
        	for(int j=0; j<matrix[0].length; j++) {
        		System.out.printf("%d ", matrix[i][j]);
        	}
        	System.out.printf("\n");
		}
	}
	
	public static void main(String[] args) {
		LongestPathInMatrix obj = new LongestPathInMatrix();
//		int[][] matrix = {
//				{4,5,6}
//		};
		
//		int[][] matrix = {
//				{3111},
//				{322},
//				{222}
//		};
		
		int[][] matrix = {{}};
		
		int res = obj.longestIncreasingPath(matrix);
		System.out.printf("res=%d", res);
	}
}
