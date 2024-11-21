package a_listas.EjercicioListasPares_Impares;

public class Node<T> {
	T data;
	Node<T> next;
	Node<T> prev;
	
	public Node(T pData) {
		this.data = pData;
	}
}
