package com.ds.examples;

import java.util.Arrays;

public class PivotBinarySearchExample {

	void controller(int[] arr, int key) {
		int loc;
		int pivot = searchPivot(arr);
		if (pivot == -1) // no rotation
			BinarySearch(arr, 0, arr.length - 1, key);
		if (key >= arr[0])
			loc = BinarySearch(arr, 0, pivot, key);
		else
			loc = BinarySearch(arr, pivot + 1, arr.length - 1, key);

		System.out.println("key found at location " + loc);
	}

	int searchPivot(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1])
				return i;
		}
		return -1;
	}

	int BinarySearch(int[] arr, int start, int end, int key) { // 1,2,3,4,5,6

		if (end < start)
			return -1;

		int mid = (start + end) / 2;
		if (key == arr[mid])
			return mid;

		if (key < arr[mid])
			return BinarySearch(arr, start, mid - 1, key);
		else
			return BinarySearch(arr, mid + 1, end, key);

	}

	int BinarySearchMinimum(int[] arr, int start, int end) {

		if (start == end)
			return arr[start];

		if (end < start)
			return arr[0];

		int mid = (start + end) / 2;
		if (mid > start && arr[mid - 1] > arr[mid]) //{4,1,7,6,5} -> {7,6,5,4,1}
			return arr[mid];

		/*
		 * if(mid < end && arr[mid+1] < arr[mid]) return arr[mid+1];
		 */

		if (arr[mid] < arr[end]) {
			return BinarySearchMinimum(arr, start, mid - 1);
		} else {
			return BinarySearchMinimum(arr, mid + 1, end);
		}
	}

	int findMinimum(int[] arr) {

		return BinarySearchMinimum(arr, 0, arr.length - 1);
	}

	int maxHammingDistance(int[] arr) {
		int currHam = 0, maxHam = 0;
		int n = arr.length;
		int[] brr = new int[2 * arr.length];

		for (int i = 0; i < arr.length; i++) {
			brr[i] = arr[i];
			brr[i + arr.length] = arr[i];
		}

		System.out.println("doubled array: " + Arrays.toString(brr));

		for (int i = 1; i < n; i++) {

			for (int j = i, k = 0; j < i + n; j++, k++) {
				if (arr[k] != brr[j])
					currHam++;
			}

			if (currHam == n)
				return n;

			maxHam = Math.max(maxHam, currHam);
			currHam = 0;

		}

		return maxHam;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 }; // { 7, 8, 11,,12,13,14,1, 3, 4}; //{1,2,3,4,5,1,2,3,4,5}
		PivotBinarySearchExample pBinarySrch = new PivotBinarySearchExample();
		// int result = pBinarySrch.maxHammingDistance(arr);
		int result = pBinarySrch.findMinimum(arr);

		System.out.println(result);
	}

}
