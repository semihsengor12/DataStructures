package treeDataStructure;

public class Node<E> {
	E data;
	Node<E> left;
	Node<E> right;
	Node<E> parent;
	
	public Node(E data) {
		this.data = data;
		left = right = parent = null;
		
	}
	
	
}

