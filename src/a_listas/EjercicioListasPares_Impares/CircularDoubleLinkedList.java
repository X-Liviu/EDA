package a_listas.EjercicioListasPares_Impares;

public class CircularDoubleLinkedList<T> {
	Node<T> first;

	public CircularDoubleLinkedList() {
		this.first = null;
	}

	public DosListas<T> obtenerListasConParesEImpares() {
		Node<T> act = null;
		DosListas<T> l = new DosListas<T>();

		if (this.first == null) {}
		else if (this.first.next == this.first) {

			Node<T> nuevo = new Node<T>(this.first.data);
			l.lImpar.first = nuevo;
			nuevo.prev = l.lImpar.first;
			nuevo.next = nuevo;
			
		}
		else {
			
			act = this.first;
			Node<T> ultLImpar = null;
			Node<T> ultLPar = null;
			int cont = 1;
			while (act != this.first) {
				Node<T> nuevo = new Node<T>(act.data);

				if (cont % 2 == 1) {

					if (l.lImpar.first == null) {

						l.lImpar.first = nuevo;
						nuevo.prev = l.lImpar.first;
						ultLImpar = nuevo;
						nuevo.next = nuevo;

					}
					else {
						nuevo.prev = ultLImpar;
						nuevo.next = l.lImpar.first;
						l.lImpar.first.prev = nuevo;
						ultLImpar.next = nuevo;
						ultLImpar = ultLImpar.next;

					}
				}
				else if(cont % 2 == 0) {
					if (l.lPar.first == null) {

						l.lPar.first = nuevo;
						nuevo.prev = l.lPar.first;
						ultLPar = nuevo;
						nuevo.next = nuevo;

					}
					else {
						nuevo.prev = ultLPar;
						nuevo.next = l.lPar.first;
						l.lPar.first.prev = nuevo;
						ultLPar.next = nuevo;
						ultLPar = ultLPar.next;
					}
					cont++;
					act = act.next;
				}
			}
		}
		return l;
	}
}
