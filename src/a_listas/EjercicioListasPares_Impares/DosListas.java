package a_listas.EjercicioListasPares_Impares;

public class DosListas<T> {
	CircularDoubleLinkedList<T> lImpar;
	CircularDoubleLinkedList<T> lPar;
	
	public DosListas() {
		lImpar.first = null;
		lPar.first = null;
	}
}
