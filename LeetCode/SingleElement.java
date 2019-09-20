package leetcode;

/*
 * 	Google
 * https://leetcode.com/discuss/interview-question/346626/google-phone-screen-single-element
 */

public class SingleElement {
	public int singleElement(int[] array) {
		int low = 0;
		int high = array.length-1;
		while(low < high) {
			// new way of finding the middle element if length of the array is given
			// right rotating the array and fill 0 at first position
			int mid = (low + high) >>> 1;
			int rightLen = high - mid + 1;
			
			// if right length is even
			// new way of checking of a number is odd or even
			if((rightLen & 1) == 1) {
				// if mid and next to id are same then sure the single element is at the right side
				if(array[mid] == array[mid+1]) {
					low = mid + 2;
				}
				else {
					high = mid;
				}
			}
			
			// if right length is even
			else {
				if(array[mid] == array[mid+1]) {
					high = mid - 1;
				}
				else {
					low = mid + 1;
				}
			}
		}
		return array[low];
	}
	
	public static void main(String[] args) {
		SingleElement obj = new SingleElement();
		// int[] input = {2, 2, 1, 1, 9, 9, 5, 2, 2};
		int[] input = {2, 2, 1, 2, 2};
		int answer = obj.singleElement(input);
		System.out.println(answer);
	}
}
