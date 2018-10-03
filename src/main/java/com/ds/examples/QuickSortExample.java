package com.ds.examples;

public class QuickSortExample {
	
	public void driver(int[] arr) {
		quicksort(arr,0,arr.length-1);
	}
	
	public void quicksort(int[] arr,int start,int end) {
		if(start<end) {
			int pivot = partition(arr,start,end);
			System.out.println(pivot);
			quicksort(arr,start,pivot-1); //pivot is in place, rest needs to be sorted
			quicksort(arr,pivot+1,end);
		}
	}
	
	public int partition(int[] arr,int low,int high) 
	{
		int i = low -1;
		int pivot = arr[high];
		for(int j=low;j<high;j++) {
			if(arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;						
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		printArray(arr);
		return i+1;
	}
	
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {9,8,4,3,2,6};
		QuickSortExample qu = new QuickSortExample();
		qu.driver(arr);
		printArray(arr);
	}

}
