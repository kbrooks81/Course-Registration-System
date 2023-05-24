package crs;

import java.util.ArrayList;

public class crsData{
	
	
	public static Object studentList;
	public static Object courseList;
	public static ArrayList<Student> students = new ArrayList<Student>();
	public static ArrayList<String> courses = new ArrayList<String>();
	
	
	public void setStudentList(ArrayList<Student> students) {
		crsData.students = students;
	}
	
	public void setCousreList(ArrayList<String> courses) {
		crsData.courses = courses;
	}
	
	public static ArrayList<Student> getStudentList() {
		
		return students;
	}
	
	public static ArrayList<String> getCourseList() {
		
		return courses;
	}
}