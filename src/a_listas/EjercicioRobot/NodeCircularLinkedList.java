package a_listas.EjercicioRobot;

public class NodeCircularLinkedList<T> {
	T data;
	NodeCircularLinkedList<T> next;
	
	public NodeCircularLinkedList(T pData) {
		this.data = pData;
	}
}
