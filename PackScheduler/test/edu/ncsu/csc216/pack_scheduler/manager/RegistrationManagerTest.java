package edu.ncsu.csc216.pack_scheduler.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.pack_scheduler.directory.StudentDirectory;

/**
 * Tests Registration Manager
 * 
 * @author Caitlyn Wiley
 * @author Claire Brown
 * @author Sam Weninger
 *
 */
public class RegistrationManagerTest {
	
	private RegistrationManager manager;
	
	/**
	 * Sets up the CourseManager and clears the data.
	 * @throws Exception if error
	 */
	@Before
	public void setUp() throws Exception {
		manager = RegistrationManager.getInstance();
		manager.clearData();
	}
	/**
	 * Tests that the registartionManager creates an empty course catalog initially
	 */
	@Test
	public void testGetCourseCatalog() {
		assertEquals(0, manager.getCourseCatalog().getCourseCatalog().length);
	}
	/**
	 * Tests that the registrationManager creates an empty student directory initially
	 */
	@Test
	public void testGetStudentDirectory() {
		assertEquals(0, manager.getStudentDirectory().getStudentDirectory().length);
	}
	/**
	 * Tests whether a student or registrar can successfully log in
	 */
	@Test
	public void testLogin() {
		StudentDirectory sd = manager.getStudentDirectory();
		sd.addStudent("Caitlyn", "Wiley", "cjwiley2", "cjwiley2@ncsu.edu", "passWord123", "passWord123", 15);
		assertNotNull(sd.getStudentById("cjwiley2"));
		manager.logout();
		assertTrue(manager.login("cjwiley2", "passWord123"));
		manager.logout();
		try {
			assertFalse(manager.login("registrr", "Regi5tr@r"));
			fail();
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "User doesn't exist.");
		}
		assertFalse(manager.login("registrar", "Registr@r"));
		assertTrue(manager.login("registrar", "Regi5tr@r"));
		
	}
	/**
	 * Tests that when a student logs in, they can log out. (Current user becomes null)
	 */
	@Test 
	public void testLogout() {
		StudentDirectory sd = manager.getStudentDirectory();
		sd.addStudent("Caitlyn", "Wiley", "cjwiley2", "cjwiley2@ncsu.edu", "passWord123", "passWord123", 15);
		manager.logout();
		assertTrue(manager.login("cjwiley2", "passWord123"));
		manager.logout();
		assertEquals(null, manager.getCurrentUser());
	}
	
	/**
	 * Tests that manager returns the correct current user
	 */
	@Test
	public void testGetCurrentUser() {
		StudentDirectory sd = manager.getStudentDirectory();
		sd.addStudent("Caitlyn", "Wiley", "cjwiley2", "cjwiley2@ncsu.edu", "passWord123", "passWord123", 15);
		assertTrue(manager.login("cjwiley2", "passWord123"));
		assertEquals("Caitlyn", manager.getCurrentUser().getFirstName());
	}

}