package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LLComponents {
	public int numComponents(ListNode head, int[] G) {
		if(head == null) {
			return 0;
		}
		
        Set<Integer> myset = new HashSet<>();
        for(int i=0; i<G.length; i++) {
        	myset.add(G[i]);
        }
//        printset(myset);
        
        int totalsets = 0;
        boolean newSetStart = true;
        
        ListNode curr = head;
//        System.out.println(head.val);
        
        while(curr!=null) {
//        	System.out.print("curr=" + curr.val);
//        	System.out.print("\tmyset.contains=" + myset.contains(curr.val));
        	if(!myset.contains(curr.val)) {
        		newSetStart = true;
        		curr = curr.next;
//        		System.out.print("\ttotalsets=" + totalsets);
//        		System.out.println();
        		continue;
        	}
        	
        	if(newSetStart) {
        		totalsets++;
        		newSetStart = false;
        	}
//        	System.out.print("\ttotalsets=" + totalsets);
        	curr = curr.next;
//        	System.out.println();
        }
        
        return totalsets;
    }
	
	public void printset(Set<Integer> myset) {
		System.out.print("myset :  ");
		for(Integer num : myset) {
			System.out.print(num + "  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LLComponents obj = new LLComponents();
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
//		head.next.next.next.next.next = new ListNode(4);
//		head.next.next.next.next.next.next = new ListNode(7);
//		head.next.next.next.next.next.next.next = new ListNode(1);
		
		int[] G = {0,3,1,4};
		int ans = obj.numComponents(head, G);
		System.out.println(ans);
		
	}
}
