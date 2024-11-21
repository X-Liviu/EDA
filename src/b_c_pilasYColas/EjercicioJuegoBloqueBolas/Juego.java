package b_c_pilasYColas.EjercicioJuegoBloqueBolas;

import java.util.Stack;

public class Juego {
	Stack<Bloque>[] tablero; // array de pilas
	public static int NUMCOLUMNAS = 7;
	public Juego() { // constructora
		tablero = (Stack<Bloque>[]) new Stack[NUMCOLUMNAS];
		for (int i = 0; i <= NUMCOLUMNAS - 1; i++) {
			tablero[i] = new Stack<Bloque>();
		}
		// código para “llenar” aleatoriamente las pilas de “bloques”
	}
	public int jugar() {
		// Pre: el juego ha sido inicializado (se han generado los
		// bloques de inicio)
		// Post: se ha jugado una partida, en la que la bola empieza
		// cayendo encima de la columna de en medio.
		// El resultado será el número de puntos obtenido al jugar con esa bola,
		// en caso de que el juego haya sido superado, y -1 en caso contrario
		new Juego();

		int puntosTotales = 0;
		int posicionBola = NUMCOLUMNAS / 2;
		boolean acabado = false;

		while (!acabado) {
			if (!tablero[posicionBola].isEmpty()) {
				
				Bloque bloqueActual = tablero[posicionBola].pop();
				puntosTotales = puntosTotales + bloqueActual.puntos;

				if (bloqueActual.direccion.equals("d")) {
					posicionBola = posicionBola + bloqueActual.salto;
				}
				else if (bloqueActual.direccion.equals("i")) {
					posicionBola = posicionBola - bloqueActual.salto;
				}

				if (posicionBola >= tablero.length || posicionBola < 0) {
					acabado = true;
				}
			}
			else {
				acabado = true;
			}
		}
		return puntosTotales;
	}
}
