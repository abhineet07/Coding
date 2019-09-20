package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/*
 * 	Amazon
 *  https://leetcode.com/problems/distant-barcodes/
 */

public class DistantBarcodes {
	public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // new way to declare for loop
        // new way to create hashmap
        for(int c: barcodes) {
        	map.put(c, 1 + map.getOrDefault(c, 0));
        }
//        printmap(map);
        
        // way of declaring priority queue
        // it gives the order in deccending order, if we swap the subtraction term then it will give ascending order
        PriorityQueue<Integer> que = new PriorityQueue<>((i, j) -> map.get(j)-map.get(i));
        que.addAll(map.keySet());
        
        int[] answer = new int[barcodes.length];
        int index = 0;
        while(!que.isEmpty()) {
        	int key = que.poll();
        	int freq = map.get(key);
        	System.out.println("key = " + key + "\tval = " + freq);
        	while(freq > 0) {
        		if(index >= barcodes.length) {
        			index = 1;
        		}
        		System.out.print("\tindex = " + index);
        		System.out.print("\tkey = " + key);
        		System.out.println();
        		answer[index] = key;
        		index += 2;
        		freq--;
        	}
        }
        return answer;
    }
	
	public void printqueue(PriorityQueue<Integer> que) {
		Iterator<Integer> itr = que.iterator();
		while(itr.hasNext()) {
			System.out.println();
			itr.next();
		}
	}
	
	public void printmap(Map<Integer, Integer> map) {
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}
	}
	
	public void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		DistantBarcodes obj = new DistantBarcodes();
		int[] input = {7,7,7,8,5,7,5,5,5,8};
		obj.printArray(obj.rearrangeBarcodes(input));
	}
}
