package a_listas.EjercicioListaSimetrica;

public class MiDoubleLinkedList {
	DoubleNode<Integer> first;

	public void obtenerListaSimetrica(SimpleLinkedList<Integer> l) {
		//Pre: la lista "l" contiene valores positivos distintos de cero (x, y, ... z)
		//Post: el resultado es una lista del tipo (-z, ... -y, -x, x ... y, z)
		// donde cada elemento x de la lista original aparece dos veces (-x, x) de manera
		// simétrica
		if (l.first == null) {}
		else {
			Node<Integer> actl1 = l.first;
			DoubleNode<Integer> antl2 = null;
			DoubleNode<Integer> ultl2 = null;

			DoubleNode<Integer> nuevo = new DoubleNode<Integer>(actl1.data);
			ultl2 = nuevo;
			DoubleNode<Integer> nuevo2 = new DoubleNode<Integer>((actl1.data) * -1);
			nuevo.prev = nuevo2;
			nuevo2.next = nuevo;
			antl2 = nuevo2;
			this.first = antl2;

			if (actl1.next != null) {
				actl1 = actl1.next;

				while (actl1 != null) {
					nuevo = new DoubleNode<Integer>(actl1.data);
					nuevo.prev = ultl2;
					ultl2.next = nuevo;
					ultl2 = nuevo;

					nuevo2 = new DoubleNode<Integer>((actl1.data) * -1);
					nuevo2.next = antl2;
					antl2.prev = nuevo2;
					antl2 = nuevo2;
					this.first = antl2;

					actl1 = actl1.next;		
				}
			}
			ultl2.next = this.first;
			this.first.prev = ultl2;
		}
	}

	public void print() {
		DoubleNode<Integer> act = this.first;
		System.out.print("[ ");
		if (act == null) {}
		else {
			System.out.print(act.data); // escribir el primero
			act = act.next;
			while (act != this.first) {
				System.out.print(", " + act.data);
				act = act.next;
			}
		}
		System.out.println(" ]");		
	}

	public static void main(String[] args) {
		MiDoubleLinkedList lista = new MiDoubleLinkedList();
		System.out.println("El resultado debería ser la lista vacía");
		SimpleLinkedList<Integer> listaSimple = new SimpleLinkedList<Integer>();
		listaSimple.first = null;
		lista.obtenerListaSimetrica(listaSimple);
		lista.print();
		
		//Prueba 2
		System.out.println("El resultado debería ser la lista [ -1, -4, -3, -8, 8, 3, 4, 1 ]: ");
		listaSimple = new SimpleLinkedList<Integer>();
		lista.obtenerListaSimetrica(listaSimple);
		lista.print();
	}

}
