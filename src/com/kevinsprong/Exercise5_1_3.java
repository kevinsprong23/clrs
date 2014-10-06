package com.kevinsprong;

import java.util.Arrays;
import java.util.Random;

public class Exercise5_1_3 {
	private static int biasedRandom(double p) {
		Random rand = new Random();
		return rand.nextDouble() < p ? 1 : 0;
	}
	
	// use biasedRandom to return an unbiased int 0 or 1
	private static int unbiasedRandom(double p) {
		// generate two random numbers until we get two unequal
		// return the first
		int first = 0;
		int second = 0;
		while (first == second) {
			first = biasedRandom(p);
			second = biasedRandom(p);
		}
		return first;
	}
	
	// probability to succeed on a given run should be 2p(1-p)
	// so should take on average 1/(2p(1-p)) runs to exit
	public static void main(String[] args) {
		int[] unbiasedInts = new int[10];
		double p = 0.9;
		for (int i = 0; i < unbiasedInts.length; i++) {
			unbiasedInts[i] = unbiasedRandom(p);
		}
		System.out.println(Arrays.toString(unbiasedInts));
	}
}
