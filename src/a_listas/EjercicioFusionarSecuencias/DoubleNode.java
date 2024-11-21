package a_listas.EjercicioFusionarSecuencias;

public class DoubleNode<T> {
	T data;
	DoubleNode<T> prev;
	DoubleNode<T> next;
	
	public DoubleNode(T pData) {
		this.data = pData;
	}
}
