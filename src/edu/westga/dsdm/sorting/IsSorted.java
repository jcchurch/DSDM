package edu.westga.dsdm.sorting;

public class IsSorted {

	/**
	 * Tests to see if a list of double values are sorted.
	 * 
	 * @param values
	 * @return True if the list is sorted, false otherwise.
	 */
	static public boolean check(double[] values) {
		boolean isSorted = true;

		for (int i = 1; i < values.length; i++) {
			if (values[i] < values[i - 1]) {
				isSorted = false;
			}
		}

		return isSorted;
	}

}
