package edu.westga.dsdm.nonlinear;

import edu.westga.dsdm.linear.DoubleLinkedList;

public class TreeNode<T> {
	private T value;
	private DoubleLinkedList<TreeNode<T>> nodes;

	public TreeNode(T value) {
		this.value = value;
		this.nodes = new DoubleLinkedList< TreeNode<T> >();
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public TreeNode<T> getNode(int i) {
		return this.nodes.get(i);
	}
	
	public void addNode(TreeNode<T> aNode) {
		this.nodes.add(aNode);
	}
	
	public TreeNode<T> removeNode(int i) {
		return this.nodes.remove(i);
	}
}
