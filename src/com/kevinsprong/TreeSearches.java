package com.kevinsprong;

// class to run basic examples of binary tree algorithms
public class TreeSearches {
	public static void main(String[] args) {
		// make a tree manually
		Node root = new Node(15);
		root.addLeft(new Node(6));
		root.addRight(new Node(18));
		root.left.addLeft(new Node(3));
		root.left.addRight(new Node(7));
		root.right.addLeft(new Node(17));
		root.right.addRight(new Node(20));
		root.left.left.addLeft(new Node(2));
		root.left.left.addRight(new Node(4));
		root.left.right.addRight(new Node(13));
		root.left.right.right.addLeft(new Node(9));
		
		BinarySearchTree tree = new BinarySearchTree(root);
		
		Node n = tree.treeSearch(7);
		StringBuilder strOut = new StringBuilder();
		strOut.append("Node with key ");
		strOut.append(n.key);
		strOut.append(" found: ");
		strOut.append("node.left: ");
		strOut.append(n.left == null ? "null" : n.left.key);
		strOut.append(", node.right: ");
		strOut.append(n.right == null ? "null" : n.right.key);
		System.out.println(strOut);
		
		n = tree.treeMin();
		strOut.setLength(0);
		strOut.append("Min tree value: ");
		strOut.append(n.key);
		System.out.println(strOut);
		
		n = tree.treeMax();
		strOut.setLength(0);
		strOut.append("Max tree value: ");
		strOut.append(n.key);
		System.out.println(strOut);
		
	}
}
