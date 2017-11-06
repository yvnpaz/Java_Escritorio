package comodinStudent.main;

import java.util.Arrays;
import java.util.List;

public class StudentMain {

	public static void printList(List<Object> list) {
	    for (Object elem : list)
	        System.out.println(elem + " ");
	    System.out.println();
	}
	
	public static void printListComodin(List<?> list) {
	    for (Object elem: list)
	        System.out.print(elem + " ");
	    System.out.println();
	}
	
	public static void main(String[] args) {
		
		List<Integer> li = Arrays.asList(1, 2, 3);
		List<String>  ls = Arrays.asList("one", "two", "three");
		StudentMain.printListComodin(li);
		StudentMain.printListComodin(ls);

	}

}
