package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 *	 Amazon
 * https://leetcode.com/problems/most-common-word/
 *		 
 *	this problem uses regular expression
 */

public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = removePunctuation(paragraph, banned);
        Map<String, Integer> map = new HashMap<String, Integer>(); 
        int max = 0;
        String ans = "";
        for(String w : words) {
        	
        	if(map.containsKey(w)) {
        		int tempVal = map.get(w) + 1;
        		map.put(w, tempVal);
        		if(tempVal > max) {
        			max = tempVal;
        			ans = w;
        		}
        	}
        	else {
        		map.put(w, 1);
        		if(max < 1) {
        			max = 1;
            		ans = w;
        		}       		
        	}
        }
        System.out.println("ans = " + ans + "\tval = " + max);
        return ans;
    }
	
	public String[] removePunctuation(String str, String[] banned) {
		// this removes all the puntuations form the code
		str = str.replaceAll("\\p{Punct}"," ").toLowerCase();
		str = str.replaceAll("( )+", " ").trim();
		System.out.println("1. " + str);
		for(String w : banned) {
			System.out.println("\tw = " + w);
			str = str.replaceAll("\\b"+ w +"\\b", "");
			System.out.println("\tstr = " + str);
		}
		// this removes all the extra white space
		str = str.replaceAll("( )+", " ").trim();
		System.out.println("2. " + str);
		String[] arr = str.split(" ");
		return arr;
	}
	
	public static void main(String[] args) {
		MostCommonWord obj = new MostCommonWord();
		String paragraph = "abc abc? abcd the jeff!";
				
		String[] banned = {"abc","abcd","jeff"};
		
		String ans = obj.mostCommonWord(paragraph, banned);
		System.out.println(ans);
	}
}
