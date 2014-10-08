package com.kevinsprong;

import java.util.Arrays;
import java.util.Random;

public class Exercise5_1_2 {
	// 5.1-2
	private static int random(int a, int b) {
		Random rand = new Random();
		// use rand.nextInt(2) as Random(0, 1) function in CLRS
		
		// find number of bits we need to generate
		int n = b - a;
		int c = (int) Math.ceil(util.lg(n)) + 1;  // 2^c may be bigger than n
		
		int csum = Integer.MAX_VALUE;
		while (csum > n) {
			csum = 0;
			for (int i = c - 1; i >= 0; i--) {  // horner's method
				csum = rand.nextInt(2) + 2 * csum;
			}
		}
		return csum + a;
	}

	public static void main(String[] args) {
		int[] randArray = new int[30];
		for (int i = 0; i < randArray.length; i++) {
			randArray[i] = random(1, 3);
		}
		System.out.print("Random Integers: ");
		System.out.println(Arrays.toString(randArray));
		
	}
}
