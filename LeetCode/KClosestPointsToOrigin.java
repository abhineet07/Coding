package leetcode;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int K) {
//        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        PriorityQueue<Integer> pr = new PriorityQueue<>((i, j) -> calculateDistance(points, j) - calculateDistance(points, i));
//        System.out.printf("pr.size=%d\n", pr.size());
        for(int i=0; i<points.length; i++) {
        	// calculate distance
        	int dist = calculateDistance(points, i);
//        	System.out.printf("i=%d, point=(%d,%d), dist=%d\n", i, points[i][0], points[i][1], dist);
        	if(pr.size() < K) {
        		pr.add(i);
//        		System.out.printf("Condition 1 : adding i = %d\n", i);
        		if(dist > high) {
        			high = dist;
        		}
        	}
        	else if(pr.size() == K) {
//        		System.out.println("Condition 2 :");
//        		System.out.printf("peek=%d\n", pr.peek());
        		if(dist < high) {
        			int temp = pr.poll();
//        			System.out.printf("poll=%d\n", temp);
        			pr.add(i);
        			high = calculateDistance(points, pr.peek());
        		}       		
        	}
//        	printQueue(pr, points);
//        	System.out.printf("high=%d, pr.size=%d\n\n", high, pr.size());
        }
        
        int[][] result = new int[K][2];
        int i = 0;
        for(Integer id : pr) {
//        	System.out.printf("id=%d\n", id);
//        	System.out.println(points[id][0]);
//        	System.out.printf("points[answer[id]][0]=5d\n", points[answer[id]][0]);
        	result[i][0] = points[id][0];
        	result[i][1] = points[id][1];
        	i++;
        }
        
        return result;
    }
	
	public int calculateDistance(int[][] points, int i) {
		return (points[i][0]*points[i][0]) + (points[i][1]*points[i][1]);
	}
	
	public void print2Darray(int[][] array) {
		int row = array.length;
		int col = array[0].length;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(array[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public void printQueue(PriorityQueue<Integer> que, int[][] points) {
		System.out.print("Queue : ");
		for(Integer i : que) {
			System.out.print(i + "  ");
		}
		
		System.out.print("\nPoints : ");
		for(Integer i : que) {
			System.out.printf("(%d,%d)  ", points[i][0], points[i][1]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
//		int[][] input = {{3,3}, {5,-1}, {-2,4}};
//		int k = 2;
//		int[][] input = {{1,3}, {-2,2}};
//		int k = 1;
		int[][] input = {{68,97}, {34,-84}, {60,100}, {2,31}, {-27,-38}, {-73,-74},{-55,-39}, {62,91},{62,92}, {-57,67}};
		int k = 5;
		
		int[][] answer = obj.kClosest(input, k);
		obj.print2Darray(answer);
	}

}
