package edu.westga.dsdm.tests.linear;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.dsdm.linear.DoubleNode;

public class DoubleNodeTest {

	private DoubleNode<Integer> four;
	private DoubleNode<Integer> eight;
	private DoubleNode<Integer> ten;
	private DoubleNode<Integer> twelve;

	@Before
	public void setUp() throws Exception {
		this.four = new DoubleNode<Integer>(4);
		this.eight = new DoubleNode<Integer>(8);
		this.ten = new DoubleNode<Integer>(10);
		this.twelve = new DoubleNode<Integer>(12);

		this.four.insert(eight);
		this.eight.insert(twelve);
	}

	@Test
	public void ShouldGet4WhenFourGet() {
		assertEquals(4, (int) this.four.get());
	}

	@Test
	public void ShouldGet8AfterFourGetNextGet() {
		assertEquals(8, (int) this.four.getNext().get());
	}

	@Test
	public void ShouldGet8AfterTwelveGetPrevGet() {
		assertEquals(8, (int) this.twelve.getPrev().get());
	}

	@Test
	public void ShouldGet12AfterFourGetNextGetNextGet() {
		assertEquals(12, (int) this.four.getNext().getNext().get());
	}

	@Test
	public void ShouldGet4AfterTwelveGetPrevGetPrevGet() {
		assertEquals(4, (int) this.twelve.getPrev().getPrev().get());
	}

	@Test
	public void ShouldGet10AfterInsertingTenBetweenEightAndTwelve() {
		this.eight.insert(ten);
		assertEquals(10, (int) this.four.getNext().getNext().get());
		assertEquals(10, (int) this.twelve.getPrev().get());
	}

}
