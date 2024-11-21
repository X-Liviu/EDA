package practicas.Practica2;

import java.util.Iterator;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> first;  // apuntador al primero
	protected Node<T> last;  // apuntador al último
	protected String descr;  // descripción
	protected int count;

	// Constructor
	public DoubleLinkedList() {
		first = null;
		last = null;
		descr = "";
		count = 0;
	}

	public void setDescr(String nom) {
		descr = nom;
	}

	public String getDescr() {
		return descr;
	}

	public T removeFirst() {
		T d = null;

		if (this.isEmpty()) {}
		else if (this.first.next == null) {
			d = this.first.data;
			this.first = null;
			this.last = null;
			this.count--;
		}
		else {
			d = this.first.data;
			this.first = this.first.next;
			this.first.prev = null;
			this.count--;
		}
		return d;
	}

	public T removeLast() {
		T d = null;

		if (this.isEmpty()) {}
		else if (this.last.prev == null) {
			d = this.last.data;
			this.last = null;
			this.first = null;
			this.count--;
		}
		else {
			d = this.last.data;
			this.last = this.last.prev;
			this.last.next = null;
			this.count--;
		}
		return d;
	}

	public T remove(T elem) {
		Node<T> actual;
		Node<T> anterior;
		boolean enc = false;
		T d = null;

		if (this.isEmpty()) {}
		else if (this.first.data.equals(elem)) {
			d = this.removeFirst();
			enc = true; 
		}
		else {
			actual = this.first;
			anterior = null;

			while (actual.next != null && !enc) {
				if (actual.data.equals(elem)) {
					d = actual.data;
					anterior.next = actual.next;
					actual.next.prev = anterior;
					actual = actual.next;
					enc = true;
					this.count--;
				}
				else {
					anterior = actual;
					actual = actual.next;
				}
			}
			if (actual.data.equals(elem)) {
				this.removeLast();
				enc = true;
			}
		}
		return d;
	}

	public void removeAll(T elem) {
		Node<T> act;
		Node<T> ant;

		if (this.isEmpty()) {}
		else {
			act = this.first;
			ant = this.first;

			while(act.next != null) {
				if (act.data.equals(elem)) {
					if (this.first.equals(act)) {
						this.removeFirst();
						act = this.first;
					} else {
						ant.next = act.next;
						act.next.prev = ant; 
						act = act.next;
						this.count = this.count - 1;
					}
				} 
				else {
					ant = act;
					act = act.next;
				}
			}
			if (act.data.equals(elem)) {
				this.removeLast();
			}
		}
	}

	public T first() {
		//Da acceso al primer elemento de la lista
		if (isEmpty()) {
			return null;
		}
		else {
			return first.data;
		}
	}
	protected DoubleLinkedList<T> createList() {
		return new DoubleLinkedList<T>();
	}


	public DoubleLinkedList<T> clone() {
		DoubleLinkedList<T> resultado = createList();
		Node<T> act = this.first;
		Node<T> ult = null;

		if (this.isEmpty()) {}
		else {
			while (act != null) {
				Node<T> nuevo = new Node<T>(act.data);
				if (resultado.isEmpty()) {
					resultado.first = nuevo;
					resultado.last = nuevo;
					ult = resultado.first;
				} 
				else {
					ult.next = nuevo;
					nuevo.prev = ult;
					ult = ult.next;
				}
				act = act.next;
			}	
		}		
		return resultado;
	}

	public T last() {
		if(this.isEmpty()) {
			return null;
		}
		return last.data;
	}

	public boolean contains(T elem) {
		boolean enc = false;

		if (this.find(elem) != null) {
			enc = true;
		}
		return enc;
	}

	public T find(T elem) {
		T d = null;
		Node<T> actual;
		boolean enc = false;

		if(this.isEmpty()) {
			return null;
		}
		else {
			actual = this.first;
			while (actual != null & !enc) {
				if (actual.data.equals(elem)) {
					d = actual.data;
					enc = true;
				}
				else {
					actual = actual.next;
				}
			}
		}
		return d;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return count;
	}

	public Iterator<T> iterator() { 
		return new ListIterator(); 
	} 

	private class ListIterator implements Iterator<T> {
		
		private Node<T> actual = first;

		@Override
		public boolean hasNext() {
			return actual != null;
		}

		@Override
		public T next() {
			if (actual == null) {
				return null;
			} 
			else 
			{
				T aux = actual.data;
				actual = actual.next;
				return aux;
			}
		} 
	}

	public void visualizarNodos() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		String result = new String();
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			T elem = it.next();
			result = result + "(" + elem.toString() + ")";
		}	
		return "DoubleLinkedList" + ":" + "[" + result + "]";
	}
}
