package treeDataStructure;
import java.util.*;
public class Tree<E> {
	Node<E> root;
	public Tree() {
		root = null;
	}
	
	
	public void addroot(Node<E> n) {
		if (root == null) {
			root = n;
		}
	}
	public Node<E> getRoot() {
		return root;
	}
	public void addLeft(Node<E> parent,  Node<E> child) {
		 if (parent.left != null)
		        throw new IllegalStateException("Left child already exists");
		parent.left = child;
		
	}
	
	public void addRight(Node<E> parent,  Node<E> child) {
		 if (parent.right!= null)
		        throw new IllegalStateException("right child already exists");
		parent.right = child;
		
	}
	
	public int height(Node<E> root){
		if (root == null) return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;	}
	
	
	public static <E> void printLevelOrder(Node<E> root) {
        if (root == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<E> current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }
	
}
