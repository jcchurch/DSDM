package edu.westga.dsdm.sorting;

public class MergeSort implements Sort {

	private void merge(double[] values, int left, int right, int end) {
		double[] auxillary = new double[values.length];

		int leftI = left;
		int rightI = right;

		int i = left;
		while (leftI < right && rightI <= end) {
			if (values[leftI] < values[rightI]) {
				auxillary[i] = values[leftI];
				leftI++;
			} else {
				auxillary[i] = values[rightI];
				rightI++;
			}
			i++;
		}
		
		while (leftI < right) {
			auxillary[i] = values[leftI];
			leftI++;
			i++;
		}
		
		while (rightI <= end) {
			auxillary[i] = values[rightI];
			rightI++;
			i++;
		}

		for (i = left; i <= end; i++) {
			values[i] = auxillary[i];
		}
	}

	private void mergeSort(double[] values, int low, int high) {
		if (low + 1 > high)
			return;

		int mid = (high - low) / 2 + low + 1;

		this.mergeSort(values, low, mid-1);
		this.mergeSort(values, mid, high);
		this.merge(values, low, mid, high);
	}

	public void sort(double[] values) {
		this.mergeSort(values, 0, values.length - 1);
	}
}
