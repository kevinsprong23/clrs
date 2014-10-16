package com.kevinsprong;

import java.util.Arrays;

public class Stack {
	// class for a simple array-backed stack of integers
	
	private int[] array;
	private int top;
	
	public Stack(int n) {
		this.array = new int[n];
		this.top = -1;
	}
	
	public int size() {
		return top + 1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return array.length == size();
	}
	
	public void push(int x) throws Exception {
		if (isFull()) {
			throw new Exception("Stack overflow");
		} else {
			top++;
			array[top] = x;
		}
	}
	
	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack underflow");
		} else {
			top--;
			return array[top + 1];
		}
			
	}
	
	public String toString() {
		// get live elements
		int[] s = new int[size()];
		for (int i = 0; i < s.length; i++) {
			s[i] = array[i];
		}
		return Arrays.toString(s);
	}
}
