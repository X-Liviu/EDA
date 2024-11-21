package a_listas.EjercicioExamen_parcial1_2022_23;

public class ListaDeProveedores 
{
	Nodo first;
	
	public void eliminarProveedores(String p) //versión de Koldo
	//pre: El proveedor está en la estructura, y no es el único
	//post: se ha eliminado ese proveedor
	{
		 boolean borrado = false;
		 Nodo nivActual = this.first;
		 
		 while (nivActual.superior != null && !borrado) {
			 Nodo act = nivActual.sigProveedor;
			 Nodo ant = nivActual;
			 boolean enc = false;
			 
			 while (!enc && act != nivActual) {
				 if (act.nombreProveedor.equals(p)) {
					enc = true;
				 }
				 else {
					 ant = act;
					 act = act.sigProveedor;
				 }
			 }
			 if (act.nombreProveedor.equals(p)) {
				borrado = true;
				ant.sigProveedor = act.sigProveedor;
				if (act == this.first) {
					this.first = this.first.sigProveedor;
				}
			 }
			 else {
				 nivActual = nivActual.superior;
			 }
		 }
	} // n = nº niveles y m = nº elementos por nivel (media) O(n * m) ó n = nº total de proveedores O(n)
}
