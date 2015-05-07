package edu.westga.dsdm.linear;

public class Stack<T> {
	private List<T> myStack;

	/**
	 * Creates a new Stack based on a list structure.
	 * 
	 * @precondition the list must not be null and must be empty
	 * @postcondition the list is used as the stack
	 * 
	 * @param myList The list structure which will be used to build this stack
	 */
	public Stack(List<T> myList) {
		if (myList == null) {
			throw new IllegalStateException("List cannot be null.");
		}
		
		if (myList.size() > 0) {
			throw new IllegalStateException("List must be empty.");
		}
		
		myStack = myList;
	}

	/**
	 * Pushes one object onto the stack
	 * 
	 * @precondition myObject cannot be null
	 * @postcondition the object is added to the top of the stack and the stack increases in size by one.
	 * 
	 * @param myObject the object to be pushed on top of the stack
	 */
	public void push(T myObject) {
		if (myObject == null) {
			throw new IllegalArgumentException("myObject cannot be null");
		}

		this.myStack.addLast(myObject);
	}

	/**
	 * The size of the stack.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of elements of the stack
	 */
	public int size() {
		return this.myStack.size();
	}

	/**
	 * Returns true if the stack is empty, false otherwise
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if the stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return this.size() == 0;
	}

	/**
	 * Remove the top of the stack and return it.
	 * 
	 * @precondition the stack must not be empty
	 * @postcondition the size of the stack is reduced by 1 and the top element is removed.
	 * 
	 * @return the top of the stack
	 */
	public T pop() {
		if (myStack.size() == 0) {
			throw new IllegalStateException("The stack is empty. Cannot pop.");
		}

		return this.myStack.removeLast();
	}

	/**
	 * Look at the top of the stack.
	 * 
	 * @precondition the stack must not be empty.
	 * @postcondition none
	 * 
	 * @return the top of the stack
	 */
	public T peek() {
		if (myStack.size() == 0) {
			throw new IllegalStateException(
					"The stack is empty. Cannot get top.");
		}

		return this.myStack.getLast();
	}
}