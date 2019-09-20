package leetcode;

public class LinkedList {
	Node last;
	Node head;
	
	class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	public LinkedList() {
		head = null;
		last = head;
	}
	
	public void addLast(int data) {
		Node node = new Node(data);
		if(head==null) {
			head = node;
			last = head;
		}
		else {
			last.next = node;
			last = node;
		}
	}
	
	public void addFirst(int data) {
		Node node = new Node(data);
		if(head==null) {
			head = node;
			last = head;
		}
		else {
			node.next = head;
			head = node;
		}
	}
	
	public void displayLinkedList() {
		Node curr = head;
		while(curr!=null) {
			System.out.print(curr.data + "  ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	public Node deleteFirst() {
		if(head == null) {
			return null;
		}
		else {
			Node node = head;
			head = head.next;
			return head;
		}
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addLast(10);
		ll.displayLinkedList();
		ll.addLast(20);
		ll.addLast(30);
		ll.displayLinkedList();
		ll.addFirst(40);
		ll.displayLinkedList();
		ll.deleteFirst();
		ll.deleteFirst();
		ll.displayLinkedList();
	}
	
	
}
