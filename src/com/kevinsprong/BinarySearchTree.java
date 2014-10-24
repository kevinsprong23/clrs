package com.kevinsprong;

public class BinarySearchTree {
	
	// root as instance variable
	Node root;
	public BinarySearchTree(Node n) {
		root = n;
	}
	
	// overload to call on root
	public void inorderPrint() {
		inorderPrint(root);
	}
	// in-order print of a tree
	public void inorderPrint(Node n) {
		if (n != null) {
			inorderPrint(n.left);
			System.out.println(n.key);
			inorderPrint(n.right);
		}
	}
	
	// overload to call on root
	public void preorderPrint() {
		preorderPrint(root);
	}
	// preorder print of a tree
	public void preorderPrint(Node n) {
		if (n != null) {
			System.out.println(n.key);
			preorderPrint(n.left);
			preorderPrint(n.right);
		}
	}

	// overload to call on root
	public void postorderPrint() {
		postorderPrint(root);
	}
	// postorder print of a tree
	public void postorderPrint(Node n) {
		if (n != null) {
			postorderPrint(n.left);
			postorderPrint(n.right);
			System.out.println(n.key);
		}
	}
	
	// find the Node with key k in a binary tree
	public Node treeSearch(int k) {
		return treeSearch(root, k);
	}
	public Node treeSearch(Node n, int k) {
		if (n == null || n.key == k) {
			return n;
		}
		return (n.key > k) ? treeSearch(n.left, k) : treeSearch(n.right, k);
	}
	
	// find the Node with min value in a tree
	public Node treeMin() {
		Node x = root;
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}

	// find the Node with max value in a tree
	public Node treeMax() {
		Node x = root;
		while (x.right != null) {
			x = x.right;
		}
		return x;
	}
}
