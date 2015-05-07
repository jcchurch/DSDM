package edu.westga.dsdm.linear;

import java.util.Iterator;

public class ArrayList<T> implements List<T>, Iterable<T> {
	private Object[] myList;
	private int size;

	/**
	 * Constructs an empty list with an initial capacity of ten. O(1)
	 */
	public ArrayList() {
		this(10);
	}

	/**
	 * Constructs an empty list with an initial capacity of n elements. O(1)
	 * 
	 * @param n
	 *            The desired number of elements in the list.
	 */
	public ArrayList(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException(
					"Cannot create a list of negative or zero number of elements.");
		}

		this.myList = new Object[n];
		this.size = 0;
	}

	/**
	 * Resizes the internal array to double the capacity. O(n)
	 * 
	 * @precondition none
	 * @postcondition the size of the internal array will be doubled
	 */
	private void resize() {
		Object[] myNewList = new Object[this.myList.length * 2];

		for (int i = 0; i < this.myList.length; i++) {
			myNewList[i] = this.myList[i];
		}

		this.myList = myNewList;
	}

	/* (non-Javadoc)
	 * @see edu.westga.dsdm.linear.List#add(T)
	 */
	@Override
	public void add(T value) {
		this.insert(this.size, value);
	}

	/* (non-Javadoc)
	 * @see edu.westga.dsdm.linear.List#insert(int, T)
	 */
	@Override
	public void insert(int index, T value) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException(
					"Index out of bounds: Cannot insert into this position.");
		}

		if (this.size == this.myList.length) {
			this.resize();
		}

		for (int i = this.size - 1; i >= index; i -= 1) {
			this.myList[i + 1] = this.myList[i];
		}

		this.myList[index] = value;
		this.size += 1;
	}

	/* (non-Javadoc)
	 * @see edu.westga.dsdm.linear.List#remove()
	 */
	@Override
	public T remove() {
		return this.remove(this.size-1);
	}

	/* (non-Javadoc)
	 * @see edu.westga.dsdm.linear.List#remove(int)
	 */
	@Override
	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException(
					"Index out of bounds: Cannot remove from this position.");
		}

		@SuppressWarnings("unchecked")
		T myValue = (T) this.myList[this.size - 1];

		for (int i = index; i < this.size - 1; i++) {
			this.myList[i] = this.myList[i + 1];
		}

		this.size -= 1;
		return myValue;
	}

	/* (non-Javadoc)
	 * @see edu.westga.dsdm.linear.List#get(int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T) this.myList[index];
	}

	/* (non-Javadoc)
	 * @see edu.westga.dsdm.linear.List#set(int, T)
	 */
	@Override
	public void set(int index, T value) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException(
					"Index out of bounds: Cannot set elements at this position.");
		}

		this.myList[index] = value;
	}

	/* (non-Javadoc)
	 * @see edu.westga.dsdm.linear.List#size()
	 */
	@Override
	public int size() {
		return this.size;
	}
	
	/* (non-Javadoc)
	 * @see edu.westga.dsdm.linear.List#addLast(T)
	 */
	@Override
	public void addLast(T value) { this.add(value); }
	/* (non-Javadoc)
	 * @see edu.westga.dsdm.linear.List#removeLast()
	 */
	@Override
	public T removeLast() { return this.remove(); }
	/* (non-Javadoc)
	 * @see edu.westga.dsdm.linear.List#getLast()
	 */
	@Override
	public T getLast() { return this.get(this.size-1); }
	
	/* (non-Javadoc)
	 * @see edu.westga.dsdm.linear.List#addFirst(T)
	 */
	@Override
	public void addFirst(T value) { this.insert(0, value); }
	/* (non-Javadoc)
	 * @see edu.westga.dsdm.linear.List#removeLast()
	 */
	@Override
	public T removeFirst() { return this.remove(0); }
	/* (non-Javadoc)
	 * @see edu.westga.dsdm.linear.List#getLast()
	 */
	@Override
	public T getFirst() { return this.get(0); }

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
