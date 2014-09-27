package com.kevinsprong;

import java.util.Arrays;

public class MergeSort {
	/**
	 * Merge two sorted sublists into a single list in place
	 * @param A a list containing two sorted sublists
	 * @param p start index of first list
	 * @param q end index of first list
	 * @param r end index of second list
	 */
	public static void merge(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		
		// this is still only O(N) space since merge gets called last in the 
		// recursion, but optimized implementations use one copy passed around
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		
		for (int i = 0; i < n1; i++) {
			L[i] = A[p + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = A[q + 1 + j];
		}
		
		// sentinel values per Cormen et. al
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		
		// sentinel values allow skipping empty checks
		for (int k = p; k <= r; k++) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
		}
	}
	
	// Exercise 2.3-2
	public static void mergeWithoutSentinels(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		
		// in real merge sort these would be a single array with size equal to A
		// but this is the Cormen et. al implementation, so yeah.
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for (int i = 0; i < n1; i++) {
			L[i] = A[p + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = A[q + 1 + j];
		}
		
		int i = 0;
		int j = 0;
		int k = p;
		// without sentinels, need to do multiple passes
		while(i < L.length && j < R.length) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
				k++;
			} else {
				A[k] = R[j];
				j++;
				k++;
			}
		}
		// only one of these will get called
		for (int ii = i; ii < L.length; ii++) {
			A[k] = L[ii];
			k++;
		}
		for (int jj = j; jj < R.length; jj++) {
			A[k] = R[jj];
			k++;
		}
		
		
	}
	
	// the Cormen et. al method signature
	public static void mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;  // don't need floor b/c of integer div.
			mergeSort(A, p, q);
			mergeSort(A, q+1, r);
			merge(A, p, q, r);
		}
	}
	
	// overloaded to call on just an array
	public static void mergeSort(int[] A) {
		int p = 0, r = A.length - 1;
		mergeSort(A, p, r);
	}
	
	public static void main(String[] args) {
		System.out.println("Merge test");
		int[] array = {1,5,7,9,11,23,45,67,2,3,4,5,6,7,8};
		int p = 0, q = 7, r = array.length - 1;
		System.out.println(Arrays.toString(array));
		merge(array, p, q, r);
		System.out.println(Arrays.toString(array));
		
		System.out.println("\nMerge Sort test");
		array = new int[20];
		util.fillWithRandomInts(array);
		System.out.println(Arrays.toString(array));
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
}
