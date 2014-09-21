package com.kevinsprong;

import java.util.Arrays;

public class ProblemsChapter1 {
	// assume each operation takes f(n) microseconds
	// find number of operations in each time window
	
	private static long calcNumLogNOps(long numberOfMicroseconds) {
		return (long) Math.pow(2, numberOfMicroseconds);
	}	
	
	private static long calcNumSqrtNOps(long numberOfMicroseconds) {
		return (numberOfMicroseconds <= Long.MAX_VALUE/numberOfMicroseconds) ?
				numberOfMicroseconds * numberOfMicroseconds : Long.MAX_VALUE;
	}
	
	private static long calcNumNOps(long numberOfMicroseconds) {
		return numberOfMicroseconds;
	}
	
	private static double lg(long n) {
		return Math.log(n) / Math.log(2);
	}
	private static long calcNumNLogNOps(long numberOfMicroseconds) {
		// need to bisect; looping is too inefficient
		long lower = 0;
		long upper = Long.MAX_VALUE;
		long est;
		
		while (true) {
			est = (lower + upper) / 2;
			if (est == lower || est == upper) {
				return est;
			}
			if (est * lg(est) > numberOfMicroseconds) {
				upper = est;
			} else {
				lower = est;
			}
		}
		
	}
	
	private static long calcNumN2Ops(long numberOfMicroseconds) {
		return (long)Math.sqrt(numberOfMicroseconds);
	}
	
	private static long calcNumN3Ops(long numberOfMicroseconds) {
		return (long)Math.pow(numberOfMicroseconds, 0.3333333333);
	}
	
	private static long calcNum2NOps(long numberOfMicroseconds) {
		return (long)(Math.log(numberOfMicroseconds) / Math.log(2));
	}
	
	private static long factorial(long n) {
		return (n <= 1) ? 1 : n * factorial(n-1);  // ugly
	}
	private static long calcNumNFactorialOps(long numberOfMicroseconds) {
		long n = 0;
		while (factorial(n) < numberOfMicroseconds) {
			n += 1;
		}
		return n - 1;
	}
	
	public static void main(String[] args) {
	
		String[] orders = {"lg n", "sqrt(n)", "n", "n lg n", "n^2",
				"n^3", "2^n", "n!"};
		long[][] results = new long[8][7];
		
		// total cycles available
		long msInASec = 1000000;
		long msInAMin = msInASec * 60;
		long msInAHour = msInAMin * 60;
		long msInADay = msInAHour * 24;
		long msInAMonth = msInADay * 30;  // for example
		long msInAYear = msInADay * 365;  
		long msInACentury = msInAYear * 100;
		long[] microsecondsAvailable = {msInASec, msInAMin, msInAHour,
				msInADay, msInAMonth, msInAYear, msInACentury};
		
		// populate results matrix as given on pg. 15 of Cormen
		for (int i = 0; i < 7; i++) {  // this will thrash a little
			results[0][i] = calcNumLogNOps(microsecondsAvailable[i]);
			results[1][i] = calcNumSqrtNOps(microsecondsAvailable[i]);
			results[2][i] = calcNumNOps(microsecondsAvailable[i]);
			results[3][i] = calcNumNLogNOps(microsecondsAvailable[i]);
			results[4][i] = calcNumN2Ops(microsecondsAvailable[i]);
			results[5][i] = calcNumN3Ops(microsecondsAvailable[i]);
			results[6][i] = calcNum2NOps(microsecondsAvailable[i]);
			results[7][i] = calcNumNFactorialOps(microsecondsAvailable[i]);
		}
		
		// print output
		System.out.println("Number of ops possible in a sec, min, hour, day, " +
				"month, year, century");
		for (int i = 0; i < results.length; i++) {
			System.out.print(orders[i] + ": ");
			System.out.println(Arrays.toString(results[i]));
		}
	}
}
