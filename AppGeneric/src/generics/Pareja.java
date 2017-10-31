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
	
	public static void imprimirTrabajador(Pareja<? extends Empleado> p)
	{
		Empleado empleado = p.getGeneric();
		System.out.println("El empleado es: "+empleado);
	}
	
}
