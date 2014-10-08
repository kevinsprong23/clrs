package com.kevinsprong;

import java.util.Random;

public class util {
	public static void fillWithRandomInts(int[] array) {
		Random rnd = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt(array.length*4);
		}
	}
	
	public static void fillWithZeroMeanInts(int[] array) {
		Random rnd = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt(array.length*4) - array.length*2;
		}
	}
	
	public static int[] deepCopy(int[] array) {
		int[] copy = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		return copy;
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
	
	// log 2 function
	public static double lg(double a) {
		return Math.log(a) / Math.log(2);
	}
	public static double lg(int a) {
		return Math.log(a) / Math.log(2);
	}
}
