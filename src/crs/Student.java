package crs;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
public class Student extends User implements StudentInterface {
	
	public String firstName;
	public String lastName;
	public int studentID;
	public ArrayList<String> registeredCourses;

	
	//Default constructor
	public Student() {
		
	}
	
	//overloaded constructor
	public Student(String firstName, String lastName, int studentID, String registeredCourses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
		this.registeredCourses = new ArrayList<String>();
	}
	
	@Override
	public String getFirstName() {
		return firstName;
	}
	
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	public ArrayList<String> getRegisteredCourses() {
		return registeredCourses;
	}
	
	public void addCourse (String course) {
		this.registeredCourses.add(course);
		
	}
	
	public void removeCourse (String course) {
		this.registeredCourses.remove(course);
	}
	
	public void removeStudent (String name) {
		
	}
	
	public String toString () {
		return this.firstName + " " + this.lastName + "\t" + this.studentID + "\t" + this.registeredCourses;
	}
	
	/////////////////////////////////////////////////Student Methods//////////////////////////////////////////////////////////
	
	//WORKS// Views list of all courses
	public static void viewAllCourses() {
		Course course = new Course();
		for (int i = 0; i<CourseRegistrationSystem.courseArrayList.size(); i++) {
			course = CourseRegistrationSystem.courseArrayList.get(i);
			System.out.println(course.toString() + "\n");
		}
		
	}
	
	//WORKS// View a list of available courses by Course Name
	public static String fullCourseID = null;
	public static void viewNotFullCourses() throws IOException {
		//In ArrayList of courses, if Max# == enrolled# return course info
		Course course = new Course();
		System.out.println("\nAvailable Courses Are: \n");
		for (int i = 0; i<CourseRegistrationSystem.courseArrayList.size(); i++) {
			course = CourseRegistrationSystem.courseArrayList.get(i);
			if (course.getEnrolledStudents() != course.getMaxStudents()) {
				String courseID = course.getCourseID();
				fullCourseID = courseID;
				System.out.println(course.toString() + "\n");
			}
		}
	}

	//WORKS// Registers student for courses. Does not allow more than 5 courses per student or same course twice.
	public static void register() {
		Course course = new Course();
		Student student = new Student();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Course Registration Number: ");
		String courseCRN = input.nextLine();		
		System.out.println("Verify first name: ");
		String firstName = input.nextLine();
		System.out.println("Verify last name: ");
		String lastName = input.nextLine();
		String name = firstName + " " + lastName;
				
		//Loops through student list to find student name
		for (int i = 0; i<crsData.students.size(); i++) {
			student = crsData.students.get(i);
			if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
				//Loops through Course List to find course
				for (int j = 0; j<CourseRegistrationSystem.courseArrayList.size(); j++) {
					course = CourseRegistrationSystem.courseArrayList.get(j);
					//WORKS// checks to see if course is full / if it is, Displays Course is full.
					if (courseCRN.equals(course.getCourseCRN()) && course.getEnrolledStudents() == course.getMaxStudents()) {
						System.out.println("\nCourse is full.\nSelect Another.\n");
						break;
					}
					//WORKS// only allows student to register for a maximum of 5 classes.
					if (student.registeredCourses.size() == 5) {
						System.out.println("\nCourse Limit Reached\n"
								+ "Please withdraw from a course to continue.\n\n");
						break;
					}
					//WORKS// Checks to see if student is already registered for course.
					if (courseCRN.equals(course.getCourseCRN()) && student.registeredCourses.contains(course.getCourseName())) {
						System.out.print("\nYou are already Registered for this course.\n\n");
						break;
					}			
					//WORKS// adds student name to course list and adds course to specific student.
					if (courseCRN.equals(course.getCourseCRN())) {
						course.addStudent(name);
						student.addCourse(course.getCourseName());
						System.out.print("\nCourse Enrolled Successfully!\n\n");
						break;
					}					
					
				}
			}
		}
		
	}


	//WORKS// Withdraws student from specific course and prints Current course list for student
	public static void withdraw() {
		Course course = new Course();
		Student student = new Student();
		Scanner input = new Scanner (System.in);
		System.out.print("Enter courseCRN: ");
		String courseCRN = input.nextLine();
		System.out.print("Verify first name: ");
		String firstName = input.nextLine();
		System.out.print("Verify last name: ");
		String lastName = input.nextLine();
		String name = firstName + " " + lastName;
		
		for (int i = 0; i<crsData.students.size(); i++) {
			student = crsData.students.get(i);
			if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
				
				for (int j = 0; j<CourseRegistrationSystem.courseArrayList.size(); j++) {
					course = CourseRegistrationSystem.courseArrayList.get(j);
					
					if (courseCRN.equals(course.getCourseCRN())) {
						course.removeStudent(name);
						student.registeredCourses.remove(course.getCourseName());
					}
				}
			}
		}
		System.out.println("\n" + student.registeredCourses.toString());
	}
	
	
	//WORKS// Views all courses student is registered for
	public static void viewYourCourses() {
		Scanner input = new Scanner (System.in);
		System.out.print("Enter student ID: ");
		int SID = input.nextInt();
		//Print out list of registered courses
		for (int i = 0; i<crsData.students.size(); i++) {
			Student student = crsData.students.get(i);
			if (student.getStudentID() == SID) {
				System.out.print("\n" + student.registeredCourses + "\n\n");
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
}