package practicas.Practica2;

public class PruebaDoubleLinkedList {


	public static void main(String[] args)  {
		//Métodos de la clase UnorderedDoubleLinkedList
		UnorderedDoubleLinkedList<Integer> l = new UnorderedDoubleLinkedList<Integer>();

		System.out.println("Primero se hacen las pruebas de los métodos de la clase DoubleLinkedList.");
		System.out.println();

		//Prueba de set y de get
		System.out.println("Prueba de los métodos get() y set(): ");
		l.setDescr("Mi lista favorita");
		System.out.println("Tiene que poner: 'Mi lista favorita' y pone: " + l.getDescr());
		System.out.println();

		System.out.println("----------------");
		System.out.println();

		//Prueba de removeFirst
		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Prueba del método removeFirst(): ");
		System.out.println();
		System.out.println("Caso 1: único elemento. Añadimos primero un elemento");
		l.addToFront(5);
		l.visualizarNodos();
		System.out.println("Lo eliminamos");
		l.removeFirst();
		l.visualizarNodos();
		System.out.println();

		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Caso 2: varios elementos. Añadimos elementos");
		l.addToRear(6);
		l.addToRear(7);
		l.addToRear(8);
		l.addToRear(9);
		l.visualizarNodos();
		System.out.println("Eliminamos el primero. Tiene que ser 7 8 9 y es: ");
		l.removeFirst();
		l.visualizarNodos();
		System.out.println();

		System.out.println("----------------");
		System.out.println();

		//Prueba de removeLast
		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Prueba del método removeLast(): ");
		System.out.println();
		System.out.println("Caso 1: único elemento. Añadimos primero un elemento");
		l.addToRear(5);
		l.visualizarNodos();
		System.out.println("Lo eliminamos");
		l.removeLast();
		l.visualizarNodos();
		System.out.println();

		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Caso 2: varios elementos. Añadimos elementos");
		l.addToRear(6);
		l.addToRear(7);
		l.addToRear(8);
		l.addToRear(9);
		l.visualizarNodos();
		System.out.println("Eliminamos el último. Tiene que ser 6 7 8 y es: ");
		l.removeLast();
		l.visualizarNodos();
		System.out.println();

		System.out.println("----------------");
		System.out.println();

		//Prueba de remove
		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Prueba del método remove(): ");
		System.out.println();
		System.out.println("Caso 1: único elemento. Ese elemento sí que hay que eliminarlo. Añadimos primero un elemento");
		l.addToRear(5);
		l.visualizarNodos();
		System.out.println("Se elimina el 5");
		l.remove(5);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 2: único elemento. Ese elemento no que hay que eliminarlo. Añadimos primero un elemento");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.visualizarNodos();
		System.out.println("Se intenta eliminar el 2. No se elimina ninguno");
		l.remove(2);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 3: varios elementos. El elemento a eliminar está en medio. Añadimos elementos");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("Se elimina el 13");
		l.remove(13);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 4: varios elementos. El elemento a eliminar está al final. Añadimos elementos");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("Se elimina el 14");
		l.remove(14);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 5: varios elementos. El elemento a eliminar está al principio. Añadimos elementos");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("Se elimina el 5");
		l.remove(5);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 6: varios elementos. Hay elementos repetidos, que es el que queremos borrar. Añadimos elementos");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(5);
		l.addToRear(6);
		l.addToRear(9);
		l.visualizarNodos();
		System.out.println("Se elimina la primera aparición de 5");
		l.remove(5);
		l.visualizarNodos();
		System.out.println();

		System.out.println("----------------");
		System.out.println();

		//Prueba de removeAll
		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Prueba del método removeAll(): ");
		System.out.println();
		System.out.println("Caso 1: único elemento. Ese elemento sí que hay que eliminarlo. Añadimos primero un elemento");
		l.addToRear(5);
		l.visualizarNodos();
		System.out.println("Se eliminan todas las apariciones de 5");
		l.removeAll(5);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 2: único elemento. Ese elemento no que hay que eliminarlo. Añadimos primero un elemento");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.visualizarNodos();
		System.out.println("Se intenta eliminar el 2. No se elimina ninguno.");
		l.removeAll(2);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 3: varios elementos. El elemento a eliminar es el 12. Añadimos elementos");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("Se eliminan todas las apariciones de 12");
		l.removeAll(12);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 4: varios elementos. El elemento a eliminar es el 14. Añadimos elementos");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("Se eliminan todas las apariciones de 14");
		l.removeAll(14);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 5: varios elementos. El elemento a eliminar está al principio. Añadimos elementos");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("Se eliminan todas las apariciones de 5");
		l.removeAll(5);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 6: varios elementos. Hay elementos repetidos, que es el que queremos borrar. Añadimos elementos");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(5);
		l.addToRear(6);
		l.addToRear(9);
		l.visualizarNodos();
		System.out.println("Se eliminan todas la apariciones de 5");
		l.removeAll(5);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 7: varios elementos. Todos los elementos son repetidos y son los que queremos borrar");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(5);
		l.addToRear(5);
		l.addToRear(5);
		l.visualizarNodos();
		System.out.println("Se eliminan todas la apariciones de 5");
		l.removeAll(5);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 8: varios elementos. Todos los elementos son repetidos y pero ninguno de ellos son los que se quieren borrar");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(5);
		l.addToRear(5);
		l.addToRear(5);
		l.visualizarNodos();
		System.out.println("Se intenta eliminar todas las apariciones de 6");
		l.removeAll(6);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 9: varios elementos. El primer elemento es diferente del resto y el el resto son todos repetidos, los cuales se quieren borrar.");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(6);
		l.addToRear(5);
		l.addToRear(5);
		l.addToRear(5);
		l.visualizarNodos();
		System.out.println("Se eliminan todas las apariciones de 5");
		l.removeAll(5);
		l.visualizarNodos();
		System.out.println();

		System.out.println("----------------");
		System.out.println();

		//Prueba de first
		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Prueba del método first(): ");
		System.out.println();

		System.out.println("Caso 1: único elemento.");
		l.addToRear(5);
		l.visualizarNodos();
		System.out.println("El primero tiene que ser 5 y es: " + l.first());
		System.out.println();

		System.out.println("Caso 2: lista vacía");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.visualizarNodos();
		System.out.println("No hay primero. Será null y es: " + l.first());
		System.out.println();

		System.out.println("Caso 3: varios elementos.");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("El primero tiene que ser el 5 y es: " + l.first());
		System.out.println();

		System.out.println("----------------");
		System.out.println();

		//Prueba de last
		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Prueba del método last(): ");
		System.out.println();

		System.out.println("Caso 1: único elemento.");
		l.addToRear(5);
		l.visualizarNodos();
		System.out.println("El último tiene que ser 5 y es: " + l.last());
		System.out.println();

		System.out.println("Caso 2: lista vacía");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.visualizarNodos();
		System.out.println("No hay último. Será null y es: " + l.last());
		System.out.println();

		System.out.println("Caso 3: varios elementos.");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("El último tiene que ser el 14 y es: " + l.last());
		System.out.println();

		System.out.println("----------------");
		System.out.println();

		//Prueba de clone
		UnorderedDoubleLinkedList<Integer> l1 = new UnorderedDoubleLinkedList<Integer>();
		DoubleLinkedList<Integer> l2 = new DoubleLinkedList<Integer>();

		System.out.println("Prueba del método clone(): ");
		System.out.println();

		System.out.println("Caso 1: único elemento.");
		l1.addToRear(5);
		l1.visualizarNodos();
		System.out.println("Se creará una nueva lista con el elemento 5");
		l2 = l1.clone();
		l2.visualizarNodos();
		System.out.println();

		l1 = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Caso 2: lista vacía.");
		l1.visualizarNodos();
		System.out.println("Se creará una nueva lista que será vacía");
		l2 = l1.clone();
		l2.visualizarNodos();
		System.out.println();

		l1 = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Caso 3: lista con varios elementos.");
		l1.addToRear(5);
		l1.addToRear(6);
		l1.addToRear(7);
		l1.addToRear(8);
		l1.visualizarNodos();
		System.out.println("Se creará una nueva lista con los elementos 5, 6, 7 y 8");
		l2 = l1.clone();
		l2.visualizarNodos();
		System.out.println();

		System.out.println("----------------");
		System.out.println();

		//Prueba de contains
		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Prueba del método contains(): ");
		System.out.println();

		System.out.println("Caso 1: único elemento y esa lista sí que contiene ese elemento buscado.");
		l.addToRear(5);
		l.visualizarNodos();
		System.out.println("Buscamos el 5. Tiene que responder true y responde: " + l.contains(5));
		System.out.println();

		System.out.println("Caso 2: único elemento y esa lista no contiene ese elemento buscado");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(7);
		l.visualizarNodos();
		System.out.println("Buscamos el 5. Tiene que responder false y responde: " + l.contains(5));
		System.out.println();

		System.out.println("Caso 3: varios elementos y esa lista sí que contiene ese elemento buscado. El elemento buscado está por el medio");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("Buscamos el 12. Tiene que responder true y responde: " + l.contains(12));
		System.out.println();

		System.out.println("Caso 4: varios elementos y esa lista sí que contiene ese elemento buscado. El elemento buscado es el primero");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("Buscamos el 5. Tiene que responder true y responde: " + l.contains(5));
		System.out.println();

		System.out.println("Caso 5: varios elementos y esa lista sí que contiene ese elemento buscado. El elemento buscado es el último");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("Buscamos el 14. Tiene que responder true y responde: " + l.contains(14));
		System.out.println();

		System.out.println("----------------");
		System.out.println();

		//Prueba de find
		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Prueba del método find(): ");
		System.out.println();

		System.out.println("Caso 1: único elemento y esa lista sí que contiene ese elemento buscado.");
		l.addToRear(5);
		l.visualizarNodos();
		System.out.println("Buscamos el 5. Tiene que devolver 5 y devuelve: " + l.find(5));
		System.out.println();

		System.out.println("Caso 2: único elemento y esa lista no contiene ese elemento buscado");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(7);
		l.visualizarNodos();
		System.out.println("Buscamos el 5. Tiene que devolver null y devuelve: " + l.find(5));
		System.out.println();

		System.out.println("Caso 3: varios elementos y esa lista sí que contiene ese elemento buscado. El elemento buscado está por el medio");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("Buscamos el 12. Tiene que devolver 12 y devuelve: " + l.find(12));
		System.out.println();

		System.out.println("Caso 4: varios elementos y esa lista sí que contiene ese elemento buscado. El elemento buscado es el primero");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("Buscamos el 5. Tiene que devolver 5 y devuelve: " + l.find(5));
		System.out.println();

		System.out.println("Caso 5: varios elementos y esa lista sí que contiene ese elemento buscado. El elemento buscado es el último");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("Buscamos el 14. Tiene que devolver 14 y devuelve: " + l.find(14));
		System.out.println();

		System.out.println("----------------");
		System.out.println();

		//Prueba de isEmpty
		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Prueba del método isEmpty(): ");
		System.out.println();

		System.out.println("Caso 1: lista vacía.");
		System.out.println("Tiene que responder true y responde: " + l.isEmpty());
		System.out.println();

		System.out.println("Caso 2: lista con un elemento");
		l.addToRear(2);
		l.visualizarNodos();
		System.out.println("Tiene que responde false y responde: " + l.isEmpty());
		System.out.println();

		System.out.println("Caso 3: lista con varios elementos.");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("Tiene que responde false y responde: " + l.isEmpty());
		System.out.println();

		System.out.println("----------------");
		System.out.println();

		//Prueba de size
		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Prueba del método size(): ");
		System.out.println();

		System.out.println("Caso 1: lista vacía.");
		System.out.println("Tiene un total de: " + l.size() + " elementos");
		System.out.println();

		System.out.println("Caso 2: lista con un elemento");
		l.addToRear(2);
		l.visualizarNodos();
		System.out.println("Tiene un total de: " + l.size() + " elemento");
		System.out.println();

		System.out.println("Caso 3: lista con varios elementos.");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		l.visualizarNodos();
		System.out.println("Tiene un total de: " + l.size() + " elementos");
		System.out.println();

		System.out.println("----------------");
		System.out.println();

		//Prueba de toString
		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Prueba del método toString(): ");
		System.out.println();

		System.out.println("Caso 1: lista vacía.");
		System.out.println(l.toString());
		System.out.println();

		System.out.println("Caso 2: lista con un elemento. Se añade el 2");
		l.addToRear(2);
		System.out.println("Se tiene que ver el 2");
		System.out.println(l.toString());
		System.out.println();

		System.out.println("Caso 3: lista con varios elementos. Se añade el 5, 12, 13 y 14");
		l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(5);
		l.addToRear(12);
		l.addToRear(13);
		l.addToRear(14);
		System.out.println("Se tiene que ver el 5, 12, 13 y el 14");
		System.out.println(l.toString());
		System.out.println();

		System.out.println("----------------");
		System.out.println();


		//Prueba de iterator
		System.out.println("Prueba del método iterator(): ");
		System.out.println();

		System.out.println("Puesto que en todas las demás pruebas se utiliza el método visualizarNodos enseña por pantalla los elementos de la lista, este método está implementado con un iterator, con su next() y su hasNext()."); 
		System.out.println("Por tanto, está correcto ya que siempre imprime los elememntos de una manera correcta");

		System.out.println("----------------");
		System.out.println();


		System.out.println("Ahora se harán las pruebas de UnorderedDoubleLinkedList.");
		System.out.println();

		//Prueba de addToFront
		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Prueba del método addToFront(): ");
		System.out.println();
		System.out.println("Caso 1: lista vacía.");
		System.out.println("Se tiene que añadir el 5");
		l.addToFront(5);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 2: lista con un elemento.");
		System.out.println("Se tiene que añadir el 6 antes que el 5");
		l.addToFront(6);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 3: lista con varios elementos.");
		System.out.println("Se tiene que añadir el 7 antes que el 6");
		l.addToFront(7);
		l.visualizarNodos();
		System.out.println();

		System.out.println("----------------");
		System.out.println();

		//Prueba de addToRear
		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Prueba del método addToRear(): ");
		System.out.println();
		System.out.println("Caso 1: lista vacía.");
		System.out.println("Se tiene que añadir el 5");
		l.addToRear(5);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 2: lista con un elemento.");
		System.out.println("Se tiene que añadir el 6 después que el 5");
		l.addToRear(6);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 3: lista con varios elementos.");
		System.out.println("Se tiene que añadir el 7 después que el 6");
		l.addToRear(7);
		l.visualizarNodos();
		System.out.println();

		System.out.println("----------------");
		System.out.println();

		//Prueba de addAfter
		l = new UnorderedDoubleLinkedList<Integer>();
		System.out.println("Prueba del método addAfter(): ");
		System.out.println();

		System.out.println("Caso 1: lista con un elemento (ya que la precondición es que target ya se encuentra en la lista, esto implica que haya mínimo un elemento).");
		System.out.println("Queremos añadir el 6 después del 5");
		l.addToRear(5);
		l.visualizarNodos();
		System.out.println("Se añade el 6. La lista tiene que quedar 5 y 6");
		l.addAfter(6, 5);
		l.visualizarNodos();
		System.out.println();

		System.out.println("Caso 2: lista varios elementos.");
		System.out.println("Queremos añadir el 7 después del 5");
		l.visualizarNodos();
		System.out.println("Se añade el 7. La lista tiene que quedar 5, 7, y 6");
		l.addAfter(7, 5);
		l.visualizarNodos();
		System.out.println();
	}
}