package b_c_pilasYColas.EjercicioJuegoDeColores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Juego {
	Queue<Integer>[] jugadores = (Queue<Integer>[]) new LinkedList[6];
	Stack<Integer> mesa = new Stack<Integer>();

	public int juego(int n, ArrayList<Tirada> tiradas) {
		// pre: n es el número de fichas inicial de cada jugador
		// “tiradas” tiene los valores de los dados durante una partida
		// post: el resultado es el número del jugador ganador

		for (int i = 0; i < jugadores.length; i++) { //inicializar las fichas
			jugadores[i] = new LinkedList<Integer>();
			for (int j = 0; j < n; j++) {
				jugadores[i].add(i);
			}
		}

		Iterator<Tirada> itr = tiradas.iterator();
		Tirada tiradaActual = null;
		boolean acabar = false;

		while (itr.hasNext() && !acabar) {
			tiradaActual = itr.next();
			this.print();
			if (tiradaActual.dado1 == 6) {
				acabar = true;
			}
			else if (tiradaActual.dado1 % 2 == 0) {
				if (!jugadores[tiradaActual.dado2 - 1].isEmpty()) {
					int fichaActual = jugadores[tiradaActual.dado2 - 1].remove();
					mesa.push(fichaActual);
				}
			}
			else {
				if (!mesa.isEmpty()) {
					int fichaActual = mesa.pop();
					jugadores[tiradaActual.dado2 - 1].add(fichaActual);
				}
			}
		}

		int maxPuntos = 0;
		int maxActual;
		int jugadorGanador = 0;

		if (acabar || !itr.hasNext()) {
			for (int i = 1; i < jugadores.length; i++) {
				Queue<Integer> jugadorActual = jugadores[i];
				maxActual = 0;

				while (!jugadorActual.isEmpty()) {
					int fichaActual = jugadorActual.remove();

					if (fichaActual == 0) {
						maxActual++;
					}
				}
				if (maxActual >= maxPuntos) {
					maxPuntos = maxActual;
					jugadorGanador = i;
				}
			}
		}
		return jugadorGanador;
	}

	private void print() {
	    for (int i = 0; i < jugadores.length; i++) {
	        StringBuilder s = new StringBuilder("<");
	        for (Integer ficha : jugadores[i]) { // Iteramos sin eliminar
	            s.append(" ").append(ficha);
	        }
	        s.append(">");
	        System.out.println(i + ": " + s);
	    }
	    StringBuilder s = new StringBuilder("<");
	    for (Integer ficha : mesa) { // Iteramos la pila sin eliminar
	        s.append(" ").append(ficha);
	    }
	    s.append(">");
	    System.out.println("Mesa: " + s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Tirada> a = new ArrayList<Tirada>();
		a.add(new Tirada(2, 3));
		a.add(new Tirada(4, 1));
		a.add(new Tirada(3, 5));
		a.add(new Tirada(6, 3));

		Juego miJuego = new Juego();
		int ganador = miJuego.juego(5, a);
		System.out.println(ganador);

	}
}
