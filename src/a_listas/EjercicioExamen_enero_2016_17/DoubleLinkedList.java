package a_listas.EjercicioExamen_enero_2016_17;

public class DoubleLinkedList<T> {
	DoubleNode<T> first;

	public void borrarLista(DoubleLinkedList<T> subLista) {
		// Precondición: “subLista” es una parte de la lista
		// los elementos de “subLista” están en el mismo orden que en la lista principal
		// Postcondición: se han quitado los elementos de “subLista”

		DoubleNode<T> actL1 = subLista.first;
		DoubleNode<T> actL2 = this.first.next;
		DoubleNode<T> antL2 = this.first;
		boolean terminado = false;
		
		if (antL2.data.equals(actL1.data)) {
			while (!terminado) { //bucle si en la lista la sublista empieza con el primero
				
				this.first = actL2;
				actL2.prev = antL2.prev;
				actL2.prev.next = actL2;
				antL2 = actL2;
				actL2 = actL2.next;

				if (actL1.next == subLista.first) {
					terminado = true;
				} 
				else {
					actL1 = actL1.next;
				}
			}
		} 
		else {
			while (!terminado) {
				if (actL2.data.equals(actL1.data)) {
					
					antL2.next = actL2.next;
					actL2.next.prev = antL2;
					
					actL2 = actL2.next;
					actL1 = actL1.next;
					
					if (this.first == actL2 && actL2.data.equals(actL1.data)) {
						this.first = this.first.next;
					}
				}
				else {
					antL2 = actL2;
					actL2 = actL2.next;
				}
				
				if (actL1 == subLista.first) {
					terminado = true;
				}
			}
		}
	}
} 

