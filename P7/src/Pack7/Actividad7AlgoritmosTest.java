package Pack7;

import grafo.Arco;
import grafo.Grafo;
import grafo.ListaAdyacencia;
import grafo.Vertice;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static Pack7.IsEqualToGrafo.equalToGrafo;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.collection.IsMapContaining.hasEntry;

public class Actividad7AlgoritmosTest {
	
	private static Grafo<Integer, Integer> g1; 
	
	private static Vertice<Integer> uno = new Vertice<Integer>(1);
	private static Vertice<Integer> dos = new Vertice<Integer>(2);
	private static Vertice<Integer> tres = new Vertice<Integer>(3);
	private static Vertice<Integer> cuatro = new Vertice<Integer>(4);
	private static Vertice<Integer> cinco = new Vertice<Integer>(5);
	private static Vertice<Integer> seis = new Vertice<Integer>(6);
    
	private static void rellenarGrafoG(){
			g1 = new ListaAdyacencia<Integer, Integer>();
			g1.insertarArco(new Arco<Integer,Integer>(uno,dos,3));
	        g1.insertarArco(new Arco<Integer,Integer>(uno,seis,5));
	        g1.insertarArco(new Arco<Integer,Integer>(dos,tres,7));
	        g1.insertarArco(new Arco<Integer,Integer>(dos,seis,10));
	        g1.insertarArco(new Arco<Integer,Integer>(seis,tres,8));
	        g1.insertarArco(new Arco<Integer,Integer>(seis,cuatro,2));
	        g1.insertarArco(new Arco<Integer,Integer>(tres,cuatro,5));
	        g1.insertarArco(new Arco<Integer,Integer>(tres,cinco,1));
	        g1.insertarArco(new Arco<Integer,Integer>(cuatro,cinco,6)); 
	        // Añado los arcos en el otro sentido, hace falta para el problema del viajante
	        g1.insertarArco(new Arco<Integer,Integer>(dos,uno,3));
	        g1.insertarArco(new Arco<Integer,Integer>(seis,uno,5));
	        g1.insertarArco(new Arco<Integer,Integer>(tres,dos,7));
	        g1.insertarArco(new Arco<Integer,Integer>(seis,dos,10));
	        g1.insertarArco(new Arco<Integer,Integer>(tres,seis,8));
	        g1.insertarArco(new Arco<Integer,Integer>(cuatro,seis,2));
	        g1.insertarArco(new Arco<Integer,Integer>(cuatro,tres,5));
	        g1.insertarArco(new Arco<Integer,Integer>(cinco,tres,1));
	        g1.insertarArco(new Arco<Integer,Integer>(cinco,cuatro,6));
	}
	@Before
	public void setUp() throws Exception {
		rellenarGrafoG();
	}
	@After
	public void tearDown() throws Exception {
	}
	
	
	//Ejercicio 6
	@Test
	public void grafoViajanteTest() {
		Grafo<Integer, Integer> grafoActual = Actividad7.viajante(g1, uno);
		Grafo<Integer, Integer> grafoEsperado = new ListaAdyacencia<Integer,Integer>();
		
		Vertice<Integer> v1 = new Vertice<Integer>(1);
		Vertice<Integer> v2 = new Vertice<Integer>(2);
		Vertice<Integer> v3 = new Vertice<Integer>(3);
		Vertice<Integer> v4 = new Vertice<Integer>(4);
		Vertice<Integer> v5 = new Vertice<Integer>(5);
		Vertice<Integer> v6 = new Vertice<Integer>(6);
	    
		grafoEsperado.insertarArco(new Arco<Integer, Integer>(v1, v2, 3));
		grafoEsperado.insertarArco(new Arco<Integer, Integer>(v2, v3, 7));
		grafoEsperado.insertarArco(new Arco<Integer, Integer>(v3, v5, 1));
		grafoEsperado.insertarArco(new Arco<Integer, Integer>(v5, v4, 6));
		grafoEsperado.insertarArco(new Arco<Integer, Integer>(v4, v6, 2));
		
		
		assertThat(grafoActual, is(equalToGrafo(grafoEsperado)));
	}
	
	//Ejercicio 7
		@Test
		public void grafoPrimTest() {
			Grafo<Integer, Integer> grafoActual = Actividad7.prim(g1, seis);
			Grafo<Integer, Integer> grafoEsperado = new ListaAdyacencia<Integer,Integer>();
			
			Vertice<Integer> v1 = new Vertice<Integer>(1);
			Vertice<Integer> v2 = new Vertice<Integer>(2);
			Vertice<Integer> v3 = new Vertice<Integer>(3);
			Vertice<Integer> v4 = new Vertice<Integer>(4);
			Vertice<Integer> v5 = new Vertice<Integer>(5);
			Vertice<Integer> v6 = new Vertice<Integer>(6);
		    
			grafoEsperado.insertarArco(new Arco<Integer, Integer>(v6, v4, 2));
			grafoEsperado.insertarArco(new Arco<Integer, Integer>(v6, v1, 5));
			grafoEsperado.insertarArco(new Arco<Integer, Integer>(v1, v2, 3));
			grafoEsperado.insertarArco(new Arco<Integer, Integer>(v4, v3, 5));
			grafoEsperado.insertarArco(new Arco<Integer, Integer>(v3, v5, 1));
			
			
			assertThat(grafoActual, is(equalToGrafo(grafoEsperado)));
		}
		
		//Ejercicio 8
		@Test
		public void dijkstraTest() {
			Map<Vertice<Integer>, Integer> grafoActual = Actividad7.dijkstra(g1, uno);
					
			assertThat(grafoActual, allOf(
							hasEntry(new Vertice<Integer>(1),0),
							hasEntry(new Vertice<Integer>(2),3),
							hasEntry(new Vertice<Integer>(3),10),
							hasEntry(new Vertice<Integer>(4),7),
							hasEntry(new Vertice<Integer>(5),11),
							hasEntry(new Vertice<Integer>(6),5)
						));

				}
	
}
