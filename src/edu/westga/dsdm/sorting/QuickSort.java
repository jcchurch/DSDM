package edu.westga.dsdm.sorting;

import java.util.Random;

public class QuickSort implements Sort {

	private void swap(double[] values, int a, int b) {
		if (a != b) {
			double tempValue = values[a];
			values[a] = values[b];
			values[b] = tempValue;
		}
	}

	private int partition(double[] values, int low, int high) {

		int pivotPoint = this.selectPivot(values, low, high);
		double pivotValue = values[pivotPoint];
		this.swap(values, pivotPoint, high);

		int storeIndex = low;
		for (int i = low; i < high; i++) {
			if (values[i] <= pivotValue) {
				this.swap(values, i, storeIndex);
				storeIndex = storeIndex + 1;
			}
		}

		this.swap(values, storeIndex, high);
		return storeIndex;
	}

	private int selectPivot(double[] values, int low, int high) {
		if (high - low < 4)
			return low;
		
		Random rng = new Random();
		int a = rng.nextInt(high - low) + low;
		int b = a;
		int c = a;
		
		while (b == a) {
			b = rng.nextInt(high - low) + low;
		}
		
		while (c == a || c == b) {
			c = rng.nextInt(high - low) + low;
		}
		
		if (values[a] > values[b]) {
			int temporary = a;
			a = b;
			b = temporary;
		}

		if (values[b] > values[c]) {
			int temporary = c;
			c = b;
			b = temporary;
		}
		
		if (values[a] > values[b]) {
			int temporary = a;
			a = b;
			b = temporary;
		}
		
		return b;
	}

	private void quickSort(double[] values, int low, int high) {
		if (low >= high)
			return;

		int pivot = partition(values, low, high);
		this.quickSort(values, low, pivot - 1);
		this.quickSort(values, pivot + 1, high);
	}

	public void sort(double[] values) {
		this.quickSort(values, 0, values.length - 1);
	}
}
