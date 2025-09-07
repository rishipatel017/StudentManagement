package in.ac.adit.studentmanagement.dao;

import java.util.List;

import in.ac.adit.studentmanagement.model.Student;

/**
 * StudentDAO defines the operations to be performed on the Student data model.
 * It serves as an abstraction for CRUD operations and authentication mechanisms.
 */

public interface StudentDAO {
	    /**s
	     * Saves a new Student's credentials and profile data into the database.
	     *
	     * @param student The Student object to be saved.
	     * @return true if the operation was successful, false otherwise.
	     */
	    public boolean save(Student student);

	    /**
	     * Retrieves a list of all students from the database.
	     *
	     * @return A List of Student objects.
	     */
	    public List<Student> getAllStudent();

	    /**
	     * Retrieves a specific student record based on username.
	     *
	     * @param username The unique username of the student.
	     * @return An student object if found, null otherwise.
	     */
	    public Student getStudent(String username);

	    /**
	     * Authenticates the user by checking the provided credentials against the database.
	     *
	     * @param username The entered username.
	     * @param password The entered password.
	     * @return true if authentication is successful, false otherwise.
	     */
	    public boolean isAuthenticated(String username, String password);
}
