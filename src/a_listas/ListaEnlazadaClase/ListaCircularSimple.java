package a_listas.ListaEnlazadaClase;

public class ListaCircularSimple 
{
	//atributos
	public Link last;
	
	public ListaCircularSimple()
	{
		this.last = null;
	}
	
	public void insertarAlFinal(Persona p)
	{
		Link nuevo = new Link(p);
		
		if (this.last == null)
		{
			this.last = nuevo;
			nuevo.next = this.last; // o valdría = nuevo
		}
		else
		{
			nuevo.next = this.last.next;
			this.last.next = nuevo;
			this.last = nuevo;
		}
	}
	
	public void enseñarLista()
	{
		if(this.last == null) {}
		else
		{
			Link actual = last.next;
			while (actual != last)
			{
				System.out.println(actual.data.getNombre());
				actual = actual.next;
			}
		}
	}
}
