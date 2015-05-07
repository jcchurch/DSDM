package edu.westga.dsdm.tests.linear;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.dsdm.linear.SingleLinkedList;
import edu.westga.dsdm.linear.Stack;

public class SingleStackTest {
	
	private Stack<Integer> mySingleStackOneItem;
	private Stack<Integer> mySingleStackThreeItems;

	@Before
	public void setUp() throws Exception {
		mySingleStackOneItem = new Stack<>(new SingleLinkedList<Integer>());
		mySingleStackOneItem.push(42);

		mySingleStackThreeItems = new Stack<>(new SingleLinkedList<Integer>());
		mySingleStackThreeItems.push(10);
		mySingleStackThreeItems.push(20);
		mySingleStackThreeItems.push(30);
	}

	@Test
	public void WhenPush1ItemSizeIs1() {
		assertEquals(1, this.mySingleStackOneItem.size());
	}
	
	@Test
	public void WhenPush3ItemSizeIs1() {
		assertEquals(3, this.mySingleStackThreeItems.size());
	}

	@Test
	public void WhenPush1ItemTopIs42() {
		assertEquals(42, (int) this.mySingleStackOneItem.peek());
	}

	@Test
	public void WhenPush3ItemsTopIs30() {
		assertEquals(30, (int) this.mySingleStackThreeItems.peek());
	}

	@Test
	public void WhenPop1ItemSizeIs0() {
		this.mySingleStackOneItem.pop();
		assertEquals(0, this.mySingleStackOneItem.size());
	}

	@Test
	public void WhenPop3ItemsSizeIs2() {
		this.mySingleStackThreeItems.pop();
		assertEquals(2, this.mySingleStackThreeItems.size());
	}

	@Test
	public void WhenPop1ItemThatItemIs42() {
	}

	@Test
	public void WhenPop3ItemsThatItemIs30() {
		assertEquals(30, (int) this.mySingleStackThreeItems.pop());
	}

	@Test
	public void WhenPop3ItemsTopItemIs20() {
		this.mySingleStackThreeItems.pop();
		assertEquals(20, (int) this.mySingleStackThreeItems.peek());
	}
}
