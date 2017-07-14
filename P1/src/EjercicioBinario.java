import arbolBinario.*;
import arbolGeneral.EnlazadoArbolGeneral;
public class EjercicioBinario {

	public static <E> void preorden(ArbolBinario<E> a)
	{
		if(!a.esVacio())
		{
			System.out.print(a.raiz()+" ");
			preorden(a.hijoIzq());
			preorden(a.hijoDer());
		}
	}
	
	public static <E> int numNodos(ArbolBinario<E> a)
	{
		if(a.esVacio())
			return 0;
		else
			return 1 + numNodos(a.hijoDer()) + numNodos(a.hijoIzq());
	}
	
	public static <E> int numHojas(ArbolBinario<E> a)
	{
		if(a.esVacio())
		{
			return 0;
		}
		else if(a.hijoDer().esVacio() && a.hijoIzq().esVacio())
		{
			return 1;
		}
		else
			return numHojas(a.hijoDer()) + numHojas(a.hijoIzq());
	}
	/*
	 * 
	 * 3. Un árbol degenerado es un árbol en el que cada nodo tiene solamente un subárbol.
		Escribe un método que dado un árbol binario indique si es degenerado o no.
	 */
	
	public static <E> boolean degenerado(ArbolBinario<E> a)//bien
	{
		if(a.esVacio())
			return false;
		else if(a.hijoIzq().esVacio() && a.hijoDer().esVacio())
			return true;
		else if(!a.hijoIzq().esVacio())
			return degenerado(a.hijoIzq());
		else
			return degenerado(a.hijoDer());
		
	}

	/*
	 * 4. Escribe un método que dados dos árboles binarios A y B, determine si son idénticos o no.
	 */
	public static <E> boolean identicos(ArbolBinario<E> a, ArbolBinario<E> b)
	{
		
		if(a.esVacio() && b.esVacio())
			return true;
		else if(a.esVacio() || b.esVacio())
			return false;
		else if(a.raiz().equals(b.raiz()))
			return identicos(a.hijoDer(),b.hijoDer()) 
					&& identicos(a.hijoIzq(), b.hijoIzq());
		else
			return false; 
	}
	/*
	 * 5. Escribe un método que dado un árbol binario, realice una copia del mismo. 
	 */
	public static <E> ArbolBinario<E> copia(ArbolBinario<E> a)
	{
		if(a.esVacio())
			return new EnlazadoArbolBinario<>();
		else if(a.hijoIzq().esVacio() && a.hijoDer().esVacio())
			return new EnlazadoArbolBinario<>(a.raiz(),new EnlazadoArbolBinario<>(), new EnlazadoArbolBinario<>());
		else
			return new EnlazadoArbolBinario<>(a.raiz(),copia(a.hijoIzq()),copia(a.hijoDer()));
	}
	
	/*
	 * 6. Escribe un método que cuente el número de nodos que están en el nivel n de un árbol
binario.
	 */
	public static <E> int numNodosNivel(ArbolBinario<E> a, int nivel)
	{
		if(a.esVacio())
			return 0;
		else if(nivel == 0)
			return 1;
		else
			return numNodosNivel(a.hijoIzq(), nivel-1) + numNodosNivel(a.hijoDer(), nivel-1);
	}
	/*
	 * 7. Escribe un método que dado un árbol binario y un nivel n del árbol, realice una copia
del árbol hasta dicho nivel.
	 */
	public static <E> ArbolBinario<E> copia(ArbolBinario<E> a, int nivel)
	{
		if(a.esVacio())
			return new EnlazadoArbolBinario<E>();
		else if(nivel == 0)
			return new EnlazadoArbolBinario<E>(a.raiz(),
					new EnlazadoArbolBinario<E>(),
					new EnlazadoArbolBinario<E>());
		else
			return new EnlazadoArbolBinario<E>(a.raiz(), copia(a.hijoIzq(), nivel-1), copia(a.hijoDer(),nivel-1));
	}
	/*
	 * 8. Escribe un método que dado un árbol binario A, cree un árbol binario B igual que A
pero sin las hojas. 
	 */
	public static <E> ArbolBinario<E> creaArbolSinHojas(ArbolBinario<E> a)
	{
		if(a.esVacio())
			return new EnlazadoArbolBinario<>();
		else if(a.hijoIzq().esVacio() && a.hijoDer().esVacio())
			return new EnlazadoArbolBinario<>();
		else
			return new EnlazadoArbolBinario<>(a.raiz(), creaArbolSinHojas(a.hijoIzq()), creaArbolSinHojas(a.hijoDer()));
	}
	
	/*
	 * 9. Un árbol de selección es un árbol binario donde cada nodo representa al menor de sus
dos hijos, excepto las hojas. Construir un método que, dado un árbol binario, indique si
es o no un árbol de selección.
	 */
	/*
	public static <E> boolean arbolSeleccion(ArbolBinario<E> a)
	{
		if(a.esVacio())
			return false;
		else if(a.hijoIzq().esVacio() && a.hijoDer().esVacio())
			return true;
		else if( !a.hijoIzq().esVacio() && a.raiz().equals(a.hijoIzq().raiz()) )
			return arbolSeleccion(a.hijoIzq());
		else if( !a.hijoDer().esVacio() && a.raiz().equals(a.hijoDer().raiz()) )
			return arbolSeleccion(a.hijoDer());
		return false;
	}
	*/
	
	public static boolean arbolSeleccion1(ArbolBinario<Integer> a)
	{
		if(a.esVacio())
			return true;
		else if(a.hijoIzq().esVacio() && a.hijoDer().esVacio())
			return true;
		else if( !a.hijoIzq().esVacio() && a.hijoDer().esVacio() && a.hijoIzq().raiz() == a.raiz() )
			return true;
		else if( !a.hijoDer().esVacio() && a.hijoIzq().esVacio() && a.hijoDer().raiz() == a.raiz() )
			return true;
		else{ 
			int menor = a.hijoIzq().raiz() <= a.hijoDer().raiz() ? a.hijoIzq().raiz() : a.hijoDer().raiz();
			if( a.raiz() == menor )
				return arbolSeleccion(a.hijoDer()) && arbolSeleccion(a.hijoIzq());
			else
				return false;
		}
		
	}
	/*
	 * arg1 > arg2  => 1
	 * arg1 == arg2 => 0
	 * arg1 < arg2  => -1
	 */
	public static <E extends Comparable<E>> boolean arbolSeleccion(ArbolBinario<E> a) throws NullPointerException
	{
		if(a.esVacio())
			return true;
		else if(a.hijoIzq().esVacio() && a.hijoDer().esVacio())
			return true;
		else{
			if( !a.hijoIzq().esVacio() ){
			
				if( a.raiz().compareTo(a.hijoIzq().raiz()) < 0 )
					return arbolSeleccion(a.hijoIzq());
			}
			else{
				 if( a.raiz().compareTo(a.hijoDer().raiz()) < 0 )
					return arbolSeleccion(a.hijoDer());
			}
		}
		return false;
		
	}
	
	/*
	 *10. Escribe un método booleano que dados un árbol binario y un camino expresado en forma
	 *  de String determine si existe dicho camino en el árbol, teniendo en cuenta que el 
	 *  camino debe comenzar necesariamente en la raíz. Por ejemplo, para el árbol que sigue
	 *  existen los caminos m-q-t y m-d, pero no existen los caminos r-q-t ni d-k.
	 *  
	 *  Cada nodo de un árbol binario A representa una letra alfabética. La concatenación de
	 *   las mismas, en cada camino que va desde la raíz a una hoja representa una palabra. 
	 *   Realizar un procedimiento que visualice todas las palabras almacenadas en un árbol binario A.
	 */
	/*
	 * String var = "hola soy yvan"
	 * substring(4) => " soy yvan" 
	 */
	public static <E> boolean camino(ArbolBinario<E> a, String cam)
	{
		if(cam.length() == 0)
			return true;
		else if(cam.length() > 0 && a.esVacio())
			return false;
		else if(!a.raiz().equals(cam.charAt(0)))
				return false;
		else return camino(a.hijoDer(),cam.substring(1) ) || camino(a.hijoIzq(), cam.substring(1) );
	}
	/*
	 * 11. Escribe un método que dado un árbol binario y un elemento devuelva el padre de dicho 
	 * elemento, suponiendo que no hay elementos repetidos.
	 */
	public static <E> E padre(ArbolBinario<E> a, E pai) throws NullPointerException
	{
//		E elemIgual = null;
//		if(a.esVacio())
//			throw new NullPointerException("Arbol vacio.");
//		else if(a.hijoDer().esVacio() && a.hijoIzq().esVacio())
//			throw new NullPointerException("Arbol sin elementos seleccionables.");
//		else if( a.hijoIzq().raiz().equals(pai) )
//			 
//			return  elemIgual = padre(a.hijoIzq(), pai);
//			
//		else if( a.hijoDer().raiz().equals(pai) )
//
//			return elemIgual = padre(a.hijoDer(), pai );
//		
//		return elemIgual;
		
		if(a.esVacio())
			throw new NullPointerException("Arbol vacio.");
		if(a.hijoDer().esVacio() && a.hijoIzq().esVacio())
			throw new NullPointerException("Arbol sin elementos seleccionables.");
		if(a.raiz().equals(pai))
			return a.raiz();
		else{
			if(!a.hijoIzq().esVacio() && a.hijoIzq().raiz().equals(pai) ||
			   !a.hijoDer().esVacio() && a.hijoDer().raiz().equals(pai))
				return a.raiz();
			E elem = padre(a.hijoIzq(), pai);
			if(elem != null)
			{
				return padre(a.hijoDer(), elem);
			}
			return elem;
		}
		
	}
	
	/*
	 * 12. 
	 * Cada nodo de un árbol binario A representa una letra alfabética. La concatenación de
	 * las mismas, en cada camino que va desde la raíz a una hoja representa una palabra.
	 * Realizar un procedimiento que visualice todas las palabras almacenadas en un árbol
 	 * binario A.
	 */
	public static <E> void visualizarPalabra(ArbolBinario<E> a, String palabra)
	{
		if(!a.esVacio()){
			if(palabra.length() == 0)
				System.out.println("Falta la palabra para concatenar.");
			else if(a.hijoIzq().esVacio() && a.hijoDer().esVacio())
				System.out.println(palabra+a.raiz());
			else{
				visualizarPalabra(a.hijoIzq(), palabra+a.raiz());
				visualizarPalabra(a.hijoDer(), palabra+a.raiz());
			}
		}
	}
	public static void main(String [] args)
	{
		//Referencias
		ArbolBinario<Character> hi = new EnlazadoArbolBinario<Character>();
		ArbolBinario<Character> hd = new EnlazadoArbolBinario<Character>();
		
		ArbolBinario<Integer> hii = new EnlazadoArbolBinario<>();
		ArbolBinario<Integer> hdd = new EnlazadoArbolBinario<>();
		
		/* arbol */
		ArbolBinario<Character> a2 = new EnlazadoArbolBinario<Character>('2',hi,hd);
		ArbolBinario<Character> a3 = new EnlazadoArbolBinario<Character>('3',hi,hd);
		ArbolBinario<Character> a4 = new EnlazadoArbolBinario<Character>('4',hi,hd);
		ArbolBinario<Character> a5 = new EnlazadoArbolBinario<Character>('5',hi,hd);
		ArbolBinario<Character> a6 = new EnlazadoArbolBinario<Character>('6',hi,hd);
		
		
		ArbolBinario<Character> cuatro = new EnlazadoArbolBinario<Character>('4',a5,a6);
		ArbolBinario<Character> tres = new EnlazadoArbolBinario<Character>('3',cuatro,hd);
		ArbolBinario<Character> dos = new EnlazadoArbolBinario<Character>('2',hi,hd);
		ArbolBinario<Character> arbol = new EnlazadoArbolBinario<Character>('1',dos,tres);
		
		/* arbol2 */
		ArbolBinario<Character> aa3 = new EnlazadoArbolBinario<Character>('2',hi,hd);
		ArbolBinario<Character> aa4 = new EnlazadoArbolBinario<Character>('3',hi,hd);
		
		ArbolBinario<Character> arbol2 = new EnlazadoArbolBinario<Character>('1',aa3,aa4);
		
		/*arbol degenerado*/
		ArbolBinario<Integer> deg2 = new EnlazadoArbolBinario<Integer>(20,hii,hdd);
		ArbolBinario<Integer> deg3 = new EnlazadoArbolBinario<Integer>(30,hii,hdd);
		
		ArbolBinario<Integer> arbolDeg2 = new EnlazadoArbolBinario<>(10,hii,deg3);
		ArbolBinario<Integer> arbolDeg1 = new EnlazadoArbolBinario<>(10,arbolDeg2,hdd);
		
		/*arbol Seleccion*/
		ArbolBinario<Integer> Sel2 = new EnlazadoArbolBinario<Integer>(10,hii,hdd);
		ArbolBinario<Integer> Sel3 = new EnlazadoArbolBinario<Integer>(12,hii,hdd);
		ArbolBinario<Integer> Sel4 = new EnlazadoArbolBinario<Integer>(40,hii,hdd);
		
		ArbolBinario<Integer> arbolSel2 = new EnlazadoArbolBinario<>(10,Sel2,Sel3);
		ArbolBinario<Integer> arbolSel1 = new EnlazadoArbolBinario<>(10,arbolSel2,Sel4);
		
		/*arbol Padre*/
		ArbolBinario<Integer> arbolPadre3 = new EnlazadoArbolBinario<Integer>(3,hii,hdd);
		
		ArbolBinario<Integer> arbolPadre2 = new EnlazadoArbolBinario<>(2,hii,hdd);
		ArbolBinario<Integer> arbolPadre = new EnlazadoArbolBinario<>(1,arbolPadre2,arbolPadre3);
		
		/*Arbol camino*/

		
		ArbolBinario<Character> arbolCtres = new EnlazadoArbolBinario<Character>('t',hi,hd);
		ArbolBinario<Character> arbolCdos = new EnlazadoArbolBinario<Character>('r',arbolCtres,hd);
		ArbolBinario<Character> arbolCamino = new EnlazadoArbolBinario<Character>('m',arbolCdos,tres);
		
		int num = numHojas(arbol);
		System.out.println("NumHojas: "+num);
		
		int numNodos = numNodos(arbol);
		System.out.println("NumNodos: "+numNodos);
		
		System.out.println("Degenerado: "+degenerado(arbol));
		System.out.println("Degenerado: "+degenerado(arbolDeg1));
		
		System.out.println("Idénticos: "+identicos(arbol,arbol2));
		
		System.out.println("NumNodosEnNivel: "+numNodosNivel(arbol, 1));
		
		System.out.println("copia");
		///
		System.out.println("Copia arbol hasta ese nivel");
		System.out.println("Devuelve arbol: ");
		ArbolBinario<Character> copia = new EnlazadoArbolBinario<Character>();
		
		copia = copia(arbol, 1);
		System.out.println("arbol 1");
		preorden(arbol);
		System.out.println("arbol 1 'copia'");
		preorden(copia);
		///
		
		ArbolBinario<Character> copiaSinHojas = new EnlazadoArbolBinario<Character>();
		copiaSinHojas = creaArbolSinHojas(arbol);
		System.out.println("arbol CON hojas");
		preorden(arbol);
		System.out.println("arbol SIN hojas");
		preorden(copiaSinHojas);
		///
		System.out.println("\nArbol Selección 1: "+arbolSeleccion1(arbolDeg1));
		System.out.println("\nArbol Selección 2: "+arbolSeleccion1(arbolSel1));
		
		String cam = "mrt";
		System.out.println("\nArbol Camino m-r-t: "+ camino(arbolCamino, cam));
		
		///
		
		int elemPai = 2;
		System.out.println("\nArbol elemento Padre: "+ padre(arbolPadre, elemPai));
		
		///
		visualizarPalabra(arbolPadre, "Raiz: ");
	}
}
