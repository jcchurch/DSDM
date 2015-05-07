package edu.westga.dsdm.algorithms;

import java.util.Random;

public class QuickSelect {

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

		return a;
	}

	private double quickSelect(double[] values, int low, int high, int sortedIndex) {
		int pivot = partition(values, low, high);
		
		if (pivot < sortedIndex) {
			return this.quickSelect(values, pivot+1, high, sortedIndex);
		}
		
		if (pivot > sortedIndex) {
			return this.quickSelect(values, low, pivot-1, sortedIndex);
		}
		
		return values[sortedIndex];
	}

	public double select(double[] values, int sortedIndex) {
		return this.quickSelect(values, 0, values.length - 1, sortedIndex);
	}
	
}
