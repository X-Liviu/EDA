package a_listas.ListaEnlazadaClase;

public class DoubleLink 
{
	public Object data;
	public DoubleLink next;
	public DoubleLink prev;
	
	public DoubleLink(Object o)
	{
		this.data = o;
		this.next = null;
		this.prev = null;
	}
}

	