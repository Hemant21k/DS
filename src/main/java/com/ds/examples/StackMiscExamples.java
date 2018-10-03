package com.ds.examples;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class StackMiscExamples {
	
	
	/*
	 * https://www.geeksforgeeks.org/check-if-stack-elements-are-pairwise-consecutive/
	 * https://www.geeksforgeeks.org/the-stock-span-problem/
	 * https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
	 */
	
	static void recRemoveDuplicates(int[] arr) {
		   Deque<Integer> stack = new ArrayDeque<Integer>();
		
	}
	
	static int findLargestRectangle(int[] arr) {
		int length = arr.length;
		int i=0,maxArea=0,currntMax=0;
		Deque<Integer> stack = new ArrayDeque<Integer>();
		while(i < length) {
			if(stack.isEmpty()|| arr[stack.peek()] < arr[i]) {
				stack.push(i);
				i++;
			} else {
				int top = stack.peek();
				stack.pop();
				currntMax = arr[top]* (stack.isEmpty()? i: i- stack.peek()-1);
			}
			
			if(currntMax>maxArea)
				maxArea=currntMax;
		}
		
		while(stack.isEmpty()==false) {
			int top = stack.peek();
			stack.pop();
			
			currntMax = arr[top]* (stack.isEmpty()? i: i- stack.peek()-1);

			if(currntMax>maxArea)
				maxArea=currntMax;
			
		}
		
		return maxArea;
		
	}
	
	
	static int[] findIntersection(int[] nums1,int[] nums2) {
		int[] output = new int[nums1.length+nums2.length];
		int k=0;
		Map<Integer,String> map = new HashMap<Integer,String>();
		
		for(int i:nums1) {
			map.put(i, "value");
		}
		
		for(int i:nums2) {
			if(map.get(i) != null) {
			    output[k++] = i;
			}
			/*else
				output[k++] = i;*/
		}
		
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6, 2, 5, 4, 5, 1, 6};
		//System.out.println(findLargestRectangle(arr));

		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		System.out.println(Arrays.toString(findIntersection(nums1,nums2)));
		int sum = 0;
		for(int i:nums2) {
			sum = sum^i;
		}
		for(int l:nums1) {
			sum = sum^l;
		}
		System.out.println(sum);
	}

}


 