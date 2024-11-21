package practicas.Practica1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	HashMap<String, ArrayList<String>> enlaces;

	public Graph() {
		this.enlaces = new HashMap<String,ArrayList<String>>();
	}

	public void crearGrafo(ListaWebs lista){
		Iterator<Web> itr = lista.getIterador();
		Web webActual = null;

		while (itr.hasNext()) {
			webActual = itr.next();
			this.enlaces.put(webActual.getNombre(), webActual.salientes());
		}
	}

	public void print() {
		for (String web : enlaces.keySet()) {
			System.out.print("Element: " + web + " >>> ");
			for (String saliente : enlaces.get(web))  System.out.print(saliente + " ### ");

			System.out.println();
		}
	}

	public boolean estanConectados(String a1, String a2) {
		Queue<String> porExaminar = new LinkedList<String>();
		HashSet<String> examinados = new HashSet<String>();

		boolean enc = false;
		String act;
		porExaminar.add(a1);
		examinados.add(a1);

		while (!enc && porExaminar.isEmpty()) {
			act = porExaminar.remove();
			if (act.equals(a2)) {
				enc = true;
			}
			else {
				for (String saliente : enlaces.get(act)) {
					if (!examinados.contains(saliente)) {
						examinados.add(saliente);
						porExaminar.add(saliente);
					}
				}
			}
		}
		return enc;
	}

	public ArrayList<String> estanConectados2(String a1, String a2) {
		Queue<String> porExaminar = new LinkedList<String>();
		HashMap<String, String> deDonde = new HashMap<String, String>();
		HashSet<String> examinados = new HashSet<String>();

		porExaminar.add(a1);
		deDonde.put("a", null);
		boolean enc = false;
		String act = a1;

		while(!enc && !porExaminar.isEmpty()) {
			act = porExaminar.remove();

			if (act.equals(a2)) {
				enc = true;
			}
			else {
				for (String saliente : enlaces.get(act)) {
					if (!examinados.contains(saliente)) {
						examinados.add(saliente);
						porExaminar.add(saliente);
						deDonde.put(saliente, act);
					}
				}
			}
		}
		ArrayList<String> resultado = new ArrayList<String>();
		
		if (enc) {
			for (String web : deDonde.keySet()) {
				resultado.add(web);
			}
		}
		return resultado;
	}
}

//PARA RECORRER UN HASHMAP
//for (String clave: enlaces.keySet())
//{
//	System.out.println(clave + ": " + enlaces.get(clave));
//}