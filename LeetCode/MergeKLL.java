/*
 * Problem link : https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Merging sorted k linked lists in a single linked list in sorted fashion
 */

public class MergeKLL {
	
	public ListNode merge(ListNode[] lists, int EmptyLists, int len, boolean[] emptystatus) {
		// when all lists are empty return null
		if(EmptyLists == len) {
			return null;
		}
		// res will store the answer
		ListNode res = null;
		// max will store the min value of first node of all non empty lists
		int max = Integer.MAX_VALUE;
		// id will store the index of list which has the first node as min
		int id = -1;
		for(int i=0; i<len; i++) {
			if(lists[i] == null) {
				if(emptystatus[i] != true) {
					EmptyLists++;
					emptystatus[i] = true;
				}				
			}
			else {
				if(lists[i].val < max) {
					max = lists[i].val;
					id = i;
				}
			}
		}
		
        if(id > -1){
        	// res stores the min of first nodes of non empty lists
            res = lists[id];
            // then removing the min node from the respected list
            lists[id] = lists[id].next;
            // res next node will be the min first node of remaining lists
		    res.next = merge(lists, EmptyLists, len, emptystatus);
        }
		
		return res;
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        int numberOfEmptyLists = 0;
        int len = lists.length;
        boolean[] emptystatus = new boolean[len];
        for(int i=0; i<len; i++) {
        	if(lists[i] == null)
        		numberOfEmptyLists++;
                emptystatus[i] = true;
        }
        
        return merge(lists, numberOfEmptyLists, len, emptystatus);
    }
}
