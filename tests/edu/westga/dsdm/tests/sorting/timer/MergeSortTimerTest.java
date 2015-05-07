package edu.westga.dsdm.tests.sorting.timer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.dsdm.sorting.MergeSort;

public class MergeSortTimerTest {

	private SortTimer st;
	
	@Before
	public void setUp() {
		this.st = new SortTimer("Merge Sort", new MergeSort());
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