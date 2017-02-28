package edu.ncsu.csc216.pack_scheduler.user.schedule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.ncsu.csc216.pack_scheduler.course.ConflictException;
import edu.ncsu.csc216.pack_scheduler.course.Course;

public class ScheduleTest {

	@Test
	public void testSchedule() {
		Schedule s = new Schedule();
		assertEquals(s.getTitle(), "My Schedule");
		assertEquals(0, s.getScheduledCourses().length);
	}

	@Test
	public void testAddCourseToSchedule() {
		Schedule s = new Schedule();
		assertEquals(s.getTitle(), "My Schedule");
		try {
			Course course = new Course("CSC216", "Intro to Programming - Java", "001", 3, "cjwiley2", "MWF", 1230,
					1330);
			assertTrue(s.addCourseToSchedule(course));
		} catch (IllegalArgumentException e) {
			fail();
		} catch (ConflictException e) {
			fail();
		}

		try {
			Course course = new Course("CSC216", "Intro to Programming - Java", "001", 3, "cjwiley2", "MWF", 1230,
					1330);
			s.addCourseToSchedule(course);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("You are already enrolled in CSC216.", e.getMessage());
		} catch (ConflictException e) {
			fail();
		}

		try {
			Course course2 = new Course("CSC226", "Discrete Math", "002", 3, "cjwiley2", "MF", 1300, 1400);
			s.addCourseToSchedule(course2);
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		} catch (ConflictException e) {
			assertEquals("The course cannot be added due to a conflict.", e.getMessage());
		}
	}

	@Test
	public void testRemoveCourseFromSchedule() {
		fail();
	}

	@Test
	public void testResetSchedule() {
		fail();
	}

	@Test
	public void testGetScheduledCourses() {
		fail();
	}

	@Test
	public void testSetTitle() {
		fail();
	}
}
