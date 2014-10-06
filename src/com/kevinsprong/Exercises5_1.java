package com.kevinsprong;

import java.util.Arrays;
import java.util.Random;

public class Exercises5_1 {
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
			// see if range is odd or even;
			// if odd, rand which way to send middle element
			rounddir = ((b - a) % 2 == 0) ? rand.nextInt(2) : 0;
				
			mid = (b + a) / 2 + rounddir;
			if (updown == 0) {
				b = mid;
			} else {
				a = mid;
			}
			
		}
		return a;
	}
	
	public static void main(String[] args) {
		int[] randArray = new int[20];
		for (int i = 0; i < randArray.length; i++) {
			randArray[i] = random(10, 40);
		}
		
		System.out.println(Arrays.toString(randArray));
		
	}
}
