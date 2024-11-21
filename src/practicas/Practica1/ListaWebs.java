package practicas.Practica1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListaWebs {

	private ArrayList<Web> lista;

	public ListaWebs() {
		this.lista = new ArrayList<Web>();
	}

	public Iterator<Web> getIterador(){
		return this.lista.iterator();
	}

	public void leerWebs(String pNomFichero) throws FileNotFoundException {
		Scanner entrada = new Scanner(new FileReader(pNomFichero));

		String linea;
		while (entrada.hasNext()) {
			linea = entrada.nextLine();
			String[] lineaSeparada = linea.split("\\s+:::\\s+");
			Web web = new Web(lineaSeparada[1]);
			this.anadirWeb(web);

		}
	}
	public void escribirWebs() {
		Iterator<Web> itr = this.getIterador();
		Web estaWeb = null;
		while (itr.hasNext()) {
			estaWeb = itr.next();
			System.out.println(estaWeb.getNombre());
		}


	}

	public void anadirWeb(Web pWeb) {
		this.lista.add(pWeb);
	}

	public void borrarWeb(String pWeb) {
		Iterator<Web> itr = this.getIterador();
		Web webActual = null;
		Web webBorrada = this.string2Web(pWeb);

		while (itr.hasNext()) {
			webActual = itr.next();
			webActual.borrarSaliente(webBorrada);
		}
		this.lista.remove(webBorrada);
	}

	public void borrar1Web(Web pWeb) {
		this.lista.remove(pWeb);
	}

	private Web ident2Web(int x) {
		return this.lista.get(x);
	}

	private Web string2Web(String pNombre) {
		Iterator<Web> itr = this.getIterador();
		Web estaWeb;
		Web laWeb = null;

		while(itr.hasNext() && laWeb == null) {
			estaWeb = itr.next();
			if (estaWeb.getNombre().equals(pNombre)) {
				laWeb = estaWeb;
			}
		}

		return laWeb;
	}

	public boolean buscarWeb(String pNombre) {
		return (this.string2Web(pNombre)!= null);
	}

	public ArrayList<String> websOrdenadas(){
		ArrayList<String> listaOrdenada = new ArrayList<String>();

		return listaOrdenada;
	}

	public ArrayList<String> word2Webs(String pPalabra){
		ArrayList<String> listaWebs = new ArrayList<String>();
		Iterator<Web> itr = this.getIterador();

		Web webActual;
		while (itr.hasNext()) {
			webActual = itr.next();
			if (webActual.getNombre().contains(pPalabra)) {
				listaWebs.add(webActual.getNombre());
			}
		}

		return listaWebs;
	}

	public ArrayList<String> salientes(String web){
		ArrayList<String> listaSalientes = new ArrayList<String>();
		Web laWeb = this.string2Web(web);

		if (laWeb!=null) {
			listaSalientes = laWeb.salientes();
		}
		return listaSalientes;
	}

	public ArrayList<String> listaWeb2listaString(){
		ArrayList<String> listaString = new ArrayList<String>();
		Iterator<Web> itr = this.getIterador();

		Web webActual;
		while (itr.hasNext()) {
			webActual = itr.next();
			listaString.add(webActual.getNombre());
		}
		return listaString;
	}

	public void cargarSalientes(String pFichero) throws FileNotFoundException {
		Scanner entrada = new Scanner(new FileReader(pFichero));
		Iterator<Web> itr = this.getIterador();

		Web webActual;
		Web salienteActual;
		String linea;

		while (entrada.hasNext()&&itr.hasNext()) {
			linea = entrada.nextLine();
			webActual = itr.next();
			String[] lineaSeparada = linea.split("\\s+>+\\s+");
			if (lineaSeparada.length>1) {
				lineaSeparada = lineaSeparada[1].split("\\s+#+\\s+");
				for (int i=0;i<=lineaSeparada.length-1;i++) {
					salienteActual = this.ident2Web(Integer.parseInt(lineaSeparada[i]));
					webActual.anadirSaliente(salienteActual);
				}
			}
		}
	}

	public void anadirSaliente(String pSaliente,String pOrigen) {
		Web webOrigen = this.string2Web(pOrigen);
		Web webSaliente = this.string2Web(pSaliente);

		if (webOrigen != null && webSaliente!=null && !webOrigen.getNombre().equals(webSaliente.getNombre()) && !webOrigen.salientes().contains(webSaliente.getNombre())) {
			webOrigen.anadirSaliente(webSaliente);
		}
	}


	public void guardarListaWebs(String pNombreFichero) {
		try {
			PrintWriter writer = new PrintWriter(pNombreFichero, "UTF-8");
			int cont = 0;
			for (Web webActual: this.lista) {
				writer.println(Integer.toString(cont) + "   :::   " + webActual.getNombre());
				cont=cont+1;
			}
			writer.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
