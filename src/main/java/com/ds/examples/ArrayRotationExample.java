package com.ds.examples;

public class ArrayRotationExample {

	void method1TempArray(int[] arr, int d) {
		int[] temp = new int[d];
		for (int i = 0; i < d; i++) {
			temp[i] = arr[i];
		}

		for (int i = 0; i < arr.length - d; i++) {
			arr[i] = arr[i + d];
		}

		for (int i = temp.length - 1; i >= 0; i--) {
			arr[arr.length - d + 1] = temp[i];
			d++;
		}
	}

	void method2OnebyOneRotation(int[] arr, int d) {
		int tmp;

		for (int k = 0; k < d; k++) {
			tmp = arr[0];
			for (int i = 0; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			arr[arr.length - 1] = tmp; // 45,6,7,8,9,23
		}
	}

	void jugglingMethod(int[] arr, int d) {
		int setSize = gcd(arr.length, d); // 23,45,6,7,8,9
		int tmp, k = 0, l;
		for (int i = 0; i < d; i++) {
			tmp = arr[i];
			l = i;
			while (l + setSize < arr.length) {
				arr[l] = arr[l + setSize];
				l = l + setSize;
			}
			arr[l] = tmp;
			System.out.println("\n");
			printArray(arr);
		}

	}

	int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	static void arrayReverse(int[] arr, int start, int end) {
		int i = start;
		int j = end; // 1,2,3,4,5 -> 2,1,5,4,3 -> 3,4,5,1,2
		while (i < j) {
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}
	}

	void reversalMethod3(int[] arr, int d) {
		// arr[0-d-1] arr[d-lentgh-1]
		arrayReverse(arr, 0, d - 1);
		arrayReverse(arr, d, arr.length - 1);
		arrayReverse(arr, 0, arr.length - 1);

	}

	static void swapBlocks(int[] arr, int start1, int end1, int start2, int end2) {
		while (start1 <= end1 && start2 <= end2) { // 1,2,3,4,5 -> 1,2 4,5 -> 4,5 1,2
			int tmp = arr[start1];
			arr[start1] = arr[start2];
			arr[start2] = tmp;
			start1++;
			start2++;
		}
	}
	
	static void swapSegments(int[] arr,int left,int right,int L) {
		
	}
	
	void blockSwapMethod(int[] arr,int d) {
		int[] x; int[] y;
		int end = arr.length -1;
		int Xlen = d-1 - 0 +1;
		int Ylen = arr.length - 1 - d +1;  //1,2,3,45,6 -> 
		if(Xlen < Ylen) {
			swapBlocks(arr,0,d-1,end-d,end);
			//swapBlocks(arr,)
		} else {
			
		}
		
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 23, 45, 6, 7, 8, 9 };
		System.out.println("Before Rotation");
		printArray(arr);

		ArrayRotationExample arrRot = new ArrayRotationExample();
		/*
		 * System.out.println("\n" + "After juggling Rotation");
		 * arrRot.jugglingMethod(arr, 2);
		 */
		/*
		 * System.out.println("\n" + "After Rotation"); arrRot.reversalMethod3(arr, 2);
		 */
		swapBlocks(arr, 1, 2, 4, 5);
		printArray(arr);

	}

}
