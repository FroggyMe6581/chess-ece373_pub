//just here to fill up folders for git...delete soon!


package org.chess.debug;

import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Test;
import org.university.people.Person;
import org.university.people.Professor;
import org.university.people.Student;
import org.university.software.Course;

public class CourseTest {

	@Test
	public void testStudent() {
		Student s1 = new Student();
		s1.setName("Tom");

		assertEquals("Tom", s1.getName());
		
		Course course1 = new Course();
		course1.setName("Java");
		course1.setSchedule(201);
		course1.setSchedule(401);
		course1.setCourseNumber(373);
		
		s1.addCourse(course1);
		assertEquals("Tom", course1.getStudentRoster().get(0).getName());
	}
	
	@Test
	public void testProfessor() {
		Professor p1 = new Professor();
		p1.setName("Marefat");
		assertEquals("Marefat", p1.getName());
		
		Course course1 = new Course();
		course1.setName("Java");
		course1.setSchedule(201);
		course1.setSchedule(401);
		course1.setCourseNumber(373);
		
		p1.addCourse(course1);
		assertEquals("Marefat", course1.getTeacher().getName());
	}

	@Test
	public void testStudentRoster() {
		Student s1 = new Student();
		s1.setName("Tom");
		Student s2 = new Student();
		s2.setName("Jerry");

		Professor p1 = new Professor();
		p1.setName("Marefat");

		Course course1 = new Course();
		course1.setName("Java");
		course1.setSchedule(201);
		course1.setSchedule(401);
		course1.setCourseNumber(373);

		s1.addCourse(course1);
		s2.addCourse(course1);
		p1.addCourse(course1);

	  //ArrayList<Student> sr = course1.getStudentRoster();
		ArrayList<Person> sr = course1.getStudentRoster();
		System.out.println("Here is the roster of Java: ");

		for (Person st : sr) {
			System.out.println(st.getName() + " ");
		}

		System.out.println("\nHere is the schedule of Java course: ");
		ArrayList<Integer> schedule = course1.getSchedule();
		for (Integer time : schedule) {
			System.out.println(time + " ");
		}

		System.out.println("\nThe teacher of the Java is Professor "
				+ course1.getTeacher().getName());

	}

}
