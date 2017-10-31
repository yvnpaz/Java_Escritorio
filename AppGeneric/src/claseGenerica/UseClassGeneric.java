package claseGenerica;

public class UseClassGeneric {

	public static void main(String[] args) {

		Pareja<String> familia = new Pareja<>();
		
		familia.setGeneric("yvan");
		System.out.println("Nombre: "+familia.getGeneric());
		
		Pareja<Persona> persona = new Pareja<>();
		
		persona.setGeneric(new Persona("yvn paz"));
		System.out.println(persona.getGeneric());
	}

}

class Persona {
	
	private String nombre;
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + "]";
	}
}