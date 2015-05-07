package edu.westga.dsdm.sorting;

import edu.westga.dsdm.linear.ArrayList;
import edu.westga.dsdm.linear.Queue;
import edu.westga.dsdm.nonlinear.BinarySearchTree;
import edu.westga.dsdm.nonlinear.BinaryTree;


public class BinarySearchTreeSort implements Sort {

	public void sort(double[] values) {
		ArrayList<Double> myList = new ArrayList<Double>();
		
		for (double value : values) {
			myList.add(value);
		}
		
		// Add Values to Binary Factory
		BinarySearchTree<Double> bstf = new BinarySearchTree<Double>();
		
		bstf.insert(myList);
		
		// Get Binary Tree From Factory
		BinaryTree<Double> tree = bstf.getTree();
		
		// Declare q for values
		Queue<Double> q = new Queue<Double>();
		
		// Add values from tree to q
		tree.inorder(q);
		
		// Drop q back to list
		for (int i = 0; i < values.length; i++) {
			values[i] = q.dequeue();
		}
	}
}
