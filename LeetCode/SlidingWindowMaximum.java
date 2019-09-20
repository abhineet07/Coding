package leetcode;

/*
 * https://leetcode.com/problems/sliding-window-maximum/
 * 
 * Try Once More (Level - Hard)
 * 
 * Solution : https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] a, int k) {		
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			System.out.printf("\ni=%d\n", i);
			printDeque(q, 1);
			System.out.printf("q.peek=%d\n", q.peek());
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			printDeque(q, 2);
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			printDeque(q, 3);
			// q contains index... r contains content
			q.offer(i);
			printDeque(q, 4);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
				System.out.printf("r[ri++]=%d\n", r[ri-1]);
			}
		}
		return r;
	}
	
	public void printDeque(Deque<Integer> q, int n) {
		System.out.print(n + " :  ");
		for(Integer i : q) {
			System.out.printf("%d  ", i);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		SlidingWindowMaximum obj = new SlidingWindowMaximum();
		// int[] a  = {1,3,-1,-3,5,3,6,7};
		int[] a = {0,1,2,3,4,5,6,7};
		int k = 3;
		int[] r = obj.maxSlidingWindow(a, k);
		
		for(int i=0; i<r.length; i++) {
			System.out.printf("%d  ", r[i]);
		}
	}
}
