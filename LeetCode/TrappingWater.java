/*
 *  Problem link : https://leetcode.com/problems/trapping-rain-water/
 */

public class TrappingWater {
	public int trap(int[] height) {
		int len = height.length;
        int[] leftToRight = new int[len];
        int[] rightToLeft = new int[len];
        
        for(int i=0; i<len; i++) {
        	if(i==0) {
        		leftToRight[0] = height[0];
        	}
        	else {
        		leftToRight[i] = Math.max(height[i], leftToRight[i-1]);
        	}
        }
        
        for(int i=len-1; i>=0; i--) {
        	if(i==len-1) {
        		rightToLeft[i] = height[i];
        	}
        	else {
        		rightToLeft[i] = Math.max(height[i], rightToLeft[i+1]);
        	}
        }
        
        int water = 0;
        for(int i=0; i<len; i++) { 
        	water += Math.min(leftToRight[i], rightToLeft[i]) - height[i];
        }
        return water;
    }
	
	public static void main(String[] args) {
		TrappingWater obj = new TrappingWater();
		
		int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		obj.trap(input);
		
	}

}
