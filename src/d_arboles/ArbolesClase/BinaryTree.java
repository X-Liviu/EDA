package d_arboles.ArbolesClase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
	public BinaryTreeNode<T> root;
	public int count;

	public BinaryTree() {
		root = null;
		count = 0;
	}

	public T find(T elem) {
		return this.find(elem, root);
	}

	private T find(T elem, BinaryTreeNode<T> a) { //Sin usar el count
		if (a == null) {
			return null;
		}
		else if (a.content.equals(elem)) {
			return a.content;
		}
		else {
			T aux = find(elem, a.left);
			if (aux != null) {
				return aux;
			}
			else {
				return find (elem, a.right);
			}
		}
	}

	public Iterator<T> iteradorPostOrden() {
		ArrayList<T> tempList = new ArrayList<T>();
		preOrden(root, tempList);
		return tempList.iterator();
	}

	private void preOrden(BinaryTreeNode<T> a, ArrayList<T> l) {
		if (a == null) {}
		else {
			l.add(a.content);
			preOrden(a.left, l);
			preOrden(a.right, l);
		}
	}

	private void inOrden(BinaryTreeNode<T> a, ArrayList<T> l) {
		if (a == null) {}
		else {
			preOrden(a.left, l);
			l.add(a.content);
			preOrden(a.right, l);
		}
	}

	private void postOrden(BinaryTreeNode<T> a, ArrayList<T> l) {
		if (a == null) {}
		else {
			preOrden(a.left, l);
			preOrden(a.right, l);
			l.add(a.content);
		}
	}

	private Iterator<T> porNiveles() {
		ArrayList<T> resultado = new ArrayList<T>();
		if (root == null) {} 
		else {
			Queue<BinaryTreeNode<T>> porEx = new LinkedList<BinaryTreeNode<T>>();
			porEx.add(root);
			
			while (!porEx.isEmpty()) {
	            BinaryTreeNode<T> act = porEx.peek();
	            resultado.add(act.content);

	            if (act.left != null) {
	                porEx.add(act.left);
	            }
	            if (act.right != null) {
	                porEx.add(act.right);
	            }
	            porEx.remove();
	        }
		}
		return resultado.iterator();
	}
}

