package practicas.Practica2;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

	public void addToFront(T elem) 
	{
		Node<T> nuevo = new Node<T>(elem);
		if (this.first == null) {
			this.first = nuevo;
			this.last = nuevo;
		}
		else {
			nuevo.next = this.first;
			this.first.prev = nuevo;
			this.first = nuevo;
		}
		this.count++;
	}

	public void addToRear(T elem) {
			Node<T> nuevo = new Node<T>(elem);
			
			if (this.isEmpty()) {
				this.first = nuevo;
				this.last = nuevo;
			} 
			else {
				this.last.next = nuevo;
				nuevo.prev = this.last;
				this.last = this.last.next;
			}
			this.count = this.count + 1;
		}

	public void addAfter(T elem, T target) {
		//Pre: target ya se encuentra en la lista
		Node<T> nuevo = new Node<T>(elem);
		Node<T> act = this.first;
		boolean enc = false;
		
		while (!enc) {
			if (act.data == target && act.next == null) {
				this.addToRear(elem);
				enc = true;
			}
			else if (act.data == target && act.next != null) {
				nuevo.prev = act;
				nuevo.next = act.next;
				act.next.prev = nuevo;
				act.next = nuevo;
				enc = true;
				this.count++;
			} 
			else {
				act = act.next;
			}
		}
	}
	
	@Override
	protected DoubleLinkedList<T> createList() {
		return new UnorderedDoubleLinkedList<T>();
	}
}
