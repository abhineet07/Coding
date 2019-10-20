package geeksForGeeks;

public class KadaneAlgorithm {
	public int maximumSubarraySum(int[] arr) {
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
		int start = 0, end=0, s=0;
		
		for(int i=0; i<arr.length; i++) {
			max_ending_here = max_ending_here + arr[i];
			if(max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}
			
			if(max_ending_here < 0) {
				max_ending_here = 0;
				s = i+1;
			}
		}
		
		System.out.printf("StartIndex=%d and EndIndex=%d\n", start, end);
		System.out.printf("Maximum subarray sum=%d", max_so_far);
		return max_so_far;
	}
	
	public static void main(String[] args) {
		KadaneAlgorithm obj = new KadaneAlgorithm();
		int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
		int res = obj.maximumSubarraySum(array);
	}
}
