package b_c_pilasYColas.EjercicioRepartirRegalos;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Colegio {
	Queue<Queue<String>> alumnos;

	public Colegio() {
		alumnos = (Queue<Queue<String>>) new LinkedList<Queue<String>>();
		for(int i = 0; i < 6; i++) {
			Queue<String> colaNueva = (Queue<String>) new LinkedList<String>();
			alumnos.add(colaNueva);
		}
		alumnos.peek().add("a");
		alumnos.peek().add("b");
		alumnos.peek().add("c");
		alumnos.peek().add("d");

		alumnos.add(alumnos.remove());

		alumnos.peek().add("e");
		alumnos.peek().add("f");
		alumnos.peek().add("g");
		alumnos.peek().add("h");

		alumnos.add(alumnos.remove());

		alumnos.peek().add("i");
		alumnos.peek().add("j");
		alumnos.peek().add("k");
		alumnos.peek().add("l");

		alumnos.add(alumnos.remove());

		alumnos.peek().add("m");
		alumnos.peek().add("n");
		alumnos.peek().add("o");
		alumnos.peek().add("p");

		alumnos.add(alumnos.remove());

		alumnos.peek().add("q");
		alumnos.peek().add("r");
		alumnos.peek().add("s");
		alumnos.peek().add("t");

		alumnos.add(alumnos.remove());

		alumnos.peek().add("u");
		alumnos.peek().add("v");
		alumnos.peek().add("w");
		alumnos.peek().add("x");

		alumnos.add(alumnos.remove());
	}

	public void repartirRegalos(Queue<String> regalos) { //SIN USAR PEEK()
		// post: los regalos se han repartido uno a uno, entregando el primer regalo a los alumnos del primer curso de la cola
		// de alumnos, y así sucesivamente
		// Se han escrito en la pantalla las asignaciones de regalos en forma de pares (alumno, regalo)
		LinkedHashMap<String, ArrayList<String>> regalosConAlumnos = new LinkedHashMap<String, ArrayList<String>>();
		
		while (!regalos.isEmpty()) {
			String regaloActual = regalos.remove();
			Queue<String> colaActual = alumnos.remove();
			Queue<String> colaAux = new LinkedList<String>();
			ArrayList<String> alumnosActuales = new ArrayList<String>();

			while (!colaActual.isEmpty()) {
				String alumnoActual = colaActual.remove();
				alumnosActuales.add(alumnoActual);
				regalosConAlumnos.put(regaloActual, alumnosActuales);
				colaAux.add(alumnoActual);
				
			}
			alumnos.add(colaAux);
		}

		for (String key: regalosConAlumnos.keySet()) {
			System.out.println("El regalo " + key + " con " + regalosConAlumnos.get(key));
		}
	}

	public static void main(String[] args) {
		Colegio miColegio = new Colegio();
		Queue<String> regalos = new LinkedList<String>();
		regalos.add("r1");
		regalos.add("r2");
		regalos.add("r3");
		regalos.add("r4");
		regalos.add("r5");
		regalos.add("r6");
		regalos.add("r7");
		regalos.add("r8");
		regalos.add("r9");
		regalos.add("r10");
		

		miColegio.repartirRegalos(regalos);
	}
}
