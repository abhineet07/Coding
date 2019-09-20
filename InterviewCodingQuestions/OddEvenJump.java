package leetcodeInterview;

import java.util.Map;
import java.util.TreeMap;

/*
 *  question link : https://leetcode.com/problems/odd-even-jump/
 */

public class OddEvenJump {
	public int oddEvenJumps(int[] A) {
		int len = A.length;
        boolean[] higher = new boolean[len];
        boolean[] lower = new boolean[len];
        
        int answer = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[len-1], len-1);
        
        for(int i=len-2; i>=0; i--) {
        	Map.Entry hi = map.ceilingEntry(A[i]);
        	Map.Entry lo = map.lowerEntry(A[i]);
        	
        	if(hi != null) {
        		higher[i] = lower[(int)hi.getValue()];
        		if(higher[i])
        			answer++;
        	}
        	if(lo != null) {
        		lower[i] = higher[(int)lo.getValue()];
        	}
        	map.put(A[i], i);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		OddEvenJump obj = new OddEvenJump();
		int[] input = {10, 13, 12, 14, 15};
	}
}
