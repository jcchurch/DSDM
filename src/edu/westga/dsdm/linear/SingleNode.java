package edu.westga.dsdm.linear;

public class SingleNode<T> {

	private T value;
	private SingleNode<T> next;

	/**
	 * Creates a new, blank SingleNode.
	 * 
	 * @precondition none
	 * @postcondition The value is set to null, next links are also set to null
	 * @param value
	 *            The value to be stored in this SingleNode.
	 */
	public SingleNode() {
		this.value = null;
		this.next = null;
	}

	/**
	 * Creates a new SingleNode storing the value of a passed parameter.
	 * 
	 * @precondition none
	 * @postcondition The next links are set to null
	 * @param value
	 *            The value to be stored in this SingleNode.
	 */
	public SingleNode(T value) {
		this.value = value;
		this.next = null;
	}

	/**
	 * Returns the SingleNode currently referenced by this SingleNode's next.
	 * 
	 * @precondition this SingleNode's next cannot be null
	 * @postcondition none
	 * @return the value of this SingleNode's next.
	 */
	public SingleNode<T> getNext() {
		if (this.next == null) {
			throw new IllegalStateException("Cannot return a null reference");
		}
		return this.next;
	}

	/**
	 * Inserts aSingleNode into an existing list represented by this SingleNode.
	 * aSingleNode will be inserted into a list after this SingleNode.
	 * 
	 * @precondition aSingleNode is not null, aSingleNode's next is null.
	 * @postcondition the links of this SingleNode will be changed to have
	 *                aSingleNode inserted between this SingleNode and the
	 *                SingleNode (if applicable) exists currently after it.
	 * @param aSingleNode
	 *            The SingleNode to be inserted after this SingleNode.
	 */
	public void insert(SingleNode<T> aSingleNode) {
		if (aSingleNode == null) {
			throw new IllegalArgumentException("aSingleNode cannot be null.");
		}

		if (aSingleNode.next != null) {
			throw new IllegalArgumentException(
					"aSingleNode is already part of a list. Cannot be inserted.");
		}

		aSingleNode.next = this.next;
		this.next = aSingleNode;
	}

	/**
	 * Stores the current value of a SingleNode AFTER this SingleNode and
	 * returns it while removing the SingleNode AFTER this SingleNode.
	 * 
	 * @precondition This node's next is not null.
	 * @postcondition The SingleNode is remove. this SingleNode now points to
	 *                the node after the node after this SingleNode.
	 * @return the value of the removed SingleNode
	 */
	public T remove() {
		if (this.next == null) {
			throw new IllegalArgumentException("aSingleNode after this node cannot be null.");
		}

		T value = this.next.value;
		this.next = this.next.next;
		return value;
	}

	/**
	 * Returns the value stored in this SingleNode.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return The value stored in this SingleNode.
	 */
	public T get() {
		return this.value;
	}

	/**
	 * Sets the value of the SingleNode with a passed value.
	 * 
	 * @precondition none
	 * @postcondition The current value of this SingleNode is overwritten with
	 *                the passed value.
	 */
	public void set(T value) {
		this.value = value;
	}
}
