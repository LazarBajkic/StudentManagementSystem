package main;

import java.util.Scanner;
import model.Managment;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Managment m = new Managment(s);
		boolean hasQuit=false;
		
		while(!hasQuit) {
			System.out.println("////////////////////////////////");
			System.out.println("Student Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Print Student List");
            System.out.println("4. Search Student");
            System.out.println("5. Help");
            System.out.println("6. Modify Student");
            System.out.println("7. Quit");
            System.out.println("////////////////////////////////");
            
			int choice = s.nextInt();
			
			switch(choice) {
			
			case 1 : 
			System.out.println(m.addStudent()+m.returnList());
			break;
			
			case 2 :
			System.out.println(m.deleteStudent());
			break; 
			
			case 3 : 
			System.out.println(m.returnList());
			break;
			
			case 4 :
			System.out.println(m.findStudent());
			break;
			
			case 5:
			m.getHelp();
			break;
			
			case 6:
			System.out.println(m.modifyStudent());
			break;
			
			case 7:
			System.out.println("We hope to see you again soon!");
			hasQuit=true;
			s.close();
			break;
			
			
			default: 
			System.out.println("Invalid choice,please select one of the provided options!");
			break;
			
			}
		}
	}

}
