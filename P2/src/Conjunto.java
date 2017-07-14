
public interface Conjunto<E> {
	public int cardinal();
	//Produce: el n�mero de elementos del conjunto
	public boolean pertenece(E x);
	//Produce: cierto si x est� en el conjunto y falso en otro caso
	public boolean inserta(E x);
	//Modifica: this
	//Produce: devuelve cierto si a�ade x al conjunto, falso en caso contrario
	public boolean elimina(E x);
	//Modifica: this
	//Produce: devuelve cierto si elimina x del conjunto, falso en caso contrario
	public E elige() throws IllegalArgumentException;
	//Produce: lanza la excepci�n cuando el conjunto est� vac�o; en otro caso, devuelve un elemento
	public Conjunto<E> union(Conjunto<E> conj);
	//Produce: devuelve un conjunto uni�n de los conjuntos this y conj;
	public Conjunto<E> interseccion(Conjunto<E> conj);
	//Produce: devuelve un conjunto intersecci�n de los conjuntos this y conj;
	public Conjunto<E> diferencia(Conjunto<E> conj);
	//Produce: devuelve un conjunto diferencia de los conjuntos this y conj;
}
