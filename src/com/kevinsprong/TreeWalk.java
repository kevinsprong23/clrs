package com.kevinsprong;

public class TreeWalk {
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
		
		System.out.println("In-order: ");
		tree.inorderPrint();
		System.out.println();
		
		System.out.println("Pre-order: ");
		tree.preorderPrint();
		System.out.println();
		
		System.out.println("Post-order: ");
		tree.postorderPrint();
		System.out.println();
		
		System.out.println("Tree height: ");
		System.out.println(tree.treeHeight());
		System.out.println();
	}
}
