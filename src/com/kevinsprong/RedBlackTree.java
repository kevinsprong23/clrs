package com.kevinsprong;

import com.kevinsprong.RBNode.Color;

public class RedBlackTree extends BinarySearchTree {
	
	RBNode nil = new RBNode(0, Color.BLACK);
	RBNode root = nil;
	
	// only allow fresh tree construction
	public RedBlackTree() {
		super(null);
	}
	
	// find the Node with min value in a tree
	public RBNode treeMin(RBNode x) {
		while (x.left != nil) {
			x = x.left;
		}
		return x;
	}

	// overloaded
	@Override
	public RBNode treeMin() {
		return treeMin(root);
	}

	
	
	private void leftRotate(RBNode node) {
		RBNode y = node.right;
		node.right = y.left;
		if (y.left != nil) {
			y.left.parent = node;
		}
		y.parent = node.parent;
		if (node.parent == nil) {
			root = y;
		} else if (node == node.parent.left) {
			node.parent.left = y;
		} else {
			node.parent.right = y;
		}
		y.left = node;
		node.parent = y;
	}
	
	private void rightRotate(RBNode node) {
		RBNode y = node.left;
		node.left = y.right;
		if (y.right != nil) {
			y.right.parent = node;
		}
		y.parent = node.parent;
		if (node.parent == nil) {
			root = y;
		} else if (node == node.parent.right) {
			node.parent.right = y;
		} else {
			node.parent.left = y;
		}
		y.right = node;
		node.parent = y;
	}
	
	@Override
	public void insert(Node node) {
		insert(new RBNode(node));
	}
	
	public void insert(RBNode node) {
		RBNode y = nil;
		RBNode x = root;
		
		while (x != nil) {
			y = x;
			if (node.key < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		node.parent = y;  // this covers all cases
		if (y == nil) {  // tree was empty
			root = node;
		} else if (node.key < y.key) {
			y.left = node;
		} else {
			y.right = node;
		}
		node.left = nil;
		node.right = nil;
		node.color = Color.RED;
		insertFixup(node);
	}
	
	// fix up the tree that just had node inserted
	private void insertFixup(RBNode z) {
		while (z.parent.color == Color.RED) {
			if (z.parent == z.parent.parent.left) {
				RBNode y = z.parent.parent.right;  // the "uncle" in CLRS
				if (y.color == Color.RED) {
					z.parent.color = Color.BLACK;
					y.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					z = z.parent.parent;
				} else {
					if (z == z.parent.right) {
						z = z.parent;
						leftRotate(z);
					}
					z.parent.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					rightRotate(z.parent.parent);
				}
			} else {
				RBNode y = z.parent.parent.left;  // the "uncle" in CLRS
				if (y.color == Color.RED) {
					z.parent.color = Color.BLACK;
					y.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					z = z.parent.parent;
				} else {
					if (z == z.parent.left) {
						z = z.parent;
						rightRotate(z);
					}
					z.parent.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					leftRotate(z.parent.parent);
				}
			}
		}
		root.color = Color.BLACK;
	}
	
	private void transplant(RBNode u, RBNode v) {
		if (u.parent == nil) {
			root = v;
		} else if (u == u.parent.left) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		v.parent = u.parent;
	}
	
	@Override
	public void delete(Node node) {
		System.err.println("Cannot delete a regular Node from a Red Black Tree");
		System.exit(1);
	}
	
	public void delete(RBNode z) {
		RBNode y = z;
		Color yOrigColor = y.color;
		RBNode x;
		if (z.left == nil) {
			x = z.right;
			transplant(z, z.right);
		} else if (z.right == nil) {
			x = z.left;
			transplant(z, z.left);
		} else {
			y = treeMin(z.right);
			yOrigColor = y.color;
			x = y.right;
			if (y.parent == z) {
				x.parent = y;
			} else {
				transplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplant(z, y);
			y.left = z.left;
			y.left.parent = y;
			y.color = z.color;
		}
		if (yOrigColor == Color.BLACK) {
			deleteFixup(x);
		}
	}
	
	private void deleteFixup(RBNode x) {
		while (x != root && x.color == Color.BLACK) {
			if (x == x.parent.left) {
				RBNode w = x.parent.right;
				if (w.color == Color.RED) {
					w.color = Color.BLACK;
					x.parent.color = Color.RED;
					leftRotate(x.parent);
					w = x.parent.right;
				}
				if (w.left.color == Color.BLACK && w.right.color == Color.BLACK) {
					w.color = Color.RED;
					x = x.parent;
				} else {
					if (w.right.color == Color.BLACK) {
						w.left.color = Color.BLACK;
						w.color = Color.RED;
						rightRotate(w);
						w = x.parent.right;
					}
					w.color = x.parent.color;
					x.parent.color = Color.BLACK;
					w.right.color = Color.BLACK;
					leftRotate(x.parent);
					x = root;
				}
			} else {
				RBNode w = x.parent.left;
				if (w.color == Color.RED) {
					w.color = Color.BLACK;
					x.parent.color = Color.RED;
					rightRotate(x.parent);
					w = x.parent.left;
				}
				if (w.right.color == Color.BLACK && w.left.color == Color.BLACK) {
					w.color = Color.RED;
					x = x.parent;
				} else {
					if (w.left.color == Color.BLACK) {
						w.right.color = Color.BLACK;
						w.color = Color.RED;
						leftRotate(w);
						w = x.parent.left;
					}
					w.color = x.parent.color;
					x.parent.color = Color.BLACK;
					w.left.color = Color.BLACK;
					rightRotate(x.parent);
					x = root;
				}
			}
		}
		x.color = Color.BLACK;
	}
	
	// in-order print of a tree
	public void inorderPrint(RBNode n) {
		if (n != nil) {
			inorderPrint(n.left);
			System.out.println(n.key);
			inorderPrint(n.right);
		}
	}
	// overload to call on root
	public void inorderPrint() {
		inorderPrint(root);
	}
}
