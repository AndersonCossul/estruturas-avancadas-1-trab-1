package br.com.unisinos.extruturasdados1.tga;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		
		BinarySearchTreeADT<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		
		bst.insert(4, 4);
		bst.insert(2, 2);
		bst.insert(1, 1);
		bst.insert(3, 3);
		bst.insert(6, 6);
		bst.insert(5, 5);
		bst.insert(7, 7);
		
		System.out.println(bst.toString());
		
		System.out.println("Em pré-ordem:");
		bst.preOrder();
		System.out.println("\nEm pós-ordem:");
		bst.postOrder();
		System.out.println("\nEm ordem:");
		bst.inOrder();
		System.out.println("\nEm nível:");
		bst.levelOrder();
	}
}
