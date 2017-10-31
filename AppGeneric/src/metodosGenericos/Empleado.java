package metodosGenericos;

public class Empleado {
	
	private String name;
	private int year;
	private double salaire;
	
	public Empleado(String name, int year, double salaire) {
		this.name = name;
		this.year = year;
		this.salaire = salaire;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public double getSalaire() {
		return salaire;
	}


	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}


	@Override
	public String toString() {
		return "Empleado [name=" + name + ", year=" + year + ", salaire=" + salaire + "]";
	}
}
