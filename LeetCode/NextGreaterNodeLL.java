package leetcode;

/*
 * 	https://leetcode.com/problems/next-greater-node-in-linked-list/
 */

public class NextGreaterNodeLL {
	
	// Solution - 1
	public int[] nextLargerNodes(ListNode head) {
        if(head == null) {
        	int[] arr = new int[0];
        	return arr;
        }
        else if(head.next == null) {
        	int[] arr = new int[1];
        	arr[0] = 0;
        	return arr;
        }
        else {
        	int length = 1;
        	ListNode nodeA = head;
        	ListNode nodeB = head.next;
        	
        	while(nodeA.next != null) {
//        		System.out.println("NodeA = " + nodeA.val);
        		nodeB = nodeA.next;
        		int temp = nodeA.val;
        		nodeA.val = 0;
        		
        		while(nodeB != null) {
//        			System.out.println("\tNodeB = " + nodeB.val);
        			if(nodeB.val > temp) {
        				nodeA.val = nodeB.val;
        				break;
        			}
        			nodeB = nodeB.next;
        		}
        		
        		nodeA = nodeA.next;
        		length++;
        	}
        	
        	if(nodeA != null){
        		nodeA.val = 0;
        	}
        	
//        	display(head);
//        	System.out.println("length = " + length);
        	
        	int[] arr = new int[length];
        	ListNode curr = head;
        	int id = 0;
        	while(curr != null) {
        		arr[id] = curr.val;
        		id++;
        		curr = curr.next;
        	}
        	
        	return arr;
        }
    }
	
	// Solution - 2
	int[] res;
	
	public void nextLargerNodes2(ListNode head) {
		
	}
	
	// Utility Functions
	public void display(ListNode head) {
		ListNode curr = head;
		while(curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	public void printArray(int[] arr) {
		System.out.print("ARRAY :  ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		NextGreaterNodeLL obj = new NextGreaterNodeLL();
		ListNode head = new ListNode(1);
		head.next = new ListNode(7);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next.next = new ListNode(1);
		
		obj.display(head);
		int[] ans = obj.nextLargerNodes(head);
		obj.printArray(ans);
		
	}
}
