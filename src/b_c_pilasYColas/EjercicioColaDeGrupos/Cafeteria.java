package b_c_pilasYColas.EjercicioColaDeGrupos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Cafeteria {
	Queue<Queue<Integer>> cola; // una cola de colas
	HashMap<Integer, Integer> teams;

	public Cafeteria() {
		cola = (Queue<Queue<Integer>>) new LinkedList();

		teams = new HashMap<Integer, Integer>();
		// Grupo A: 1, 5, 7
		// Grupo B: 2, 4, 8, 10
		// Grupo C: 3, 6, 11
		teams.put(1, 1);
		teams.put(5, 1);
		teams.put(7, 1);
		teams.put(2, 2);
		teams.put(4, 2);
		teams.put(8, 2);
		teams.put(10, 2);
		teams.put(3, 3);
		teams.put(6, 3);
		teams.put(11, 3);
	}
	public void insertar(Integer elem) {
		// Postcondición: se ha añadido “elem” en la cola de la cafetería
		Queue<Queue<Integer>> colaAux = new LinkedList<Queue<Integer>>();
		boolean enc = false;

		while (!cola.isEmpty()){
            Queue<Integer> colaPersonas = cola.remove();

            if (teams.get(colaPersonas.peek()) == teams.get(elem)) { // son del mismo grupo
                colaPersonas.add(elem); 
                enc = true;
            } // se añade al final de esa cola, porque se ha encontrado una persona de su grupo

            colaAux.add(colaPersonas);
        }
        if (!enc) { // la persona que entra no ha encontrado a nadie de su grupo. Se pone al final
            Queue<Integer> nuevaCola = new LinkedList<Integer>();
            nuevaCola.add(elem);
            colaAux.add(nuevaCola);
        }
        cola = colaAux;
        
    
	}
	public Integer borrar() {
		// Precondición: se tiene al menos un elemento en la cola
		// Postcondición: se ha eliminado el primer elemento de la cola y
		// se devuelve su valor
		return 0;
	}
	public boolean mismoGrupo(int p1, int p2) {
		// Postcondición: true si p1 y p2 pertenecen al mismo grupo y false si no
		// NO HAY QUE IMPLEMENTAR ESTE MÉTODO
		return true;
	}
} 
