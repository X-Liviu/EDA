package a_listas.EjercicioMultiplicarLista;

public class Node<T> {
	T data;
	Node<T> next;
	Node<T> prev;
	
	public Node(T pData) {
		this.next = null;
		this.prev = null;
		this.data = pData;
	}
}
