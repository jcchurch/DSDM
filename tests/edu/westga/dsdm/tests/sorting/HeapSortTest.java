package edu.westga.dsdm.tests.sorting;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import edu.westga.dsdm.sorting.HeapSort;
import edu.westga.dsdm.sorting.IsSorted;

public class HeapSortTest {

	private HeapSort sortMe;

	@Before
	public void setUp() throws Exception {
		this.sortMe = new HeapSort();
	}

	@Test
	public void onOneElementShouldReturnTrue() {
		double a[] = { 1 };

		this.sortMe.sort(a);

		assertTrue (IsSorted.check(a));
	}

	@Test
	public void onTwoElement_1_2_ShouldReturnTrue() {
		double a[] = { 1, 2 };

		this.sortMe.sort(a);

		assertTrue (IsSorted.check(a));
	}

	@Test
	public void onTwoElement_2_1_ShouldReturnTrue() {
		double a[] = { 2, 1 };

		this.sortMe.sort(a);

		assertTrue (IsSorted.check(a));
	}

	@Test
	public void onElements_1_2_3_ShouldReturnTrue() {
		double a[] = { 1, 2, 3 };

		this.sortMe.sort(a);

		assertTrue (IsSorted.check(a));
	}

	@Test
	public void onElements_2_1_3_ShouldReturnTrue() {
		double a[] = { 2, 1, 3 };

		this.sortMe.sort(a);

		assertTrue (IsSorted.check(a));
	}

	@Test
	public void onElements_1_3_2_ShouldReturnTrue() {
		double a[] = { 1, 3, 2 };

		this.sortMe.sort(a);

		assertTrue (IsSorted.check(a));
	}

	@Test
	public void onElements_3_2_1_ShouldReturnTrue() {
		double a[] = { 3, 2, 1 };

		this.sortMe.sort(a);

		assertTrue (IsSorted.check(a));
	}

	@Test
	public void onElements_1_1_1_ShouldReturnTrue() {
		double a[] = { 1, 1, 1 };

		this.sortMe.sort(a);

		assertTrue (IsSorted.check(a));
	}

	@Test
	public void onJenny_ShouldReturnTrue() {
		double a[] = { 8, 6, 7, 5, 3, 0, 9 };

		this.sortMe.sort(a);

		assertTrue (IsSorted.check(a));
	}

	@Test
	public void on1000RandomNumbers_ShouldReturnTrue() {
		Random rng = new Random();
		int n = 1000;
		double a[] = new double[n];

		for (int i = 0; i < n; i++) {
			a[i] = rng.nextDouble();
		}

		this.sortMe.sort(a);

		assertTrue (IsSorted.check(a));
	}

	@Test
	public void on1000OrderedNumbers_ShouldReturnTrue() {
		int n = 1000;
		double a[] = new double[n];

		for (int i = 0; i < n; i++) {
			a[i] = i;
		}

		this.sortMe.sort(a);

		assertTrue (IsSorted.check(a));
	}

	@Test
	public void on1000ReversedNumbers_ShouldReturnTrue() {
		int n = 1000;
		double a[] = new double[n];

		for (int i = 0; i < n; i++) {
			a[i] = n - i;
		}

		this.sortMe.sort(a);

		assertTrue (IsSorted.check(a));
	}
}
