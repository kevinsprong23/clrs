package com.kevinsprong;

import java.util.Arrays;

public class InsertionSort {
	
	private static void insertionSort(int[] array) {
		// loop indices off by 1; Cormen et. al index is 1:length
		for (int j = 1; j < array.length; j++) {
			int key = array[j];
			int i = j - 1;
			while (i >= 0 && array[i] > key) {
				array[i+1] = array[i];
				i -= 1;
			}
			array[i+1] = key;
		}
	}
	
	private static void insertionSortDec(int[] array) {
		// loop indices off by 1; Cormen et. al index is 1:length
		for (int j = 1; j < array.length; j++) {
			int key = array[j];
			int i = j - 1;
			while (i >= 0 && array[i] < key) {
				array[i+1] = array[i];
				i -= 1;
			}
			array[i+1] = key;
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[20];
		util.fillWithRandomInts(array);
		
		System.out.print("Test array: ");
		System.out.println(Arrays.toString(array));
		
		System.out.print("Sorted: ");
		insertionSort(array);
		System.out.println(Arrays.toString(array));
		
		System.out.print("Reverse Sorted: ");
		insertionSortDec(array);
		System.out.println(Arrays.toString(array));
	}
}
