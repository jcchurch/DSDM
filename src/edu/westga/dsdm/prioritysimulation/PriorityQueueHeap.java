package edu.westga.dsdm.prioritysimulation;

import edu.westga.dsdm.nonlinear.Heap;

public class PriorityQueueHeap<T extends Comparable<T>> {

	// Add comments and implementation to this file.
	
	private Heap<T> aHeap;
	
	public PriorityQueueHeap() {
		this.aHeap = new Heap<T>();
	}
	
	public void insert(T anObject) {
		if (anObject == null) {
			throw new IllegalArgumentException("Object to insert is null");
		}
		this.aHeap.add(anObject);
	}
	
	public T remove() {
		return this.aHeap.remove();
	}
	
	public T get() {
		return this.aHeap.peek();
	}
	
	public int size() {
		return this.aHeap.size();
	}
	
	public boolean isEmpty() {
		return this.aHeap.size() == 0;
	}
}
