package arrayList;

import java.util.ArrayList;
import java.util.List;

public class UseEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Empleado> misEmpleados = new ArrayList<>();
//		Empleado [] misEmpleados = new Empleado[3];
	
		misEmpleados.add(new Empleado("yvn", 28, 1000));
		misEmpleados.add(new Empleado("geralt", 30, 1230));
		misEmpleados.add(new Empleado("chelebrimbor", 197, 5400));
		
		for (Empleado empleado : misEmpleados) {
			System.out.println(empleado.toString());
		}	
	}
}

class Empleado {
	
	private String name;
	private int year;
	private double salaire;
	
	public Empleado(String name, int year, double salaire) {
		this.name = name;
		this.year = year;
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Empleado [name=" + name + ", year=" + year + ", salaire=" + salaire + "]";
	}
}
