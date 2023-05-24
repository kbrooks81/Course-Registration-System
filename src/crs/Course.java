package crs;


import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileInputStream;

public class Course implements Comparable<Course> {
	


	public Course() {
		
	}
	
	public  String courseName;
	public  String courseID;
	public  String courseCRN;
	public  int maxStudents;
	public  int enrolledStudents;
	public  ArrayList<String> students;
	public  String courseInstructor;
	public  int courseSection;
	public  String creditHours;
	public  ArrayList<String> studentCourses;
	
	
	public Course(String courseName, String courseID, String courseCRN, Integer maxStudents, Integer enrolledStudents, 
			ArrayList<String> students, String courseInstructor, Integer courseSection, String creditHours) {
		this.courseName = courseName;
		this.courseID = courseID;
		this.courseCRN = courseCRN;
		this.maxStudents = maxStudents;
		this.enrolledStudents = enrolledStudents;
		this.students = new ArrayList<String>();
		this.courseInstructor = courseInstructor;
		this.courseSection = courseSection;
		this.creditHours = creditHours;
		
	}

	public  String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	public  String getCourseCRN() {
		return courseCRN.substring(4);
	}
	
	public  void setCourseCRN(String courseCRN) {
		this.courseCRN = courseCRN;
	}

	public  int getMaxStudents() {
		return maxStudents;
	}

	public  void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public  int getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(int enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public  ArrayList<String> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<String> students) {
		this.students = students;
	}

	public String getCourseInstructor() {
		return courseInstructor;
	}

	public  void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	public int getCourseSection() {
		return courseSection;
	}

	public  void setCourseSection(int courseSection) {
		this.courseSection = courseSection;
	}

	public String getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(String creditHours) {
		this.creditHours = creditHours;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public ArrayList<String> getStudentCourses() {
		return studentCourses;
	}
	public void setStudentCourses(ArrayList<String> studentCourses) {
		this.studentCourses = studentCourses;
	}
	public void addStudentCourses(String courseID) {
		this.studentCourses.add(courseID);
	}
	public void removeStudentCourses(String courseID) {
		this.studentCourses.remove(courseID);
	}
	public void addStudent (String name) {
		this.students.add(name);
		this.enrolledStudents +=1;
	}
	
	public void removeStudent(String name) {
		this.students.remove(name);
		this.enrolledStudents -=1;
	}
	
	public int compareTo(Course course) {
	     int cmp = this.courseName.compareTo(course.courseName);
	     if (cmp == 0) {
	       cmp = this.courseName.compareTo(course.courseName);
	     } 
	     return cmp;
	   }
	
	@Override
	public String toString() {
		return this.courseName + " " + this.courseID + " " + this.courseCRN + " " + this.maxStudents + " " + this.enrolledStudents  + " " + this.students + " " + this.courseInstructor + " " + this.courseSection + " " + this.creditHours;
	}
	
}