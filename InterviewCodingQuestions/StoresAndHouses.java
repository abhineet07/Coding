package leetcodeInterview;

import java.util.TreeSet;

public class StoresAndHouses {
	public int[] nearestStores(int[] houses, int[] stores) {
		int[] res = new int[houses.length];
		TreeSet<Integer> set = new TreeSet<>();
		for(int st : stores) {
			set.add(st);
		}
		
		for(int i=0; i<houses.length; i++) {
			 int top = set.ceiling(houses[i]) == null ? Integer.MAX_VALUE : set.ceiling(houses[i]) - houses[i];
			 int bottom = set.floor(houses[i]) == null ? Integer.MAX_VALUE : houses[i] - set.floor(houses[i]);
			 
			 if(top >= bottom) {
				 res[i] = set.floor(houses[i]);
			 }
			 else if (bottom > top) {
				 res[i] = set.ceiling(houses[i]);
			 }
			 
		}
		
		return res;
	}
	
	public void printArray(int[] arr) {
		System.out.print("Array : ");
		for(int i : arr) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		StoresAndHouses obj = new StoresAndHouses();
		int[] houses = {5, 10, 17};
		int[] stores = {1, 5, 20, 11, 16};
		
		int[] ans = obj.nearestStores(houses, stores);
		obj.printArray(ans);
		
	}
}
