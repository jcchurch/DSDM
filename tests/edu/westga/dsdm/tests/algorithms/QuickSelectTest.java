package edu.westga.dsdm.tests.algorithms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.dsdm.algorithms.QuickSelect;

public class QuickSelectTest {

	private double[] one = {1};
	private double[] onetwo = {1, 2};
	private double[] twoone = {2, 1};
	private double[] jenny = {8, 6, 7, 5, 3, 0, 9};
	
	private QuickSelect qs;

	@Before
	public void setUp() throws Exception {
		this.qs = new QuickSelect();
	}
	
	@Test
	public void onOne_0_ShouldBe_1() {
        assertEquals(1, (int) qs.select(one, 0));
	}
	
	@Test
	public void onOneTwo_0_ShouldBe_1() {
        assertEquals(1, (int) qs.select(onetwo, 0));
	}
	
	@Test
	public void onOneTwo_1_ShouldBe_2() {
        assertEquals(2, (int) qs.select(onetwo, 1));
	}
	
	@Test
	public void onTwoOne_0_ShouldBe_1() {
        assertEquals(1, (int) qs.select(twoone, 0));
	}
	
	@Test
	public void onTwoOne_1_ShouldBe_2() {
        assertEquals(2, (int) qs.select(twoone, 1));
	}

	@Test
	public void onJenny_0_ShouldBe_0() {
        assertEquals(0, (int) qs.select(jenny, 0));
	}

	@Test
	public void onJenny_1_ShouldBe_3() {
        assertEquals(3, (int) qs.select(jenny, 1));
	}
	
	@Test
	public void onJenny_2_ShouldBe_5() {
        assertEquals(5, (int) qs.select(jenny, 2));
	}
	
	@Test
	public void onJenny_3_ShouldBe_6() {
        assertEquals(6, (int) qs.select(jenny, 3));
	}
	
	@Test
	public void onJenny_4_ShouldBe_7() {
        assertEquals(7, (int) qs.select(jenny, 4));
	}

	@Test
	public void onJenny_5_ShouldBe_8() {
        assertEquals(8, (int) qs.select(jenny, 5));
	}
	
	@Test
	public void onJenny_6_ShouldBe_9() {
        assertEquals(9, (int) qs.select(jenny, 6));
	}
}
