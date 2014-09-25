package com.kevinsprong;

import java.util.Random;

public class util {
	public static void fillWithRandomInts(int[] array) {
		Random rnd = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt(array.length*4);
		}
	}
	
	public static int[] deepCopy(int[] array) {
		int[] copy = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		return copy;
	}
}
