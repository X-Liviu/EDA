package d_arboles.EjercicioArbolGenealogico;

import java.util.HashMap;

public class ArbolGenealogico {
	BinaryTreeNode<Persona> root;

	public boolean esVizcainoDePuraCepa(String nombre, HashMap<String, String> localidades) {
		BinaryTreeNode<Persona> p = find(nombre, root);
		if (p == null) { //no hace falta porque dice que sí que está la persona 
			return false;
		}
		else {
			return todosVizcainos(p, localidades);
		}
	}

	private BinaryTreeNode<Persona> find(String nom, BinaryTreeNode<Persona> a) {
		if (a == null) {
			return null;
		}
		else if (a.data.nombre.equals(nom)) {
			return a;
		}
		else {
			BinaryTreeNode<Persona> aux = find(nom, a.left);
			if (aux != null) {
				return aux;
			}
			else {
				return find(nom, a.right);
			}
		}
	}
	
	private boolean todosVizcainos(BinaryTreeNode<Persona> a, HashMap<String, String> locs) {
		if (a == null) {
			return true;
		}
		else if (!locs.get(a.data.localidadNacimiento).equals("Bizkaia")) {
			return false;
		}
		else {
			return todosVizcainos(a.left, locs) && todosVizcainos(a.right, locs);
		}
		//Coste: O(n)
	}
}
