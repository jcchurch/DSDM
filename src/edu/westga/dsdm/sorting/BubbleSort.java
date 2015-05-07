package edu.westga.dsdm.sorting;

public class BubbleSort implements Sort {
    public void sort(double[] values) {
    	for (int i = 0; i < values.length; i++) {
    		for (int j = 1; j < values.length; j++) {
    			if (values[j] < values[j-1]) {
    				double temporary = values[j];
    				values[j] = values[j-1];
    				values[j-1] = temporary;
    			}
    		}
    	}
    }
}
