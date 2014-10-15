package com.kevinsprong;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
	// CLRS suggests LSD using any stable sort and in particular counting sort,
	// but most implementations suggest a bucket-based sort
	public static void radixSort(int[] A) {
		// will still need extra space for buckets, but will assign back to 
		// original array
		final int RADIX = 10;
		
		// initialize buckets
		@SuppressWarnings("unchecked")  // safe since we only assign ints
		ArrayList<Integer>[] buckets = new ArrayList[RADIX];
		for (int i = 0; i < RADIX; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		
		// loop over A, for each significant digit
		int divisor = 1;  // isolate nth significant digit
		boolean maxDigits = false;
		while (!maxDigits) {
			maxDigits = true;
			// bucket A based on significant digit
			for (int a : A) {
				int tmp = a / divisor;
				int sig = (tmp % RADIX);
				buckets[sig].add(a);
				// see if we have more sig digits to process
				if (maxDigits && tmp > RADIX) {
					maxDigits = false;
				}
			}
			
			// reassign buckets into A
			int j = 0;
			for (int i = 0; i < RADIX; i++) {
				for (int a : buckets[i]) {
					A[j] = a;
					j++;
				}
				buckets[i].clear();
			}
			
			divisor *= RADIX;
		}
	}
	public static void main(String[] args) {
		System.out.println("\nRadix Sort test");
		int[] array = new int[30];
		util.fillWithRandomInts(array);
		System.out.println(Arrays.toString(array));
		radixSort(array);
		System.out.println(Arrays.toString(array));
	}
}
