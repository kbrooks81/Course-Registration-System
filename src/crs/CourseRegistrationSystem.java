/****************************************
*	Student Name: Kristopher Brooks
*	Date Due: 11/30/2022
*	Date Submitted: 11/30/2022
*	Program Name: Course Registration System
*	Program Description: This is a Course Registration System for a University Administration Department
*						it features an organized location to store all University courses as well as students.
****************************************/

package crs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class CourseRegistrationSystem {

	public static void main (String [] args) throws IOException, Exception {
		User admin = new Admin("Carter", "Fodge", "Admin", "Admin001");	
		courseList();
		LoginMain();

	}
	
	public static ArrayList<Course> courseArrayList = new ArrayList<Course>();
	
	public static ArrayList<Course> courseList() throws IOException{
		
		ArrayList<Course> courses = new ArrayList<Course>();		
		
		courseArrayList = courses;
		
		return courseArrayList;
	}
	
	public static ArrayList<Student> studentArrayList = new ArrayList<Student>();
	
	public static ArrayList<Student> studentList() throws IOException{
		
		ArrayList<Student> students = new ArrayList<Student>();		
		
		studentArrayList = students;
		
		return studentArrayList;
	}
	
	
	public static void LoginMain() throws IOException, Exception{
		System.out.print("1. Admin\n" + "2. Student\n" + "3. Exit\n");
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		
		
		Scanner input2 = new Scanner(System.in);
		
		//Check if username/password are correct
		if (choice == 1) {  
			System.out.println("Username: ");
			String username = input2.nextLine();
			
			System.out.println("Password: ");
			String password = input2.nextLine();
			
			if (username.equals("Admin") && password.equals("Admin001")) {adminSelection();}
			
		}
		//DOES NOT WORK AS INTENDED//
		if (choice == 2) {
			Scanner firstTimeLog = new Scanner(System.in);
			System.out.print("Do you have an existing account?\n" +
								"Enter Y for Yes\n" + 
								"Enter N for No\n");
			String ftl = firstTimeLog.nextLine();

			
			//Let the user create a new username and password themselves // NEEDS ADDITIONAL FEATURES FOR y OPTION//
			if (ftl.equals("y") || ftl.equals("Y")) {
				studentSelection();
			}
			if (ftl.equals("n") || ftl.equals("N")) {
				System.out.print("Enter your First Name: ");
				String firstName = firstTimeLog.nextLine();
				System.out.print("Enter your Last Name: ");         
				String lastName = firstTimeLog.nextLine();
				System.out.print("Create Username: ");
				String newUsername = firstTimeLog.nextLine();

				System.out.print("Create Password: ");
				String newPassword = firstTimeLog.nextLine();
				
				for (int i = 0; i<crsData.students.size(); i++) {
						Student studentIndex = crsData.students.get(i);
						//Find student object in ArrayList to add username/password to correct profile
						if (studentIndex.getFirstName().equals(firstName) && studentIndex.getLastName().equals(lastName)) {
							studentIndex.setUsername(newUsername);
							studentIndex.setPassword(newPassword);
							studentIndex.setFirstName(firstName);
							studentIndex.setLastName(lastName);
					}
				}
				
				System.out.println("New username and password set.");
				studentSelection();
			}
					
		}
		if (choice == 3) {
			System.exit(0);
		}
	}
	
	
	public static void adminSelection() throws IOException, Exception {
		System.out.print("\nCourse Management:\n"
				+ "1. Import course list\n"
				+ "2. Delete a course\n"
				+ "3. Edit a course\n"
				+ "4. Display course info\n"
				+ "5. Import student list\n"
				+ "6. View all students\n"
				+ "7. Remove student from course\n"
				+ "8. Remove student from student list\n\n");
		
		System.out.print("Reports:\n"
				+ "9. View all courses\n"
				+ "10. View all full courses\n"
				+ "11. View students in a course\n"
				+ "12. View courses for a student\n"
				+ "13. Sort courses Alphabetically\n"
				+ "14. Exit\n");
		//Ask user to make selection
		Scanner input = new Scanner(System.in);
		System.out.println("Enter selection: ");
		int systemEntry = input.nextInt();
		
		//Call specified method from Admin class based on selection
		
			Scanner input2 = new Scanner(System.in);
			if (systemEntry == 1) Admin.createCourses();
			if (systemEntry == 2) Admin.deleteCourse();
			if (systemEntry == 3) Admin.editCourse();
			if (systemEntry == 4) Admin.displayInfo();
			if (systemEntry == 5) Admin.registerStudent();
			if (systemEntry == 6) Admin.viewAllStudents();
			if (systemEntry == 7) Admin.removeStudentFromCourse();
			if (systemEntry == 8) Admin.removeStudentFromList();
			if (systemEntry == 9) Admin.viewCourses();
			if (systemEntry == 10) Admin.viewFullCourses();
			if (systemEntry == 11) Admin.studentNamesInCourse();
			if (systemEntry == 12) Admin.coursesPerStudent();
			if (systemEntry == 13) Admin.getSortedCourseList();
			if (systemEntry == 14) {
				LoginMain(); 
			}
		adminSelection();
	}
	
	public static void studentSelection() throws IOException, Exception {
		System.out.print("Course Management:\n"
				+ "1. View all courses\n"
				+ "2. View all available courses\n"
				+ "3. Register for a course\n"
				+ "4. Withdraw from a course\n"
				+ "5. Your courses\n"
				+ "6. Exit\n");
		//Ask user to make selection
		Scanner input = new Scanner(System.in);
		System.out.println("Enter selection: ");
		int systemEntry = input.nextInt();
		
		//Call specified method from Student class based on selection
		Scanner input2 = new Scanner(System.in);
		if (systemEntry == 1) Student.viewAllCourses();
		if (systemEntry == 2) Student.viewNotFullCourses();
		if (systemEntry == 3) Student.register();
		if (systemEntry == 4) Student.withdraw();
		if (systemEntry == 5) Student.viewYourCourses();
		if (systemEntry == 6) {
			LoginMain();
		}
		studentSelection();
	}
}