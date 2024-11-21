package b_c_pilasYColas.EjercicioPartidaPoker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Juego {
	public int jugar(int nJugadores, int nBilletesInicial, ArrayList<Pago> pagos) {

		Stack<Boolean>[] jugadores = new Stack[nJugadores];

		for (int i = 0; i < jugadores.length; i++) { //inicializar las pilas (fajo de billetes) de cada jugador
			jugadores[i] = new Stack<Boolean>();//crear los billetes
			
			if (i == 0) {
				for (int j = 1; j <= nBilletesInicial; j++) { //billetes falsos (false) para el jugador 0
					jugadores[i].add(false);
				}
			}
			else {
				for (int j = 1; j <= nBilletesInicial; j++) { //billetes falsos (true) para el resto
					jugadores[i].add(true);
				}
			}
		}
		
		Iterator<Pago> itr = pagos.iterator();
		Pago pagoActual = null;
		
		while (itr.hasNext()) {
			
			pagoActual = itr.next();
			int aux = pagoActual.cantidad;
			
			for (int i = 1; i <= aux; i++) { //hacer intercambio de billetes (asumimos que como minimo paga 1)
				boolean dinero = jugadores[pagoActual.pagador].pop();
				jugadores[pagoActual.cobrador].push(dinero);
			}
		}
		
		Stack<Boolean> pilaAuxJ0 = jugadores[0];
		int nBilletesJ0 = 0;
		
		while (!pilaAuxJ0.isEmpty()) {
			boolean billeteActual = pilaAuxJ0.pop();
			if (billeteActual == true) {
				nBilletesJ0++;
			}
		}
		return nBilletesJ0;
	}
}
