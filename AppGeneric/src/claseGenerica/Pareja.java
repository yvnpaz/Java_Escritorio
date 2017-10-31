package claseGenerica;

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
	
}
