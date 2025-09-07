package in.ac.adit.studentmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * StudentDAOImpl provides concrete implementations of StudentDAO interface.
 * It uses JDBC with PreparedStatement to securely interact with the MySQL database.
 */
import in.ac.adit.studentmanagement.model.Student;

public class StudentDAOImpl implements StudentDAO{
	
	// credential details to configure connection to database 
	private final String DBNAME = "student_db";
    private final String DBUSER = "root";
    private final String DBPASSWORD = "admin@2905";
    private final String CONURL = "jdbc:mysql://localhost:3306/" + DBNAME;

    static Connection connection;
    PreparedStatement pstm;
    ResultSet resultSet;
    
    /**
     * Constructor that initializes the database connection.
     */
    public StudentDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(CONURL, DBUSER, DBPASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Load Driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Constructor Error: " + e.getMessage());
        }
    }
    
    /**
     * Saves the student login credentials and personal details into two separate tables.
     *
     * @param student The Student object to be saved.
     * @return true if both inserts succeed, false otherwise.
     */

	@Override
	public boolean save(Student student) {
		try {
            pstm = connection.prepareStatement("insert into login_info_tbl (username,password) values (?,?)");
            pstm.setString(1, student.getStudentid());
            pstm.setString(2, student.getPassword());
            pstm.execute();

            pstm = connection.prepareStatement(
                "insert into student_info_tbl (studentid,firstname,lastname,email,course,gender) values(?,?,?,?,?,?)"
            );
            pstm.setString(1, student.getStudentid());
            pstm.setString(2, student.getFirstname());
            pstm.setString(3, student.getLastname());
            pstm.setString(4, student.getEmail());
            pstm.setString(5, student.getCourse());
            pstm.setString(6, student.getGender());
            pstm.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudent(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Checks if the provided credentials match a record in the login table.
	 *
	 * @param username The username.
	 * @param password The password.
	 * @return true if credentials match, false otherwise.
	*/
	@Override
	public boolean isAuthenticated(String username, String password) {
		try {
	            pstm = connection.prepareStatement("select username from login_info_tbl where username = ? and password = ?");
	            pstm.setString(1, username);
	            pstm.setString(2, password);
	            resultSet = pstm.executeQuery();
	            return resultSet.next(); // Returns true if a record is found
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
}
