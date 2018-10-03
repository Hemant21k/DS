package com.ds.examples;

import java.util.Arrays;

public class ArrayUtilExamples {
	
	void mergeSortedArrayNew(int arr[],int start,int mid,int end) {
		int p = start; // {1,2,7,8,3,4,5,6};
		int q = mid+1;
		int k=0;
		int tmp[] = new int[end - start+1];
		
		for(k=0;k<tmp.length;k++) {
			if(p > mid) {
				tmp[k] = arr[q];
				q++;
			} else if(q > end){
				tmp[k] = arr[p];
				p++;
			}
			else if(arr[p] < arr[q]) {
				tmp[k]= arr[p];
				p++;
			}
			
			else if(arr[q] < arr[p]) {
				tmp[k] = arr[q];
				q++;
			}
			
		}
		
		for(int i=0;i<k;i++) {
			arr[start++]=tmp[i];
		}
	}
	
	void mergeSortedArray(int[] arr,int start,int mid,int end) {
		int p = start;  // {1,2,7,8,3,4,5,6};
		int q = mid+1;
		int[] tmp = new int[end - start+1]; 
		int k=0;
		
		while(p <= mid && q <= end) {
			if(arr[p] < arr[q]) {
				tmp[k]= arr[p];
				k++;
				p++;				
			} else {
				tmp[k]=arr[q];
				k++;
				q++;
			}
		}
		
		if(p <= mid) {
			while(p <= mid) {
				tmp[k] = arr[p];
				k++;
				p++;
			}
		} else {
			while(q <= end) {
				tmp[k] = arr[q];
				k++;q++;
			}
		}
		
		for(int i=start;i<=end;i++) {
			arr[i] = tmp[i];
			}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayUtilExamples obj = new ArrayUtilExamples();
		int[] arr = {1,3,10,7,8,9};
		int mid = (0+4)/2;
		obj.mergeSortedArrayNew(arr, 0, mid, 4);
		System.out.println(Arrays.toString(arr));

	}

}
