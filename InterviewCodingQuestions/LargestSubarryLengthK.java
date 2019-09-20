package leetcodeInterview;

/*
 *  Link : https://leetcode.com/discuss/interview-question/352459/Google-or-OA-Fall-Internship-2019-or-Largest-Subarray-Length-K
 *  GOOGLE
 *  
 */

public class LargestSubarryLengthK {
	public int[] largestSubarray(int[] array, int k) {
		int[] res = new int[k];
		int n = array.length;
		if(n < k) {
			return array;
		}
		int subarrays = n - k + 1;
		int i = 0;
		int j = 1;
		while(i <= n-k && j <= n-k) {
			System.out.println("Entring the while loop");
			if(array[j] < array[i]) {
				System.out.println("Condition 1");
				j++;
			}
			else if(array[j] == array[i]) {
				System.out.println("Condition 2");
				int temp = maxVal(array, i, j, k, n);
				if(i != temp) {
					i = temp;
					j = i + 1;
				}
			}
			else {
				System.out.println("Condition 3");
				i = j;
				j = j + 1;
			}
			System.out.println();
		}
//		System.out.printf("i=%d array[%d]=%d", i,i,array[i]);
		
		for(int x=0; x<k; x++) {
			res[x] = array[i+x];
		}
		return res;
	}
	
	public int maxVal(int[] array, int i, int j, int k, int n) {
		int cnt = 0;
		int answer = i;
		while(cnt < k && cnt+i < n) {
			if(array[cnt+i] != array[cnt+j]) {
				answer = array[cnt+i] > array[cnt+j] ? i : j;
				return answer;
			}
			cnt++;
		}
		return j;
	}
	
	public void printArray(int[] array) {
		System.out.print("\nARRAY : ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] array = {6};
		int k = 2;
		LargestSubarryLengthK obj = new LargestSubarryLengthK();
		int[] result = obj.largestSubarray(array, k);
		obj.printArray(result);
	}
}
