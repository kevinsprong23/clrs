package com.kevinsprong;

import java.util.Arrays;
import java.util.Random;

public class RandomizedSelect {
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
	
	// find the i'th smallest element in array A
	public static int randomizedSelect(int[]A, int p, int r, 
			int i, Random rand) {
		if (p == r) {
			return A[p];
		}
		
		int q = partition(A, p, r, rand);
		
		int k = q - p + 1;
		
		if (i == k) {
			return A[q];
		} else if (i < k) {
			return randomizedSelect(A, p, q-1, i, rand);
		} else {
			return randomizedSelect(A, q+1, r, i - k, rand);
		}
	}
	
	public static int randomizedSelect(int[]A, int i) {
		// O(n) space, but don't permute the original array
		int[] B = util.deepCopy(A);  
		Random rand = new Random();
		
		return randomizedSelect(B, 0, B.length - 1, i, rand);
	}
	
	public static void main(String[] args) {
		int[] array = new int[20];
		util.fillWithRandomInts(array);
		
		int n = 4;
		int nth = randomizedSelect(array, n);
		
		System.out.print("Test array: ");
		System.out.println(Arrays.toString(array));
		
		
		System.out.print("Sorted: ");
		Quicksort.quicksort(array);
		System.out.println(Arrays.toString(array));
		
		System.out.println("Randomized select with n = " + 
				Integer.toString(n) + ": returns " + Integer.toString(nth));
	}
	
	
}
