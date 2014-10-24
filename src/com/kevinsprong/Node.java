package com.kevinsprong;

public class Node {
	// Node class
	int key;
	Node left = null;
	Node right = null;

	public Node(int k) {
		key = k;
	}

	public void addLeft(Node n) {
		left = n;
	}
	public void addRight(Node n) {
		right = n;
	}
}

