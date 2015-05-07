package edu.westga.dsdm.tests.nonlinear;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.westga.dsdm.linear.ArrayList;
import edu.westga.dsdm.linear.Queue;
import edu.westga.dsdm.nonlinear.BinarySearchTree;
import edu.westga.dsdm.nonlinear.BinaryTree;

public class BinaryTreeTest {

	@Test
	public final void PreOrderTraversalOf_1ListShouldBeSorted() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.add(1);

		BinarySearchTree<Integer> factory = new BinarySearchTree<Integer>();
		factory.insert(arrayList);
		BinaryTree<Integer> arrayTree = factory.getTree();
		Queue<Integer> q = new Queue<Integer>();

		arrayTree.inorder(q);

		System.out.println("====");
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int x = q.dequeue();
			System.out.println(x);
			q.enqueue(x);
		}
		
		System.out.println("====");
		factory.getTree().printTree();

		assertEquals(1, (int) q.dequeue());
	}

	@Test
	public final void PreOrderTraversalOf_1_2ListShouldBeSorted() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.add(1);
		arrayList.add(2);

		BinarySearchTree<Integer> factory = new BinarySearchTree<Integer>();
		factory.insert(arrayList);
		BinaryTree<Integer> arrayTree = factory.getTree();
		Queue<Integer> q = new Queue<Integer>();

		arrayTree.inorder(q);

		System.out.println("====");
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int x = q.dequeue();
			System.out.println(x);
			q.enqueue(x);
		}
		
		System.out.println("====");
		factory.getTree().printTree();

		assertEquals(1, (int) arrayTree.getValue());

		assertEquals(1, (int) q.dequeue());
		assertEquals(2, (int) q.dequeue());
	}
	
	@Test
	public final void PreOrderTraversalOf8_6_7ListShouldBeSorted() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.add(8);
		arrayList.add(6);
		arrayList.add(7);

		BinarySearchTree<Integer> factory = new BinarySearchTree<Integer>();
		factory.insert(arrayList);
		BinaryTree<Integer> myTree = factory.getTree();
		Queue<Integer> q = new Queue<Integer>();

		myTree.inorder(q);

		System.out.println("====");
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int x = q.dequeue();
			System.out.println(x);
			q.enqueue(x);
		}
		
		System.out.println("----");
		factory.getTree().printTree();
		
		assertEquals(7, (int) myTree.getValue());
		assertEquals(8, (int) myTree.getRight().getValue());
		assertEquals(6, (int) myTree.getLeft().getValue());

		assertEquals(6, (int) q.dequeue());
		assertEquals(7, (int) q.dequeue());
		assertEquals(8, (int) q.dequeue());
	}

	@Test
	public final void PreOrderTraversalOfJennyListShouldBeSorted() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.add(8);
		arrayList.add(6);
		arrayList.add(7);
		arrayList.add(5);
		arrayList.add(3);
		arrayList.add(0);
		arrayList.add(9);

		BinarySearchTree<Integer> factory = new BinarySearchTree<Integer>();
		factory.insert(arrayList);
		BinaryTree<Integer> myTree = factory.getTree();
		Queue<Integer> q = new Queue<Integer>();

		myTree.inorder(q);

		System.out.println("====");
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int x = q.dequeue();
			System.out.println(x);
			q.enqueue(x);
		}
		
		System.out.println("----");
		factory.getTree().printTree();

		assertEquals(8, (int) myTree.getValue());
		assertEquals(9, (int) myTree.getRight().getValue());
		assertEquals(6, (int) myTree.getLeft().getValue());

		assertEquals(0, (int) q.dequeue());
		assertEquals(3, (int) q.dequeue());
		assertEquals(5, (int) q.dequeue());
		assertEquals(6, (int) q.dequeue());
		assertEquals(7, (int) q.dequeue());
		assertEquals(8, (int) q.dequeue());
		assertEquals(9, (int) q.dequeue());
	}
	
	@Test
	public final void PreOrderTraversalOfOrderedListShouldBeSorted() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for (int i = 0; i < 4; i++) {
			arrayList.add(i);
		}

		BinarySearchTree<Integer> factory = new BinarySearchTree<Integer>();
		factory.insert(arrayList);
		BinaryTree<Integer> myTree = factory.getTree();
		Queue<Integer> q = new Queue<Integer>();

		myTree.inorder(q);

		System.out.println("==== ORDERED");
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int x = q.dequeue();
			System.out.println(x);
			q.enqueue(x);
		}
		
		System.out.println("----");
		factory.getTree().printTree();

	}
}
