/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.course.validator;

/**
 * @author Claire
 *
 */
public class CourseNameValidator {
	
	public boolean isValid(String name){
		return false;
	}
	private abstract class State{
		public abstract void onLetter();
		public abstract void onDigit();
		public void onOther(){
			throw new InvalidTransitionException("Course name can only contain letters and digits.");
		}
	}

}
