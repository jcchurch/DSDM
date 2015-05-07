package edu.westga.dsdm.rpn;

import edu.westga.dsdm.linear.DoubleLinkedList;
import edu.westga.dsdm.linear.Stack;

public class ReversePolishNotation {

	private Stack<Double> myStack;

	public ReversePolishNotation() {
		myStack = new Stack<Double>(new DoubleLinkedList<Double>());
	}

	private void addSymbol(String symbol) {

		try {
			double value = Double.parseDouble(symbol);
			myStack.push(value);
		} catch (NumberFormatException e) {
			if (symbol.equals("*")) {
				this.performMultiplication();
			} else if (symbol.equals("/")) {
				this.performDivision();
			} else if (symbol.equals("+")) {
				this.performAddition();
			} else if (symbol.equals("-")) {
				this.performSubtraction();
			} else {
				throw new IllegalArgumentException(
						"Symbol not understood. Must be number or operator.");
			}
		}
	}

	private void performSubtraction() {
		if (this.myStack.size() < 2) {
			throw new IllegalStateException(
					"There must be at least 2 elements in the stack to perform a substraction.");
		}

		double second = this.myStack.pop();
		double first = this.myStack.pop();

		this.myStack.push(first - second);
	}

	private void performAddition() {
		if (this.myStack.size() < 2) {
			throw new IllegalStateException(
					"There must be at least 2 elements in the stack to perform an addition.");
		}

		double second = this.myStack.pop();
		double first = this.myStack.pop();

		this.myStack.push(first + second);
	}

	private void performDivision() {
		if (this.myStack.size() < 2) {
			throw new IllegalStateException(
					"There must be at least 2 elements in the stack to perform a division.");
		}

		double second = this.myStack.pop();
		double first = this.myStack.pop();
		
		if (second == 0.0) {
			throw new IllegalStateException("Value in stack is zero. Cannot divide by zero.");
		}

		this.myStack.push(first / second);
	}

	private void performMultiplication() {
		if (this.myStack.size() < 2) {
			throw new IllegalStateException(
					"There must be at least 2 elements in the stack to perform a multiplication.");
		}

		double second = this.myStack.pop();
		double first = this.myStack.pop();

		this.myStack.push(first * second);
	}

	public void loadExpression(String expression) {
        for (String symbol : expression.split(" ")) {
        	this.addSymbol(symbol);
        }
	}
	
	public double getResult() {
		if (this.myStack.size() != 1) {
			throw new IllegalStateException("There must be exactly one element on the stack.");
		}
		
		return this.myStack.pop();
	}
}
