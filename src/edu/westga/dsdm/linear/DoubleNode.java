package edu.westga.dsdm.linear;


public class DoubleNode<T> {

	private T value;
	private DoubleNode<T> prev;
	private DoubleNode<T> next;

	/**
	 * Creates a new, blank DoubleNode.
	 * 
	 * @precondition none
	 * @postcondition The value is set to null, previous and next links are also
	 *                set to null
	 * @param value
	 *            The value to be stored in this DoubleNode.
	 */
	public DoubleNode() {
		this.value = null;
		this.prev = null;
		this.next = null;
	}

	/**
	 * Creates a new DoubleNode storing the value of a passed parameter.
	 * 
	 * @precondition none
	 * @postcondition The previous and next links are set to null
	 * @param value
	 *            The value to be stored in this DoubleNode.
	 */
	public DoubleNode(T value) {
		this.value = value;
		this.prev = null;
		this.next = null;
	}

	/**
	 * Returns the DoubleNode currently referenced by this DoubleNode's next.
	 * 
	 * @precondition this DoubleNode's next cannot be null
	 * @postcondition none
	 * @return the value of this DoubleNode's next.
	 */
	public DoubleNode<T> getNext() {
		if (this.next == null) {
			throw new IllegalStateException("Cannot return a null reference");
		}
		return this.next;
	}

	/**
	 * Returns the DoubleNode currently referenced by this DoubleNode's previous.
	 * 
	 * @precondition this DoubleNode's previous cannot be null
	 * @postcondition none
	 * @return the value of this DoubleNode's previous.
	 */
	public DoubleNode<T> getPrev() {
		if (this.prev == null) {
			throw new IllegalStateException("Cannot return a null reference");
		}
		return this.prev;
	}

	/**
	 * Inserts aDoubleNode into an existing list represented by this DoubleNode. aDoubleNode will
	 * be inserted into a list after this DoubleNode.
	 * 
	 * @precondition aDoubleNode is not null, aDoubleNode's prev and next are null.
	 * @postcondition the links of this DoubleNode will be changed to have aDoubleNode
	 *                inserted between this DoubleNode and the DoubleNode (if applicable)
	 *                exists currently after it.
	 * @param aDoubleNode
	 *            The DoubleNode to be inserted after this DoubleNode.
	 */
	public void insert(DoubleNode<T> aDoubleNode) {
		if (aDoubleNode == null) {
			throw new IllegalArgumentException("aDoubleNode cannot be null.");
		}

		if (aDoubleNode.prev != null || aDoubleNode.next != null) {
			throw new IllegalArgumentException(
					"aDoubleNode is already part of a list. Cannot be inserted.");
		}

		// First, set aDoubleNode's previous to this DoubleNode.
		aDoubleNode.prev = this;

		// Second, check to see if there is currently a next DoubleNode.
		if (this.next != null) {
			this.next.prev = aDoubleNode;
		}

		// Third, set aDoubleNode's next to this's next
		aDoubleNode.next = this.next;

		// Fourth, set this's next to aDoubleNode
		this.next = aDoubleNode;
	}

	/**
	 * Stores the current value of a DoubleNode and returns it while removing the
	 * DoubleNode.
	 * 
	 * @precondition None
	 * @postcondition The DoubleNode is remove. If there is a next DoubleNode, it's previous
	 *                points to this DoubleNode's previous. If there is a previous
	 *                DoubleNode, it's next points to this DoubleNode's next.
	 * @return the value of the removed DoubleNode
	 */
	public T remove() {
		T value = this.value;

		if (this.next != null) {
			this.next.prev = this.prev;
		}

		if (this.prev != null) {
			this.prev.next = this.next;
		}

		return value;
	}

	/**
	 * Returns the value stored in this DoubleNode.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return The value stored in this DoubleNode.
	 */
	public T get() {
		return this.value;
	}

	/**
	 * Sets the value of the DoubleNode with a passed value.
	 * 
	 * @precondition none
	 * @postcondition The current value of this DoubleNode is overwritten with the
	 *                passed value.
	 */
	public void set(T value) {
		this.value = value;
	}
}
