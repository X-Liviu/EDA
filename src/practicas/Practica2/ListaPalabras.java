package practicas.Practica2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListaPalabras {

	private UnorderedDoubleLinkedList<String> lista;

	public ListaPalabras() {
		this.lista = new UnorderedDoubleLinkedList<String>();
	}

	private Iterator<String> getIterador(){
		return this.lista.iterator();

	}

	public void leerPalabras(String pNomFichero) throws FileNotFoundException {
		Scanner entrada = new Scanner(new FileReader(pNomFichero));

		String linea;
		while (entrada.hasNext()) {

			linea = entrada.nextLine();
			String nuevaPalabra = linea;
			this.lista.addToRear(nuevaPalabra);

		}
	}

	public UnorderedDoubleLinkedList<String> getPalabras() {
		return this.lista;
	}

	public ArrayList<String> web2words(String pWeb){
		ArrayList<String> listaPalabras = new ArrayList<String>();
		Iterator<String> itr = this.getIterador();

		String palabraActual;
		while (itr.hasNext()) {
			palabraActual = itr.next();
			if (pWeb.contains(palabraActual)) {
				listaPalabras.add(palabraActual);
			}
		}

		return listaPalabras;
	}

}
