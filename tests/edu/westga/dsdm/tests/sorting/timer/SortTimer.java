package edu.westga.dsdm.tests.sorting.timer;

import java.util.Random;
import edu.westga.dsdm.sorting.IsSorted;
import edu.westga.dsdm.sorting.Sort;

public class SortTimer {

	private String name;
	private Sort mySortingAlgorithm;
	private int n;

	public SortTimer(String name, Sort mySortingAlgorithm) {
		this.name = name;
		this.mySortingAlgorithm = mySortingAlgorithm;
		this.n = 10000;
	}

	private void printMessage(String typeOfData, double seconds) {
		System.out.printf("%30s of %6d %20s: %5.2f seconds\n", this.name, this.n, typeOfData, seconds);
	}

	private double speedTestOfSort(Sort sortingObject, double a[]) {
		long startTime = System.currentTimeMillis();
		sortingObject.sort(a);
		long endTime = System.currentTimeMillis();

		double seconds = (endTime - startTime) / 1000.0;
		return seconds;
	}

	public boolean sortNRandomValues() {
		Random rng = new Random();
		double a[] = new double[this.n];

		for (int i = 0; i < this.n; i++) {
			a[i] = rng.nextDouble();
		}

		double seconds = this.speedTestOfSort(this.mySortingAlgorithm, a);
		this.printMessage("Random Data", seconds);
		return IsSorted.check(a);
	}

	public boolean sortNOrderedValues() {
		double a[] = new double[this.n];

		for (int i = 0; i < this.n; i++) {
			a[i] = i;
		}

		double seconds = this.speedTestOfSort(this.mySortingAlgorithm, a);
		this.printMessage("Ordered Data", seconds);
		return IsSorted.check(a);
	}

	public boolean sortNReversedValues() {
		double a[] = new double[this.n];

		for (int i = 0; i < this.n; i++) {
			a[i] = this.n - i;
		}

		double seconds = this.speedTestOfSort(this.mySortingAlgorithm, a);
		this.printMessage("Reversed Data", seconds);
		return IsSorted.check(a);
	}
}