package edu.ncsu.csc216.pack_scheduler.course.validator;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tester class for the CourseNameValidatpr class.
 * 
 * @author Sam
 * @author Claire
 * @author Caitlyn
 */
public class CourseNameValidatorFSMTest {
	
	/**
	 * 
	 */
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
		/*test start with letter*/
		try{
			assert(fsm.isValid("T167C"));
		}
		catch(InvalidTransitionException e)
		{
			fail();
		}
		/*test start with non letter or number*/
		try{
			assert(fsm.isValid("!16CSC"));
			fail();
		}
		catch(InvalidTransitionException e)
		{
			assertEquals(e.getMessage(), "Course name can only contain letters and digits.");
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
		
		/*test start with 2 letters*/
		try{
			assert(fsm.isValid("Cl516"));
		}
		catch(InvalidTransitionException e)
		{
			fail();
		}
		
		/*test start with 3 letters*/
		try{
			assert(fsm.isValid("Clr516"));
		}
		catch(InvalidTransitionException e)
		{
			fail();
		}
		
		/*test start with 4 letters*/
		try{
			assert(fsm.isValid("Clre516"));
		}
		catch(InvalidTransitionException e)
		{
			fail();
		}
		
		/*test with valid suffix*/
		try{
			assert(fsm.isValid("Clre516A"));
		}
		catch(InvalidTransitionException e)
		{
			fail();
		}
		
		/*test only 1 digit*/
		try{
			assert(!fsm.isValid("Cl5"));
		}
		catch(InvalidTransitionException e)
		{
			//skip
		}
		
		/*test only 2 digit*/
		try{
			assert(!fsm.isValid("Clr51"));
		}
		catch(InvalidTransitionException e)
		{
			//skip
		}
		
		/*test 4 digit*/
		try{
			assert(!fsm.isValid("Clre5165"));
		}
		catch(InvalidTransitionException e)
		{
			//skip
		}
			
		
		
		
		
	}

}
