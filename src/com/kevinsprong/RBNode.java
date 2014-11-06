package com.kevinsprong;

// Node for Red-Black tree
// extend Node with a color category
public class RBNode extends Node {
	public enum Color {RED, BLACK}
	
	public Color color;
	
	public RBNode(int k, Color c) {
		super(k);
		color = c;
	}

}
