package edu.westga.dsdm.tests.sorting.timer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.dsdm.sorting.InsertionSort;

public class InsertionSortTimerTest {

	private SortTimer st;
	
	@Before
	public void setUp() {
		this.st = new SortTimer("Insertion Sort", new InsertionSort());
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