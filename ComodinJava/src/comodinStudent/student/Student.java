package comodinStudent.student;

public class Student implements Comparable<Student> {

	private int id;

	public Student(int id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(Student o) {
		return (id > o.id) ? 1 : ((id <o.id) ? -1 : 0);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
	
}
