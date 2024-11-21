package practicas.Practica1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListaPalabras {

	private ArrayList<String> lista;
	
	public ListaPalabras() {
		this.lista = new ArrayList<String>();
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
	    	this.anadirPalabra(nuevaPalabra);
	      
	    }
	}
	
	public void escribirPalabras() {
    	Iterator<String> itr = this.getIterador();
		String estaPalabra = null;
    	while (itr.hasNext()) {
    		estaPalabra = itr.next();
    		System.out.println(estaPalabra);
    	}
    	
    	
    }
    
    public void anadirPalabra(String pPalabra) {
    	this.lista.add(pPalabra);
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
