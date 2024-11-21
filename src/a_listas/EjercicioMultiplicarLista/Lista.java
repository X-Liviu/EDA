package a_listas.EjercicioMultiplicarLista;

public class Lista <T> {
	Node<T> first;
	
	public Lista() {
		
	}
	
	public void insertLast(T elem) {
		Node<T> nuevo = new Node<T>(elem);
		
		if (first == null) {
			first = nuevo;
			nuevo.next = nuevo;
			nuevo.prev = nuevo;
		}
		else {
			Node<T> ult = first.prev;
			nuevo.next = first;
			ult.next = nuevo;
			first.prev = nuevo;
			nuevo.prev = ult;
			ult = nuevo;
		}
	}
	
	public void multiplicar(Integer n) {
	
		if (n == 1 || this.first == null) {}
		
		else if (this.first == this.first.next) {
			Node<T> act = this.first;
			Node<T> sig = this.first.next; 
			boolean realizado = false;
			while (!realizado) {
				int cont = 0;
				while (cont < n - 1) {
					Node<T> nuevo = new Node<>(act.data);
					nuevo.prev = act;
					act.next = nuevo;
					act = act.next;
					nuevo = null; //no sé si hace falta esto
					cont++;
				}
				act.next = sig;
				sig.prev = act;

				realizado = true;
			}
		}
		else {
			Node<T> act = this.first;
			Node<T> sig = this.first.next; 
			while (sig != this.first) {

				int cont = 0;
				while (cont < n - 1) {
					Node<T> nuevo = new Node<>(act.data);
					nuevo.prev = act;
					act.next = nuevo;
					act = act.next;
					
					cont++;
				}
				act.next = sig;
				sig.prev = act;

				act = sig;
				sig = sig.next;
			}
			//faltaba esto, ya que el ultimo elemento no entra en el bucle grande para que se multiplique. Esto ya lo sabía en su momento cuando hice el programa
			// pero la verdad es que no me puse a pensar cual era la condicion perfecta del bucle
			int cont = 0;
			while (cont < n - 1) {
				Node<T> nuevo = new Node<>(act.data);
				nuevo.prev = act;
				act.next = nuevo;
				act = act.next;
				
				cont++;
			}
			act.next = sig;
			sig.prev = act;
		}
	}
	
	public void print() {
		if (first == null) {
		} else {
			Node<T> act = first;
			System.out.print(act.data.toString() + " ");
			act = act.next;
			while (act != this.first) {
				System.out.print(act.data.toString() + " ");
				act = act.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// Caso 1: x2
	
		Lista<Integer> l = new Lista<Integer>();
		l.insertLast(1);
		l.insertLast(2);
		l.insertLast(3);
		l.insertLast(4);
		
		System.out.println("================================================================");
		System.out.println("Caso 1: multiplicar por 2");
		System.out.println("================================================================");
		l.print();
		l.multiplicar(2);
		l.print();
		

	}
}
