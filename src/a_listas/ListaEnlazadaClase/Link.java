package a_listas.ListaEnlazadaClase;

public class Link {
	//atributos
	public Persona data; //esto en PMOO estaba prohibido
	public Link next;	 //esto en PMOO estaba prohibido
	
	public Link (Persona p)
	{
		this.data = p;
		this.next = null;
	}
}
