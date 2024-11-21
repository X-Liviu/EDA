package a_listas.EjercicioObtenerListaComplementaria;

public class Lista 
{
	Node first;
	
	public Lista()
	{
		this.first = null;
	}
	
	public Lista obtenerListaComplementaria(int n) //versión de Koldo
	//pre: n >= 1. La lista está ordenada acendentemente
	//post: El resultado es una lista que contiene los valores entre 1 y n que no estaban en la lista original, en orden ascendente.
	{
		Lista resultado = new Lista();
		int i = 1;
		Node act = this.first;
		Node ult = null;
		
		while (i <= n && act != null) {
			if (i == act.data) {
				i++;
				act = act.next;
			}
			else { // i < act.data
				Node nuevo = new Node(i); //1 desde aqui
				if (resultado.first != null) {
					resultado.first = nuevo;
					ult = nuevo;
				}
				else {
					ult.next = nuevo;
					ult = nuevo;
				}
				i++; //hasta aqui
			}
		}
		
		for (int j = i; j <= n; j++) {
			Node nuevo = new Node(i); 
			if (resultado.first != null) {
				resultado.first = nuevo;
				ult = nuevo;
			}
			else {
				ult.next = nuevo;
				ult = nuevo;
			}
		}
		return resultado;
	}
}
