package edu.westga.dsdm.linear;

import java.util.Iterator;

public interface List<T> {

	/**
	 * Adds a value to the end of an ArrayList.
	 * 
	 * @param value
	 *            the value to be added.
	 */
	public abstract void add(T value);

	/**
	 * Inserts an element into the list at a given position.
	 * 
	 * @precondition the index element is from 0 to size (potentially one larger
	 *               than the length of the list)
	 * @postcondition the element will be added to the list at the index
	 *                position and the size of the list will increase by 1.
	 * 
	 * @param index
	 *            the index position of the value to be inserted
	 * @param value
	 *            the value to be inserted
	 */
	public abstract void insert(int index, T value);

	/**
	 * Removes an element from the list and returns the removed element.
	 * 
	 * @precondition The list is not empty
	 * @postcondition The element is removed from the end, returned, and the
	 *                size decreases by 1.
	 * 
	 * @return the value previously at the last position of the list
	 */
	public abstract T remove();

	/**
	 * Removes an element from the list at a specified index and returns it.
	 * 
	 * @precondition 0 <= index && index < size
	 * @postcondition The value is removed from the list, all elements after it
	 *                are shifted over one, and the size of the list decreases
	 *                by 1.
	 * 
	 * @param index
	 *            position of the element to be removed
	 * @return the removed value
	 */
	public abstract T remove(int index);

	/**
	 * Returns the element stored at a specified index position in the list.
	 * 
	 * @param index
	 *            the desired position into the list
	 * @return the element at the specified position
	 */
	public abstract T get(int index);

	/**
	 * Replaces the value at a specified index with a new value. The size of the
	 * list does not change.
	 * 
	 * @precondition 0 <= index && index < size
	 * @postcondition The element at specified index is overwritten
	 * 
	 * @param index
	 *            position of the element to be replaced
	 * @param value
	 *            The value to replace at the specified index
	 */
	public abstract void set(int index, T value);

	/**
	 * Returns the size of the list
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the size of the list
	 */
	public abstract int size();

	public abstract void addLast(T value);

	public abstract T removeLast();

	public abstract T getLast();
	
	public abstract void addFirst(T value);

	public abstract T removeFirst();

	public abstract T getFirst();
	
	public abstract Iterator<T> iterator();

}