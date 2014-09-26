package com.kevinsprong;

import java.util.Arrays;

public class Problem2_4 {
	// b. {n... 2, 1} has (n choose 2) inversions
	
	// c. 

	// d.
	// this one runs in O(N^2) time
	public static int countInversionsNaive(int[] array) {
		int total = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) total += 1;
			}
		}
		return total;
	}
	
	// here is the merge sort modification, modifying the merge function
	public static int mergeInversion(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		
		int inversions = 0;
		
		// in real merge sort these would be a single array with size equal to A
		// but this is the Cormen et. al implementation, so yeah.
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		
		for (int i = 0; i < n1; i++) {
			L[i] = A[p + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = A[q + 1 + j];
		}
		
		// sentinel values per Cormen et. al
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		
		// sentinel values allow skipping empty checks
		for (int k = p; k <= r; k++) {
			
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
				
				// this is the key to n * log(n) runtime.
				// since subarrays are in sorted order, we know R[j] 
				// is smaller than all remaining items in L, and don't need to
				// explicitly test each.
				inversions += n1 - i;  
			}
		}
		
		return inversions;
	}
	
	// the Cormen et. al method signature
	public static int countInversions(int[] A, int p, int r) {
		int inversions = 0;
		if (p < r) {
			int q = (p + r) / 2;  // don't need floor b/c of integer div.
			inversions += countInversions(A, p, q);
			inversions += countInversions(A, q+1, r);
			inversions += mergeInversion(A, p, q, r);
		}
		return inversions;
	}
	
	// overloaded to call on just an array
	public static int countInversions(int[] A) {
		int p = 0, r = A.length - 1;
		return countInversions(util.deepCopy(A), p, r);
	}
	
	
	public static void main(String[] args) {
		System.out.println("\nInvariant Count test");
		int[] array = new int[8];
		util.fillWithRandomInts(array);
		System.out.println(Arrays.toString(array));
		
		
		System.out.print("Naive comparison: ");
		System.out.println(countInversionsNaive(util.deepCopy(array)));
		
		System.out.print("Merge comparison: ");
		System.out.println(countInversions(util.deepCopy(array)));
	}
}