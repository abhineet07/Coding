package geeksForGeeks;
/*
 * https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubarraysWithSumZero {
	class Pair{
		int a;
		int b;
		Pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	
	public ArrayList<Pair> subArrayWithSumZero(int[] array) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		
		ArrayList<Pair> pairList = new ArrayList<>();
		
		int currsum = 0;
		for(int i=0; i<array.length; i++) {
			currsum +=  array[i];
			
			// if the sum is zero, this will create a pair
			// starting from index 0 till the current index
			if(currsum == 0) {
				pairList.add(new Pair(0, i));
			}
			
			ArrayList<Integer> currlist = new ArrayList<>();
			
			// this will also create pair for the sum already encountered whether it is 0 or any other number
			// pair will start from the next index of the sums already present...
			// skipping the index of the current sum
			if(map.containsKey(currsum)) {
				currlist = map.get(currsum);
				for(int j=0; j<currlist.size(); j++) {
					pairList.add(new Pair(currlist.get(j)+1, i));
				}			
			}
			
			// adding the latest index to the list of currsum
			currlist.add(i);
			// then putting the new updated list back to map
			map.put(currsum, currlist);		
		}	
		return pairList;
	}
	
	public static void printPair(ArrayList<Pair> pairList) {
		for(Pair p: pairList) {
			System.out.printf("(%d, %d)\n", p.a, p.b);
		}
	}
	
	public static void main(String[] args) {
		SubarraysWithSumZero obj = new SubarraysWithSumZero();
		// int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7}; 
		int[] arr = {0, 0, 0, 3, 0, 0 , 0}; 
		printPair(obj.subArrayWithSumZero(arr));
	}
}
