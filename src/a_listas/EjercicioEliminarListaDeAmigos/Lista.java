package a_listas.EjercicioEliminarListaDeAmigos;

public class Lista {
	Nodo first;

	public void eliminar(String id){
		// Precondicion: “id” corresponde a un elemento de la lista
		// Postcondicion: se ha eliminado el elemento de la lista
		// correspondiente a “id”.
		// También se han borrado (puesto a null) las referencias
		// de los amigos que apuntaban a “id”
		Nodo ant = null;
		Nodo act = this.first;
		boolean borrado = false;
		int i = 0;
		
		while (act != null) {
			if (act.info.id.equals(id)) {
				if (act == this.first) {
					this.first = this.first.next;
					act = this.first;
				}
				else if (act.next == null) {
					ant.next = null;
					act = null; //para que se acabe el bucle en caso de que haya que borrar el último elemento
				}
				else {
					ant.next = act.next;
					act = act.next;
				}
			}
			else {
				while (!borrado && i < act.info.amigos.length) {
					if (act.info.amigos[i].id.equals(id)) {
						act.info.amigos[i] = null;
						borrado = true;
					}
					else {
						i++;
					}
				}
				borrado = false;
				i = 0;
				
				ant = act;
				act = act.next;
			}
		}
	}
}
