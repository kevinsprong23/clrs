package com.kevinsprong;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
	
	private static void insertionSort(int[] array) {
		// loop indices off by 1; Cormen index is 1:length
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
		// loop indices off by 1; Cormen index is 1:length
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
	
	private static void fillWithRandomInts(int[] array) {
		Random rnd = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt(array.length*4);
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[20];
		fillWithRandomInts(array);
		
		System.out.println(Arrays.toString(array));
		insertionSort(array);
		System.out.println(Arrays.toString(array));
		insertionSortDec(array);
		System.out.println(Arrays.toString(array));
	}
}
