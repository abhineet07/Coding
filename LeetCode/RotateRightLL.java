package leetcode;

public class RotateRightLL {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null) {
			return null;
		}
		
        int length = 0;
        ListNode curr = head;
        while(curr != null) {
        	length++;
        	curr = curr.next;
        }
       
        k = k % length;
        if(k == 0) {
        	return head;
        }
        
        int r = length - k;
        curr = head;
        ListNode last = head;
        
        int i = 1;
        while(last.next!=null) {
        	if(i < r) {
        		curr = curr.next;
        		i++;
        	}
        	last = last.next;
        }
        
        ListNode newhead = curr.next;
        curr.next = null;
        last.next = head;
        
        return newhead;        
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
		RotateRightLL obj = new RotateRightLL();
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next = new ListNode(60);
		
		obj.display(head);
		head = obj.rotateRight(head, 7);
		obj.display(head);
	}
}
