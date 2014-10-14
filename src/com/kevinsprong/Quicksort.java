package com.kevinsprong;

import java.util.Arrays;

public class Quicksort {
	public static int partition(int[] A, int p, int r) {
		// choose a pivot
		int pivIdx = p + (r - p) / 2;
		int pivVal = A[pivIdx];
		
		// temporarily swap pivot and last val
		util.swap(A, pivIdx, r);
		
		// keep track of top idx of filtered vals
		int q = p;
		// do the filtering
		for (int i = p; i < r; i++) {
			if (A[i] < pivVal) {
				util.swap(A, i, q);
				q++;
			}
		}
		util.swap(A, r, q);
		return q;
	}
	
	public static void quicksort(int[] A, int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quicksort(A, p, q);
			quicksort(A, q+1, r);
		}
	}
	
	public static void quicksort(int[] A) {
		if (A.length > 1) {
			quicksort(A, 0, A.length -1);
		}
	}
	
	public static void main(String[] args) {
		/*
		System.out.println("\nPartition test");
		int[] array = new int[20];
		util.fillWithRandomInts(array);
		System.out.println(Arrays.toString(array));
		int q = partition(array, 0, array.length -1);
		System.out.println(q);
		System.out.println(Arrays.toString(array));
		*/
		
		System.out.println("\nQuicksort test");
		int[] array = new int[20];
		util.fillWithRandomInts(array);
		System.out.println(Arrays.toString(array));
		quicksort(array);
		System.out.println(Arrays.toString(array));
	}
	
}
