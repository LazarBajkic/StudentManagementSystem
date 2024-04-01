package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Managment {
	
	//initializing the variables
	private ArrayList<Student> studentList=new ArrayList<Student>();
	private Scanner s;
	private List<String> coursesTaken = new ArrayList<>();
	
	public Managment(Scanner s) {
		this.s=s;
	}
	
	//The logic that checks the user input and adds it to the array list studentList
	
	public String addStudent() {
		
		
		//Check for user input for each attribute of the student object
		
		System.out.println("Enter the id:");
		Integer id = s.nextInt();
		
		System.out.println("Enter the first name:");
		String firstName = s.next();
		s.nextLine();
		
		System.out.println("Enter the last name:");
		String lastName = s.next();
		
		System.out.println("Enter the GPA:");
		float GPA = s.nextFloat();
				
		processCourseInput(coursesTaken);
		
		//Checking if certain input criteria where met
		
		if(id==null || firstName == null||lastName == null||Float.isNaN(GPA)) {
			return "All fields must be filled out!";
		}
				
		if(id<=0) {
			return "The id cannot be 0 or less than 0\n";
		}
		
		if(GPA < 0 || GPA > 5) {
			return "The GPA cannot be less than 0 or more than 5!";
		}
		
		//If yes,then make a new student object from the user inputs,add it to the student list and print a message confirming it.
		
		Student newStudent = new Student(id,firstName,lastName,GPA,coursesTaken);
		studentList.add(newStudent);
		return "Successfully created student!\n";
	}
	
	//The logic behind removing a student from the student list
	
	public String deleteStudent() {
		
		//checks if the student list is empty
		
		if(studentList.isEmpty()) {
			return "The list is empty!";
		}else {
		
			//If it isn't ask the user to enter the id of the student to delete
			
			System.out.println("Enter the id of the student:\n");
			Integer id = s.nextInt();
			Iterator<Student> iterator = studentList.iterator();
			while (iterator.hasNext()) {
			    Student st = iterator.next();
			    if (st.getid() == id) {
			        iterator.remove();
			        return "Successfully deleted";
			    }
			}
		}
		
		//if the id exists delete it,if not print an error message
		
		return "There was an error,please make sure you entered a valid id";
	}
	
	
	//The logic behind finding a certain student using his first and last name
	
	public String findStudent() {
		
		//calls the method to find the student 
		Student foundStudent=findStudentLogic();
		
		//if the return of the method is not null,then print the student
				if(foundStudent!=null) {
					return "The student you searched for \n"+foundStudent.toString();
				}
			
		//otherwise print an error message
				
		return "There was an error,make sure that the student exists in the database";
	}
	
	//The logic that allows the user to pick a student and then alter any kind of attribute the student currently has
	
	public String modifyStudent() {
		
		//Check if the student exists 
		Student modifiedStudent = findStudentLogic();
		
		String result="";
		
		//if the student we are looking for exists,ask what parameter would the user like to change
		
		if(modifiedStudent!=null) {
			System.out.println("What would you like to modify?\n1.Id\n2.First name\n3.Last name\n4.GPA\n5.Course\n enter the number of the option");
			int choice = s.nextInt();
			switch(choice) {
			
			
				//changing  the id 
			case 1:
				System.out.println("Enter the new id:");
				int newId = s.nextInt();
				if(newId > 0) {
					modifiedStudent.setid(newId);
					result="The id was successfully changed!";	
				}
				break;
			
				//changing the first name
			case 2:
				System.out.println("Enter the new first name:");
				String newFName = s.next();
				modifiedStudent.setFirstName(newFName);
				result = "The first name was successfully changed!";
				break;
			
				//changing the last name
			case 3:
				System.out.println("Enter the new last name:");
				String newLName = s.next();
				modifiedStudent.setLastName(newLName);
				result = "The last name was successfully changed!";
				break;
			
				//changing the GPA
			case 4:
				System.out.println("Enter the new GPA:");
				float newGPA = s.nextFloat();
				if(newGPA > 0) {
					modifiedStudent.setGPA(newGPA);
					result = "The GPA was successfully changed!";
				}
				break;
			
			case 5:
				changeStudentCourse(modifiedStudent);
				break;
		
			
			
				//default case where the input is invalid
			default:
				result="Invalid input,make sure to enter a number between 1-4,please try again";
			}
		}
		return result;
	}
	
	//prints the entire list of students
	public String returnList(){
		if(studentList.isEmpty()) {
			return "The list is empty!";
		}
		return studentList.toString();
	}
	
	//prints the help panel
	public void getHelp() {
		System.out.println("////////////////////////////////");
		System.out.println("Student Management System Help:");
        System.out.println("1. To add a student, choose option 1 and follow the prompts.");
        System.out.println("2. To delete a student, choose option 2 and follow the prompts.");
        System.out.println("3. To print the student list, choose option 3.");
        System.out.println("4. To search for a student, choose option 4 and follow the prompts.");
        System.out.println("5. To quit the application, choose option 5.");
        System.out.println("6. For help, choose option 6.");
		System.out.println("////////////////////////////////");
	}
	
	//used to loop through the student list and return a student if the first and last names entered by the user match ones from a database
	public Student findStudentLogic() {
		if(studentList.isEmpty()) {
			System.out.println("The list is empty!");
		}else {
			System.out.println("Enter the first name of the student:");
			String firstName = s.next();
			System.out.println("Enter the last name of the student:");
			String lastName = s.next();
			
			firstName=firstName.toLowerCase();
			lastName = lastName.toLowerCase();
			
			for(Student st : studentList) {
							
				if(st.getFirstName().toLowerCase().contains(firstName) && st.getLastName().toLowerCase().contains(lastName)) {
					return st;
				}
			}
		}
		return null;
	}
	
	
	private void changeStudentCourse(Student st) {
		
		//Getting the course list for the specified student and checking which course the user would like to alter
		List<String> courseList = st.getCourses();
		System.out.println(courseList.toString());
		System.out.println("Which course would you like to change?");
		Integer courseChosen = s.nextInt()-1;
		
		//Checking if the entered course choice is valid
		if(courseChosen >= 0 && courseChosen < courseList.size()) {
			//If yes,ask the user to enter a new course to replace the old one
			System.out.println("And what course would you like to add instead?");
			String newCourse = s.next();
			
			//if it already contains that course,warn the user and ask them to try again
			if(courseList.contains(newCourse)) {
				System.out.println("That course already exists!,please enter a different one");
				newCourse = s.next();
			}else {
				//otherwise if it doesn't,print a success message and alter the existing course to hold the value of the new course entered
				System.out.println("Success!");
				courseList.set(courseChosen, newCourse);
				System.out.println(courseList.toString());
			}
		}
	}
	
	//logic behind adding courses to a student by asking how many courses is the student currently taking 
	private void processCourseInput(List<String> coursesTaken) {
		//Ask the user how many courses should be added to the list
		System.out.print("Enter the number of courses: ");
		Integer numOfCourses=s.nextInt();;

		do {
	       //ask the user to enter the courses
	        for(int i = 1;i<=numOfCourses;i++) {
	        	System.out.println("Enter course number "+i);
	        	String newCourse=s.next();
	        	coursesTaken.add(newCourse);
	        }
	        
	      //error handling if the user enters 0 or less courses
	        if (numOfCourses < 1) {
	            System.out.println("Number of courses must be at least 1. Please try again.");
	        }
	    } while (numOfCourses < 1);

	}
}
