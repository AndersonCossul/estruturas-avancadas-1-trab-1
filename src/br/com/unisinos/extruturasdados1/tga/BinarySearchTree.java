package br.com.unisinos.extruturasdados1.tga;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree<K extends Comparable<K>, V> implements BinarySearchTreeADT<K, V> {

	protected Node root;

	// Nested Class
	protected class Node {
		private K key;
		private V value;
		private Node left, right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public Node next(K other) {
			return other.compareTo(key) < 0 ? left : right;
		}

		public boolean isLeaf() {
			return left == null && right == null;
		}

		@Override
		public String toString() {
			return "" + key;
		}
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public V search(K key) {
		return search(root, key);
	}

	private V search(Node node, K key) {
		if (node == null) {
			return null;
		} else if (key.compareTo(node.key) == 0) {
			return node.value;
		}
		return search(node.next(key), key);
	}

	@Override
	public void insert(K key, V value) {
		root = insert(root, key, value);
	}

	private Node insert(Node node, K key, V value) {
		if (node == null) {
			return new Node(key, value);
		} else if (key.compareTo(node.key) > 0) {
			node.right = insert(node.right, key, value);
		} else if (key.compareTo(node.key) < 0) {
			node.left = insert(node.left, key, value);
		}

		return node;
	}

	@Override
	public String toString() {
		return root == null ? "[empty]" : printTree(new StringBuffer());
	}

	private String printTree(StringBuffer sb) {
		if (root.right != null) {
			printTree(root.right, true, sb, "");
		}
		sb.append(root + "\n");
		if (root.left != null) {
			printTree(root.left, false, sb, "");
		}

		return sb.toString();
	}

	private void printTree(Node node, boolean isRight, StringBuffer sb, String indent) {
		if (node.right != null) {
			printTree(node.right, true, sb, indent + (isRight ? "        " : " |      "));
		}
		sb.append(indent + (isRight ? " /" : " \\") + "----- " + node + "\n");
		if (node.left != null) {
			printTree(node.left, false, sb, indent + (isRight ? " |      " : "        "));
		}
	}

	@Override
	public boolean delete(K key) {
		return deleteByCopying(key);
		// return deleteByMerging(key);
	}

	private boolean deleteByCopying(K key) {
		Node parent = null, current = root;
		for (; current != null && key.compareTo(current.key) != 0; parent = current, current = current.next(key))
			;

		if (current == null)
			return false;
		else if (current.left != null && current.right != null) {
			// Caso 3
			Node tmp = current.left;
			while (tmp.right != null)
				tmp = tmp.right;
			deleteByCopying(tmp.key);
			current.key = tmp.key;
		} else {
			// Caso 1 ou Caso 2
			Node nextNode = current.right == null ? current.left : current.right;
			if (current.equals(root))
				root = nextNode;
			else if (parent.left.equals(current))
				parent.left = nextNode;
			else
				parent.right = nextNode;
		}

		return true;
	}

	private boolean deleteByMerging(K key) {
		Node parent = null, current = root;
		for (; current != null && key.compareTo(current.key) != 0; parent = current, current = current.next(key))
			;

		if (current == null)
			return false;
		else if (current.left != null && current.right != null) {
			// Caso 3
			Node tmp = current.left;
			while (tmp.right != null)
				tmp = tmp.right;
			tmp.right = current.right;

			if (current.equals(root))
				root = current.left;
			else if (parent.left.equals(current))
				parent.left = current.left;
			else
				parent.right = current.left;
		} else {
			// Caso 1 ou Caso 2
			Node nextNode = current.right == null ? current.left : current.right;
			if (current.equals(root))
				root = nextNode;
			else if (parent.left.equals(current))
				parent.left = nextNode;
			else
				parent.right = nextNode;
		}

		return true;
	}

	@Override
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node != null) {
			System.out.print(node + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	@Override
	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node + " ");
			inOrder(node.right);
		}
	}

	@Override
	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node + " ");
		}
	}

	@Override
	public void levelOrder() {
		levelOrder(root);
	}

	private void levelOrder(Node node) {
		if (node != null) {
			Queue<Node> fila = new ArrayDeque<>();
			fila.add(node);
			while (!fila.isEmpty()) {
				Node current = fila.remove();
				System.out.print(current + " ");
				if (current.left != null)
					fila.add(current.left);
				if (current.right != null)
					fila.add(current.right);
			}
		}
	}
	

	/**A PARTIR DAQUI, ESTÃO OS MÉTODOS QUE PRECISAM SER IMPLEMENTADOS!!! **/
	@Override
	public int countNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countInternalNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countLeaves() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int degree(K key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int degreeTree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height(K key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int heightTree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int depth(K key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String ancestors(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String descendents(K key) {
		// TODO Auto-generated method stub
		return null;
	}

}
