package hello;

public class Student {
	//instance variable
	public String name;

	//static/class variable
	public static int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//Overload constructor
	public Student(String name) {
		this.name = name;		
	}
	
}
