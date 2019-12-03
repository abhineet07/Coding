package leetcode;

/*
 * https://leetcode.com/problems/grumpy-bookstore-owner/
 * 
 * Approach:
 * 1) First we traverse the whole array and find the sum of customers when the owner is not grumpy = satisfied customers
 * 2) Then take the window of size X and calculate the sum of customers when the owner is grumpy = unsatisfied customers
 * 3) Now for the current window if we make the owner not grumpy then the current unsatisfied customers will become satisfied
 * 		So for current window maximum satisfied customers = satisfied customers + unsatisfied customers
 * 4) Now for next window calculate unsatisfied customers, make them satisfied and calculate the current window maximum satisfied customers
 * 5) And keep track of maximum satisfied customers from each window 
 */

public class GrumpyBookstoreOwner {
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int satisfied_customers = 0;
		for(int i=0; i<customers.length; i++) {
			if(grumpy[i]==0) {
				satisfied_customers += customers[i];
			}
		}
		
		int s = 0;
		int e = X-1;
		int unsatisfied_customers = 0;
		for(int i=s; i<=e; i++) {
			if(grumpy[i] == 1) {
				unsatisfied_customers += customers[i];
			}
		}
		
		int max_sum = satisfied_customers + unsatisfied_customers;
		int curr_sum = max_sum;
//		System.out.printf("start=%d, end=%d, curr_sum=%d\n", s, e, curr_sum);
		s++;
		e++;
		while(e < customers.length) {
			if(grumpy[s-1] == 1) {
				unsatisfied_customers -= customers[s-1];
			}
			if(grumpy[e] == 1) {
				unsatisfied_customers += customers[e];
			}
			curr_sum = satisfied_customers + unsatisfied_customers;
			if(curr_sum > max_sum) {
				max_sum = curr_sum;
			}
//			System.out.printf("start=%d, end=%d, curr_sum=%d\n", s, e, curr_sum);
			s++;
			e++;
		}
		
		return max_sum;
	}

	public static void main(String[] args) {
		GrumpyBookstoreOwner obj = new GrumpyBookstoreOwner();
		int[] customers = {1};
		int[] grumpy = {1};
		int X = 1;
		int res = obj.maxSatisfied(customers, grumpy, X);
		System.out.println("\nANS = " + res);
	}

}
