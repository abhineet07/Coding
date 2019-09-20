package leetcode;

/*
 * https://leetcode.com/problems/heaters/
 * 
 * 
 */

import java.util.TreeSet;

public class Heaters {
	public int findRadius(int[] houses, int[] heaters) {
		TreeSet<Integer> heaterSet = new TreeSet<>();
		for(int heater : heaters) {
			heaterSet.add(heater);
		}
		
		int index=0, res=0;
        for(int house : houses) {
        	int dist1 = heaterSet.ceiling(house) == null ? Integer.MAX_VALUE : heaterSet.ceiling(house) - house;
        	int dist2 = heaterSet.floor(house) == null ? Integer.MAX_VALUE : house - heaterSet.floor(house);
        	res = Math.max(res, Math.min(dist1, dist2));
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		Heaters obj = new Heaters();
		int[] houses = {1,2,3,4};
		int[] heaters = {1,4};
	}

}
