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

	public boolean isValid(String name){
		return false;
	}

	public abstract class State {
		public abstract void onLetter();
		public abstract void onDigit();

		public void onOther() throws InvalidTransitionException {
			throw new InvalidTransitionException("Course name can only contain letters and digits.");
		}

		public class LetterState extends State {

			private static final int MAX_PREFIX_LETTERS = 4;

			@Override
			public void onLetter() {


			}

			@Override
			public void onDigit() {
				// TODO Auto-generated method stub

			}

		}

		public class SuffixState extends State {

			@Override
			public void onLetter() {
				// TODO Auto-generated method stub

			}

			@Override
			public void onDigit() {
				// TODO Auto-generated method stub

			}

		}

		public class InitialState extends State {

			@Override
			public void onLetter() {
				// TODO Auto-generated method stub

			}

			@Override
			public void onDigit() {
				// TODO Auto-generated method stub

			}

		}

		public class NumberState extends State {

			private static final int COURSE_NUMBER_LENGTH = 3;

			@Override
			public void onLetter() {
				// TODO Auto-generated method stub

			}

			@Override
			public void onDigit() {
				// TODO Auto-generated method stub

			}

		}
	}

}
