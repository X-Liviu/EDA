package practicas.Practica2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaPalabrasTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testListaPalabras() {
		//ListaPalabras l1 = new ListaPalabras();
	}

	@Test
	void getPalabras() {
		//Metodo getter, solo lo usamos para las JUnit
	}

	@Test
	void testLeerPalabras() {

		//Leer palabras de un fichero que no existe
		//Leer palabras de un fichero vacio
		//Leer palabras de un fichero que existe pero solo tiene 1 palabra
		//Leer palabras de un fichero que existe y tiene varias palabras

		//La excepción se trata en la clase TodasLasPalabras


		//Leer palabras de un fichero que no existe
		ListaPalabras l1 = new ListaPalabras();
		try {
			l1.leerPalabras("ficheroInexistente");
			fail("El programa ha fallado");

		}
		catch(FileNotFoundException fnfe) {
			System.out.println("El fichero no existe, con lo cual, este caso funciona");
		}

		//Leer palabras de un fichero vacio
		ListaPalabras l2 = new ListaPalabras();
		try {
			l2.leerPalabras("ficheroVacio.txt");
			System.out.println("Se ha leido correctamente");
			assertEquals(l2.getPalabras().toString(),"DoubleLinkedList:[]");

		}
		catch(FileNotFoundException fnfe) {
			fail("El programa ha fallado");
		}


		//Leer palabras de un fichero que existe pero solo tiene 1 palabra
		ListaPalabras l3 = new ListaPalabras();
		try {
			l3.leerPalabras("fichero1Palabra.txt");
			System.out.println("Se ha leido correctamente");
			assertEquals(l3.getPalabras().toString(),"DoubleLinkedList:[(hola)]");

		}
		catch(FileNotFoundException fnfe) {
			fail("El programa ha fallado");
		}

		//Leer palabras de un fichero que existe y tiene varias palabras
		ListaPalabras l4 = new ListaPalabras();
		try {
			l4.leerPalabras("ficheroVariasPalabras.txt");
			System.out.println("Se ha leido correctamente");
			assertEquals(l4.getPalabras().toString(),"DoubleLinkedList:[(hola)(adios)(jamon)(tortilla)]");

		}
		catch(FileNotFoundException fnfe) {
			fail("El programa ha fallado");
		}


	}

	@Test
	void testWeb2words() {

		//En teoria solo se pide el método word2Webs, este método sale en el enunciado pero no se pide

		//Web que no contiene ninguna palabra del fichero
		//Web que contiene 1 palabra del fichero
		//Web que contien varias palabras del fichero

		//Web que no contiene ninguna palabra del fichero 
		try {
			ListaPalabras l1 = new ListaPalabras();
			l1.leerPalabras("words.txt");
			assertEquals(l1.web2words("").toString(),"[, ]");


		}
		catch(FileNotFoundException fnfe) {
			fail("El programa ha fallado");
		}

		//Web que contiene 1 palabra del fichero
		try {
			ListaPalabras l2 = new ListaPalabras();
			l2.leerPalabras("words.txt");
			assertEquals(l2.web2words("z").toString(),"[, , z]");


		}
		catch(FileNotFoundException fnfe) {
			fail("El programa ha fallado");
		}

		//Web que contien varias palabras del fichero
		try {
			ListaPalabras l3 = new ListaPalabras();
			l3.leerPalabras("words.txt");
			assertEquals(l3.web2words("ultimate.es").toString(),"[a, at, ate, e, es, , i, im, l, lt, m, ma, mat, mate, s, t, te, ti, tim, u, ult, ultima, ultimate, ]");


		}
		catch(FileNotFoundException fnfe) {
			fail("El programa ha fallado");
		}

	}

}
