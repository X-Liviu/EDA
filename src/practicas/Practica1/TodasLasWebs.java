package practicas.Practica1;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TodasLasWebs {

	private ListaWebs lista;
	private static TodasLasWebs miTodasLasWebs = new TodasLasWebs("index-2024-25", "pld-arcs-1-N-2024-25");

	private TodasLasWebs(String pFichero,String pSalientes) {
		try 
		{
			this.lista = new ListaWebs();
			this.lista.leerWebs(pFichero);
			this.lista.cargarSalientes(pSalientes);
		}
		catch (FileNotFoundException fnfe) 
		{
			System.out.println("No se ha encontrado alguno de los dos ficheros");
		}

	}
	public static TodasLasWebs getTodasLasWebs()
	{
		return miTodasLasWebs;
	}

	public void escribirWebs() {
		this.lista.escribirWebs();
	}

	public ArrayList<String> websOrdenadas(){
		return this.lista.websOrdenadas();
	}

	public ArrayList<String> word2Webs(String pPalabra){
		return this.lista.word2Webs(pPalabra);
	}

	public void anadirSaliente(String pSaliente,String pOrigen) {
		this.lista.anadirSaliente(pSaliente,pOrigen);
	}

	public void borrarWeb(String pWeb) {
		this.lista.borrarWeb(pWeb);
	}

	public ArrayList<String> verSalientes(String pWeb) {
		return this.lista.salientes(pWeb);
	}

	public void insertarWeb(String pWeb) {
		Web nuevaWeb = new Web(pWeb);
		this.lista.anadirWeb(nuevaWeb);
	}

	public void guardarListaWebs(String pNombreFichero) {
		this.lista.guardarListaWebs(pNombreFichero);
	}

	//no falta poner el buscarWeb? Pero aún así no devuelve la web si no un booleano...

}
