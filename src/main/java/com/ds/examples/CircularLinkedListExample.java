package com.ds.examples;

public class CircularLinkedListExample {

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
		
	}
	
	Node head = null;
	Node tail;
	
	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void insertElementToHead(int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
			head.next = head;
		} else {
			Node temp = head;
			node.next = head.next;
			temp.next = node;
			//head = node;
		}
		
	}
	
	public void deleteGivenElement(int data) {
		Node current = head.next;
		Node previous = head;
		Node deleted = null;
		if(head == null) {
			return;
		} else {
			do {
				if(current.data == data) {
					deleted = current;
					previous.next = current.next;
					deleted = null;
					return;
					
				} else {
					previous = current;
				}
				current = current.next;
			} while (current != head.next);
			
		}
	}
	
	public void printElements() {
		Node current = head;
		do {
			System.out.println("head: " + head.data + "," + "current: " + current.data);
			current = current.next;
		} while(current != head);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedListExample cLL = new CircularLinkedListExample();
		cLL.insertElementToHead(34);
		cLL.insertElementToHead(45);
		cLL.insertElementToHead(56);
		cLL.insertElementToHead(21);
		cLL.insertElementToHead(1);
		cLL.printElements();
		cLL.deleteGivenElement(34);
		System.out.println("After deletion CLL is: ");
		cLL.printElements();
	}

}
