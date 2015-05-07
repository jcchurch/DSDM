package edu.westga.dsdm.sorting;

public class InsertionSort implements Sort {

	private void insertIndexIntoSortedPortion(double[] values,
			int firstUnsortedIndex) {
		double valueToInsert = values[firstUnsortedIndex];

		int i = firstUnsortedIndex - 1;
		while (i >= 0 && values[i] > valueToInsert) {
			values[i + 1] = values[i];
			i -= 1;
		}

		values[i + 1] = valueToInsert;
	}

	public void sort(double[] values) {
		for (int i = 1; i < values.length; i++) {
			this.insertIndexIntoSortedPortion(values, i);
		}
	}
}
