package com.ds.examples;

public class InverseCountExample {

	public int sort(int[] Arr) {
		return mergeSort(Arr, 0, Arr.length - 1);
	}

	public int mergeSort(int[] Arr, int start, int end) {
		int invCount = 0;
		if (start < end) {
			int mid = (start + end) / 2;
			invCount = mergeSort(Arr, start, mid);
			invCount += mergeSort(Arr, mid + 1, end);
			invCount += merge(Arr, start, mid, end);
		}
		//System.out.println("inside mergeSort: " + invCount);
		return invCount;
	}

	private int merge(int[] arr, int start, int mid, int end) {

		int p = start, k = 0, invCount = 0;
		int q = mid + 1;
		int[] tmp = new int[end - start + 1];

		for (int i = start; i <= end; i++) {

			if (p > mid)
				tmp[k++] = arr[q++];

			else if (q > end)
				tmp[k++] = arr[p++];

			else if (arr[p] > arr[q]) {
				tmp[k++] = arr[q++];
				invCount = invCount + (mid - p +1) ; //(mid - i); //1 6 20 4 5   //org -> 1 20 6 4 5 
			}

			else
				tmp[k++] = arr[p++];

		}

		for (int t = 0; t < k; t++)
			arr[start++] = tmp[t];

		return invCount;

	}

	public static void main(String[] args) {
		int arr[] = { 12,11,13,5,6,7};
		InverseCountExample mms = new InverseCountExample();
		System.out.println("inverse count = " + mms.sort(arr));
		printArray(arr);
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
