package edu.westga.dsdm.linear;

public class Queue<T> {
	private DoubleLinkedList<T> myQueue;

	/**
	 * Creates a new Stack based on a linked list structure.
	 */
	public Queue() {
		myQueue = new DoubleLinkedList<T>();
	}

	/**
	 * Enqueues one object to the end of the queue
	 * 
	 * @precondition myObject cannot be null
	 * @postcondition the object is added to the end of the queue and the queue increases in size by one.
	 * 
	 * @param myObject the object to be pushed on front of the queue
	 */
	public void enqueue(T myObject) {
		if (myObject == null) {
			throw new IllegalArgumentException("myObject cannot be null");
		}

		this.myQueue.addLast(myObject);
	}

	/**
	 * The size of the queue.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of elements of the queue
	 */
	public int size() {
		return this.myQueue.size();
	}

	/**
	 * Returns true if the queue is empty, false otherwise
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if the queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return this.size() == 0;
	}

	/**
	 * Remove the front of the queue and return it.
	 * 
	 * @precondition the queue must not be empty
	 * @postcondition the size of the queue is reduced by 1 and the front element is removed.
	 * 
	 * @return the front of the queue
	 */
	public T dequeue() {
		if (myQueue.size() == 0) {
			throw new IllegalStateException("The queue is empty. Cannot dequeue.");
		}

		return this.myQueue.removeFirst();
	}

	/**
	 * Look at the front of the queue.
	 * 
	 * @precondition the queue must not be empty.
	 * @postcondition none
	 * 
	 * @return the front of the queue
	 */
	public T peek() {
		if (myQueue.size() == 0) {
			throw new IllegalStateException(
					"The queue is empty. Cannot get front.");
		}

		return this.myQueue.getFirst();
	}
}