package edu.ncsu.csc216.pack_scheduler.user.schedule;

import edu.ncsu.csc216.pack_scheduler.course.ConflictException;
import edu.ncsu.csc216.pack_scheduler.course.Course;
import edu.ncsu.csc216.pack_scheduler.util.ArrayList;

/**
 * Class that handles the creation and management of a schedule of courses, intended to be used by Student
 * @author Sam
 *
 */
public class Schedule {
	private ArrayList<Course> schedule;
	private String title;
	
	/**
	 * Constructor for schedule, initializes the schedule to an empty array list and sets name to My Schedule
	 */
	public Schedule() {
		schedule = new ArrayList<Course>();
		title = "My Schedule";
	}
	
	/**
	 * Method to add a course to the schedule
	 * @param c the course to add
	 * @return true if it is added and false if it is not
	 * @throws IllegalArgumentException if the course that wants to be added is a duplicate
	 * @throws ConflictException if the course that wants to be added has a conflict with existing courses
	 */
	public boolean addCourseToSchedule(Course c) throws IllegalArgumentException, ConflictException {
		for(int i = 0; i < schedule.size(); i++) {
			if(c.equals(schedule.get(i))) {
				throw new IllegalArgumentException("You are already enrolled in " + schedule.get(i).getName() + ".");
			}
			try {
				c.checkConflict(schedule.get(i));
			}
			catch(ConflictException e) {
				throw new ConflictException("The course cannot be added due to a conflict.");
			}
		}
		schedule.add(schedule.size(),c);
		return true;
	}
	
	/**
	 * Method that return the currently scheduled courses
	 * @return a [][] of the scheduled courses and there information
	 */
	public String [][] getScheduledCourses() {
		String [][] s = new String [schedule.size()][4];
		for(int i = 0; i < schedule.size(); i++) {
			String [] c = schedule.get(i).getShortDisplayArray();
			
			for(int j = 0; j < 4; j++) {
				s[i][j] = c[j];
			}
		}
		return s;
	}
	
	/**
	 * Getter method for title
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Removes a specified course from the schedule
	 * 
	 * @param c the course to remove.
	 * @return true if the course was removed and false otherwise.
	 */
	public boolean removeCourseFromSchedule(Course c) {
		for(int i = 0; i < schedule.size(); i++) {
			if(schedule.get(i).equals(c)) {
				schedule.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Resets the schedule to an empty array list of courses
	 */
	public void resetSchedule() {
		ArrayList<Course> c = new ArrayList<Course>();
		schedule = c;
	}
	
	/**
	 * Sets the schedule's title
	 * @param s the title to set
	 * @throws IllegalArgumentException if the paramater is null
	 */
	public void setTitle(String s) throws IllegalArgumentException {
		if(s == null) {
			throw new IllegalArgumentException("Title cannot be null.");
		}
		title = s;
	}
}