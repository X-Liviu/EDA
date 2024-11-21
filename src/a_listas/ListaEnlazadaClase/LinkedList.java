package a_listas.ListaEnlazadaClase;

public class LinkedList {
	//atributos
	private Link first;

	public LinkedList()
	{
		this.first = null;
	}

	public boolean estaVacia()
	{
		boolean vaciaQ = false;
		if (this.first == null)
		{
			vaciaQ = true;
		}
		return vaciaQ;
	}

	public void insertarPrimero(Persona p)
	{
		Link nuevo = new Link(p);
		if(this.estaVacia())
		{
			this.first = nuevo;
		}
		else
		{
			nuevo.next = first; //si el atributo es publico
			this.first = nuevo;
		}
	}

	public Persona deleteFirst()
	{
		Persona aux;

		if (this.estaVacia())
		{
			return null;
		}
		else
		{
			aux = this.first.data; //si el atributo es publico
			this.first = first.next;
		}
		return aux;
	}

	public void enseñarLista()
	{
		//Link actual = new Link(null);//sirve pero está mal porque no hace falta crear un objeto para esto, sólo necesitamos para apuntar al siguiente
		Link actual = this.first;

		while (actual != null)
		{
			System.out.println(actual.data.getNombre());
			actual = actual.next;
		}
	}

	public Persona encontrar(Persona key)
	{
		Link actual = this.first;
		boolean enc = false;
		Persona laPersona = null;

		if (this.estaVacia())
		{
			return null;
		}

		while (actual != null && !enc)
		{
			if (actual.data.equals(key))
			{
				laPersona = actual.data;
				enc = true;
			}
			else
			{
				actual = actual.next;
			}
		}
		return laPersona;
	}

	public boolean contiene(Persona p)
	{
		return encontrar(p) != null; 
	}

	public Persona borrar(Persona p)
	{
		Link actual = this.first;
		Link anterior = null;
		boolean enc = false;

		while (actual != null && !enc)
		{
			if (actual.data.equals(p))
			{
				enc = true;
			}
			else
			{
				anterior = actual;
				actual = actual.next;
			}
		}
		if (!enc) //no es la manera en la que yo haría esto pero también sirve
		{
			return null;
		}
		else if (actual == this.first)
		{
			this.first = actual.next;
		}
		else if (actual.next == null)
		{
			anterior.next = null;
		}
		else
		{
			anterior.next = actual.next;
			actual.next = null;
		}
		return actual.data;
	}

	public void insertarAlFinal(Persona p)
	{
		Link nuevo = new Link(p);
		Link actual;

		if(this.first == null)
		{
			this.first = nuevo;
		}
		else
		{	
			actual = first;
			while(actual.next != null)
			{
				actual = actual.next;
			}
			actual.next = nuevo;	
		}
	}

	public void reverseList()
	{
		Link actual;
		Link last = null;
		Link anterior = null;

		if (this.first == null) {}
		else {
			actual = this.first;
			while (last != this.first)
			{
				while (actual.next != last) 
				{
					anterior = actual;
					actual = actual.next;
				}
				
				last = actual;
				actual.next = anterior;
				actual = this.first;
			}
		}
	}
	
	public void reverseList2()
	{
		Link actual;
		Link anterior = null;
		Link last = null;
		Link aux;
		
		if (this.first == null) {}
		else {
			aux = this.first;
			actual = aux;
			while (last != aux) {
				while (actual.next != last) {
					anterior = actual;
					actual = actual.next;
				}
				last = actual;
				actual.next = anterior;
				actual = aux;
				
			}
		}
	}
}
