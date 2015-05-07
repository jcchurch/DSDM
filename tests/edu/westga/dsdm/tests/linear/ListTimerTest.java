package edu.westga.dsdm.tests.linear;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.dsdm.linear.ArrayList;
import edu.westga.dsdm.linear.DoubleLinkedList;
import edu.westga.dsdm.linear.DoubleLinkedListRecursion;
import edu.westga.dsdm.linear.Stack;

public class ListTimerTest {
	
	private final int ITERATIONS = 1000000;

	private double speedTestOfStack(Stack<Character> myStack) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < this.ITERATIONS; i++) {
			myStack.push('A');
		}
		
		while (!myStack.isEmpty()) {
			myStack.peek();
			myStack.pop();
		}

		long endTime = System.currentTimeMillis();
		
		double seconds = (endTime - startTime) / 1000.0;
		return seconds;
	}
	
	@Test
	public void pushPopAndPeakRepeatedTestOfDoubleLinkedListShouldTakeLessThan1Second() {
		Stack<Character> stack = new Stack<Character>(new DoubleLinkedList<Character>());
        double seconds = this.speedTestOfStack(stack);
		System.out.println("Double Linked List: "+seconds);
		assertEquals(0, (int) seconds);
	}
	
	@Test
	public void pushPopAndPeakRepeatedTestOfDoubleLinkedListRecursionShouldTakeLessThan1Second() {
		Stack<Character> stack = new Stack<Character>(new DoubleLinkedListRecursion<Character>());
        double seconds = this.speedTestOfStack(stack);
		System.out.println("Double Linked List Recursion: "+seconds);
		assertEquals(0, (int) seconds);
	}
	
	@Test
	public void pushPopAndPeakRepeatedTestOfArrayListShouldTakeLessThan1Second() {
		Stack<Character> stack = new Stack<Character>(new ArrayList<Character>());
        double seconds = this.speedTestOfStack(stack);
		System.out.println("Array List: "+seconds);
		assertEquals(0, (int) seconds);
	}
}
