package leetcodeInterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays {
	public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        while(N > 0) {
        	int[] nextState = new int[8];
        	System.out.print("N="+N);
        	map.put(Arrays.toString(cells), N--);
        	System.out.println(Arrays.toString(cells));
        	for(int i=1; i<7; ++i) {
        		nextState[i] = cells[i-1] == cells[i+1] ? 1 : 0;
        	}
        	cells = nextState;
        	System.out.println("N=" + N + Arrays.toString(cells));
        	System.out.println();
        	if(map.containsKey(Arrays.toString(cells))) {
        		System.out.println("\t"+map.get(Arrays.toString(cells)) + "\tN = " + N);
        		System.out.println("Calculation1 : " + (map.get(Arrays.toString(cells)) - N));
        		System.out.println("Calculation2 : " + N % (map.get(Arrays.toString(cells)) - N));
        		N %= map.get(Arrays.toString(cells)) - N;
        		
        		System.out.println(N);
        	}
        }
        return cells;
    }
	
	public int[] prisonAfterNDays2(int[] cells, int N) {
		Map<String, Integer> seen = new HashMap<String, Integer>();
		int D = 0;
		while(D < N) {
			int[] nextState = new int[8];
			System.out.print("D="+D);
			seen.put(Arrays.toString(cells), D++);
			System.out.println(Arrays.toString(cells));
			
			for(int i=1; i<7; i++) {
				nextState[i] = cells[i-1] == cells[i+1] ? 1 : 0;
			}
			cells = nextState;
			System.out.println("D="+D + Arrays.toString(cells));
			System.out.println();
			
			if(seen.containsKey(Arrays.toString(cells))) {
				System.out.println("\t"+seen.get(Arrays.toString(cells)) + "\tD = " + D);
				break;
			}
		}
		return cells;
	}
	
	public static void main(String[] args) {
		PrisonCellsAfterNDays obj = new PrisonCellsAfterNDays();
		int[] cells = {1,0,0,1,0,0,1,0};
		obj.prisonAfterNDays2(cells, 1000000000);
		obj.prisonAfterNDays2(cells, 19);
	}
}
