package generics;

public class Pareja<T> {

	private T generic;
	
	public Pareja() {
		generic = null;
	}

	public T getGeneric() {
		return generic;
	}

	public void setGeneric(T generic) {
		this.generic = generic;
	}
	
	
	/**
	 * Todos los tipos de objetos que se le pasan al Objeto Pareja como tipo puede ejecutar este método.
	 * @param p
	 */
	public static void imprimirTrabajador(Pareja<? extends Empleado> p)
	{
		Empleado empleado = p.getGeneric();
		System.out.println("El empleado es: "+empleado);
	}
	
}
