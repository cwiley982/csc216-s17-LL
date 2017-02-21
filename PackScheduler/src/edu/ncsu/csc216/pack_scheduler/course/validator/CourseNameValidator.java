/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.course.validator;

/**
 * Class for testing a course name as valid or not
 * 
 * @author Claire
 *
 */
public class CourseNameValidator {
	
	private int letterCount;
	private int digitCount;
	private boolean validEndState;
	private State currentState;
	
	/**
	 * Tests to see if the name is valid
	 * 
	 * @param name the name to test 
	 * @return true if the mane is valid false otherwise
	 */
	public boolean isValid(String name){
		return validEndState;
	}
	
	/**
	 * Inner class that the concrete state classes will extend and work with
	 * 
	 * @author Sam
	 *
	 */
	public abstract class State {
		/**Method if the input is a letter */
		public abstract void onLetter() throws InvalidTransitionException;
		/**Method if the input is a digit */
		public abstract void onDigit() throws InvalidTransitionException;
		/**Method if the input is other */
		public void onOther() throws InvalidTransitionException {
			throw new InvalidTransitionException("Course name can only contain letters and digits.");
		}
		
		/**
		 * inner inner class that is a letter state
		 * @author Sam
		 *
		 */
		public class LetterState extends State {

			private static final int MAX_PREFIX_LETTERS = 4;

			@Override
			public void onLetter() throws InvalidTransitionException {
				letterCount++;
				if (letterCount > MAX_PREFIX_LETTERS) {
					throw new InvalidTransitionException();
				}

			}

			@Override
			public void onDigit() {
				digitCount++;
				if (letterCount <= MAX_PREFIX_LETTERS) {
					currentState = new NumberState();
				}

			}

		}
		
		/**
		 * inner inner class that is a suffix state
		 * @author Sam
		 *
		 */
		public class SuffixState extends State {

			@Override
			public void onLetter() throws InvalidTransitionException {
				throw new InvalidTransitionException();

			}

			@Override
			public void onDigit() throws InvalidTransitionException {
				throw new InvalidTransitionException();

			}

		}
		
		/**
		 * inner inner class that is an initial state
		 * @author Sam
		 *
		 */
		public class InitialState extends State {

			@Override
			public void onLetter() {
				letterCount++;
				currentState = new LetterState();
			}

			@Override
			public void onDigit() throws InvalidTransitionException {
				throw new InvalidTransitionException();
			}

		}
		
		/**
		 * inner inner class that is a number state
		 * @author Sam
		 *
		 */
		public class NumberState extends State {

			private static final int COURSE_NUMBER_LENGTH = 3;

			@Override
			public void onLetter() throws InvalidTransitionException {
				if (digitCount == COURSE_NUMBER_LENGTH) {
					currentState = new SuffixState();
				} else {
					throw new InvalidTransitionException();
				}

			}

			@Override
			public void onDigit() throws InvalidTransitionException {
				digitCount++;
				if (digitCount > COURSE_NUMBER_LENGTH) {
					throw new InvalidTransitionException();
				}

			}

		}
	}

}
