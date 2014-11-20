package com.kevinsprong;

import java.util.Random;

public class RedBlackSandbox {
	public static void main(String[] args) {
		RedBlackTree tree = new RedBlackTree();
		BinarySearchTree tree2 = new BinarySearchTree();
		
		Random rand = new Random();
		
		for (int i = 0; i < 500; i++) {
			tree.insert(new RBNode(rand.nextInt(1000)));
			tree2.insert(new Node(rand.nextInt(1000))); 
		}
		RBNode root = tree.root;
		
		System.out.println("root");
		System.out.println(tree.root.key);
		System.out.println("in order");
		tree.inorderPrint();
		
		System.out.println("deleting");
		tree.delete(root.right);
		
		System.out.println("root");
		System.out.println(tree.root.key);
		System.out.println("in order");
		tree.inorderPrint();
		
		System.out.println("Height comparison");
		System.out.print("Binary search tree: ");
		System.out.println(tree2.treeHeight());
		
		System.out.print("Red black tree: ");
		System.out.println(tree.treeHeight());
	}
}
