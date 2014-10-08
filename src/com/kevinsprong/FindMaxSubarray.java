package com.kevinsprong;

import java.util.Arrays;

public class FindMaxSubarray {
	// directly from Cormen et. al, p. 71
    public static int[] findMaxCrossingSubarray(int[] array, 
    		int low, int mid, int high) {
    	int[] result = {0,0,0};
    	
    	// find largest left sub array
    	int leftSum = Integer.MIN_VALUE;
    	int sum = 0;
    	for (int i = mid; i >= low; i--) {
    		sum += array[i];
    		if (sum > leftSum) {
    			leftSum = sum;
    			result[0] = i;
    		}
    	}
    	
    	// find largest right sub array
    	int rightSum = Integer.MIN_VALUE;
    	sum = 0;
    	for (int j = mid + 1; j <= high; j++) {
    		sum += array[j];
    		if (sum > rightSum) {
    			rightSum = sum;
    			result[1] = j;
    		}
    	}
    	
    	result[2] = leftSum + rightSum;
    	
    	return result;
    }
    
    // directly from Cormen et. al, p. 72
    public static int[] findMaximumSubarray(int[] A, int low, int high) {
    	if (low == high) {
    		return new int[]{low, high, A[low]};
    	}
    	
    	// set mid in a way that avoids overflow
    	int mid = low + (int) Math.floor((high-low)/2);
    	
    	int[] resultLeft = findMaximumSubarray(A, low, mid);
    	int[] resultRight = findMaximumSubarray(A, mid+1, high);
    	int[] resultCross = findMaxCrossingSubarray(A, low, mid, high);
    	
    	if (resultLeft[2] >= resultRight[2] &&
    			resultLeft[2] >= resultCross[2]) {
    		return resultLeft;
    	} else if (resultRight[2] >= resultLeft[2] &&
    			resultRight[2] >= resultCross[2]) {
    		return resultRight;	
    	} else {
    		return resultCross;
    	}
    }
    
    // overload for natural-feeling function call
    public static int[] findMaximumSubarray(int[] A) {
    	return findMaximumSubarray(A,0,A.length-1);
    }
    
    public static void main(String[] args) {
    	int[] array = new int[10];
    	util.fillWithZeroMeanInts(array);
    	int[] maxSubarray = findMaximumSubarray(array);
    	
    	System.out.println(Arrays.toString(array));
    	System.out.println(Arrays.toString(maxSubarray));
    	
    }
}
