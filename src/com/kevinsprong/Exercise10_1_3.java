package com.kevinsprong;

public class Exercise10_1_3 {
	public static void main(String[] args) throws Exception {
		Queue q = new Queue(6);
		
		System.out.println(q.toString());
		q.enqueue(4);
		System.out.println(q.toString());
		q.enqueue(1);
		System.out.println(q.toString());
		q.enqueue(3);
		System.out.println(q.toString());
		System.out.println(q.dequeue());
		System.out.println(q.toString());
		q.enqueue(8);
		System.out.println(q.toString());
		System.out.println(q.dequeue());
		System.out.println(q.toString());
	}
}
