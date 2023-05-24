package crs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;



public class Admin extends User implements AdminInterface{


	public Admin(String fn, String ln, String usn, String psw) {
		
		String firstName = fn;
		String lastName = ln;
		String username = usn;
		String password = psw;
	}
	
	//Instantiate course object from default constructor
	
	//WORKS// Imports a Course List.
	public static String createCourses() throws IOException, Exception {
		java.io.File file = new java.io.File("CourseList2.txt");
		Scanner loadCourses = new Scanner(file);
		while (loadCourses.hasNext() ) {
			String courseID = loadCourses.next();
			String courseName = loadCourses.next();
			String courseCRN = loadCourses.next();
			int maxStudents = 10;
			int currentStudents = 0;
			String courseInstructor = loadCourses.next();
			int sectionNumber = loadCourses.nextInt();
			String creditHours = loadCourses.next();
			Course newCourse = new Course (courseName, courseID, courseCRN, maxStudents,currentStudents,null,courseInstructor,sectionNumber,creditHours);
			CourseRegistrationSystem.courseArrayList.add(newCourse);
		}
		System.out.println("Courses added successfully!");
		return "Course added.";
		
		/////Creates a new Course and adds it to the Course List.////
		/**Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);

		System.out.print("Course Name: ");
		String courseName = input.nextLine();
		
		System.out.print("Course ID: ");
		String courseID = input.nextLine();
		
		System.out.print("Max # of Students: ");
		int maxStudents = input2.nextInt();
		
		int currentStudents = 0;
				
		System.out.print("Course Instructor: ");
		String courseInstructor = input.nextLine();
		
		System.out.print("Section Number: ");
		int sectionNumber = input2.nextInt();
		
		System.out.print("Credit Hours: ");
		String creditHours = input.nextLine();
		
		
		//add new course
		Course newCourse = new Course (courseName,courseID,maxStudents,currentStudents,null,courseInstructor,sectionNumber,creditHours);
		CourseRegistrationSystem.courseArrayList.add(newCourse);
		return "Course added.";*/
	}
	
	//WORKS// Deletes a course from the Course List.
	public static void deleteCourse() {
		Course course = new Course();
		//Ask user for courseID
		Scanner input = new Scanner(System.in);
		System.out.print("Enter course ID: ");
		String courseID = input.nextLine();
		//Remove index from ArrayList of courses
		
		for (int i = 0; i<CourseRegistrationSystem.courseArrayList.size(); i++) {
			course = CourseRegistrationSystem.courseArrayList.get(i);
			if (course.getCourseID().equals(courseID)) {
				CourseRegistrationSystem.courseArrayList.remove(i);
			}
		}
	}
	
	//WORKS// Edits Course information from specific Course in Course List. 
	public static void editCourse() throws IOException {
		Course course = new Course();
		Scanner input = new Scanner(System.in);
		Scanner edit = new Scanner(System.in);
		System.out.print("Course ID: ");
		String courseID = input.nextLine();
		
		//Ask user what they want to edit
		System.out.print("What would you like to edit?\n");
		System.out.print("1. Course Name\n");
		System.out.print("2. Course ID\n");
		System.out.print("3. Max amount of students\n"); 
		System.out.print("4. Course Instructor\n");      
		System.out.print("5. Section Number\n");         
		System.out.print("6. Credit Hours\n");
		int choice = input.nextInt();
		
		for (int i = 0; i<CourseRegistrationSystem.courseArrayList.size(); i++) {
			course = CourseRegistrationSystem.courseArrayList.get(i);
				//WORKS
				if (choice == 1 && courseID.equals(course.getCourseID())) {
					System.out.print("New Course Name: ");
					String newCourseName = edit.nextLine();
					course.setCourseName(newCourseName);
					System.out.print("\n" + course + "\n");
					break;
				}
				//WORKS
				if (choice == 2 && courseID.equals(course.getCourseID())) {
					System.out.print("New Course ID: ");
					String newCourseID = edit.nextLine();
					course.setCourseID(newCourseID);
					System.out.print("\n" + course + "\n");
					break;
				}
				//WORKS
				if (choice == 3 && courseID.equals(course.getCourseID())) {
					System.out.print("New max amount of students: ");
					int newMax = input.nextInt();
					course.setMaxStudents(newMax);
					System.out.print("\n" + course + "\n");
					break;
				}
				//WORKS
				if (choice == 4 && courseID.equals(course.getCourseID())) {
					System.out.println("New course instructor: ");
					String newInstructor = edit.nextLine();
					course.setCourseInstructor(newInstructor);
					System.out.print("\n" + course + "\n");
					break;
				}
				//WORKS
				if (choice == 5 && courseID.equals(course.getCourseID())) {
					System.out.println("New section number: ");
					int newSection = input.nextInt();
					course.setCourseSection(newSection);
					System.out.print("\n" + course + "\n");
					break;
				}
				//WORKS
				if (choice == 6 && courseID.equals(course.getCourseID())) {
					System.out.print("New credit hours: ");
					String newCreditHours = edit.nextLine();
					course.setCreditHours(newCreditHours);
					System.out.print("\n" + course + "\n");
					break;
				}		
		}	
	}

	//WORKS// Displays specific course information.
	public static void displayInfo() throws IOException {
		Course course = new Course(); 
		Scanner input = new Scanner(System.in);
		//Ask user for Course ID
		System.out.print("Enter course ID: ");
		String courseID = input.nextLine();
		
		for (int i = 0; i<CourseRegistrationSystem.courseArrayList.size(); i++) {
			course = CourseRegistrationSystem.courseArrayList.get(i);
			if (course.getCourseID().equals(courseID)) {
				System.out.println(CourseRegistrationSystem.courseArrayList.get(i));
			}
		}
	}
	
	//WORKS// Imports Student List as Registered Student in Student List.
	public static void registerStudent() throws Exception {
		java.io.File file = new java.io.File("StudentList.txt");
		Scanner input = new Scanner(System.in);
		Scanner loadStudents = new Scanner(file);
		while (loadStudents.hasNext() ) {
			String firstName = loadStudents.next();
			String lastName = loadStudents.next();
			int studentID = loadStudents.nextInt();
			Student newStudent = new Student(firstName, lastName, studentID, null);
			crsData.students.add(newStudent);
		}
		//ADD Student individually
		/**System.out.println("Student First Name: ");
		String firstName = input.nextLine();
		System.out.println("Student Last Name: ");
		String lastName = input.nextLine(); 
		System.out.println("Enter StudentID: ");
		int studentID = input.nextInt();
		
		Student newStudent = new Student(firstName, lastName, studentID, null);
		crsData.students.add(newStudent);*/
		//Student.add(newStudent);
		System.out.println("\nStudent added successfully!");
		loadStudents.close();
	}
	
	//WORKS// ArrayList of students
	public static void viewAllStudents() {
		System.out.printf("\n%7s%11s%13s\n", "Student", "ID", "Courses");
		for (int i = 0; i<crsData.students.size(); i++) {
			System.out.println(crsData.students.get(i));
		}
	}

	
	//WORKS// Remove student from course
	public static void removeStudentFromCourse() {
		Course course = new Course();
		Student student = new Student();
		Scanner input = new Scanner(System.in);
		//Enter courseID
		System.out.print("Enter courseID: ");
		String courseID = input.nextLine();
		//Add courseID to list of registered courses
		
		//Add name to registered students
		System.out.println("Verify first name: ");
		String firstName = input.nextLine();
		System.out.println("Verify last name: ");
		String lastName = input.nextLine();
		String name = firstName + " " + lastName;
				
		
		for (int i = 0; i<crsData.students.size(); i++) {
			student = crsData.students.get(i);
			if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {	
				
				for (int j = 0; j<CourseRegistrationSystem.courseArrayList.size(); j++) {
					course = CourseRegistrationSystem.courseArrayList.get(j);
					
					if (courseID.equals(course.getCourseID())) {
						course.removeStudent(name);
						student.removeCourse(course.getCourseName());
					}					
				}
			}
		}
		System.out.println("\nStudent Removed Succesfully!");
		
	}
	
	//WORKS// Remove student from student list
		public static void removeStudentFromList() {
			Scanner input = new Scanner(System.in);
			Student student = new Student();
			System.out.println("Student First Name: ");
			String firstName = input.nextLine();
			System.out.println("Student Last Name: ");               //Will not remove Student from Course List if
			String lastName = input.nextLine(); 					// registered for a course already. 
			System.out.println("Enter StudentID: ");
			String studentID = input.nextLine();
			String name = firstName + " " + lastName;
			
			for (int i = 0; i<crsData.students.size(); i++) {
				student = crsData.students.get(i);
				if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
					crsData.students.remove(i);
					System.out.println("Student removed successfully!");
				}
			};
		}
	
	
	//WORKS// Displays a list of all current Courses
	public static void viewCourses() {
		Course course = new Course();
		for (int i = 0; i<CourseRegistrationSystem.courseArrayList.size(); i++) {
			course = CourseRegistrationSystem.courseArrayList.get(i);
			System.out.println(course.toString() + "\n");
		}
		
	}

	//WORKS// Displays a list of courses that are currently FULL
	public static String fullCourseID = null;
	public static String viewFullCourses() throws IOException {
		//If currentStudents == maxStudents
		//		display courseIDs
		Course course = new Course();
		for (int i = 0; i<CourseRegistrationSystem.courseArrayList.size(); i++) {
			course = CourseRegistrationSystem.courseArrayList.get(i);
			if (course.getEnrolledStudents() == course.getMaxStudents()) {
				String courseID = course.getCourseID();
				fullCourseID = courseID;
				System.out.println(courseID);
			}
		}
		return fullCourseID;
	}

	//WORKS
	public static void studentNamesInCourse() {
		//Print out list of names (index 4 of course array list)
		//Ask user for courseID 
		Course course = new Course();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter course ID: ");
		String courseID = input.nextLine();
				//Remove index from ArrayList of courses
				
		for (int i = 0; i<CourseRegistrationSystem.courseArrayList.size(); i++) {
			course = CourseRegistrationSystem.courseArrayList.get(i);
			if (course.getCourseID().equals(courseID)) {
				System.out.println(course.getStudents().toString());
			}
		}
	}
	
	public static void coursesPerStudent() {
		Course course = new Course();
		//Search first name, last name
		Scanner input = new Scanner(System.in);
		System.out.println("Enter student first name: ");
		String firstName = input.nextLine();
		System.out.println("Enter student last name: ");
		String lastName = input.nextLine();
		System.out.println("Enter studentID: ");
		int studentID = input.nextInt();
		
		String name = firstName = " " + lastName;
		Student testStudent = new Student(firstName, lastName, studentID, null);
		System.out.println("Their registered courses: ");
		
		for (int i = 0; i<CourseRegistrationSystem.courseArrayList.size(); i++) {
			course = CourseRegistrationSystem.courseArrayList.get(i);
			System.out.println(crsData.courses.toString());
		}
		
	}
	//WORKS// Sorts ArrayList of current courses
	public static ArrayList<Course> getSortedCourseList() {
		Collections.sort(CourseRegistrationSystem.courseArrayList);
		return  CourseRegistrationSystem.courseArrayList;
	}
		
}