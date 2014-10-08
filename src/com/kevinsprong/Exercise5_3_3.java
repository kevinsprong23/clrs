package com.kevinsprong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Exercise5_3_3 {
	// recursively print a naive shuffle starting at stIdx
	public static void printNaiveShuffle(int[] array, int stIdx, 
			ArrayList<String> out) {
		if (stIdx == array.length) {
			// end of array - add and print
			out.add(Arrays.toString(array));
			System.out.println(Arrays.toString(array));
		} else {
			for (int j = 0; j < array.length; j++) {
				int[] arraycop = util.deepCopy(array);
				util.swap(arraycop, stIdx, j);
				printNaiveShuffle(arraycop, stIdx + 1, out);
			}

		}
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3};
		ArrayList<String> out = new ArrayList<String>();
		
		System.out.println("Printing all key combos");
		printNaiveShuffle(array, 0, out);
		
		// this is so much quicker in Python
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		for (String key : out) {
			if (counts.containsKey(key)) {
				int val = counts.get(key);
				counts.put(key, val + 1);
			} else {
				counts.put(key, 1);
			}
		}
		
		// now print it
		System.out.println("Printing key frequencies");
		for (String key : counts.keySet()) {
			System.out.println(key.toString() + ": " + 
					counts.get(key).toString());
		}
	}
	
}