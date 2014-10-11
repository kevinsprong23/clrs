package com.kevinsprong;

import java.util.Arrays;

public class HeapSort {
	
	// methods to get index of the parent or left/right child
	// of the node at index i
	@SuppressWarnings("unused")
	private static int parentIdx(int i) {
		return (i - 1) / 2;  // no need for Math.floor; integer div.
	}
	private static int leftIdx(int i) {
		return 2 * i + 1;
	}
	private static int rightIdx(int i) {
		return 2 * i + 2;
	}
	
	// restore max-heap property for the heap with 
	// parent node at index i 
	// assumes children of A[i] are roots of max-heaps 
	public static void maxHeapify(int[] A, int i, int heapMaxIdx) {
		int L = leftIdx(i);
		int R = rightIdx(i);
		int largest = i;
		if (L <= heapMaxIdx && A[L] > A[i]) {
			largest = L;
		}
		if (R <= heapMaxIdx && A[R] > A[largest]) {
			largest = R;
		}
		if (largest != i) {
			util.swap(A, i, largest);
			maxHeapify(A, largest, heapMaxIdx);
		}	
	}
	
	// turn an arbitrary array into a max-heap
	public static void buildMaxHeap(int[] A) {
		int heapMaxIdx = A.length - 1;
		for (int i = heapMaxIdx / 2; i >= 0; i--) {
			maxHeapify(A, i, heapMaxIdx);
		}
	}
	
	// heap sort
	public static void heapSort(int[] A) {
		int heapMaxIdx = A.length - 1;
		buildMaxHeap(A);
		for (int i = A.length - 1; i > 0; i--) {
			util.swap(A, 0, i);  // since A[0] is max element
			heapMaxIdx--;
			maxHeapify(A, 0, heapMaxIdx);
		}
	}
	
	public static void main(String[] args) {
		/*
		System.out.println("\nMax Heapify test");
		int[] array = new int[]{16,4,10,14,7,9,3,2,8,1};
		System.out.println(Arrays.toString(array));
		maxHeapify(array, 1, array.length-1);
		System.out.println(Arrays.toString(array));
		

		System.out.println("\nBuild Max Heap test");
		array = new int[20];
		util.fillWithRandomInts(array);
		System.out.println(Arrays.toString(array));
		buildMaxHeap(array);
		System.out.println(Arrays.toString(array));
		*/
		
		System.out.println("\nHeap Sort test");
		int[] array = new int[20];
		util.fillWithRandomInts(array);
		System.out.println(Arrays.toString(array));
		heapSort(array);
		System.out.println(Arrays.toString(array));
		
	}
	
}
