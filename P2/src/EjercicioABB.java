
public class EjercicioABB {

	
	public static <E extends Comparable<E>> void ver(Conjunto<E> conj){
		Conjunto<E> aux = new ConjuntoABB<E>();
		
		while(conj.cardinal() != 0)
		{
			E elemento = conj.elige();
			System.out.print(elemento+",");
			conj.elimina(elemento);
			aux.inserta(elemento);
			
		}
		
		while(aux.cardinal() != 0)
		{
			E elemento = aux.elige();
			
			aux.elimina(elemento);
			conj.inserta(elemento);
		}
	}
	
	public static void main(String[] args)
	{
		Conjunto<Integer> cjt1 = new ConjuntoABB<Integer>();
		
		for(int i = 1; i <= 2; i++)
		{
			cjt1.inserta(i);
		}
		
		System.out.println("Cardinal del conjunto 1 es: "+ cjt1.cardinal());
		System.out.println("\nVer conjunto 1: ");
		ver(cjt1);
		System.out.println("\n*********");
		//Eliminar
		System.out.println("Eliminar un elemento: "+ cjt1.elimina( 2 ));
		///
		System.out.println("Cardinal del conjunto 1 es: "+ cjt1.cardinal());
		
				
		Conjunto<Integer> cjt2 = new ConjuntoABB<Integer>();
		for (int i = 2; i <= 3; i++)
			cjt2.inserta(i);
		//ver(cjt2);
		System.out.println("Cardinal del conjunto 2 es: "+ cjt2.cardinal());
		System.out.println("\nVer conjunto 2: ");
		ver(cjt2);
		
		//unión 
		Conjunto<Integer> union = cjt1.union(cjt2);
		System.out.print("\n\nUnion cjt1 y cjt2: \n");
		ver(union);
		
		//interseccion
		Conjunto<Integer> intersec = cjt1.interseccion(cjt2);
		
		System.out.println("\n\nInterseccion cjt1 con cjt2: ");
		ver(intersec);
		
		//diferencia
		Conjunto<Integer> dif = cjt1.diferencia(cjt2);
		System.out.println("\n\nDiferencia cjt1 - cjt2: ");
		ver(dif);
	}
}


