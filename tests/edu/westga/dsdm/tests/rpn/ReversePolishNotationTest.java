package edu.westga.dsdm.tests.rpn;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.dsdm.rpn.ReversePolishNotation;

public class ReversePolishNotationTest {
	
	private ReversePolishNotation rpn;
	
	@Before
	public void setUp() {
		rpn = new ReversePolishNotation();
	}

	@Test
	public void oneNumberShouldBe1() {
		rpn.loadExpression("1");
		assertEquals(1.0, rpn.getResult(), 0.001);
	}

	@Test
	public void TwoPlusTwoIs4() {
		rpn.loadExpression("2 2 +");
		assertEquals(4.0, rpn.getResult(), 0.001);
	}
	
	@Test
	public void FiveMinusThreeIs2() {
		rpn.loadExpression("5 3 -");
		assertEquals(2.0, rpn.getResult(), 0.001);
	}
	
	@Test
	public void FiveTimesThreeIs15() {
		rpn.loadExpression("5 3 *");
		assertEquals(15.0, rpn.getResult(), 0.001);
	}
	
	@Test
	public void ThirtyDividedBySixIs5() {
		rpn.loadExpression("30 6 /");
		assertEquals(5.0, rpn.getResult(), 0.001);
	}

	@Test
	public void FiveTimesTheResultOftwoPlusTwoIs20() {
		rpn.loadExpression("5 2 2 + *");
		assertEquals(20.0, rpn.getResult(), 0.001);
	}
}
