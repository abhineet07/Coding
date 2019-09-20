package leetcode;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class SwapNodesInPair {
	public ListNode swapPairs(ListNode head) {
		if(head == null) {
			return null;
		}
		
		  ListNode node2x = head;
		  while(node2x.next!=null && node2x.next.next!=null) {
		  	int temp = node2x.val;
		  	node2x.val = node2x.next.val;
		  	node2x.next.val = temp;
		  	
		  	node2x = node2x.next.next;
		  }
		  
		  if(node2x.next!=null) {
			  int temp = node2x.val;
			  node2x.val = node2x.next.val;
			  node2x.next.val = temp;
		  }
		  
//		  System.out.println("\tData : " + node2x.val);
		  
		  return head;
	}

	public void display(ListNode head) {
		ListNode curr = head;
		while(curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SwapNodesInPair obj = new SwapNodesInPair();
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next = new ListNode(60);
		
		obj.display(head);
		ListNode ans = obj.swapPairs(head);
		obj.display(ans);
	}
}

