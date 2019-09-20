package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumTo100 {
	String DIGITS = "123456789";
	List<String> result;
	
	public List<String> test(int target) {
		result = new ArrayList<>();
		testUtil(0, 0, target, new StringBuilder(), result);		
		return result;
	}
		
	
	public void testUtil(int start, int sum, int target, StringBuilder path, List<String> result) {
		if(start == DIGITS.length()) {
			if(sum == target) {
				result.add(path.toString());
			}
			return;
		}
		
		int pathLen = path.length();
		int num = 0;
		for(int i=start; i<DIGITS.length(); i++) {
			num = 10 * num + DIGITS.charAt(i) - '0';
			if(start != 0)
				path.append("+");
			path.append(num);
			testUtil(i+1, sum + num, target, path, result);
			
			// removing <+><digit>
			path.setLength(pathLen);
			
			// - sign
			if(start != 0)
				path.append("-");
			path.append(num);
			testUtil(i+1, sum - num, target, path, result);
			path.setLength(pathLen);
		}
	}
	
	public void printList(List<String> result) {
		System.out.println("TOTAL RESULT : " + result.size());
		int i = 1;
		for(String s : result) {
			System.out.println(i + " :  " + s);
			i++;
		}
	}
	
	public static void main(String[] args) {
		SumTo100 obj = new SumTo100();
		int target = 100;
		List<String> ans = obj.test(target);
		obj.printList(ans);
	}

}
