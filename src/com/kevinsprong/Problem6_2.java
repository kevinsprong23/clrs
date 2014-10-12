package com.kevinsprong;

import java.util.Arrays;

public class Problem6_2 {
	// analysis of D-ary heaps
	 
	// a. How would you represent a d-ary heap in an array?
	// children of index i are at d*i + 1...d*i + 2..d*(i + 1)
	
	// b. What is the height of a d-ary heap of n elements?
	// floor ( log d of n)

	// heap operations from earlier in the chapter
	// methods to get index of the parent or left/right child
	// of the node at index i
	@SuppressWarnings("unused")
	private static int parentIdx(int i, int d) {
		return (i - 1) / d;  // no need for Math.floor; integer div.
	}
	private static int childIdx(int i, int d, int k) {
		// return the kth child of the d-ary heap at index i
		return d * i + k;
	}
	

	// restore max-heap property for the heap with 
	// parent node at index i 
	// assumes children of A[i] are roots of max-heaps 
	public static void maxHeapify(int[] A, int i, int d, 
			int heapMaxIdx) {
		int largest = i;
		// check all of this heap's children
		for (int k = 1; k <= d; k++) {
			int C = childIdx(i, d, k);
			if (C <= heapMaxIdx && A[C] > A[largest]) {
				largest = C;
			}
		}
		if (largest != i) {
			util.swap(A, i, largest);
			maxHeapify(A, largest, d, heapMaxIdx);
		}	
	}

	// turn an arbitrary array into a d-ary max-heap
	public static void buildMaxHeap(int[] A, int d) {
		int heapMaxIdx = A.length - 1;
		for (int i = heapMaxIdx / d; i >= 0; i--) {
			maxHeapify(A, i, d, heapMaxIdx);
		}
	}

	public static void heapSort(int[] A, int d) {
		int heapMaxIdx = A.length - 1;
		buildMaxHeap(A, d);
		for (int i = A.length - 1; i > 0; i--) {
			util.swap(A, 0, i);  // since A[0] is max element
			heapMaxIdx--;
			maxHeapify(A, 0, d, heapMaxIdx);
		}
	}
	
	// new shit
	// d * logd (n), via max heapify
	public static int heapExtractMax(int[] A, int d, int maxHeapIdx) 
			throws IllegalArgumentException {
		if (maxHeapIdx < 0) {
			throw new IllegalArgumentException("heap underflow");
		}
		int m = A[0];
		A[0] = A[maxHeapIdx];
		// in "real life" would want to wrap this in a heap object 
		// so we can track the heap size 
		maxHeapify(A, 0, d, maxHeapIdx-1);
		return m;
	}
	
	// these next two are logd (n)
	public static void heapIncreaseKey(int[] A, int d, int i, int key) {
		if (key < A[i]) {
			throw new IllegalArgumentException("key is smaller than current val");
		}
		A[i] = key;
		int par = parentIdx(i, d);
		while (i > 0 && A[i] > A[par]) {
			util.swap(A, i, par);
			i = par;
			par = parentIdx(i, d);
		}
	}
	
	public static void maxHeapInsert(int[] A, int d, int maxHeapIdx,
			int key) {
		A[maxHeapIdx+1] = Integer.MIN_VALUE;
		heapIncreaseKey(A, d, maxHeapIdx+1, key);
	}
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("\nHeap Sort test");
		int[] array = new int[20];
		util.fillWithRandomInts(array);
		System.out.println(Arrays.toString(array));
		heapSort(array, 3);
		System.out.println(Arrays.toString(array));
		
	}

}
