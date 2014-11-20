package com.kevinsprong;

// Node for Red-Black tree
public class RBNode extends Node {
	public enum Color {RED, BLACK}
	
	RBNode parent = null;
	RBNode left = null;
	RBNode right = null;
	Color color;
	
	public RBNode(int k, Color c) {
		super(k);
		color = c;
	}
	
	// constructor for conversion of existing node
	public RBNode(Node n) {
		super(n.key);
		color = Color.RED;
	}

}
