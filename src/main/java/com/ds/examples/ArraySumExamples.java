package com.ds.examples;

public class ArraySumExamples {
	
	//5,6,7,8 | 1,2,3,4 -> 
	int findPairs(int[] arr,int lowstart,int highend,int sum) {
	int num=0;
		while(lowstart > highend & lowstart<=arr.length-1 & highend>=0) {
			if(arr[lowstart]+arr[highend] == sum) {
				num=num+1;
				lowstart++;
				highend--;
			continue;
			}
			if(arr[lowstart]+arr[highend]< sum)
				lowstart++;
			else
				highend--;
		}
		
		return num;
	}
	
	int calculateArraySum(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	int calculateR0(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum += i*arr[i];
		}
		return sum;
	}
	
	int maximumRotatedSum(int[] arr) {
		int sum = calculateArraySum(arr);
		int sumR0= calculateR0(arr);
		int maxValue = sumR0;
		int n=arr.length;
		for(int j=1;j<n;j++) {
			sumR0 = sumR0 + sum - n*arr[n-j];
			if(sumR0 > maxValue) {
				maxValue = sumR0; }
		}
		return maxValue;
	}

	
	int findNumRotations(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i] > arr[i+1])
				return i+1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr =  {8, 9, 10, 7}; //{15,16,1,2,3,4,5,6};
		ArraySumExamples arrSum = new ArraySumExamples();
		System.out.println(arrSum.findNumRotations(arr));

	}
}