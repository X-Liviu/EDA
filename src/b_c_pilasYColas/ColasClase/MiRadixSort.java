package b_c_pilasYColas.ColasClase;

import java.util.LinkedList;
import java.util.Queue;

public class MiRadixSort {

	public void radixSort(Integer[] a, int maxCifras) {
		// Pre: maxCifras indica el número de cifras del elemento mayor de a
		Queue<Integer>[] arrayDeColas = new LinkedList[10];

		for (int i = 0; i < arrayDeColas.length; i++) { // inicializar colas
			arrayDeColas[i] = new LinkedList<Integer>();
		}

		Queue<Integer> colaResultado = new LinkedList<Integer>();

		for(int i = 0; i < a.length; i++) {
			colaResultado.add(a[i]);
		}

		int exp = 0;
		int division = 1;
		while(exp < maxCifras) {

			while (!colaResultado.isEmpty()) {
				int numActual = colaResultado.remove();
				arrayDeColas[(numActual / division % 10)].add(numActual);
			}
			exp++;
			division = division * 10;
			for (int i = 0; i < arrayDeColas.length; i++) {
				while(!arrayDeColas[i].isEmpty()) {
					int aux = arrayDeColas[i].remove();
					colaResultado.add(aux);
				}
			}
		}
		int index = 0;
		while(!colaResultado.isEmpty()) {
			a[index] = colaResultado.remove();
			index++;
		}
	}

	public static void main(String[] args) { // prueba radix sort con palabras


		Integer[] a = {101, 207, 198, 713, 542, 23, 78, 2, 966, 205};
		new MiRadixSort().radixSort(a, 3);

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
