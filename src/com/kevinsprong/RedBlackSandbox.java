package com.kevinsprong;

public class RedBlackSandbox {
	public static void main(String[] args) {
		RedBlackTree tree = new RedBlackTree();
		BinarySearchTree tree2 = new BinarySearchTree();
		
		for (int i = 0; i < 100; i++) {
			tree.insert(new RBNode(i));
			tree2.insert(new Node(i));  // worst-case performance
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
