package Pack7;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import grafo.*;
import java.util.Map;

public class Actividad7 {

	
	/*
	 * 0. //Produce: devuelve un iterador sobre los predecesores del vértice v en el grafo g. Se dice
	 * que w es predecesor del vértice v si existe un arco que tenga por origen w y por destino
	 * v, es decir, el arco (w,v) pertenece al conjunto de arcos del grafo. 
	 */
	public static <E,T> Iterator<Vertice<E>> predecesores(Grafo <E,T> g, Vertice<E> v)
	{
		Vector<Vertice<E>> pred = new Vector<Vertice<E>>();
		Iterator<Vertice <E>> itv = g.vertices();
		while (itv.hasNext()){
			Vertice<E> w = itv.next();
			Iterator<Vertice<E>> it2 = g.adyacentes(w);
			while (it2.hasNext()){
				if (it2.next().equals(v))
					pred.add(w);
			}
		}
		return pred.iterator();
	}
	
	/*
	 * 1. Escribe un método que dado un grafo y un vértice, determine si ese vértice es pozo o
	 * sumidero. Un vértice se dice sumidero si su grado de entrada es n-1 y su grado de salida
	 * es 0. |V| = n, es decir, n es el número de vértices del grafo.
	 */
	
	public static <E,T> boolean sumidero(Grafo<E,T> g, Vertice<E> v)
	{
		Iterator<Vertice<E>> itrVert = g.vertices();
		int numVertices=0;
		while(itrVert.hasNext())
		{
			numVertices++;
			itrVert.next();
		}
		
		//saber predecesores
		Iterator<Vertice<E>> itrPred = predecesores(g,v);
		int numPred = 0;
		while(itrPred.hasNext())
		{
			numPred++;
			itrPred.next();
		}
		//saber adyacentes
		int numAdya = 0;
		Iterator<Vertice<E>> itrAdya = g.adyacentes(v);
		while(itrAdya.hasNext())
		{
			numAdya++;
			itrAdya.next();
		}
		
		return (numVertices-1 == numPred && numAdya == 0) ? true : false;
		
	}
	
	/*
	 * 3. Escribe un método que devuelva cierto si un grafo es regular. 
	 * Un grafo es regular si todos sus vértices tienen el mismo número de vertices adyacentes
	 */
	
	public static <E,T> boolean regular(Grafo<E,T> g)
	{
		if(g.esVacio())
			return true;
		
		Iterator<Vertice<E>> itrVert = g.vertices();
		Vertice<E> vert = itrVert.next();
		Iterator<Vertice<E>> itrAdya = g.adyacentes(vert);
		
		int numAdy = 0;
		while(itrAdya.hasNext())
		{
			numAdy++;
			itrAdya.next();
		}
		
		while(itrVert.hasNext())
		{
			Vertice<E> v = itrVert.next();
			itrAdya = g.adyacentes(v);
			//para cada nuevo vertice se empieza a contar sus adyacentes
			int numVertices = 0;
			while(itrAdya.hasNext())
			{
				numVertices++;
				itrAdya.next();
			}
			return numVertices!=numAdy ? false : true;
		}
		return false;
	}
	
	/*
	 * 4. Escribe un método que dado un grafo dirigido y dos vértices devuelva cierto si existe un
	 * camino simple de un vértice a otro. 
	 */
	public static <E,T> boolean hayCaminoEntreDos (Grafo<E,T> g, Vertice<E> v1, Vertice<E> v2){
        Vector<Vertice<E>> visitados = new Vector<Vertice<E>>();
        return caminoEntreDos(g,v1,v2,visitados);
    }
	
	private static <E,T> boolean caminoEntreDos (Grafo<E,T> g,Vertice<E> v1, Vertice<E> v2, Vector<Vertice<E>> visitados){
        boolean encontrado=false;
        visitados.add(v1);
        if (v1.equals(v2))
            return true;
        else {
            Iterator<Vertice<E>> adys = g.adyacentes(v1);
            while (adys.hasNext()&& !encontrado){
                Vertice<E> w = adys.next();
                if (!visitados.contains(w))
                  encontrado = caminoEntreDos(g, w, v2, visitados);
            }
           return encontrado;
        }
    }
	
	/*
	 * 5. Escribe un método que dado un grafo g y un vértice v de dicho grafo, nos devuelva un
	 * iterador sobre los vértices no alcanzables desde v, es decir, los vértices para los que no
	 * hay ningún camino desde v.
	 */
	public static <E,T> Iterator<Vertice<E>> noAlcanzables(Grafo<E,T> g, Vertice<E> v){
		
		
		Vector<Vertice<E>> vertices = new Vector<>();
		
		Iterator<Vertice<E>> itrvert = g.vertices();
		while(itrvert.hasNext())
		{
			Vertice<E> vert = itrvert.next();
				if(!v.equals(vert))
				{
					if(!hayCaminoEntreDos(g, v, vert))
					{
						vertices.add(vert);
					}
			}
		}
		return vertices.iterator();
	}
	
	/*
	 * 6. Algoritmo del Viajante. Consideremos un mapa de carreteras, con dos tipos de
	 * componentes: las ciudades (nodos) y las carreteras que las unen. Cada tramo de
	 * carreteras (arco) está señalado con su longitud. “Un viajante debe recorrer una serie de
	 * ciudades interconectadas entre sí, de manera que recorra todas ellas con el menor número
	 * de kilómetros posible”
	 */
    public static<E extends Comparable<E>> Grafo<E,Integer> viajante(Grafo<E,Integer> g, Vertice<E> v)
    {
     Vertice<E> nodoActual = v;
     Vector<E> porVisitar = new Vector<E>(); 
     Grafo<E,Integer> solucion = new ListaAdyacencia<E,Integer>();
     
     Iterator<Vertice<E>> it_v = g.vertices();
     
     while (it_v.hasNext())
     {
         Vertice<E> vert = it_v.next();
         porVisitar.add(vert.getEtiqueta());
     }
     
     porVisitar.remove(nodoActual.getEtiqueta());
     
     boolean continuar = true;
        
     while (!porVisitar.isEmpty() && continuar)
     {
           Arco<E,Integer> u = minimo(g.arcos(),nodoActual,porVisitar);
           if (u != null)
           {
                porVisitar.remove(u.getDestino().getEtiqueta());
                solucion.insertarArco(u);
                nodoActual = u.getDestino();
            }
           else continuar = false;
     }
     return solucion;   
    } 
    
    private static <E extends Comparable<E>> Arco<E,Integer> minimo (Iterator<Arco<E,Integer>> arc, Vertice<E> v, Vector<E> iPorVisitar)
    {
         int dist_v_min= 0;
         int min = Integer.MAX_VALUE;
         Arco<E,Integer> arco_min = null;
         while (arc.hasNext()) {
                  Arco<E,Integer> a1 = arc.next();
                  E w = a1.getDestino().getEtiqueta();
                  if (a1.getOrigen().equals(v) && iPorVisitar.contains(w))
                  {
                            dist_v_min = a1.getEtiqueta();   
                            if ( dist_v_min < min)
                            {
                               arco_min = a1;
                               min = dist_v_min;
                            }
                                   
                   } 
         } 
        return arco_min;
        
    } 
    
    /*
     * 7. Algoritmo de Prim. Es un algoritmo perteneciente a la teoría de los grafos para
	 * encontrar un árbol recubridor mínimo en un grafo conexo, no dirigido y cuyas
	 * aristas están etiquetadas. 
     */
	    public static<E extends Comparable<E>> Grafo<E,Integer> prim(Grafo<E,Integer> g, Vertice<E> v)
	    {
	     Vector<E> porVisitar = new Vector<E>();
	     Vector<E> visitados = new Vector<E>();
	     Grafo<E,Integer> solucion = new ListaAdyacencia<E,Integer>();
	     
	     Iterator<Vertice<E>> it_v = g.vertices();
	     
	     while (it_v.hasNext())
	     {
	         Vertice<E> vert = it_v.next();
	         porVisitar.add(vert.getEtiqueta());
	     }
	     
	     porVisitar.remove(v.getEtiqueta());
	     visitados.add(v.getEtiqueta());
	                
	     while (!porVisitar.isEmpty())
	     {
	           Arco<E,Integer> u = minimo(g.arcos(),porVisitar,visitados);
	           E w = u.getDestino().getEtiqueta();
	           porVisitar.remove(w);
	           visitados.add(w);
	           solucion.insertarArco(u);
	     }
	     return solucion;   
	    } 
	    
	    
	   private static <E extends Comparable<E>> Arco<E,Integer> minimo (Iterator<Arco<E,Integer>> arc, Vector<E> iPorVisitar, Vector<E> iVisitados)
	    {
	         int dist_v_min= 0;
	         int min = Integer.MAX_VALUE;
	         Arco<E,Integer> arco_min = null;
	         
	         while (arc.hasNext()) {
	                     Arco<E,Integer> a1 = arc.next();
	                     E w = a1.getDestino().getEtiqueta();
	                     E v = a1.getOrigen().getEtiqueta();
	                     if (iVisitados.contains(v) && iPorVisitar.contains(w))
	                     {
	                            dist_v_min = a1.getEtiqueta();   
	                            if ( dist_v_min < min)
	                            {
	                               arco_min = a1;
	                               min = dist_v_min;
	                            }
	                                   
	                     } 
	                  }
	                
	        return arco_min;
	        
	    }  
    
	/*
	 * 8. Escribe el algoritmo de Dijkstra, también llamado algoritmo de caminos mínimos.
	 */
	private static <E> int distDosVertices(Grafo<E, Integer> g, Vertice<E> v1, Vertice<E> v2)
	{
		Iterator<Arco<E,Integer>> itrVert = g.arcos();
		int valorEtiqueta = 0;
		while(itrVert.hasNext())
		{
			Arco<E,Integer> itrVertice = itrVert.next();
			if(itrVertice.getOrigen().equals(v1) && itrVertice.getDestino().equals(v2))
			{
				valorEtiqueta = itrVertice.getEtiqueta();
			}
		}
		return valorEtiqueta;
		
	}
	public static <E> Map<Vertice<E>, Integer> dijkstra(Grafo<E, Integer> g, Vertice<E> v)
	{
		
		//declarar una estructura map, para almacenar distancias minimas
		
		Map<Vertice<E>,Integer> mapa = new HashMap<Vertice<E>, Integer>();
		
		//declarar una estructura que alamacena los vertices porVisitar: Set, Vector ,...
		
		Vector<Vertice<E>> porVisitar = new Vector<Vertice<E>>();
		
		//inicializar el map con 0 e infinito (Integer_MAX_VALUE)
		
		Iterator<Vertice<E>> itrVertice = g.vertices();
		
		while(itrVertice.hasNext()){
			
			Vertice<E> verItr = itrVertice.next();
			
			if(verItr.equals(v)){
				mapa.put(verItr, 0);
			}
			else{
				
				mapa.put(verItr, Integer.MAX_VALUE);
			}
		
			porVisitar.add(verItr);
		}
		
		while(!porVisitar.isEmpty()){
			
			Vertice<E> vMin = distMinimo(mapa,porVisitar.iterator());
			int disMin  = mapa.get(vMin);
			mapa.remove(disMin);
			
			if(disMin != Integer.MAX_VALUE)
			{
				Iterator<Vertice<E>> itrV = g.adyacentes(vMin);
				while(itrV.hasNext()){
					Vertice<E> vertice = itrV.next();
					disMin = distDosVertices(g,vMin,vertice);
				}
			}
		}
		return mapa;
	}
	
	
	
	
	private static <E> Vertice<E> distMinimo(Map<Vertice<E>,Integer> mapa, Iterator<Vertice<E>> it){
		
		Vertice<E> vDistMinimo = null;
		int min = Integer.MAX_VALUE;
		while(it.hasNext()){
			
			Vertice<E> vDistMinimo2 = it.next();
			Integer disMin = mapa.get(vDistMinimo2);
			
			//it.remove(vDistMinimo);
			
			if(disMin < min){
				
				min =disMin;
				vDistMinimo = vDistMinimo2 ;
				
			}
			
		}
		
		return vDistMinimo;
		
	}
	
}
