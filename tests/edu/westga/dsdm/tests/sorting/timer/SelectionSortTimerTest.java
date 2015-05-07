package edu.westga.dsdm.tests.sorting.timer;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.westga.dsdm.sorting.SelectionSort;

public class SelectionSortTimerTest {

	private SortTimer st;
	
	@Before
	public void setUp() {
		this.st = new SortTimer("Selection Sort", new SelectionSort());
	}
	
	@Test
	public void sortNRandomValues() {
		assertTrue(st.sortNRandomValues());
	}

	@Test
	public void sortNOrderedValues() {
		assertTrue(st.sortNOrderedValues());
	}

	@Test
	public void sortNReversedValues() {
		assertTrue(st.sortNReversedValues());
	}
}