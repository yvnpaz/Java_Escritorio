/**
 * @author yvanp
 *
 */
package Pack7;

import grafo.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestActividad7 {
	
	private static Grafo<String, Integer> g; 
	private static Grafo<String, Integer> gVacio = new ListaAdyacencia<String, Integer>();
	
	private static Vertice<String> v1 = new Vertice<String>("Coruña");
	private static Vertice<String> v2 = new Vertice<String>("Lugo");
	private static Vertice<String> v3 = new Vertice<String>("Ourense");
	private static Vertice<String> v4 = new Vertice<String>("Pontevedra");
    
	private static void rellenarGrafoG(){
			g = new ListaAdyacencia<String, Integer>();
			g.insertarArco(new Arco<String, Integer>(v2, v1, 10));
		    g.insertarArco(new Arco<String, Integer>(v1, v3, 20));
		    g.insertarArco(new Arco<String, Integer>(v2, v4, 115));
		    g.insertarArco(new Arco<String, Integer>(v3, v4, 100));
		    g.insertarArco(new Arco<String, Integer>(v2, v3, 100));
		    g.insertarArco(new Arco<String, Integer>(v4, v2, 120));
		    g.insertarArco(new Arco<String, Integer>(v4, v3, 120));
	}
	@Before
	public void setUp() throws Exception {
		rellenarGrafoG();
	}
	@After
	public void tearDown() throws Exception {
	}
	
	//ejercicio 1
	@Test
	public void predecesoresTest(){
		Iterator<Vertice<String>> itPred = Actividad7.predecesores(g, v4);
		List<String> result = new ArrayList<>();
		while (itPred.hasNext()) {
			result.add(itPred.next().getEtiqueta());
		}
		List<String> expResult = new ArrayList<>();
		expResult.add("Lugo");
		expResult.add("Ourense");
		assertArrayEquals(expResult.toArray(), result.toArray());
	}

	//ejercicio 2
	@Test
	public void sumideroVacioTest(){
		boolean eq = Actividad7.sumidero(gVacio,v3);
		assertFalse("Sumidero " +v3+ "?:  true  (false) " ,eq);
	}
	
	@Test
	public void noSumideroTest(){
		boolean eq = Actividad7.sumidero(g,v3);
		assertFalse("Sumidero " +v3+ "?:  true  (false) " ,eq);
	}
	@Test
	public void siSumideroTest(){
		g.eliminarArco(new Arco<String,Integer>(v3,v4, 100));
		boolean eq = Actividad7.sumidero(g,v3);
		assertTrue("Sumidero " +v3+ "?:  (true)  false " ,eq);
	}
	
//	//ejercicio 3
	@Test
	public void regularVacioTest(){
		boolean eq = Actividad7.regular(gVacio);
		assertTrue("Regular " +v3+ "?:  (true)  false " ,eq);
	}
	@Test
	public void noRegularTest(){
		boolean eq = Actividad7.regular(g);
		assertFalse("Regular " +v3+ "?:  true  (false) " ,eq);
	}
	@Test
	public void siRegularTest(){
		g.eliminarArco(new Arco<String,Integer>(v2,v4, 115));
		g.insertarArco(new Arco<String,Integer>(v1, v4, 200));
		g.insertarArco(new Arco<String,Integer>(v3, v1, 120));
		boolean eq = Actividad7.regular(g);
		assertTrue("Regular " +v3+ "?:  (true)  false " ,eq);
	}
	
	//ejercicio 4
	@Test
	public void caminoVacioTest(){
		boolean eq = Actividad7.hayCaminoEntreDos(gVacio, v1, v2);
		assertFalse("Regular " +v3+ "?:  true  (false) " ,eq);
	}
	@Test
	public void noCaminoTest(){
		g.eliminarArco(new Arco<String,Integer>(v2, v1, 100));
		g.insertarArco(new Arco<String,Integer>(v1, v2, 200));
		boolean eq = Actividad7.hayCaminoEntreDos(g,v4,v1);
		assertFalse("Regular " +v3+ "?:  true  (false) " ,eq);
	}
	@Test
	public void siCaminoTest(){
		boolean eq = Actividad7.hayCaminoEntreDos(g, v4, v1);
		assertTrue("Regular " +v3+ "?:  (true)  false " ,eq);
	}
	
	//ejercicio 5
	@Test
	public void noAlcanzableTest(){
		g.eliminarArco(new Arco<String,Integer>(v2, v1, 100));
		Iterator<Vertice<String>> itV = Actividad7.noAlcanzables(g, v3);
		List<String> result = new ArrayList<>();
		while (itV.hasNext()) {
			result.add(itV.next().getEtiqueta());
		}
		List<String> expResult = new ArrayList<>();
		expResult.add("Coruña");
		assertArrayEquals(expResult.toArray(), result.toArray());
	}
	
	
}
