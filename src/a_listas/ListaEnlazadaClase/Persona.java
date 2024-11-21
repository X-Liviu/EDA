package a_listas.ListaEnlazadaClase;

public class Persona {
	//atributos
	private String nombre;
	private String dni;
	
	public Persona (String pNombre, String pDni)
	{
		this.nombre = pNombre;
		this.dni = pDni;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
}
