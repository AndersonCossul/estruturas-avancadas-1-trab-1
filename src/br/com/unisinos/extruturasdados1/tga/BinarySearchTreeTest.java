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
		
//		System.out.println("Count nodes: " + bst.countNodes());
//		System.out.println("Count internal nodes: " + bst.countInternalNodes());
//		System.out.println("countLeaves: " + bst.countLeaves());
//		System.out.println("degree: " + bst.degree(4));
//		System.out.println("degreeTree: " + bst.degreeTree());
//		System.out.println(bst.toString());
//		System.out.println("depth: " + bst.depth(-2));
//		System.out.println("height: " + bst.height(4));
//		System.out.println("heightTree: " + bst.heightTree());
//		System.out.println("ancestors: " + bst.ancestors(0));
//		System.out.println("descendents: " + bst.descendents(4));
	}
}
