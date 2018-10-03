package com.ds.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackExamples {
	
	Stack<Integer> Elements = new Stack<Integer>();
	Stack<Integer> auxMin = new Stack<Integer>();
	
	int findminimuminConstantTime() {
		int min;
		if(auxMin.isEmpty()) 
			min = 0;
		else min = auxMin.peek();
		
		return min;
	}
	
	void addElements(int data) {
		Elements.push(data);
		int auxTop;
		if(!auxMin.empty()) {
			auxTop = auxMin.peek();
			if(auxTop > data)
				auxMin.push(data);
			else {
				int localMin = auxMin.pop();
				auxMin.push(localMin);
				auxMin.push(localMin);
			}
		}
		else
			auxMin.push(data);
	}
	
	void deleteElements() {
		if(!Elements.isEmpty())
			Elements.pop(); auxMin.pop();
		
	}
	
	void printElements() {
		Elements.forEach((k) -> System.out.println("Elements: " + k));
		auxMin.forEach((k) -> System.out.println("auxMin: "+ k));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackExamples stE = new StackExamples();
		Integer[] arr = {9,8,2,6,3,7};
		List<Integer> arrList = Arrays.asList(arr);
		arrList.forEach((k) -> stE.addElements(k));
		
		stE.printElements();
	
		System.out.println(stE.findminimuminConstantTime());
		
		for(Integer i: arrList) {
			stE.deleteElements();
		}
		
		stE.printElements();

	}

}
