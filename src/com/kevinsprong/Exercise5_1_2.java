package com.kevinsprong;

import java.util.Arrays;
import java.util.Random;

public class Exercise5_1_2 {
	// 5.1-2
	private static int random(int a, int b) {
		Random rand = new Random();
		// use rand.nextInt(2) as Random(0, 1) function in CLRS
		
		// I think we can binary search this
		// start with range [a, b], call random(0,1)
		// if 0, search bottom half, if 1, search top half
		int updown, mid, rounddir;
		while (a < b) {
			updown = rand.nextInt(2);
			mid = (b + a) / 2;
			
			// if odd, need to see which way to count middle element
			rounddir = ((b - a) % 2 == 1) ? rand.nextInt(2) : 0;
			
			// iterative binary search, to keep same Random() instance
			if (updown == 0) {
				b = mid - rounddir;
			} else {
				a = mid + 1 - rounddir;
			}
		}
		return a;
	}

	public static void main(String[] args) {
		int[] randArray = new int[10];
		for (int i = 0; i < randArray.length; i++) {
			randArray[i] = random(1, 3);
		}
		
		System.out.println(Arrays.toString(randArray));
		
	}
}
