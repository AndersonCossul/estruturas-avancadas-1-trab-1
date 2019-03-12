package br.com.unisinos.extruturasdados1.tga;

public interface BinarySearchTreeADT<K, V> {
	// Contratos implementados
	public void clear();
	public boolean isEmpty();
	public V search(K key);
	public void insert(K key, V value);
	public boolean delete(K key);
	public void preOrder();
	public void inOrder();
	public void postOrder();
	public void levelOrder();
	
	// Contratos não implementados
	public int countNodes();
	public int countInternalNodes();
	public int countLeaves();
	public int degree(K key);
	public int degreeTree();
	public int height(K key);
	public int heightTree();
	public int depth(K key);
	public String ancestors(K key);
	public String descendents(K key);
}
