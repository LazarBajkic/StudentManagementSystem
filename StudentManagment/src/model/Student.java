package model;

import java.util.List;

public class Student {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private float GPA;
	private List<String> courses;
	
	public Student(Integer id,String firstName,String lastName,float GPA,List<String> courses) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.GPA=GPA;
		this.courses=courses;
	}
	
	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public Student() {
		
	}
	
	public void setid(Integer id) {
		this.id=id;
	}
	
	public Integer getid() {
		return id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setGPA(float GPA) {
		this.GPA=GPA;
	}
	
	public float getGPA() {
		return GPA;
	}

	@Override
	public String toString() {
		return "id=" + id + "\n First Name=" + firstName + "\n Last Name=" + lastName + "\n GPA=" + GPA + "\n Courses= "+ courses + "\n";
	}
	
}
