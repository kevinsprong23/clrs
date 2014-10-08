package com.kevinsprong;

import java.util.Arrays;

public class Problem2_2 {
	public static void bubbleSort(int[] array) {
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < array.length-1; i++) {
				if (array[i] > array[i+1]) {
					util.swap(array, i, i+1);
					swapped = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[20];
		util.fillWithRandomInts(array);
		
		System.out.print("Test array: ");
		System.out.println(Arrays.toString(array));
		
		System.out.print("Bubble sorted: ");
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}
}
