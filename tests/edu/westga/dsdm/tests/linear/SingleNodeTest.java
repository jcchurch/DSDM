package edu.westga.dsdm.tests.linear;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.dsdm.linear.SingleNode;

public class SingleNodeTest {

	private SingleNode<Integer> four;
	private SingleNode<Integer> eight;
	private SingleNode<Integer> ten;
	private SingleNode<Integer> twelve;

	@Before
	public void setUp() throws Exception {
		this.four = new SingleNode<Integer>(4);
		this.eight = new SingleNode<Integer>(8);
		this.ten = new SingleNode<Integer>(10);
		this.twelve = new SingleNode<Integer>(12);

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
	public void ShouldGet12AfterFourGetNextGetNextGet() {
		assertEquals(12, (int) this.four.getNext().getNext().get());
	}

	@Test
	public void ShouldGet10AfterInsertingTenBetweenEightAndTwelve() {
		this.eight.insert(ten);
		assertEquals(10, (int) this.four.getNext().getNext().get());
	}

}
