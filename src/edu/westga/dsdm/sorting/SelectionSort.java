package edu.westga.dsdm.sorting;

public class SelectionSort implements Sort {
	
	static public int findMinLocation(double[] values, int startingPoint) {
		int minLocation = startingPoint;
		for (int i = startingPoint+1; i < values.length; i++) {
			if (values[i] < values[minLocation]) {
				minLocation = i;
			}
		}
		return minLocation;
	}

    public void sort(double[] values) {
    	for (int i = 0; i < values.length-1; i++) {
    		int minLocation = findMinLocation(values, i);
    		if (i != minLocation) {
    			double minValue = values[minLocation];
    			values[minLocation] = values[i];
    			values[i] = minValue;
    		}
    	}
    }
}
