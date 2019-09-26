package leetcode;

public class EditDistance {
	public int minDistance(String word1, String word2) {
        int[][] array = new int[word2.length()+1][word1.length()+1];
        
        for(int i=0; i<word1.length()+1; i++) {
        	array[0][i] = i;
        }
        for(int i=0; i<word2.length()+1; i++) {
        	array[i][0] = i;
        }
        
        for(int i=1; i<word2.length()+1; i++) {
        	for(int j=1; j<word1.length()+1; j++) {
        		if(word2.charAt(i-1) == word1.charAt(j-1)) {
        			array[i][j] = array[i-1][j-1];
        		}
        		else {
        			array[i][j] = Math.min(Math.min(array[i-1][j], array[i-1][j-1]), array[i][j-1])+1;
        		}
        	}
        }
        
        for(int i=0; i<word2.length()+1; i++) {
        	for(int j=0; j<word1.length()+1; j++) {
        		System.out.print(array[i][j] + " ");
        	}
        	System.out.println();
        }
        
        return array[word2.length()][word1.length()];
    }
	
	public static void main(String[] args) {
		EditDistance obj = new EditDistance();
		String word1 = "intention";
		String word2 = "execution";
		
		obj.minDistance(word1, word2);
	}
}
