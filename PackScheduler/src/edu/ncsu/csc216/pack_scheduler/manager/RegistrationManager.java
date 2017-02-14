package edu.ncsu.csc216.pack_scheduler.manager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import edu.ncsu.csc216.pack_scheduler.catalog.CourseCatalog;
import edu.ncsu.csc216.pack_scheduler.directory.StudentDirectory;
import edu.ncsu.csc216.pack_scheduler.user.Student;
import edu.ncsu.csc216.pack_scheduler.user.User;

/**
 * Class for creating an instance of registration manager
 * @author Sam
 *
 */
public class RegistrationManager {

	/**the instance of registration manager*/
	private static RegistrationManager instance;
	/**the instance of course catalog*/
	private CourseCatalog courseCatalog;
	/**the instance of student directory*/
	private StudentDirectory studentDirectory;
	/**the instance of user*/
	private User registrar;
	/**the current user*/
	private User currentUser;
	/** Hashing algorithm */
	private static final String HASH_ALGORITHM = "SHA-256";
	/**the password to use*/
	private static final String PW = "Regi5tr@r";
	/**the hashed password*/
	private static String hashPW;

	//Static code block for hashing the registrar user's password
	{
		try {
			MessageDigest digest1 = MessageDigest.getInstance(HASH_ALGORITHM);
			digest1.update(PW.getBytes());
			hashPW = new String(digest1.digest());
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("Cannot hash password");
		}
	}

	private RegistrationManager() {
		courseCatalog = new CourseCatalog();
		studentDirectory = new StudentDirectory();
		registrar = new Registrar();
	}
	
	/**
	 * Method to create an instance of registrationManager
	 * @return the instince of RegistrationManager
	 */
	public static RegistrationManager getInstance() {
		if (instance == null) {
			instance = new RegistrationManager();
		}
		return instance;
	}
	
	/**
	 * Get method for the course catalog
	 * @return the course catalog
	 */
	public CourseCatalog getCourseCatalog() {
		return courseCatalog;
	}
	
	/**
	 * get method for student directory
	 * @return the student directory
	 */
	public StudentDirectory getStudentDirectory() {
		return studentDirectory;
	}

	/**
	 * Method to login as a registrar
	 * @param id the id of the user that wants to log in
	 * @param password the password of the user that wants to log in
	 * @return true if the login is sucsessful and false otherwise
	 */
	public boolean login(String id, String password) {
		Student s = studentDirectory.getStudentById(id);
		try {
			MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
			digest.update(password.getBytes());
			String localHashPW = new String(digest.digest());
			if (s.getPassword().equals(localHashPW)) {
				currentUser = s;
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException();
		}	

		if (registrar.getId().equals(id)) {
			MessageDigest digest;
			try {
				digest = MessageDigest.getInstance(HASH_ALGORITHM);
				digest.update(password.getBytes());
				String localHashPW = new String(digest.digest());
				if (registrar.getPassword().equals(localHashPW)) {
					currentUser = registrar;
					return true;
				}
			} catch (NoSuchAlgorithmException e) {
				throw new IllegalArgumentException();
			}
		}

		return false;
	}

	/**
	 * Method that logs out the registrar
	 */
	public void logout() {
		currentUser = registrar; 
	}

	/**
	 * method that gets the current user
	 * @return the current user
	 */
	public User getCurrentUser() {
		//TODO implement method
		return null;
	}

	/**
	 * method that clears the data in course catalog and student directory
	 */
	public void clearData() {
		courseCatalog.newCourseCatalog();
		studentDirectory.newStudentDirectory();
	}

	/**
	 * The inner class for registrar which is a user that can work with registration manager
	 * @author Sam
	 *
	 */
	private static class Registrar extends User {

		private static final String FIRST_NAME = "Wolf";
		private static final String LAST_NAME = "Scheduler";
		private static final String ID = "registrar";
		private static final String EMAIL = "registrar@ncsu.edu";

		/**
		 * Create a registrar user with the user id of registrar and
		 * password of Regi5tr@r.  Note that hard coding passwords in a 
		 * project is HORRIBLY INSECURE, but it simplifies testing here.
		 * This should NEVER be done in practice!
		 */
		public Registrar() {
			super(FIRST_NAME, LAST_NAME, ID, EMAIL, hashPW);
		}
	}
}