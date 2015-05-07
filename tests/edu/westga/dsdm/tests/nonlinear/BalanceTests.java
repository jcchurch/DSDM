package edu.westga.dsdm.tests.nonlinear;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.westga.dsdm.linear.ArrayList;
import edu.westga.dsdm.nonlinear.BinarySearchTree;
import edu.westga.dsdm.nonlinear.BinaryTree;

public class BalanceTests {
	
	@Test
	public final void BalanceFactorOfJennyListShouldBeMinus3() {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		
		myList.add(8);
		myList.add(6);
		myList.add(7);
		myList.add(5);
		myList.add(3);
		myList.add(0);
		myList.add(9);

		BinarySearchTree<Integer> factory = new BinarySearchTree<Integer>();
		factory.insert(myList);
		BinaryTree<Integer> myTree = factory.getTree();
		
		assertEquals(-3 , myTree.balanceFactor());
	}
	
	@Test
	public final void BalanceFactorOf62705943ListShouldBeMinus2() {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		
		myList.add(6);
		myList.add(2);
		myList.add(7);
		myList.add(0);
		myList.add(5);
		myList.add(9);
		myList.add(4);
		myList.add(3);

		BinarySearchTree<Integer> factory = new BinarySearchTree<Integer>();
		factory.insert(myList);
		BinaryTree<Integer> myTree = factory.getTree();
		
		assertEquals(-2 , myTree.balanceFactor());
	}
}
