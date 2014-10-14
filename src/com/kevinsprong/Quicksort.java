package com.kevinsprong;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {
	public static int partition(int[] A, int p, int r, Random rand) {
		// permute A[r] with a random element
		int idx = rand.nextInt(r - p + 1) + p;
		util.swap(A,  idx, r);
		
		// choose a pivot
		int pivVal = A[r];
		
		// keep track of top idx of filtered vals
		int q = p;
		
		// do the filtering
		for (int i = p; i < r; i++) {
			if (A[i] <= pivVal) {
				util.swap(A, i, q);
				q++;
			}
		}
		util.swap(A, r, q);
		return q;
	}
	
	public static void quicksort(int[] A, int p, int r, Random rand) {
		if (p < r) {
			int q = partition(A, p, r, rand);
			quicksort(A, p, q-1, rand);
			quicksort(A, q+1, r, rand);
		}
	}
	
	public static void quicksort(int[] A) {
		Random rand = new Random();
		if (A.length > 1) {
			quicksort(A, 0, A.length -1, rand);
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
