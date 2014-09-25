package com.kevinsprong;

import java.util.Arrays;

public class Problem2_3 {
	// evaluate a polynomial defined by coefficients a[] at a value x
	public static double horner(double[] a, double x) {
		double y = 0;
		for (int i = a.length-1; i >= 0; i--) {
			y = a[i] + x * y;
		}
		return y;
	}
	
	public static double naivePoly(double[] a, double x) {
		double y = 0;
		for (int i = 0; i < a.length; i++) {
			// should use Math.pow, but they asked for naive...
			int xpow = 1;
			for (int j = 0; j < i; j++) {
				xpow *= x;
			}
			y += a[i] * xpow;
		}
		return y;
	}
	
	public static void main(String[] args) {
		double[] a = {1, 2, 3};  // 1 + 2x + 3x^2
		double x = 2;
		
		System.out.print("Coeffs: ");
		System.out.println(Arrays.toString(a));
		System.out.print("Val: ");
		System.out.println(x);
		
		System.out.print("Horner: ");
		System.out.println(horner(a, x));
		
		System.out.print("Naive: ");
		System.out.println(naivePoly(a,x));
		
	}
}
