package edu.westga.dsdm.tests.linear;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.dsdm.linear.DoubleLinkedList;
import edu.westga.dsdm.linear.Stack;

public class DoubleStackTest {
	
	private Stack<Integer> myStackOneItem;
	private Stack<Integer> myStackThreeItems;

	@Before
	public void setUp() throws Exception {
		myStackOneItem = new Stack<>(new DoubleLinkedList<Integer>());
		myStackOneItem.push(42);

		myStackThreeItems = new Stack<>(new DoubleLinkedList<Integer>());
		myStackThreeItems.push(10);
		myStackThreeItems.push(20);
		myStackThreeItems.push(30);
	}

	@Test
	public void WhenPush1ItemSizeIs1() {
		assertEquals(1, this.myStackOneItem.size());
	}
	
	@Test
	public void WhenPush3ItemSizeIs1() {
		assertEquals(3, this.myStackThreeItems.size());
	}

	@Test
	public void WhenPush1ItempeakIs42() {
		assertEquals(42, (int) this.myStackOneItem.peek());
	}

	@Test
	public void WhenPush3ItemspeakIs30() {
		assertEquals(30, (int) this.myStackThreeItems.peek());
	}

	@Test
	public void WhenPop1ItemSizeIs0() {
		this.myStackOneItem.pop();
		assertEquals(0, this.myStackOneItem.size());
	}

	@Test
	public void WhenPop3ItemsSizeIs2() {
		this.myStackThreeItems.pop();
		assertEquals(2, this.myStackThreeItems.size());
	}

	@Test
	public void WhenPop1ItemThatItemIs42() {
		assertEquals(42, (int) this.myStackOneItem.pop());
	}

	@Test
	public void WhenPop3ItemsThatItemIs30() {
		assertEquals(30, (int) this.myStackThreeItems.pop());
	}
	
	@Test
	public void WhenPop3ItemsPeakItemIs20() {
		this.myStackThreeItems.pop();
		assertEquals(20, (int) this.myStackThreeItems.peek());
	}
}
