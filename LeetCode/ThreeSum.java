package leetcode;

import java.util.Arrays;

/*
 * 	https://leetcode.com/problems/3sum/
 */

import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		// sorting the array first
		Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        
        // for loop till the last third number
        for(int i=0; i<nums.length-2; i++) {
        	// skip if the previous number is same as current number
        	if(i==0 || nums[i] != nums[i-1]) {
        		int lo=i+1, hi=nums.length-1, sum=0-nums[i];
            	while(lo < hi) {
            		// there could be three cases
            		// Case1 1: when sum of nums[lo] + nums[hi] == sum. This is what we want.
            		if(nums[lo] + nums[hi] == sum) {
            			result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
            			// if next number after nums[lo] is same sa nums[lo] then skip and increase the lo
            			while(lo < hi && nums[lo] == nums[lo+1])
            				lo++;
            			// if num at hi-1 is same as num at hi then skip and decrease hi 
            			while(lo < hi && nums[hi] == nums[hi-1])
            				hi--;
            			lo++;
            			hi--;
            		}
            		// Case 2: when sum is greater than nums[lo]+nums[hi]
            		else if(nums[lo] + nums[hi] < sum)
            			lo++;
            		// Case 3: when sum is less than nums[lo]+nums[hi]
            		else 
            			hi--;	
            	}
        	}
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {-1, 0, 1, 2, -1, -4};
		ThreeSum obj = new ThreeSum();
		obj.threeSum(array);
	}

}
