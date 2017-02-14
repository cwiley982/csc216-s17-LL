package edu.ncsu.csc216.pack_scheduler.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.pack_scheduler.catalog.CourseCatalog;
import edu.ncsu.csc216.pack_scheduler.directory.StudentDirectory;


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

	@Test
	public void testLogin() {
		StudentDirectory sd = manager.getStudentDirectory();
		sd.addStudent("Caitlyn", "Wiley", "cjwiley2", "cjwiley2@ncsu.edu", "passWord123", "passWord123", 15);
		assertTrue(manager.login("cjwiley2", "passWord123"));
		assertFalse(manager.login("registrr", "Regi5tr@r"));
		assertFalse(manager.login("registrar", "Registr@r"));
		assertTrue(manager.login("registrar", "Regi5tr@r"));
		
	}

	@Test
	public void testLogout() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrentUser() {
		fail("Not yet implemented");
	}

}