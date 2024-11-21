package a_listas.ListaEnlazadaClase;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void testReverseList() {
		LinkedList lista = new LinkedList();
		Persona p1 = new Persona("1", "null");
		Persona p2 = new Persona("2", "null");
		Persona p3 = new Persona("3", "null");
		Persona p4 = new Persona("4", "null");
		
		lista.insertarAlFinal(p1);
		lista.insertarAlFinal(p2);
		lista.insertarAlFinal(p3);
		lista.insertarAlFinal(p4);
		
		lista.reverseList2();
		lista.enseñarLista();
	}

}
