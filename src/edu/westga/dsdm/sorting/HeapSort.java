package edu.westga.dsdm.sorting;

import edu.westga.dsdm.linear.ArrayList;
import edu.westga.dsdm.nonlinear.Heap;

public class HeapSort implements Sort {

	public void sort(double[] values) {
		Heap<Double> h = new Heap<Double>();
		
		ArrayList<Double> objValues = new ArrayList<>();
		
		for (double value : values) {
			objValues.add(value);
		}
		
		h.heapify(objValues);
		
		for (int i = values.length-1; i >= 0; i--) {
			values[i] = h.remove();
		}
	}

}
