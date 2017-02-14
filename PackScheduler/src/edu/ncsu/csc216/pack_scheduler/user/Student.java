package edu.ncsu.csc216.pack_scheduler.user;

/**
 * Outlines a Student object which contains information about students
 * @author kagordo3 ckbrown3 cavandiv
 */
public class Student implements Comparable<Student> {
	
	/** Student's first name */
	private String firstName;
	/** Student's last name */
	private String lastName;
	/** Student's id */
	private String id;
	/** Student's email */
	private String email;
	/** Student's password */
	private String password;
	/** Student's maximum number of credit hours */
	private int maxCredits;
	/** Maximum number of credit hours for any student */
	public static final int MAX_CREDITS = 18;

	/**
	 * Constructs a Student with values for all fields
	 * @param firstName student first name
	 * @param lastName student last name
	 * @param id student id
	 * @param email student email
	 * @param password student hashed password
	 * @param maxCredits student maximum credit hours
	 */
	public Student(String firstName, String lastName, String id, String email, String password, int maxCredits) {
		setFirstName(firstName);
		setLastName(lastName);
		setId(id);
		setEmail(email);
		setPassword(password);
		setMaxCredits(maxCredits);
	}
	/**
	 * Constructs a student with maximum value of maxCredits
	 * @param firstName student first name
	 * @param lastName student last name
	 * @param id student id
	 * @param email student email
	 * @param password student hashed password
	 */
	public Student(String firstName, String lastName, String id, String email, String password) {
		this(firstName, lastName, id, email, password, MAX_CREDITS);
	}
	/**
	 * Returns the Student's first name
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Sets the student's first name
	 * @param firstName the first name to set
	 * @throws IllegalArgumentException if firstName is null or empty
	 */
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.equals("")){
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}
	/**
	 * Returns the Student's last name
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Sets the student's last name
	 * @param lastName the last name to set
	 * @throws IllegalArgumentException if lastName is null or empty
	 */
	public void setLastName(String lastName) {
		if(lastName == null || lastName.equals("")){
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}
	/**
	 * Returns the Student's id
	 * @return the id
	 */
	public String getId() {
	
		return id;
	}
	/**
	 * Sets the student's id
	 * @param id the id to set
	 * @throws IllegalArgumentException if id is null or empty
	 */
	private void setId(String id) {
		if(id == null || id.equals("")){
			throw new IllegalArgumentException("Invalid id");
		}
		this.id = id;
	}
	/**
	 * Returns the Student's email
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * Sets the student's email
	 * @param email the email to set
	 * @throws IllegalArgumentException if email is null, empty, does not contain '@' or '.', or if '.' appears before '@'
	 */
	public void setEmail(String email) {
		if(email == null || email.equals("") || email.indexOf('@') == -1 || email.indexOf('.') == -1 || email.lastIndexOf('.') < email.indexOf('@'))
		{
			throw new IllegalArgumentException("Invalid email");
		}
		this.email = email;
	}
	/**
	 * Returns the Student's password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Sets the student's password
	 * @param password the password to set
	 * @throws IllegalArgumentException if password is null or empty
	 */
	public void setPassword(String password) {
		if(password == null || password.equals("")){
			throw new IllegalArgumentException("Invalid password");
		} 
		this.password = password;
	}
	/**
	 * Returns the Student's maximum number of credit hours
	 * @return the maximum number of credit hours
	 */
	public int getMaxCredits() {
		return maxCredits;
	}
	/**
	 * Sets the student's maximum number of credit hours
	 * @param maxCredits the credits to set
	 * @throws IllegalArgumentException if maxCredits is less than 3 or greater than 18
	 */
	public void setMaxCredits(int maxCredits) {
		if(maxCredits < 3 || maxCredits > 18){
			throw new IllegalArgumentException("Invalid max credits");
		}
		this.maxCredits = maxCredits;
	}
	/** 
	 * Generates a hashCode for Student using all fields
	 * @return hashCode
	 */
	@Override
	public int hashCode() {
		//generates a numerical value for the field
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + maxCredits;
		return result;
	}
	/** 
	 * Compares another object to this object to determine equality based on all fields
	 * @param obj the object to compare
	 * @return true if all fields of the objects are equivalent
	 */
	@Override
	public boolean equals(Object obj) {
		//determines if objects are equivalent
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (maxCredits != other.maxCredits)
			return false;
		return true;
	}
	/**
	 * Returns a String representation of Student
	 * @return comma separated String of all Student fields
	 */
	@Override
	public String toString() {
		return firstName + "," + lastName + "," + id + "," + email + "," + password + "," + maxCredits;
	}
	/**
	 * Compares a student
	 * @param s student to compare
	 * @return 1 if greater, 0 if the same, -1 if less
	 */
	public int compareTo(Student s) 
	{
		int compareToVal = 0;
		/**Tests if the last names are the same**/
		if (this.getLastName().equals(s.getLastName())){
			/**Tests if the first names are the same**/
			if(this.getFirstName().equals(s.getFirstName())){
				/**Tests if the ids are the same**/
				if(this.getId().equals(s.getId()))
					return 0;
				else
				{
					compareToVal = this.getId().compareTo(s.getId());
					if (compareToVal > 0)
						compareToVal = 1;
					else if (compareToVal < 0)
						compareToVal = -1;
					return compareToVal;
				}
			}
			/**If the last names are the same, but the first names aren't the same**/
			else{
				compareToVal = this.getFirstName().compareTo(s.getFirstName());
				if (compareToVal > 0)
					compareToVal = 1;
				else if (compareToVal < 0)
					compareToVal = -1;
				return compareToVal;
			}
		}
		/**If last names are not equal, which comes first**/
		else{
			compareToVal = this.getLastName().compareTo(s.getLastName());
			if (compareToVal > 0)
				compareToVal = 1;
			else if (compareToVal < 0)
				compareToVal = -1;
			return compareToVal;
		}
	}
}
