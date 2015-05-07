package edu.westga.dsdm.tests.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.dsdm.sorting.IsSorted;

public class IsSortedTest {

	@Test
	public void onOneElementShouldReturnTrue() {
		double a[] = {1};
		
		assertTrue(IsSorted.check(a));
	}
	
	@Test
	public void onTwoElement_1_2_ShouldReturnTrue() {
		double a[] = {1, 2};
		
		assertTrue(IsSorted.check(a));
	}
	
	@Test
	public void onTwoElement_2_2_ShouldReturnFalse() {
		double a[] = {2, 1};
		
		assertFalse(IsSorted.check(a));
	}
	
	@Test
	public void onElements_1_2_3_ShouldReturnTrue() {
		double a[] = {1, 2, 3};
		
		assertTrue(IsSorted.check(a));
	}
	
	@Test
	public void onElements_2_1_3_ShouldReturnFalse() {
		double a[] = {2, 1, 3};
		
		assertFalse(IsSorted.check(a));
	}
	
	@Test
	public void onElements_1_3_2_ShouldReturnFalse() {
		double a[] = {1, 3, 2};
		
		assertFalse(IsSorted.check(a));
	}
	
	@Test
	public void onElements_3_2_1_ShouldReturnFalse() {
		double a[] = {3, 2, 1};
		
		assertFalse(IsSorted.check(a));
	}
	
	@Test
	public void onElements_1_1_1_ShouldReturnTrue() {
		double a[] = {1, 1, 1};
		
		assertTrue(IsSorted.check(a));
	}
	
	@Test
	public void on1000OrderedNumbers_ShouldReturnFalse() {
		int n = 1000;
		double a[] = new double[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = i;
		}
		
		assertTrue(IsSorted.check(a));
	}
	
	@Test
	public void on1000ReversedNumbers_ShouldReturnTrue() {
		int n = 1000;
		double a[] = new double[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = n-i;
		}
		
		assertFalse(IsSorted.check(a));
	}
}
