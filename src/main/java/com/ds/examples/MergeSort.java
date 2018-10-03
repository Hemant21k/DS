package com.ds.examples;

public class MergeSort {
	
	public void driver(int[] arr) {
		int start=0,end;
		end = arr.length - 1;
		sortFunction(arr,start,end);
	}
	
	public void sortFunction(int[] Arr,int start,int end) {
		//int mid = (start + end)/2;
		if(start < end) {
		int mid = (end + start)/2;
		sortFunction(Arr,start,mid);
		sortFunction(Arr,mid+1,end);
		merge(Arr,start,mid,end);	
	}
	}
	
	public void merge(int[] Arr,int start,int mid,int end) {
		int p = start;
		int q = mid+1;

		int[] tmp = new int[end - start+1];
		int k=0;
		
		for(int i = start;i<=end;i++) {
			if(p > mid)
				tmp[k++] = Arr[q++];
			else if(q > end)
				tmp[k++] = Arr[p++];
			else if(Arr[p] < Arr[q])
				tmp[k++] = Arr[p++];
			else
				tmp[k++] = Arr[q++];

		}
		
		for(int t=0;t<k;t++) {
			Arr[start++] = tmp[t];
		}
		
		
		
	}

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7};
		MergeSort mms = new MergeSort();
		mms.driver(arr);
		printArray(arr);
	}

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
