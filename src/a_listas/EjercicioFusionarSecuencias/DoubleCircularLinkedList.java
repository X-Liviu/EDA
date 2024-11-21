package a_listas.EjercicioFusionarSecuencias;

public class DoubleCircularLinkedList {
	DoubleNode<String> first;

	public void fusionarSecuencias (String[] s1, String[] s2) {
		int i = 0;
		int j = 0;
		boolean terminadoS1 = false;
		boolean terminadoS2 = false;
		boolean yaAñadido = false;
		
		while (!terminadoS1 && !terminadoS2) {
			DoubleNode<String> nuevo = new DoubleNode<String>(null);
			if (s1[i].compareTo(s2[j]) < 0) {
				nuevo.data = s1[i];
				i++;
			} 
			else if (s1[i].compareTo(s2[j]) > 0) {
				nuevo.data = s2[j];
				j++;
			} 
			else {
				DoubleNode<String> nuevo2 = new DoubleNode<String>(null);
				nuevo2.data = s2[j];
				this.addAfter(nuevo);
				yaAñadido = true;
				this.addAfter(nuevo2);
				i++;
				j++;
			}
			if (!yaAñadido) {
				this.addAfter(nuevo);
			}
			yaAñadido = false;
			
			if (i == s1.length && j != s2.length) {
				terminadoS1 = true;
			} else if (i != s1.length && j == s2.length) {
				terminadoS2 = true;
			} else if (i == s1.length && j == s2.length) {
				terminadoS1 = true;
				terminadoS2 = true;
			}
		}
		
		if (terminadoS1 && !terminadoS2) {
			while (j < s2.length) {
				DoubleNode<String> nuevo = new DoubleNode<String>(s2[j]);
				this.addAfter(nuevo);
				j++;
			}
		} else if (terminadoS2 && !terminadoS1) {
			while (i < s1.length) {
				DoubleNode<String> nuevo = new DoubleNode<String>(s1[i]);
				this.addAfter(nuevo);
				i++;
			}
		}
		else if (terminadoS1 && terminadoS2) {}
	}
	
	private void addAfter(DoubleNode<String> nuevo) {
		DoubleNode<String> ult = null;
		
		if (this.first == null) {
			nuevo.prev = this.first;
			nuevo.next = nuevo;
		}
		else if (this.first != null) {
			ult = this.first.prev;
			
			nuevo.prev = ult;
			nuevo.next = this.first;
			ult.next = nuevo;
			this.first.prev = nuevo;
		}
	}
}
