package leetcodeInterview;

public class MinimumDominoRotation {
	public int minDominoRotations(int[] A, int[] B) {
        int len = A.length;
        int count_a = 0;
        int count_b = 0;
        for(int i=0; i<len-1; i++) {
        	int a = A[i];
        	int b = B[i];
        	int a_next = A[i+1];
        	int b_next = B[i+1];
        	
        	if(a == b_next || b == a_next || a == a_next || b == b_next) {
        		if(a == a_next || b == b_next) {
    				continue;
    			}
        		else if(a == b_next) {
        			count_a++;
        		}
        		else if(b == a_next) {
        			count_b++;
        		}
        	}
        	else {
        		return -1;
        	}
        	
        	
        	if(i==len-2) {
        		if(a == b_next || b == a_next || a == a_next || b == b_next) {
        			if(a == a_next || b == b_next) {
        				continue;
        			}
        			else if(a == b_next) {
            			count_b++;
            		}
            		else if(b == a_next) {
            			count_a++;
            		}
            	}
            	else {
            		return -1;
            	}
        	}
        }
        System.out.println("count_a " + count_a);
        System.out.println("count_b " + count_b);
        return Math.min(count_a, count_b);
        
    }
	
	public static void main(String[] args) {
		MinimumDominoRotation obj = new MinimumDominoRotation();
		int[] A = {1,2,1,1,2};
		int[] B = {3,1,3,1,1};
		
		int ans = obj.minDominoRotations(A, B);
		System.out.println("Answer : " + ans);
	}
}
