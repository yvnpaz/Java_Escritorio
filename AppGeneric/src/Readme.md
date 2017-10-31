#generics
<ul>
  <li>Métodos genéricos</li>
  <li>Tipos comodin* : ArrayList<\?> or ArrayList<\? extends Empleado></li>
  <li>ArrayList</li>
</ul>

<h6>* Ayuda para la implementación de tipos genéricos, significa "cualquier tipo de objeto". </h6>

#claseGenerica
<ul>
  <li>Clase genérica</li>
</ul>

#arrayList
<ul>
  <li>ArrayList</li>
</ul>

#metodosGenericos
<ul>
    <li>Métodos genéricos</li>
</ul>

<h5>Permiten realizar acciones para distintos tipos de datos</h5>
  ```[Java]
  public static <T> String getelementos(T [] elements);<p></p>
  public static <T extends Comparable> T getGenerics(T[] elements);
