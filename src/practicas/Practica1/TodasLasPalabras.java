package practicas.Practica1;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TodasLasPalabras {

	private ListaPalabras lista;
	private static TodasLasPalabras miTodasLasPalabras = new TodasLasPalabras("words.txt");

	private TodasLasPalabras(String pFichero) {
		try 
		{
			this.lista = new ListaPalabras();
			this.lista.leerPalabras(pFichero);
		}
		catch(FileNotFoundException fnfe) 
		{
			System.out.println("No se ha encontrado el fichero");
		}
	}

	public static TodasLasPalabras getTodasLasPalabras()
	{
		return miTodasLasPalabras; 
	}

	public void escribirPalabras() {
		this.lista.escribirPalabras();
	}

	public ArrayList<String> web2words(String pWeb){
		return this.lista.web2words(pWeb);
	}

}
