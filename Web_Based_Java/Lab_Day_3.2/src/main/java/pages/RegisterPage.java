package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojos.User;
import dao.UserDaoImpl;
import java.sql.Date;
import dao.UserDaoImpl;

/**
 * Servlet implementation class RegisterPage
 */
@WebServlet("/signup")
public class RegisterPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("in init of " + getClass());
		try {
			userDao = new UserDaoImpl();
		} catch (SQLException e) {
			throw new ServletException("Error in init of " + getClass(), e);
		}

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy of " + getClass());
		try {
			userDao.cleanUp();
		} catch (SQLException e) {
			throw new RuntimeException("Error in destroy of " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String firstName, String lastName, String email, String password, Date dob
		response.setContentType("text/html");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("em");
		String pass = request.getParameter("pass");
		LocalDate unCheckedDob = LocalDate.parse(request.getParameter("dob"));
		LocalDate checkedDob = checkDob(unCheckedDob);
		Date dob = Date.valueOf(checkedDob);
//		Date dob = Date.parse(request.getParameter("dob"));
		User newUser = new User(fname, lname, email, pass, dob);
		String temp = "";

		try (PrintWriter pw = response.getWriter()) {
			try {
				temp = userDao.registerNewVoter(newUser);
			} catch (SQLException e) {
				pw.print(e);
//				pw.print("<h3>Voter reg failed!!!!!!!!!!!!!</h3>");
			}
			pw.print(temp);
		}

	}

	private LocalDate checkDob(LocalDate unCheckedDob) throws ServletException {
//		LocalDate checkedDob;
		LocalDate now = LocalDate.now();
		LocalDate allowedDob = now.minusYears(21);
		if (allowedDob.isBefore(unCheckedDob)) {
			throw new ServletException("Age is below 21!! ");
		}
		return unCheckedDob;
	}

}
