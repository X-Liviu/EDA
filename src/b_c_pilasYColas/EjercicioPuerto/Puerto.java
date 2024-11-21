package b_c_pilasYColas.EjercicioPuerto;

import java.util.Queue;
import java.util.Stack;

public class Puerto {
	Stack<String>[] muelles;
	
	public void simularPuerto(Queue<Barco> barcos, int maxPeticiones, int numMuelles) {
		//Pre: maxPeticiones es el número máximo de peticiones que se pueden atender en el turno de un barco
		//   : numMuelles es el número de muelles del puerto (>= 2). El muelle 0 es especial
		//Post: se ha simulado la actividad del puerto, atendiendo las peticiones de los barcos
		
		muelles = (Stack<String>[]) new Stack[numMuelles];
		
		for(int i = 0; i < muelles.length; i++) {
			Stack<String> muelle = new Stack<String>();
			muelles[i] = muelle;
		}
		
		while (!barcos.isEmpty()) {
			Barco barcoActual = barcos.peek();
			
			if (barcoActual.tipo == 0) {
				int i = 0;
				boolean acabado = false;
				
				while(i < maxPeticiones && !acabado) {
					
					if (!barcoActual.peticiones.isEmpty()) {
						Peticion peticionActual = barcoActual.peticiones.remove();
						muelles[peticionActual.muelle].push(peticionActual.codigoDeContenedor);
					}
					else {
						acabado = true;
					}
					i++;
				}
				if (!barcoActual.peticiones.isEmpty()) {
					barcos.add(barcos.remove());
				}
				else {
					barcos.remove();
				}
				
			}
			else {
				while(!barcoActual.peticiones.isEmpty()) {
					Peticion peticionActual = barcoActual.peticiones.peek(); //si hiciera remove, podría acabar el bucle antes de poder hacer lo demás
					boolean enc = false;
					
					while (!enc) {
						if (muelles[peticionActual.muelle].peek().equals(peticionActual.codigoDeContenedor)) {
							muelles[peticionActual.muelle].pop();
							enc = true;
						}
						else {
							muelles[0].push(muelles[peticionActual.muelle].pop());
						}
					}
					
					while (!muelles[0].isEmpty()) {
						muelles[peticionActual.muelle].push(muelles[0].pop());
					}
					barcoActual.peticiones.remove();
				}
				barcos.remove();
			}
		}
	}
}
