package edu.westga.dsdm.sorting;

import edu.westga.dsdm.linear.Queue;

public class MergeSortQueue implements Sort {

	private void enqueueSublist(Queue<Double> list, double[] values, int start,
			int end) {

		// Base case is empty list.

		if (start <= end) { // Inductive
			list.enqueue(values[start]);
			this.enqueueSublist(list, values, start + 1, end);
		}
	}

	private void dequeueToSublist(Queue<Double> list, double[] values,
			int start, int end) {

		// Base case is empty list

		// Inductive case
		if (start <= end) {
			values[start] = list.dequeue();
			this.dequeueToSublist(list, values, start + 1, end);
		}
	}

	private void mergeQueues(Queue<Double> leftList, Queue<Double> rightList,
			Queue<Double> auxillaryList) {

		// Base Case
		if (leftList.isEmpty()) {
			if (rightList.isEmpty()) {
				return;
			}

		// Next four cases: inductive cases
			auxillaryList.enqueue(rightList.dequeue());
		} else if (rightList.isEmpty()) {
			auxillaryList.enqueue(leftList.dequeue());
		} else if (leftList.peek() < rightList.peek()) {
			auxillaryList.enqueue(leftList.dequeue());
		} else {
			auxillaryList.enqueue(rightList.dequeue());
		}

		this.mergeQueues(leftList, rightList, auxillaryList);
	}

	private void merge(double[] values, int left, int right, int end) {
		Queue<Double> leftList = new Queue<Double>();
		Queue<Double> rightList = new Queue<Double>();
		Queue<Double> auxillaryList = new Queue<Double>();

		this.enqueueSublist(leftList, values, left, right - 1);
		this.enqueueSublist(rightList, values, right, end);
		this.mergeQueues(leftList, rightList, auxillaryList);
		this.dequeueToSublist(auxillaryList, values, left, end);
	}

	private void mergeSort(double[] values, int low, int high) {
		// Base Case
		if (low + 1 > high)
			return;

		// Rest: Induction
		int mid = (high - low) / 2 + low + 1;

		this.mergeSort(values, low, mid - 1);
		this.mergeSort(values, mid, high);
		this.merge(values, low, mid, high);
	}

	public void sort(double[] values) {
		this.mergeSort(values, 0, values.length - 1);
	}
}
