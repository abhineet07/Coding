package leetcode;

/*
 * https://leetcode.com/problems/rotate-image/
 */

public class RotateImage {
	public void rotate(int[][] matrix) {
        int rows = matrix.length;        
        int depth = (int)Math.ceil( ((float)rows) / ((float)2) );
        
        // System.out.println(depth);
        
        for(int i=0; i<depth; i++) {
        	for(int j=i; j<rows-1-i; j++) {
        		int temp1 = matrix[j][rows-i-1];
        		matrix[j][rows-i-1] = matrix[i][j];
        		
        		int temp2 = matrix[rows-i-1][rows-j-1];
        		matrix[rows-i-1][rows-j-1] = temp1;
        		
        		temp1 = matrix[rows-j-1][i];
        		matrix[rows-j-1][i] = temp2;
        		
        		matrix[i][j] = temp1;
        		printMatrix(matrix);
        		System.out.println("-------------");
        	}
        }
        System.out.println("====================");
        printMatrix(matrix);
  
    }
	
	public void printMatrix(int[][] matrix) {
		int rows = matrix.length; 
		for(int i=0; i<rows; i++) {
        	for(int j=0; j<rows; j++) {
        		System.out.print(matrix[i][j] + "\t");
        	}
        	System.out.println();
        }
	}
	
	public static void main(String[] args) {
		RotateImage obj = new RotateImage();
//		int[][] matrix = {
//				{1,2,3,4,5},
//				{6,7,8,9,10},
//				{11,12,13,14,15},
//				{16,17,18,19,20},
//				{21,22,23,24,25}
//		};
		
		int[][] matrix = {};
		
		obj.rotate(matrix);
		
//		int div = (int)Math.ceil( ((float)3) / ((float)2) );
//		System.out.println(div);
	}
}
