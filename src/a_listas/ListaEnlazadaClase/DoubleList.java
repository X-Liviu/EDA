package a_listas.ListaEnlazadaClase;

public class DoubleList 
{
	public DoubleLink first;
	public DoubleLink last;

	public DoubleList()
	{
		this.first = null;
		this.last = null;
	}

	public void insertFirst(Object elem) //utilizar para UnorderedDoubleLinkedList
	{
		DoubleLink nuevo = new DoubleLink(elem);
		if (this.first == null)
		{
			this.first = nuevo;
			this.last = nuevo;
		}
		else
		{
			nuevo.next = this.first;
			this.first.prev = nuevo;
			this.first = nuevo;
		}
	}

	public void insertEnMedio(DoubleLink pos) //utilizar para UnorderedDoubleLinkedList
	{
		Object elem = null; //en un caso real lo pasas como parámetro
		DoubleLink nuevo = new DoubleLink(elem);
		if (pos == this.last)
		{
			pos.next = nuevo;
			nuevo.prev = pos;
			this.last = nuevo;
		}
		else
		{
			nuevo.next = pos.next;
			nuevo.prev = pos;
			pos.next.prev = nuevo;
			pos.next = nuevo;
		}
	}

//	public Object delete(Object elem)
//	{
//		DoubleLink pos; //posicion de elem, lo obtendrías con otro método.
//		if (pos == null)
//		{
//			return null;
//		}
//		else if (pos == this.first)
//		{
//			if (this.first == this.last)
//			{
//				Object temp = pos.data;
//				this.first = null;
//				this.last = null;
//				return temp;
//			}
//			else
//			{
//				this.first = this.first.next;
//				this.first.prev = null;
//				return pos.data;
//			}
//		}
//		else if (pos == this.last)
//		{
//			this.last = this.last.prev;
//			this.last.next = null;
//			return pos.data;
//		}
//		else
//		{
//			pos.prev.next = pos.next;
//			pos.next.prev = pos.prev;
//			return pos.data;
//		}
//	}
}
