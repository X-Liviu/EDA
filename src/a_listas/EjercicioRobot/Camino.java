package a_listas.EjercicioRobot;
import java.util.ArrayList;
import java.util.Iterator;
public class Camino {
	Node first;
	public Camino() {
		this.first = null;
	}

	public CircularLinkedList<String> obtCoordenadas(ArrayList<String> acciones) {
		// pre: la lista acciones tiene al menos un elemento, e indica los
		// movimientos a realizar por el robot
		// El recorrido no produce error (nunca se intenta avanzar por un
		// enlace con valor null)
		// post: devuelve una nueva lista, que contendrá
		// las coordenadas de los puntos recorridos
		// La lista original no se ha modificado

		Iterator<String> itr = this.getIterator(acciones);
		String laAccion = null;
		Node act = this.first; //suponiendo que el camino siempre existe

		CircularLinkedList<String> resultado = new CircularLinkedList<String>();
		NodeCircularLinkedList<String> primero = new NodeCircularLinkedList<String>(this.first.coord);
		resultado.last = primero;

		if (this.first.next != null) {
			while (itr.hasNext()) {
				laAccion = itr.next();
				if(laAccion.equals("izquierda")) {
					act = act.left;
					NodeCircularLinkedList<String> nuevo = new NodeCircularLinkedList<String>(act.coord);
					resultado.last.next = nuevo;
					resultado.last = nuevo;
				} 
				else if (laAccion.equals("derecha") ) {
					act = act.right;
					NodeCircularLinkedList<String> nuevo = new NodeCircularLinkedList<String>(act.coord);
					resultado.last.next = nuevo;
					resultado.last = nuevo;
				}
				else if(laAccion.equals("adelante")) {
					act = act.next;
					NodeCircularLinkedList<String> nuevo = new NodeCircularLinkedList<String>(act.coord);
					resultado.last.next = nuevo;
					resultado.last = nuevo;
				}
			}
			resultado.last.next = primero;
			primero = null; //para que no se entienda como que se usa un first, aunque de todos modos no es lo mismo (es opcional en verdad)
		}

		return resultado;
	}
	
	private Iterator<String> getIterator(ArrayList<String> lista) {
		return lista.iterator();
	}
	
}
