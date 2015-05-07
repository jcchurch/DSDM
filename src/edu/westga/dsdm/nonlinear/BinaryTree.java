package edu.westga.dsdm.nonlinear;

import edu.westga.dsdm.linear.Queue;

public class BinaryTree<T> {

	private T value;
	private BinaryTree<T> left;
	private BinaryTree<T> right;

	/**
	 * Creates a Binary Tree.
	 * 
	 * @precondition value != null
	 * @postcondition the tree is created with the value at the center and
	 *                without left and right branches.
	 * 
	 * @param value
	 *            the value to add to the Tree
	 */
	public BinaryTree(T value) {
		if (value == null) {
			throw new IllegalArgumentException("value to add is null");
		}

		this.setValue(value);
		this.left = null;
		this.right = null;
	}

	/**
	 * Returns true if there is a left branch, false otherwise.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if there is a left branch
	 */
	public boolean isLeftSet() {
		return this.left != null;
	}

	/**
	 * Returns true if there is a right branch, false otherwise.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if there is a right branch
	 */
	public boolean isRightSet() {
		return this.right != null;
	}

	/**
	 * Sets the left branch of this tree with a node.
	 * 
	 * @precondition node != null and isLeftSet() == false
	 * @postcondition the node is set as the left branch
	 * 
	 * @param node
	 *            the node to be added to the left branch of this tree
	 */
	public void setLeft(BinaryTree<T> node) {
		if (node == null) {
			throw new IllegalArgumentException("node cannot be null");
		}

		this.left = node;
	}

	/**
	 * Sets the right branch of this tree with a node.
	 * 
	 * @precondition node != null and isRightSet() == false
	 * @postcondition the node is set as the right branch
	 * 
	 * @param node
	 *            the node to be added to the right branch of this tree
	 */
	public void setRight(BinaryTree<T> node) {
		if (node == null) {
			throw new IllegalArgumentException("node cannot be null");
		}

		this.right = node;
		
	}

	/**
	 * Returns the left node of the tree.
	 * 
	 * @precondition this.isSetLeft() == true
	 * @postcondition none
	 * 
	 * @return the left node
	 */
	public BinaryTree<T> getLeft() {
		if (this.isLeftSet() == false) {
			throw new IllegalStateException("Cannot get left. Does not exist.");
		}

		return this.left;
	}

	/**
	 * Returns the right node of the tree.
	 * 
	 * @precondition this.isSetRight() == true
	 * @postcondition none
	 * 
	 * @return the right node
	 */
	public BinaryTree<T> getRight() {
		if (this.isRightSet() == false) {
			throw new IllegalStateException("Cannot get right. Does not exist.");
		}

		return this.right;
	}

	/**
	 * Gets the value of this node.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the value of this node
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * Sets the value of the tree with the passed value.
	 * 
	 * @precondition value != null
	 * @postcondition none
	 * 
	 * @param value
	 *            the value to set at this tree
	 */
	public void setValue(T value) {
		if (value == null) {
			throw new IllegalArgumentException("value to add is null");
		}

		this.value = value;
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @returns the number of elements.
	 */
	public int size() {
		if (!this.isLeftSet() && !this.isRightSet()) {
			return 1;
		}

		int leftBranchSize = 0;
		int rightBranchSize = 0;

		if (this.isLeftSet()) {
			leftBranchSize = this.left.size();
		}

		if (this.isRightSet()) {
			rightBranchSize = this.right.size();
		}

		return 1 + leftBranchSize + rightBranchSize;
	}

	/**
	 * Computes the height of this tree
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		if (!this.isLeftSet() && !this.isRightSet()) {
			return 0;
		}

		int leftBranchHeight = 0;
		int rightBranchHeight = 0;

		if (this.isLeftSet()) {
			leftBranchHeight = this.left.height();
		}

		if (this.isRightSet()) {
			rightBranchHeight = this.right.height();
		}

		return 1 + Math.max(leftBranchHeight, rightBranchHeight);
	}

	/**
	 * Counts the Leaf Nodes of the Tree
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of leaf nodes
	 */
	public int countLeaves() {
		if (!this.isLeftSet() && !this.isRightSet()) {
			return 1;
		}

		int leftBranchLeaves = 0;
		int rightBranchLeaves = 0;

		if (this.isLeftSet()) {
			leftBranchLeaves = this.left.countLeaves();
		}

		if (this.isRightSet()) {
			rightBranchLeaves = this.right.countLeaves();
		}

		return leftBranchLeaves + rightBranchLeaves;
	}

	/**
	 * Performs the preorder traversal of the tree and adds each element to the
	 * Queue
	 * 
	 * @precondition q != null
	 * @postcondition q is updated with one element per tree node in a preorder
	 *                traversal.
	 */
	public void preorder(Queue<T> q) {
		if (q == null) {
			throw new IllegalArgumentException("Queue cannot be null.");
		}

		q.enqueue(this.value);

		if (this.isLeftSet())
			this.left.preorder(q);

		if (this.isRightSet())
			this.right.preorder(q);
	}

	/**
	 * Performs the postorder traversal of the tree and adds each element to the
	 * Queue
	 * 
	 * @precondition q != null
	 * @postcondition q is updated with one element per tree node in a postorder
	 *                traversal.
	 */
	public void postorder(Queue<T> q) {
		if (q == null) {
			throw new IllegalArgumentException("Queue cannot be null.");
		}

		if (this.isLeftSet())
			this.left.postorder(q);

		if (this.isRightSet())
			this.right.postorder(q);

		q.enqueue(this.value);
	}

	/**
	 * Performs the inorder traversal of the tree and adds each element to the
	 * Queue
	 * 
	 * @precondition q != null
	 * @postcondition q is updated with one element per tree node in a inorder
	 *                traversal.
	 */
	public void inorder(Queue<T> q) {
		if (q == null) {
			throw new IllegalArgumentException("Queue cannot be null.");
		}

		if (this.isLeftSet())
			this.left.inorder(q);

		q.enqueue(this.value);

		if (this.isRightSet())
			this.right.inorder(q);
	}

	public int balanceFactor() {

		int leftHeight = 0;
		if (this.isLeftSet()) {
			leftHeight = 1 + this.left.height();
		}

		int rightHeight = 0;
		if (this.isRightSet()) {
			rightHeight = 1 + this.right.height();
		}

		return rightHeight - leftHeight;
	}

	public void printTree() {
		this.printTreeHelper(0);
	}

	private void printTreeHelper(int level) {
		// TODO Auto-generated method stub
		for (int i = 0; i < level; i++) {
			System.out.print("-");
		}
		System.out.println(value);
		
		if (this.isLeftSet())
			this.left.printTreeHelper(level+1);
		
		if (this.isRightSet())
			this.right.printTreeHelper(level+1);
	}
}
