package com.kevinsprong;

import java.util.Arrays;

// class for a simple array-backed queue of integers
public class Queue {

	private int[] array;
	private int head, tail;

	// constructor
	public Queue(int n) {
		this.array = new int[n];
		this.head = 0;
		this.tail = 0;
	}
	
	// methods
	private int increment(int n) {
		return (n == array.length - 1) ? 0 : n + 1;
	}

	public boolean isFull() {
		return (head == 0 && tail == array.length - 1) || 
				(head == tail + 1);
	}
	
	public boolean isEmpty() {
		return head == tail;
	}

	public int size() {
		return (tail >= head) ? tail - head : array.length - head + tail;
	}

	public void enqueue(int x) throws Exception {
		if (isFull()) {
			throw new Exception("Queue overflow");
		} else {
			array[tail] = x;
			tail = increment(tail);
		}
	}

	public int dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue underflow");
		} else {
			int x = array[head];
			head = increment(head);
			return x;
		}

	}
	
	public String toString() {
		// this one is more complicated
		if (tail >= head) {
			int[] s = new int[size()];
			int i = head;
			while (i < tail) {
				s[i - head] = array[i];
				i++;
			}
			return Arrays.toString(s);
		} else {
			// 0 to tail
			int[] s1 = new int[tail];
			for (int i = 0; i < tail; i++) {
				s1[i] = array[i];
			}
			
			// head to end
			int[] s2 = new int[array.length - head];
			for (int i = head; i < array.length; i++) {
				s2[i - head] = array[i];
			}
			return Arrays.toString(s1) + Arrays.toString(s2);
		}
	}
}
