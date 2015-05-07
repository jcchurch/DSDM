package edu.westga.dsdm.linear;

import java.util.Iterator;

public class DoubleLinkedList<T> implements List<T>, Iterable<T> {
	private DoubleNode<T> head;
	private DoubleNode<T> tail;
	private int size;

	/**
	 * Creates a new linked list of zero elements.
	 * 
	 * @precondition none
	 * @postcondition The head is connected to the tail and the size is
	 *                initialized to zero.
	 */
	public DoubleLinkedList() {
		this.head = new DoubleNode<T>();
		this.tail = new DoubleNode<T>();

		this.head.insert(this.tail);
		this.size = 0;
	}

	/**
	 * Returns the size of the list
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the size of the list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Adds a new value on to the end of the list
	 * 
	 * @precondition none
	 * @postcondition the length of the list increases in size by 1 and the
	 *                value is added
	 * @param value
	 *            the value to be added
	 */
	public void add(T value) {
		this.tail.getPrev().insert(new DoubleNode<T>(value));
		this.size += 1;
	}

	/**
	 * Adds a value to the list at a desired index position.
	 * 
	 * @precondition 0 <= index && index < size
	 * @postcondition the length of the list increases in size by 1 and the
	 *                value is added at a particular index
	 * 
	 * @param index
	 *            The position to add a value
	 * @param value
	 *            The value to be added
	 */
	public void insert(int index, T value) {

		if (index < 0 || index > this.size) {
			throw new IllegalArgumentException("Index out of bounds: " + index);
		}

		// Special Case
		if (index == this.size) {
			this.add(value);
			return;
		}

		DoubleNode<T> pointer = head;
		for (int i = 0; i < index; i++) {
			pointer = pointer.getNext();
		}

		pointer.insert(new DoubleNode<T>(value));
		this.size += 1;
	}

	/**
	 * Removes an element from the list at a specified index.
	 * 
	 * @precondition index > 0 && index < size
	 * @postcondition the element is removed from the list and the size
	 *                decreases by 1.
	 * 
	 * @param index
	 *            The position of the value to be removed
	 * @return The value of the removed position
	 */
	public T remove(int index) {
		if (index < 0 || index >= this.size) {
			throw new IllegalArgumentException("index is out of bounds: "
					+ index);
		}

		// Special Case
		if (index == this.size - 1) {
			T value = tail.getPrev().get();
			tail.getPrev().remove();
			this.size -= 1;
			return value;
		}

		DoubleNode<T> pointer = head.getNext();
		for (int i = 0; i < index; i++) {
			pointer = pointer.getNext();
		}

		T value = pointer.get();
		pointer.remove();
		this.size -= 1;

		return value;
	}

	/**
	 * Returns the value of the element at position index
	 * 
	 * @precondition 0 <= index && index < size
	 * @postcondition none
	 * 
	 * @param index
	 *            The position of the
	 * @return The value of the element at position index
	 */
	public T get(int index) {
		if (index < 0 || index >= this.size) {
			throw new IllegalArgumentException("index is out of bounds: "
					+ index);
		}

		// Special case
		if (index == this.size - 1) {
			return tail.getPrev().get();
		}

		DoubleNode<T> pointer = head.getNext();
		for (int i = 0; i < index; i++) {
			pointer = pointer.getNext();
		}

		return pointer.get();
	}

	/**
	 * Adds a value to the beginning of a list. The size of the list increases
	 * by 1.
	 * 
	 * @param value
	 *            the value to be added
	 */
	public void addFirst(T value) {
		this.insert(0, value);
	}

	/**
	 * Adds a value to the end of a list. The size of the list increases by 1.
	 * 
	 * @param value
	 *            the value to be added
	 */
	public void addLast(T value) {
		this.insert(this.size, value);
	}

	/**
	 * Returns the value of the first element.
	 * 
	 * @return the value of the first element
	 */
	public T getFirst() {
		if (this.size == 0) {
			throw new IllegalStateException("The list cannot be empty.");
		}

		return this.get(0);
	}

	/**
	 * 
	 * Returns the value of the last element.
	 * 
	 * @precondition size > 0
	 * @return the value of the last element.
	 */
	public T getLast() {
		if (this.size == 0) {
			throw new IllegalStateException("The list cannot be empty.");
		}

		return this.get(this.size - 1);
	}

	/**
	 * Removes and returns the first element in the list. The size of the list
	 * decreases by 1.
	 * 
	 * @precondition size > 0
	 * @return the formerly first element in the list
	 */
	public T removeFirst() {
		if (this.size == 0) {
			throw new IllegalStateException("The list cannot be empty.");
		}

		return this.remove(0);
	}

	/**
	 * Removes and returns the last element in the list. The size of the list
	 * decreases by 1.
	 * 
	 * @precondition size > 0
	 * @return the formerly last element in the list
	 */
	public T removeLast() {
		if (this.size == 0) {
			throw new IllegalStateException("The list cannot be empty.");
		}

		return this.remove(this.size - 1);
	}

	public boolean equals(DoubleLinkedList<T> aList) {
		if (aList == null) {
			throw new IllegalStateException("aList cannot be null");
		}

		if (this.size() != aList.size()) {
			return false;
		}

		boolean same = true;

		DoubleNode<T> myPointer = head.getNext();
		DoubleNode<T> yourPointer = aList.head.getNext();

		for (int i = 0; i < aList.size(); i++) {
			if (myPointer.get() != yourPointer.get()) {
				same = false;
			}

			myPointer.getNext();
			yourPointer.getNext();
		}

		return same;
	}

	@Override
	public T remove() {
		return this.removeLast();
	}

	@Override
	public void set(int index, T value) {
		if (index < 0 || index >= this.size) {
			throw new IllegalArgumentException("index is out of bounds: "
					+ index);
		}

		// Special case
		if (index == this.size - 1) {
			tail.getPrev().set(value);
		}

		DoubleNode<T> pointer = head.getNext();
		for (int i = 0; i < index; i++) {
			pointer = pointer.getNext();
		}

		pointer.set(value);
	}
	
	@Override
	public Iterator<T> iterator() {
	    Iterator<T> it = new Iterator<T>() {
	
	        private int currentIndex = 0;
	
	        @Override
	        public boolean hasNext() {
	            return currentIndex < size;
	        }

			@Override
	        public T next() {
				currentIndex++;
	            return get(currentIndex-1);
	        }
	
	        @Override
	        public void remove() {
	            throw new UnsupportedOperationException();
	        }
	    };
	    return it;
	}
}
