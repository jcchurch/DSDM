package edu.westga.dsdm.nonlinear;

import edu.westga.dsdm.linear.ArrayList;

public class Heap<T extends Comparable<T>> {

	private ArrayList<T> elements;

	/**
	 * Creates a new Heap
	 */
	public Heap() {
		this.elements = new ArrayList<T>();
	}

	private void swap(int i, int j) {
		if (i != j) {
			T temporary = this.elements.get(i);
			this.elements.set(i, this.elements.get(j));
			this.elements.set(j, temporary);
		}
	}

	private void shiftUp(int child) {
		int parent = (child - 1) / 2;

		while (child > 0
				&& this.elements.get(parent)
						.compareTo(this.elements.get(child)) < 0) {
			this.swap(parent, child);
			child = parent;
			parent = (child - 1) / 2;
		}
	}

	private void shiftDown(int parent) {
		int leftChild = 2 * parent + 1;
		int rightChild = 2 * parent + 2;

		while (leftChild < this.size()) {
			boolean leftChildIsLargerThanParent = this.elements.get(parent)
					.compareTo(this.elements.get(leftChild)) < 0;
			boolean rightChildIsLargerThanParent = rightChild < this.elements
					.size()
					&& this.elements.get(parent).compareTo(
							this.elements.get(rightChild)) < 0;
			boolean rightChildIsLargerThanLeftChild = rightChild < this.elements
					.size()
					&& this.elements.get(leftChild).compareTo(
							this.elements.get(rightChild)) < 0;

			if (rightChildIsLargerThanParent && rightChildIsLargerThanLeftChild) {
				this.swap(parent, rightChild);
				parent = rightChild;
			} else if (!rightChildIsLargerThanLeftChild
					&& leftChildIsLargerThanParent) {
				this.swap(parent, leftChild);
				parent = leftChild;
			} else {
				parent = this.size();
			}

			leftChild = 2 * parent + 1;
			rightChild = 2 * parent + 2;
		}
	}

	/**
	 * Heapify a list.
	 * 
	 * If there are existing elements in the heap, the new elements are
	 * incorporated into the heap.
	 * 
	 * @param array
	 *            an ArrayList of elements which are in an unknown order
	 * @return
	 */
	public T heapify(ArrayList<T> myList) {
		if (myList == null) {
			throw new IllegalArgumentException("myList cannot be null");
		}

		for (T value : myList) {
			this.elements.add(value);
		}
		this.heapifyNode(0);
		return this.peek();
	}

	private void heapifyNode(int parent) {
		int leftChild = 2 * parent + 1;
		int rightChild = 2 * parent + 2;

		if (leftChild < this.size()) {
			this.heapifyNode(leftChild);
		}

		if (rightChild < this.size()) {
			this.heapifyNode(rightChild);
		}

		this.shiftDown(parent);
	}

	/**
	 * Returns the size of the heap.
	 * 
	 * @return the size of the heap
	 */
	public int size() {
		return this.elements.size();
	}

	/**
	 * Returns the top of the heap
	 * 
	 * @return the top of the heap
	 */
	public T peek() {
		if (this.size() == 0) {
			throw new IllegalStateException(
					"heap is empty. Cannot peek at top.");
		}

		return this.elements.get(0);
	}

	/**
	 * Adds an element to the top of the heap.
	 * 
	 * @precondition value != null
	 * @postcondition value is added to the heap and the size of the heap
	 *                increases by 1
	 * 
	 * @param value
	 *            the value to add
	 */
	public void add(T value) {
		if (value == null) {
			throw new IllegalArgumentException("value cannot be null");
		}

		this.elements.add(value);
		int child = this.elements.size() - 1;
		this.shiftUp(child);
	}

	/**
	 * Removes the top of the heap and returns it.
	 * 
	 * @precondition this.size() > 0
	 * @postcondition the top of the heap is removed and the size of the heap
	 *                decreases by 1
	 * 
	 * @return the top of the heap (which is also removed)
	 */
	public T remove() {
		if (this.size() == 0) {
			throw new IllegalStateException("heap is empty. Cannot remove.");
		}

		T value = this.elements.get(0);
		this.elements.set(0, this.elements.getLast());
		this.elements.removeLast();
		this.shiftDown(0);
		return value;
	}
}
