package generics;

public class Jefe extends Empleado {

	public Jefe(String nombre, int edad, double salaire) {
		super(nombre, edad, salaire);
	}
	
	double incentivo(double inc)
	{
		return inc;
	}
}
