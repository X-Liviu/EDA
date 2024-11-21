package a_listas.EjercicioExamen_parcial1_2023_24;

public class DoubleLinkedList {
	DoubleNode first;
	
	public DoubleLinkedList() {
		this.first = null;
	}
	public void obtenerLista(ListaDePersonas l) {
		//DoubleLinkedList resultado = new DoubleLinkedList();
		DoubleNode ult = null; 
		for (int i = 0; i < l.personas.length; i++) {
			String persona = l.personas[i];
			DoubleNode nuevo = new DoubleNode(persona);
			if (this.first == null) {
				this.first = nuevo;
				ult = nuevo;
			}
			else {
				ult.next = nuevo;
				nuevo.prev = ult;
				ult = nuevo;
			}
		}
		// me falta hacer el bucle para las listas de alimentos
	}
}
