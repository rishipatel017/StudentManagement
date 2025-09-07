package in.ac.adit.studentmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ac.adit.studentmanagement.dao.StudentDAOImpl;

/**
 * The {@code AuthenticateServlet} class handles user authentication requests.
 * <p>
 * This servlet is mapped to the URL pattern {@code /AuthenticateServlet} using
 * the {@code @WebServlet} annotation. Typically, it processes login credentials
 * submitted via an HTTP POST or GET request and validates them against stored
 * user data (e.g., database or config).
 * </p>
 *
 * <p>
 * <b>Note:</b> Currently, the {@code service()} method is empty and should be
 * implemented to handle login functionality.
 * </p>
 *
 * @author Rishi Patel
 * @version 1.0
 * @since 07-09-2025
 */
@WebServlet("/AuthenticateServlet")
public class AuthenticateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Handles both GET and POST requests for user authentication.
	 * <p>
	 * Override this method to add logic for extracting login credentials from the
	 * {@code HttpServletRequest}, validating them, managing session state, and
	 * redirecting the user based on authentication status.
	 * </p>
	 *
	 * @param request  the {@code HttpServletRequest} object containing client
	 *                 request data
	 * @param response the {@code HttpServletResponse} object used to return
	 *                 response to client
	 * @throws IOException
	 * @throws ServletException
	 */
	
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        StudentDAOImpl student = new StudentDAOImpl();
        
        RequestDispatcher rd;

		if (student.isAuthenticated(username, password)) {
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("home.jsp");		
		} else{
			request.setAttribute("msg","Invalid Credentials");
			rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request,response);
		}
    }
}
