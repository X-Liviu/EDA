package b_c_pilasYColas.EjercicioImpresora;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Impresoras {

	public void procesarTrabajos(ArrayList<Peticion> lista) {
		Queue<Integer>[] impresoras = new LinkedList[6];

		for (int i = 0; i < impresoras.length; i++) {
			Queue<Integer> impr = new LinkedList<Integer>();
			impresoras[i] = impr;
		}

		Iterator<Peticion> itr = lista.iterator();
		Peticion petiAct = null;
		boolean apagon = false;

		while (itr.hasNext()) {
			petiAct = itr.next();
			if (petiAct.tipoEvento.equals('P') && !apagon) {
				impresoras[petiAct.impresora].add(petiAct.trabajo);
			}
			else if (petiAct.tipoEvento.equals('P') && apagon) {
				impresoras[0].add(petiAct.trabajo);
			}
			else if (petiAct.tipoEvento.equals('F')) {
				impresoras[petiAct.impresora].remove();
			}
			else if (petiAct.tipoEvento.equals('A')) {
				apagon = true;
				for (int i = 0; i < impresoras.length; i++) {
					while (!impresoras[i].isEmpty()) {
						impresoras[0].add(impresoras[i].remove());
					}
				}
			}
			else if (petiAct.tipoEvento.equals('S')) {
				apagon = false;
			}
		}
	}
}
