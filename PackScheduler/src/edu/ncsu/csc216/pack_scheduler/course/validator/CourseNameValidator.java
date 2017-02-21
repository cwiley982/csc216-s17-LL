/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.course.validator;

/**
 * @author Claire
 *
 */
public class CourseNameValidator {
	
	private int letterCount;
	private int digitCount;
	private boolean validEndState;
	private State currentState;

	public boolean isValid(String name){
		return false;
	}

	public abstract class State {
		public abstract void onLetter() throws InvalidTransitionException;

		public abstract void onDigit() throws InvalidTransitionException;

		public void onOther() throws InvalidTransitionException {
			throw new InvalidTransitionException("Course name can only contain letters and digits.");
		}

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
