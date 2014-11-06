package com.kevinsprong;

import com.kevinsprong.RBNode.Color;

public class RedBlackTree extends BinarySearchTree {
	
	Node nil = new RBNode(0, Color.BLACK);

	// only allow fresh tree construction
	public RedBlackTree() {
		super(null);
	}
	
	
	

}
