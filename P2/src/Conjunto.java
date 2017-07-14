
public interface Conjunto<E> {
	public int cardinal();
	//Produce: el número de elementos del conjunto
	public boolean pertenece(E x);
	//Produce: cierto si x está en el conjunto y falso en otro caso
	public boolean inserta(E x);
	//Modifica: this
	//Produce: devuelve cierto si añade x al conjunto, falso en caso contrario
	public boolean elimina(E x);
	//Modifica: this
	//Produce: devuelve cierto si elimina x del conjunto, falso en caso contrario
	public E elige() throws IllegalArgumentException;
	//Produce: lanza la excepción cuando el conjunto está vacío; en otro caso, devuelve un elemento
	public Conjunto<E> union(Conjunto<E> conj);
	//Produce: devuelve un conjunto unión de los conjuntos this y conj;
	public Conjunto<E> interseccion(Conjunto<E> conj);
	//Produce: devuelve un conjunto intersección de los conjuntos this y conj;
	public Conjunto<E> diferencia(Conjunto<E> conj);
	//Produce: devuelve un conjunto diferencia de los conjuntos this y conj;
}
