package com.ds.examples;

public class LinkedList {

	private class Node {

		Node(int data2) {
			this.data = data2;
		}

		Node next = null;
		int data;
	}

	private Node head;

	public void insert(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(data);
		}
	}

	public void delete(int key) {
		Node current = head;
		Node previous = current;
		Node deleted = null;
		while (current != null) {
			if (current.data == key) {
				if (current == head) {
					head = current.next;
					deleted = current;
					deleted = null;
					previous = head;
				} else if (current.next == null) {
					previous.next = null;
					deleted = current;
					deleted = null;
				} else {
					previous.next = current.next;
					deleted = current;
					deleted = null;
				}
			} else {
				previous = current;
			}

			current = current.next;
		}
	}

	static void printLinkedList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	Node mergeLinkedList(Node head1, Node head2) {

		Node head = null;
		Node curr = null;

		while (head1 != null && head2 != null) { // 1->2->3->4 ; 5->6->7
			if (head1.data < head2.data) {
				if (head == null) {
					head = head1;
					curr = head;

				} else {
					curr.next = head1;
					curr = curr.next;
				}
				head1 = head1.next;
			} else {
				if (head == null) {
					head = head2;
					curr = head;
				} else {
					curr.next = head2;
					curr = curr.next;
				}
				head2 = head2.next;
			}
		}

		if (head1 == null) {
			curr.next = head2;
		} else if (head2 == null) {
			curr.next = head1;
		}

		return head;
	}

	Node mergeLinkedListRec(Node head1, Node head2) {

		if (head1 == null)
			return head2;

		if (head2 == null)
			return head1;

		Node head = new Node(0);

		if (head1.data < head2.data) {
			head = head1;
			head1.next = mergeLinkedListRec(head1.next, head2);
		} else {
			head = head2;
			head2.next = mergeLinkedListRec(head1, head2.next);
		}
		return head;
	}
	
	Node reverseUtil(Node curr,Node prev) {
		if(curr.next == null) {
		head = curr;
		curr.next = prev;	
		return null;
		} 
		
		Node next1 = curr.next;
		curr.next = prev;
		reverseUtil(next1,curr);	
		return head;
	}
	
	void reverseLinkedList(Node head) {
		// 1 -> 2 -> 3 -> 4 -> 5 |  5 -> 4 
		Node headnew = reverseUtil(head,null);
		printLinkedList(headnew); 
	}

	
	static void printReversedLinkedList(Node head) {
		if(head == null)
			return;
		
		printReversedLinkedList(head.next);
		
		System.out.println(head.data);
	}
	
	public static void main(String[] args) {
		LinkedList Ll = new LinkedList();

		LinkedList Ll1 = new LinkedList();
		LinkedList Ll2 = new LinkedList();

		Ll1.insert(1);
		Ll1.insert(5);
		Ll1.insert(8);
		Ll1.insert(9);
		Ll1.insert(21);

		Ll2.insert(2);
		Ll2.insert(3);
		Ll2.insert(6);
		Ll2.insert(7);
		Ll2.insert(10);

/*		Node mergedHead = Ll.mergeLinkedList(Ll1.head, Ll2.head);

		printLinkedList(mergedHead);*/
		//printLinkedList(Ll1.head);
		//Ll1.reverseLinkedList(Ll1.head);
		printReversedLinkedList(Ll1.head);

	}
}
