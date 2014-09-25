package com.kevinsprong;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Problem2_1 {
	// 2-1 
	// No real software exercises here, so I am going to implement 
	// and time insertion sort on small arrays within merge sort for various k
	public static int arraySizeThresh = 4;
	
	// implement insertionSort with index cutoffs
	private static void insertionSort(int[] array, int p, int r) {
		// loop indices off by 1; Cormen et. al index is 1:length
		for (int j = p + 1; j <= r; j++) {
			int key = array[j];
			int i = j - 1;
			while (i >= p && array[i] > key) {
				array[i+1] = array[i];
				i -= 1;
			}
			array[i+1] = key;
		}
	}
	
	public static void combinedSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;  // don't need floor b/c of integer div.
			int sizeLeft = q - p + 1;
			int sizeRight = r - q;
			
			if (sizeLeft <= arraySizeThresh) {
				insertionSort(A, p, q);
			} else {
				combinedSort(A, p, q);
			}
			if (sizeRight <= arraySizeThresh) {
				insertionSort(A, q+1, r);
			} else {
				combinedSort(A, q+1, r);
			}
			MergeSort.merge(A, p, q, r);
		}
		
	}
	
	public static void combinedSort(int[] array) {
		int p = 0, r = array.length - 1;
		combinedSort(array, p, r);
	}
	
	public static void main(String[] args) throws IOException {
		int[] array = new int[20];
		util.fillWithRandomInts(array);
		
		// demo our modified insertion sort
		System.out.println("Indexed insertion sort");
		System.out.println(Arrays.toString(array));
		insertionSort(array, 2, 15);
		System.out.println(Arrays.toString(array));
		
		// now demo our combined sort
		System.out.println("Combined Sort");
		combinedSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
		
		// now tune value of arraySizeThresh empirically
		int[] insertionThresh = {1,2,4,8,16,32,64,128,256,512,1024};
		int arraySize = 1000000;
		int nReps = 30;
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(
					new File("sort_times_p2-1.csv"), false));
		} catch (IOException e) {
			e.printStackTrace();
		}
		bw.write("ins_threshold,trial_num,time_merge_sec,time_combined_sec");
		bw.newLine();
		

		for (int thresh : insertionThresh) {
			arraySizeThresh = thresh;
			
			for (int i = 0; i < nReps; i++) {
				System.out.println(Integer.toString(thresh) + "," + 
									Integer.toString(i));

				// create arrays
				int[] array1 = new int[arraySize];
				util.fillWithRandomInts(array1);
				int[] array2 = util.deepCopy(array1);

				long t0 = System.nanoTime();
				MergeSort.mergeSort(array1);
				long t1 = System.nanoTime();
				combinedSort(array2);
				long t2 = System.nanoTime();

				double tMerge = (t1 - t0) / 1e9;
				double tCom = (t2 - t1) / 1e9;

				bw.write(Integer.toString(thresh) + "," +
						Integer.toString(i) + "," +
						Double.toString(tMerge) + "," +
						Double.toString(tCom));
				bw.newLine();
			}
		}
		
		bw.close();

	}
}
