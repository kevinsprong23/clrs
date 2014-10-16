package com.kevinsprong;

public class Exercise10_1_1 {
	public static void main(String[] args) throws Exception {
		Stack s = new Stack(6);
		
		System.out.println(s.toString());
		s.push(4);
		System.out.println(s.toString());
		s.push(1);
		System.out.println(s.toString());
		s.push(3);
		System.out.println(s.toString());
		System.out.println(s.pop());
		System.out.println(s.toString());
		s.push(8);
		System.out.println(s.toString());
		System.out.println(s.pop());
		System.out.println(s.toString());
	}
}
