package edu.ncsu.csc216.pack_scheduler.user.schedule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.ncsu.csc216.pack_scheduler.course.ConflictException;
import edu.ncsu.csc216.pack_scheduler.course.Course;

/**
 * Tests the functionality of the Schedule class
 * 
 * @author Caitlyn
 * @author Sam
 * @author Claire
 *
 */
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
		Schedule s = new Schedule();
		assertEquals(s.getTitle(), "My Schedule");
		Course course = new Course("CSC216", "Intro to Programming - Java", "001", 3, "cjwiley2", "MWF", 1230, 1330);
		Course course2 = new Course("CSC226", "Discrete Math", "002", 3, "cjwiley2", "MF", 1300, 1400);
		try {
			assertTrue(s.addCourseToSchedule(course));
		} catch (IllegalArgumentException e) {
			fail();
		} catch (ConflictException e) {
			fail();
		}

		assertTrue(s.removeCourseFromSchedule(course));
		assertFalse(s.removeCourseFromSchedule(course2));
	}

	@Test
	public void testResetSchedule() {
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
		s.resetSchedule();
		assertEquals(0, s.getScheduledCourses().length);
	}

	@Test
	public void testGetScheduledCourses() {
		Schedule s = new Schedule();
		Course course = new Course("CSC216", "Intro to Programming - Java", "001", 3, "cjwiley2", "MWF", 1230, 1330);
		Course course2 = new Course("CSC226", "Discrete Math", "002", 3, "cjwiley2", "MF", 1400, 1500);
		try {
			assertTrue(s.addCourseToSchedule(course));
			assertTrue(s.addCourseToSchedule(course2));
		} catch (IllegalArgumentException e) {
			fail();
		} catch (ConflictException e) {
			fail();
		}
		assertEquals("Discrete Math", s.getScheduledCourses()[1][2]);
	}

	@Test
	public void testSetTitle() {
		Schedule s = new Schedule();
		try {
			s.setTitle(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Title cannot be null.", e.getMessage());
		}
	}
}
