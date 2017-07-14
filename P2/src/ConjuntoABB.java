import arbolBusqueda.*;

public class ConjuntoABB<E extends Comparable<E>> implements Conjunto<E> {
	
	private ArbolBusqueda<E> elementos;
	
	public ConjuntoABB()
	{
		elementos = new ArbolBinarioBusqueda<>();
	}

	private int cuentaNodos(ArbolBusqueda<E> a)
	{
		if(a.esVacio())
			return 0;
		else
			return 1 + cuentaNodos(a.hijoIzq()) + cuentaNodos(a.hijoDer());
	}
	
	public int cardinal()
	{
		return cuentaNodos(elementos);
	}
	
	@Override
	public boolean pertenece(E x) {
		return elementos.buscar(x);
	}
	
	public boolean perteneceArbol(ArbolBusqueda<E> elementos, E e)
	{
		if(elementos.esVacio())
			return false;
		else{
			if(elementos.raiz().equals(e))
				return true;
			else
				return false;
		}
	}

	@Override
	public boolean inserta(E x) {
		// TODO Auto-generated method stub
		if(pertenece(x))
			return false;
		else
			elementos.insertar(x);
		return true;
		
	}
	
//	public boolean insertaArbol(ArbolBusqueda<E> arbol, E e)
//	{
//		if(pertenece(e))
//			return false;
//		else{
//			arbol.insertar( e );
//			return true;
//		}
//	}

	@Override
	public boolean elimina(E x) {
		if(!pertenece(x))
			return false;
		else{
			elementos.eliminar(x);
		}
		return true;
	}

//	public boolean eliminaArbol( ArbolBusqueda<E> arbol , E e)
//	{
//		if(!pertenece(e))
//			return false;
//		else{
//			arbol.eliminar( e );
//			return true;
//		}
//	}
	
	@Override
	public E elige() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(elementos.esVacio())
			throw new IllegalArgumentException("Arbol vacio.");
		else
			return elementos.raiz();
	}
	
//	public E eligeArbol(ArbolBusqueda<E> arbol, E e) throws IllegalArgumentException
//	{
//		if( arbol.esVacio() )
//			return null;
//		else
//			return arbol.raiz();
//	}

	@Override
	public Conjunto<E> union(Conjunto<E> conj) {
		
		Conjunto<E> aux = new ConjuntoABB<>();
		Conjunto<E> toret = new ConjuntoABB<>();
		
		while(this.cardinal() != 0){
			E elemento = this.elige();
			this.elimina(elemento);
			
			toret.inserta(elemento);
			aux.inserta(elemento);		
		}
		
		//devuelve los elementos a this (opcional)
		while(aux.cardinal() != 0){
			E elemento = aux.elige();
			//conj.elimina(elemento);
			
			aux.elimina(elemento);
			this.inserta(elemento);
		}
		
		while(conj.cardinal() != 0)
		{
			E elemento = conj.elige();
			conj.elimina(elemento);
			
			toret.inserta(elemento);
			aux.inserta(elemento);
		}
		
		//devuelve los elementos a conj (opcional)
		while(aux.cardinal() != 0){
			E elemento = aux.elige();
			
			aux.elimina(elemento);
			conj.inserta(elemento);
		}
		return toret;
	}

	@Override
	public Conjunto<E> interseccion(Conjunto<E> conj) {
		// TODO Auto-generated method stub
		Conjunto<E> aux = new ConjuntoABB<>();
		Conjunto<E> toret = new ConjuntoABB<>();
		
		while( this.cardinal() != 0 )
		{
			E elemento = this.elige();
			
			this.elimina(elemento);
			if(conj.pertenece( elemento ))
				toret.inserta( elemento );
			aux.inserta( elemento );
		}
		
		while(aux.cardinal() != 0){
			E elemento = aux.elige();
			
			this.inserta(elemento);
			aux.elimina(elemento);
		}
		return toret;
	}

	@Override
	public Conjunto<E> diferencia(Conjunto<E> conj) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Conjunto<E> aux = new ConjuntoABB<>();
		Conjunto<E> toret = new ConjuntoABB<>();
		
		while( this.cardinal() != 0 )
		{
			E elemento = this.elige();
			
			this.elimina(elemento);
			if(!conj.pertenece( elemento ))
				toret.inserta( elemento );
			aux.inserta( elemento );
		}
		
		while(aux.cardinal() != 0){
			E elemento = aux.elige();
			
			this.inserta(elemento);
			aux.elimina(elemento);
		}
		return toret;
	}
	
	private void recorrer(ArbolBusqueda<E> arbol, Conjunto<E> conj)
	{
		//Mete los elementos del árbol en el conjunto conj
		if(!arbol.esVacio()){
			conj.inserta( arbol.raiz() );
			recorrer(arbol.hijoIzq(), conj);
			recorrer(arbol.hijoDer(), conj);
		}
	}
	
	public Conjunto<E> unionArbol(ConjuntoABB<E> conj)
	{
		Conjunto<E> conjUnion = new ConjuntoABB<>();
		recorrer(this.elementos, conjUnion);
		recorrer(((ConjuntoABB<E>)conj).elementos, conjUnion);
		return conjUnion;
	}
	
	private void recorrer2(ArbolBusqueda<E> a1, ArbolBusqueda<E> a2, Conjunto<E> conj)
	{
		//Mete en conj los elementos de a1 que estén en a2
		if( !a1.esVacio() )
		{
			if(a2.buscar(a1.raiz()))
				conj.inserta( a1.raiz() );
			recorrer2(a1.hijoIzq(), a2, conj);
			recorrer2(a1.hijoDer(), a2, conj);
		}
	}
	
	
	public Conjunto<E> interArbol(ConjuntoABB<E> conj)
	{
		Conjunto<E> conjInt = new ConjuntoABB<>();
		
		recorrer2(this.elementos,((ConjuntoABB<E>)conj).elementos, conjInt);
		return conjInt;
	}
	
	
	private void recorrerDif(ArbolBusqueda<E> a1, ArbolBusqueda<E> a2, Conjunto<E> conj)
	{
		//Mete en conj los elementos de a1 que estén en a2
		if( !a1.esVacio() )
		{
			if(!a2.buscar(a1.raiz()))
				conj.inserta( a1.raiz() );
			recorrerDif(a1.hijoIzq(), a2, conj);
			recorrerDif(a1.hijoDer(), a2, conj);
		}
	}
	
	public Conjunto<E> difArbol(ConjuntoABB<E> conj)
	{
		Conjunto<E> conjDif = new ConjuntoABB<>();
		
		recorrer2(this.elementos,((ConjuntoABB<E>)conj).elementos, conjDif);
		return conjDif;
	}
	
	
}
