package in.ac.adit.studentmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.studentmanagement.dao.StudentDAOImpl;
import in.ac.adit.studentmanagement.model.Student;

/**
 * Servlet implementation class SignupController
 * 
 * Handles user signup functionality by capturing form data, creating a new
 * Employee object, saving it via DAO layer, and forwarding the response to
 * appropriate view (JSP).
 * 
 * Mapped to URL: /SignupController
 * 
 * This controller is part of the MVC architecture and acts as a mediator
 * between the View (signup.jsp) and Model (Employee, DAO).
 * 
 * @author Rishi Patel
 * @version 1.0
 * @since 07-09-2025
 */
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Processes HTTP request (GET/POST) for student registration.
	 * 
	 * @param request  HttpServletRequest object that contains the request the
	 *                 client made
	 * @param response HttpServletResponse object that contains the response the
	 *                 servlet returns
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Retrieve form data from request parameters
		String username = request.getParameter("studentId");
		String password = request.getParameter("password"); // currently unused (you may consider saving or hashing)
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		String gender = request.getParameter("gender");

		// Populate Employee model with retrieved data
		Student student = new Student();
		student.setStudentid(username);
		student.setFirstname(firstname);
		student.setLastname(lastname);
		student.setEmail(email);
		student.setCourse(course);
		student.setGender(gender);
		student.setPassword(password);

		// Instantiate DAO implementation to interact with database
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();

		// Define dispatcher for redirecting to appropriate view
		RequestDispatcher rd;

		// Save student to database and forward to appropriate JSP
		if (studentDAOImpl.save(student)) {
			request.setAttribute("msg", "Employee Created..");
			rd = request.getRequestDispatcher("login.jsp");
		} else {
			request.setAttribute("msg", "Error Pls Resolve");
			rd = request.getRequestDispatcher("register.jsp");
		}

		// Forward the request and response
		rd.forward(request, response);
	}
}
