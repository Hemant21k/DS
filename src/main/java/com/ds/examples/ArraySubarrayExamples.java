package com.ds.examples;

import java.util.Arrays;

public class ArraySubarrayExamples {
	
	
	int max(int a,int b) {
		return Math.max(a+b, a);
	}
	
	int findMaxArray(int[] arr) { //{-1,2,4,5,3}
		int globalMax = Integer.MIN_VALUE;
		int localMax = 0;	
		for(int i=0;i<arr.length;i++) {
			if((localMax+arr[i])> localMax) {
				localMax += arr[i];
			} else {
				localMax = 0;
			}
			globalMax = Math.max(globalMax, localMax);
		}
		return globalMax;
	}

	
    static int maxSubArraySum(int a[], int size)
    {
    int max_so_far = a[0];
    int curr_max = a[0];
    int start=0,end = 0;
    boolean negsort = false;
 
    for (int i = 1; i < size; i++)
    {
    	if(a[i] > (curr_max+a[i])) { 
    		if(curr_max > a[i]) {
    			negsort = true;
    		} else {
    		start = i;
    		}
    		curr_max = a[i];
    	} else if((curr_max+a[i]) > a[i]) {
    		curr_max = curr_max+a[i];
    	}
    	
    	if(max_so_far < curr_max) {
    		max_so_far = curr_max;
    		end = i;
    	} 
    }
    if(negsort == true) {
    	start = end;
    }
    System.out.println("start: "+ start + " and " + "end: " + end);
    return max_so_far;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArraySubarrayExamples arrSE = new ArraySubarrayExamples();
		int[] arr = {1,3,4,-2};
		int ret = maxSubArraySum(arr,arr.length); //arrSE.findMaxArray(arr); 
		System.out.println(ret);

	}

}
