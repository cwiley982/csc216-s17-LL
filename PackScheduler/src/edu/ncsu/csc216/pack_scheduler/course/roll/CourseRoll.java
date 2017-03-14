package edu.ncsu.csc216.pack_scheduler.course.roll;

import edu.ncsu.csc216.pack_scheduler.user.Student;
import edu.ncsu.csc216.pack_scheduler.util.LinkedAbstractList;

public class CourseRoll {
	
	private LinkedAbstractList<Student> roll;
	private int enrollmentCap;
	private static final int MIN_ENROLLMENT = 10;
	private static final int MAX_ENROLLMENT = 250;
	
	public CourseRoll(int cap) {
		roll = new LinkedAbstractList<Student>();
		setEnrollmentCap(cap);
	}

	/**
	 * @return the enrollmentCap
	 */
	public int getEnrollmentCap() {
		return enrollmentCap;
	}
	
	/**
	 * Sets the enrollment cap
	 */
	public void setEnrollmentCap(int cap) {
		if(cap > MAX_ENROLLMENT || cap < MIN_ENROLLMENT || cap < getOpenSeats()) {
			throw new IllegalArgumentException();
		}
		this.enrollmentCap = cap;
	}

	/**
	 * return the amount of open seats in a class
	 * @param enrollmentCap the enrollmentCap to set
	 */
	public int getOpenSeats () {
		return enrollmentCap - roll.size();
	}

}
