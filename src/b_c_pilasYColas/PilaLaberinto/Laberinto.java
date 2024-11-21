package b_c_pilasYColas.PilaLaberinto;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

public class Laberinto {

	private int[][] laberinto = 
			   {{1,1,1,0,0,1,0},
				{1,1,0,1,0,1,0},
				{0,1,0,1,1,1,1},
				{1,1,1,0,1,0,0},
				{0,0,1,1,1,0,1},
				{1,0,0,0,1,0,1},
				{1,1,1,1,1,0,0},
				{1,0,0,0,0,1,1},
				{1,1,1,1,1,1,1}};

	public boolean haySalida(){
		Casilla inicio = new Casilla(0, 0);
		Casilla fin = new Casilla(laberinto.length - 1, laberinto[0].length - 1);

		Stack<Casilla> porExaminar = new Stack<Casilla>();
		ArrayList<Casilla> examinados = new ArrayList<Casilla>();
		porExaminar.add(inicio);
		laberinto[0][0] = 8; // indica que ha sido "marcada"

		boolean encontrado = false;
		porExaminar.push(inicio);
		examinados.add(inicio);

		while (!encontrado && !porExaminar.isEmpty()){
			Casilla act = porExaminar.pop();

			if (act.equals(fin)) {
				encontrado = true;
			}
			else {
				if (act.fila - 1 >= 0 && act.fila - 1 < laberinto.length && act.columna >= 0 && act.columna < laberinto[0].length 
					&& laberinto[act.fila][act.columna] == 1 && !examinados.contains(act)) {
					
					Casilla nuevo = new Casilla(act.fila - 1, act.columna - 1);
					porExaminar.push(nuevo);
					examinados.add(nuevo);
				}
				else if (act.fila >= 0 && act.fila < laberinto.length && act.columna + 1 >= 0 && act.columna + 1 < laberinto[0].length 
						&& laberinto[act.fila][act.columna] == 1 && !examinados.contains(act)) {
					
					Casilla nuevo = new Casilla(act.fila - 1, act.columna);
					porExaminar.push(nuevo);
					examinados.add(nuevo);
				}
				else if (act.fila >= 0 && act.fila < laberinto.length && act.columna - 1 >= 0 && act.columna - 1 < laberinto[0].length 
						&& laberinto[act.fila][act.columna] == 1 && !examinados.contains(act)){
					
					Casilla nuevo = new Casilla(act.fila, act.columna - 1);
					porExaminar.push(nuevo);
					examinados.add(nuevo);
				}
				else if (act.fila + 1 >= 0 && act.fila + 1 < laberinto.length && act.columna >= 0 && act.columna < laberinto[0].length 
						&& laberinto[act.fila][act.columna] == 1 && !examinados.contains(act)) {
					
					Casilla nuevo = new Casilla(act.fila + 1, act.columna);
					porExaminar.push(nuevo);
					examinados.add(nuevo);
				} 
			}
		}
		return encontrado;
	}



	public void print(){
		for (int i = 0; i < laberinto.length; i++){
			for (int j = 0; j < laberinto[0].length; j++){
				System.out.print(laberinto[i][j]);
			}
			System.out.println();
		}
	}
	public String toString() {
		return "Laberinto [laberinto=" + Arrays.toString(laberinto) + "]";
	}

	public static void main(String[] args) {
		Laberinto l = new Laberinto();
		l.haySalida();
		System.out.print(l.haySalida());
		
	}
}

