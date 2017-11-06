package comodinStudent.accions;

import comodinStudent.student.CollegeStudent;
import comodinStudent.student.Student;

public class SortArray {

	//El uso conjunto de objetos de un grupo de inserción, N: el número de elementos de matriz
		public static <T extends Comparable<? super T>> void selectionSort(T[] a,int n) {
			for (int index = 0; index <n-1; index++) {
				int indexOfSmallest = getIndexOfSmallest(a,index,n-1);
				swap(a,index,indexOfSmallest);
			}
		}
		
		public static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last) {
			T minValue = a[first]; // La primera hipótesis para minValue
			int indexOfMin = first; // Un minValue subíndice
			for (int index = first + 1; index <= last; index++) {
				if (a[index].compareTo(minValue) <0) {
					minValue = a[index];
					indexOfMin = index;
				}
			}

			return indexOfMin;
		}
		
		public static void swap(Object[] a,int first,int second) {
			Object temp = a[first];
			a[first] = a[second];
			a[second] = temp;
		}
		
		public static void main(String[] args) {
			CollegeStudent[] stu = new CollegeStudent[]{
					new CollegeStudent(3),
					new CollegeStudent(2),
					new CollegeStudent(5),
					new CollegeStudent(4)};
			selectionSort(stu, 4);
			for (Student student : stu) {
				System.out.println(student);
			}
		}
		
}
