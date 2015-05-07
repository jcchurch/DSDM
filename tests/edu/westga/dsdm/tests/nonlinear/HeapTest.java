package edu.westga.dsdm.tests.nonlinear;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.dsdm.nonlinear.Heap;

public class HeapTest {

	@Test
	public final void When1000ElementsPeekIs1000() {
		Heap<Double> h = new Heap<Double>();
		double[] array = new double[1000];
		
		for (int i = 1; i <= 1000; i++) {
			array[i-1] = i;
		}
		
		for (double value : array) {
			h.add(value);
		}

		assertEquals(1000, h.peek(), 0.001);
	}
	
	@Test
	public final void When1000ElementsRemoveIs999() {
		Heap<Double> h = new Heap<Double>();
		double[] array = new double[1000];
		
		for (int i = 1; i <= 1000; i++) {
			array[i-1] = i;
		}
		
		for (double value : array) {
			h.add(value);
		}
		h.remove();		
		assertEquals(999, h.peek(), 0.001);
	}
	
	@Test
	public final void WhenJennyRemoveIsInOrder() {
		Heap<Double> h = new Heap<Double>();
		double[] array = {8, 6, 7, 5, 3, 0, 9};
		
		for (double value : array) {
			h.add(value);
		}
		
		assertEquals(9, h.remove(), 0.001);
		assertEquals(8, h.remove(), 0.001);
		assertEquals(7, h.remove(), 0.001);
		assertEquals(6, h.remove(), 0.001);
		assertEquals(5, h.remove(), 0.001);
		assertEquals(3, h.remove(), 0.001);
		assertEquals(0, h.remove(), 0.001);
	}
	
	@Test
	public final void WhenJennyRemoveIs8() {
		Heap<Double> h = new Heap<Double>();
		double[] array = {8, 6, 7, 5, 3, 0, 9};
		
		for (double value : array) {
			h.add(value);
		}
		h.remove();
		assertEquals(8, h.peek(), 0.001);
	}

	@Test
	public final void When0_1_2_3PeekIs3() {
		Heap<Double> h = new Heap<Double>();
		double[] array = {0, 1, 2, 3};
		
		for (double value : array) {
			h.add(value);
		}

		assertEquals(3, h.peek(), 0.001);
	}
	
	@Test
	public final void When0_1_2_3_Remove_PeekIs2() {
		Heap<Double> h = new Heap<Double>();
		double[] array = {0, 1, 2, 3};
		
		for (double value : array) {
			h.add(value);
		}
		h.remove();
		assertEquals(2, h.peek(), 0.001);
	}
	
	@Test
	public final void When1PeekIs1() {
		Heap<Double> h = new Heap<Double>();
		double[] array = {1};
		
		for (double value : array) {
			h.add(value);
		}
		
		assertEquals(1, h.peek(), 0.001);
	}
	
	@Test
	public final void When1_2PeekIs2() {
		Heap<Double> h = new Heap<Double>();
		double[] array = {1, 2};
		
		for (double value : array) {
			h.add(value);
		}
		
		assertEquals(2, h.peek(), 0.001);
	}

	@Test
	public final void When1_2RemoveIs1() {
		Heap<Double> h = new Heap<Double>();
		double[] array = {1, 2};
		
		for (double value : array) {
			h.add(value);
		}
		h.remove();
		assertEquals(1, h.peek(), 0.001);
	}
	
	@Test
	public final void When2_1PeekIs2() {
		Heap<Double> h = new Heap<Double>();
		double[] array = {2, 1};
		
		for (double value : array) {
			h.add(value);
		}
		
		assertEquals(2, h.peek(), 0.001);
	}
	
	@Test
	public final void When2_1RemoveIs1() {
		Heap<Double> h = new Heap<Double>();
		double[] array = {2, 1};
		
		for (double value : array) {
			h.add(value);
		}
		h.remove();
		assertEquals(1, h.peek(), 0.001);
	}

}
