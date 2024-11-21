package practicas.Practica1;

import java.util.ArrayList;

public class Web {

	private String nombre;
	private ListaWebs lista;
	
	public Web(String pNombre) {
		this.nombre = pNombre;
		this.lista = new ListaWebs();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void borrarSaliente(Web pWeb) {
		this.lista.borrar1Web(pWeb);
	}
	
	public void anadirSaliente(Web pWeb) {
		this.lista.anadirWeb(pWeb);
	}
	
	public ArrayList<String> salientes(){
		return this.lista.listaWeb2listaString();
	}
	
	
	
}
