package com.kevinsprong;

// Node class for search trees
public class Node {
	Node parent = null;
	int key;
	Node left = null;
	Node right = null;
	
	// constructor
	public Node(int k) {
		key = k;
	}

	// add children
	public void addLeft(Node n) {
		n.parent = this;
		left = n;
	}
	public void addRight(Node n) {
		n.parent = this;
		right = n;
	}
}

