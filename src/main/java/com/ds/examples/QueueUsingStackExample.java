package com.ds.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class QueueUsingStackExample {

	Stack<Integer> insertStack = new Stack<Integer>();
	Stack<Integer> deleteStack = new Stack<Integer>();

	void insertAtBottom(Stack<Integer> stack, int data) {

		if (stack.isEmpty()) {
			stack.push(data);
			return;
		}

		int temp = stack.pop();
		insertAtBottom(stack, data);

		stack.push(temp);

	}
	
	void deleteItem(Stack<Integer> stack,int data) {
		
		if(stack.isEmpty())
			return;
		
		int temp = stack.pop();
		if(temp == data) {
			return;
		} else {			
			deleteItem(stack,data);
			stack.push(temp);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStackExample quse = new QueueUsingStackExample();
		Stack<Integer> iStack = new Stack<Integer>();
		Integer[] arr = { 2, 3, 4, 55, 6, 9 };
		List<Integer> l = Arrays.asList(arr);
		l.forEach((k) -> iStack.push(k));
		System.out.println("Before insert");
		iStack.forEach((k) -> System.out.println(k));
		quse.insertAtBottom(iStack, 99);
		System.out.println("After insert");
		iStack.forEach((k) -> System.out.println(k));
		
		quse.deleteItem(iStack, 66);
		System.out.println("After deletion");
		iStack.forEach((k) -> System.out.println(k));
	}

}
