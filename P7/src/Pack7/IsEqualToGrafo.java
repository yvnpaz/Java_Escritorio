package Pack7;

import java.util.Iterator;

import grafo.Arco;
import grafo.Grafo;
import grafo.Vertice;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

public class IsEqualToGrafo<E, T> extends TypeSafeMatcher<Grafo<E, T>> {
	private Grafo<E, T> expected;
	
	public IsEqualToGrafo(Grafo<E, T> expected) {
		this.expected = expected;
	}

	@Override
	public void describeTo(Description desc) {
		desc.appendText("Grafos distintos");
	}

	@Override
	protected boolean matchesSafely(Grafo<E, T> actual) {
		
		Iterator<Arco<E,T>> arc = actual.arcos();
		
		while (arc.hasNext()) {
			Iterator<Arco<E,T>> arcExpected = expected.arcos();
			boolean continuar = true;
			Arco<E,T> a1 = arc.next();
            Vertice<E> w1 = a1.getDestino();
            Vertice<E> v1 = a1.getOrigen();
			
			while (arcExpected.hasNext() && continuar){
			    Arco<E,T> a2 = arcExpected.next();
			    Vertice<E> w2 = a1.getDestino();
			    Vertice<E> v2 = a1.getOrigen(); 
			    
			    if (a1.getEtiqueta().equals(a2.getEtiqueta()) && w1.equals(w2) && v1.equals(v2)) 
			    	continuar = false;
            }
			
			if (continuar) 
					return false;
			}

		// Se comprueba en el otro sentido para garantizar que tienen exactamente los mismos arcos y no más
		arc = expected.arcos();
		
		while (arc.hasNext()) {
			Iterator<Arco<E,T>> arcActual = actual.arcos();
			boolean continuar = true;
			Arco<E,T> a1 = arc.next();
            Vertice<E> w1 = a1.getDestino();
            Vertice<E> v1 = a1.getOrigen();
			
			while (arcActual.hasNext() && continuar){
			    Arco<E,T> a2 = arcActual.next();
			    Vertice<E> w2 = a1.getDestino();
			    Vertice<E> v2 = a1.getOrigen(); 
			    
			    if (a1.getEtiqueta().equals(a2.getEtiqueta()) && w1.equals(w2) && v1.equals(v2)) 
			    	continuar = false;
            }
			
			if (continuar) 
					return false;
			}
		return true;
	}

	@Factory
	public static <E, T> IsEqualToGrafo<E, T> equalToGrafo(Grafo<E, T> expected) {
		return new IsEqualToGrafo<E, T>(expected);
	}
}
