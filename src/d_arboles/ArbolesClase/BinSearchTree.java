package d_arboles.ArbolesClase;

public class BinSearchTree<T> extends BinaryTree<T> {
	BinaryTreeNode<T> root;
	int count;

	public T find(T elem) {
		//Pre: elem tiene que ser una clase que tenga implementado la interfaz Comparable<T>
		return this.find(elem, root);
		//CASOS TRIVIALES:
		//if a es vacio -> null
		//if raiz(a) = elem -> raiz(a)

		//CASOS RECURSIVOS:
		//if no es un caso trivial
		//if elem < raiz(a) -> find(elem, a.izq)
		//else find (elem, a.der)
	}

	private T find(T elem, BinaryTreeNode<T> a) {
		if (a == null) return null;
		else {
			Comparable<T> comp = (Comparable<T>) elem;
			if (comp.compareTo(a.content) == 0) {
				return a.content;
			}
			else if (comp.compareTo(a.content) < 0) {
				return find(elem, a.left);
			}

			else {
				return find(elem, a.right);
			}
		}
	}
	
	public T findIte(T elem) {
		//Pre: elem tiene que ser una clase que tenga implementado la interfaz Comparable<T>
		
		BinaryTreeNode<T> act = root;
		Comparable<T> comp = (Comparable<T>) elem;
		boolean enc = false;
		
		while (!enc && act != null) {
			if (comp.compareTo(act.content) == 0) enc = true;
			else if (comp.compareTo(act.content) < 0) act = act.left;
			else act = act.right;
		}
		if (enc) return act.content;
		else return null;
	}
	
	public void addElem(T elem) {
		Comparable<T> comp = (Comparable<T>) elem;
		BinaryTreeNode<T> nuevo = new BinaryTreeNode<T>();
		
		
		if (root == null) root = nuevo;
		else {
			boolean added = false;
			BinaryTreeNode<T> act = root;
			
			while (!added) {
				if (comp.compareTo(act.content) < 0) {
					if (act.left == null) {
						act.left = nuevo;
						added = true;
					}
					else {
						act = act.left;
					}
				}
				else { // >=)
					if (act.right == null) {
						act.right = nuevo;
						added = true;
					}
					else {
						act = act.right;
					}
				}
			}
		}
		count++;
		//Coste: O(log n)
	}
	
	public T findMin() {
		//Pre: al menos 1 elemento en el árbol
		BinaryTreeNode<T> act = root;
		while (act.left != null) {
			act = act.left;
		}
		return act.content;	
	}
	
}
