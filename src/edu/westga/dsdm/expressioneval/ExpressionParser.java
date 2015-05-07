package edu.westga.dsdm.expressioneval;

import edu.westga.dsdm.linear.ArrayList;
import edu.westga.dsdm.nonlinear.BinaryTree;
/*
public class ExpressionParser {
	private String expression;

	public ExpressionParser(String expression) {
		this.expression = expression;
	}

	private BinaryTree<String> parseValue(ArrayList<String> tokens) {

		String firstToken = tokens.removeFirst();

		try {
			double value = Double.parseDouble(firstToken);
			return new BinaryTree<String>(firstToken);
		} catch (NumberFormatException e) {
			if (firstToken.equals("(")) {
				BinaryTree<String> node = this.parseExpression(tokens);

				String afterToken = tokens.removeFirst();

				if (afterToken != ")") {
					throw new IllegalArgumentException(
							"No matching end parentheses to expression");
				}

				return node;
			} else {
				throw new IllegalArgumentException("Illegal Token: "
						+ firstToken);
			}
		}
	}

	private BinaryTree<String> parseExpression(ArrayList<String> tokens) {
		// TODO Auto-generated method stub
		return null;
	}

}
*/