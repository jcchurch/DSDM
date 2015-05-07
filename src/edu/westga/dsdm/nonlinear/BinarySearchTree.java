package edu.westga.dsdm.nonlinear;

import edu.westga.dsdm.linear.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {
	BinaryTree<T> root;

	/**
	 * Creates a Binary Search Tree with zero nodes.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public BinarySearchTree() {
		root = null;
	}
	
	public BinaryTree<T> getTree() {
		return root;
	}
	
	public void insert(ArrayList<T> values) {
		for (T value : values) {
			this.insert(value);
		}
	}

	/**
	 * Given a value, it selects the correct location for this node.
	 * 
	 * If the element is less than the node, either move or set to the left
	 * (which depends on if moving left is possible). If the element is greater
	 * than or equal to the node, either move or set to the right (which depends
	 * on if moving right is possible).
	 * 
	 * @precondition the tree has already been initialized
	 * @postcondition the tree selects the correct place for the node and adds
	 *                it.
	 * 
	 * @param element
	 * @param aNode
	 */
	public void insert(T value) {
		if (value == null) {
			throw new IllegalArgumentException("value is null");
		}

		if (this.root == null) {
			this.root = new BinaryTree<T>(value);
		} else {
			this.insertHelper(this.root, value);
		}

		int myBalanceFactor = this.root.balanceFactor();

		if (myBalanceFactor == 2) {
			this.root = this.leftRotation(this.root);
		}

		if (myBalanceFactor == -2) {
			this.root = this.rightRotation(this.root);
		}
	}

	private void insertHelper(BinaryTree<T> aNode, T value) {
		if (value.compareTo(aNode.getValue()) < 0) {
			if (aNode.isLeftSet()) {
				this.insertHelper(aNode.getLeft(), value);
			} else {
				aNode.setLeft(new BinaryTree<T>(value));
			}
		} else {
			if (aNode.isRightSet()) {
				this.insertHelper(aNode.getRight(), value);
			} else {
				aNode.setRight(new BinaryTree<T>(value));
			}
		}

		// Begin AVL Balancing
		// Right - Left
		// Positive numbers mean more nodes to the right.
		// Negative numbers mean more nodes to the left.

		if (aNode.isLeftSet()) {
			int myBalanceFactor = aNode.getLeft().balanceFactor();

			if (myBalanceFactor == 2) {
				aNode.setLeft(this.leftRotation(aNode.getLeft()));
			}
			if (myBalanceFactor == -2) {
				aNode.setLeft(this.rightRotation(aNode.getLeft()));
			}
		}

		if (aNode.isRightSet()) {
			int myBalanceFactor = aNode.getRight().balanceFactor();

			if (myBalanceFactor == 2) {
				aNode.setRight(this.leftRotation(aNode.getRight()));
			}
			if (myBalanceFactor == -2) {
				aNode.setRight(this.rightRotation(aNode.getRight()));
			}
		}
	}

	/**
	 * Returns true if a value exists in a tree.
	 * 
	 * @precondition the value is not null
	 * 
	 * @param value
	 *            the value to be searched
	 * @return true if the value is found in the tree, false otherwise.
	 */
	public boolean isInTree(T value) {
		if (value == null) {
			throw new IllegalArgumentException("value is null");
		}

		// Special Case. There is no tree.
		if (this.root == null) {
			return false;
		}

		return isInTreeHelper(this.root, value);
	}

	private boolean isInTreeHelper(BinaryTree<T> aNode, T value) {
		if (aNode.getValue().equals(value)) {
			return true;
		}

		if (value.compareTo(aNode.getValue()) < 0) {
			if (aNode.isLeftSet()) {
				return isInTreeHelper(aNode.getLeft(), value);
			}
		} else {
			if (aNode.isRightSet()) {
				return isInTreeHelper(aNode.getRight(), value);
			}
		}

		return false;
	}

	private BinaryTree<T> getAChild(BinaryTree<T> node) {
		if (node.isLeftSet()) {
			return node.getLeft();
		} else if (node.isRightSet()) {
			return node.getRight();
		} else {
			return null;
		}
	}

	/**
	 * Given a value, it is found and deleted.
	 * 
	 * @precondition the value to delete is not null
	 * @postcondition the value is deleted if it exists
	 * 
	 * @param value
	 *            the value to delete from the tree
	 * @return true if the value was deleted, false if it could not be found
	 */
	public boolean delete(T value) {
		if (value == null) {
			throw new IllegalArgumentException("value is null");
		}

		// Special Case. There is no tree.
		if (this.root == null) {
			return false;
		}

		// Special Case. We delete root.
		if (this.root.getValue().equals(value)) {
			this.root = this.getAChild(this.root);
			return true;
		}

		return deleteHelper(this.root, value);
	}

	private boolean deleteHelper(BinaryTree<T> aNode, T value) {
		if (value.compareTo(aNode.getValue()) < 0) {
			if (aNode.isLeftSet()) {
				if (aNode.getLeft().getValue().equals(value)) {
					aNode.setLeft(this.getAChild(aNode.getLeft()));
					return true;
				} else {
					return deleteHelper(aNode.getLeft(), value);
				}
			}
		} else {
			if (aNode.isRightSet()) {
				if (aNode.getRight().getValue().equals(value)) {
					aNode.setRight(this.getAChild(aNode.getRight()));
					return true;
				} else {
					return deleteHelper(aNode.getRight(), value);
				}
			}
		}
		return false;
	}

	// -2
	public BinaryTree<T> rightRotation(BinaryTree<T> node) {
		if (node.isLeftSet() == false) {
			throw new IllegalStateException(
					"Cannot rotate right. No left node.");
		}
		
		System.out.println("Rotate Right");

		BinaryTree<T> leftChild = node.getLeft();
		
		System.out.println("Balance: "+leftChild.balanceFactor());
		
		System.out.println("+++");
		this.root.printTree();
		System.out.println("+++");
		leftChild.printTree();
		System.out.println("+++");
		
		if (leftChild.balanceFactor() == 1) {
			node.setLeft( this.leftRotation(leftChild) );
		}

		if (node.getLeft().isRightSet()) {
		    node.setLeft(node.getLeft().getRight());
		}
		
		leftChild.setRight(node);
		
		//leftChild.printTree();
		//System.out.println("+++");

		return leftChild;
	}

	// 2
	public BinaryTree<T> leftRotation(BinaryTree<T> node) {
		if (node.isRightSet() == false) {
			throw new IllegalStateException(
					"Cannot rotate left. No right node.");
		}

		System.out.println("Rotate Left");
		
		BinaryTree<T> rightChild = node.getRight();
		
		System.out.println("Balance: "+rightChild.balanceFactor());
		
		if (rightChild.balanceFactor() == -1) {
			node.setRight( this.rightRotation(rightChild) );
		}
		
		if (node.getRight().isLeftSet()) {
		    node.setRight(node.getRight().getLeft());
		}
		
		rightChild.setLeft(node);

		return rightChild;
	}
}
