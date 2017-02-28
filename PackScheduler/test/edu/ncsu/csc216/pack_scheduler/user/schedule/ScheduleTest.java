package edu.ncsu.csc216.pack_scheduler.user.schedule;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScheduleTest {

	@Test
	public void testSchedule() {
		Schedule s = new Schedule();
		assertEquals(s.getTitle(), "My Schedule");
		String[][] courses = new String[0][4];
		assertEquals(s.getScheduledCourses()[0][2], courses[0][2]);
		fail("Not yet implemented");
	}

}
