package com.kevinsprong;

public class RedBlackSandbox {
	public static void main(String[] args) {
		RedBlackTree tree = new RedBlackTree();
		for (int i = 0; i < 100; i++) {
			tree.insert(new RBNode(i));
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
	}
}
