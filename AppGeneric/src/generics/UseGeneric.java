package generics;

public class UseGeneric {

	public static void main(String[] args) {

//		Empleado admin = new Empleado("yvn", 28, 1000);
//		
//		Empleado directo = new Jefe("geralt", 38, 2000);
		
		Pareja<Empleado> admin = new Pareja<>();
		Pareja<Jefe> director = new Pareja<>();
		
		admin.setGeneric(new Empleado("yvn", 28, 1000));
		director.setGeneric(new Jefe("geralt", 38, 2000));
		
		Pareja.imprimirTrabajador(admin);
		Pareja.imprimirTrabajador(director);
		
	}

}
