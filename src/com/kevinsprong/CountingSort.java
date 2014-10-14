package com.kevinsprong;

import java.util.Arrays;

public class CountingSort {
	
	// sort n integers in O(n) time if they are all <= a known k
	public static int[] countingSort(int[] A, int k) {
		int[] B = new int[A.length];
		int[] C = new int[k + 1];
		
		// step 1: fill each C[i] with count of how many times A[j] == i
		for (int i = 0; i < C.length; i++) {
			C[i] = 0;
		}
		
		for (int i = 0; i < A.length; i++) {
			C[A[i]]++;
		}
		
		// step 2: make C[i] be count of all A[j] <= i
		for (int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}
		
		// step 3: populate B
		for (int j = A.length - 1; j >= 0; j--) {
			B[C[A[j]] - 1] = A[j];  // -1 here to jive w/ CLRS' 1-indexing
			C[A[j]]--;
		}
		
		
		return B;
	}
	
	public static void main(String[] args) {	
		int arrayLen = 20;
		System.out.println("\nCounting Sort test");
		int[] array = new int[arrayLen];
		util.fillWithRandomInts(array);
		
		System.out.println(Arrays.toString(array));
		array = countingSort(array, arrayLen * 4);
		System.out.println(Arrays.toString(array));
	}
}
