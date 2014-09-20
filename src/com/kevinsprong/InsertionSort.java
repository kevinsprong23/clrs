package com.kevinsprong;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
	
	private static void insertionSort(int[] array) {
		
	}
	
	private static void fillWithRandomInts(int[] array) {
		Random rnd = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt(array.length*4);
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[50];
		fillWithRandomInts(array);
		
		System.out.println(Arrays.toString(array));
		insertionSort(array);
		System.out.println(Arrays.toString(array));
	}
}
