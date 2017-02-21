package edu.ncsu.csc216.pack_scheduler.course.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseNameValidatorFSMTest {

	@Test
	public void test() {
		CourseNameValidatorFSM fsm = new CourseNameValidatorFSM();
		/*test valid input*/
		try{
			assert(fsm.isValid("CSC216"));
		}
		catch(InvalidTransitionException e)
		{
			fail();
		}
		/*test start with number*/
		try{
			assert(fsm.isValid("216CSC"));
			fail();
		}
		catch(InvalidTransitionException e)
		{
			//skip
		}
		/*test start with more than four letters*/
		try{
			assert(fsm.isValid("Claire216"));
			fail();
		}
		catch(InvalidTransitionException e)
		{
			//skip
		}
		/*test end with multiple letters*/
		try{
			assert(fsm.isValid("CSC216Awesome"));
			fail();
		}
		catch(InvalidTransitionException e)
		{
			//skip
		}
		
	}

}
