package leetcode;

public class DecodeWays {
    public int numDecodings(String s) {
    	
        int len = s.length();
    	int[] array = new int[len];
    	if(len == 0) {
    		return 0;
    	}
        if(len == 1) {
        	return 1;
        }
        array[len-1] = 1;
        int nextDigit = Character.getNumericValue(s.charAt(len-1));
    	int currentDigit = Character.getNumericValue(s.charAt(len-2));
        if(len==2 || len > 2) {       	
        	if(currentDigit >= 1 && currentDigit <= 2 && nextDigit>=1 && nextDigit<=6) {
        		array[len-2] = 2;
        	}
        	else {
        		array[len-2] = 1;
        	}        	
        }        
        
        for(int j=len-3; j>=0; j--) {
        	nextDigit = Character.getNumericValue(s.charAt(j+1));
        	currentDigit = Character.getNumericValue(s.charAt(j));
        	array[j] = array[j+1];
        	if(currentDigit >= 1 && currentDigit <= 2 && nextDigit>=1 && nextDigit<=6) {
        		array[j] += array[j+2];
        	}
        }
        
        return array[0];
    }
    
    public int numberOfways(String s) {
    	int len = s.length();
    	if(len==0 || s.charAt(0)=='0')
    		return 0;
    	if(len==1) {
    		if(s.equals("0"))
    			return 0;
    		return 1;	
    	}
    	int[] array = new int[len];
    	if(s.charAt(len-1)!='0')
    		array[len-1] = 1;
    	printarray(array);
    	for(int i=len-2; i>=0; i--) {
    		int nextDigit = Character.getNumericValue(s.charAt(i+1));
        	int currentDigit = Character.getNumericValue(s.charAt(i));
        	System.out.printf("nxetDigit=%d, currentDigit=%d\n", nextDigit, currentDigit);
        	if(nextDigit==0 && currentDigit==0)
        		return 0;
        	array[i] = array[i+1];
        	if(currentDigit >= 1 && currentDigit <= 2 && nextDigit>=0 && nextDigit<=6) {
        		if(i==len-2) {
        			array[i]++;
        		}
        		else {
        			array[i] += array[i+2];
        		}        		
        	}
        	printarray(array);
    	}
    	return array[0];
    }
    
    public void printarray(int[] array) {
    	for(int i=0; i<array.length ; i++) {
    		System.out.print(array[i] + "\t");
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
		DecodeWays obj = new DecodeWays();
		String s = "101";
		int res = obj.numberOfways(s);
		System.out.println(res);
	}
}
