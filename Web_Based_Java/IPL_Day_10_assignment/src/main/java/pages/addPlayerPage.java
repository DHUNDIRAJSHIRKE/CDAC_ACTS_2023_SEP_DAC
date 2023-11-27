package pages;
import utils.HibernateUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import dao.TeamDao;
import dao.TeamDaoImpl;
import static utils.DBUtils.*;

/**
 * Servlet implementation class addPlayerPage
 */
@WebServlet("/l")
public class addPlayerPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlayerDaoImpl playerDao;
	private TeamDaoImpl teamDao;
	private Connection cn;
	public addPlayerPage() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	public void init() throws ServletException {
		try {
			cn = openConnection();
			 playerDao = new PlayerDaoImpl();
			 teamDao = new TeamDaoImpl();
		} catch (Exception e) {
			throw new ServletException("error in init of " + getClass(), e);
		}
	}*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		session.setAttribute("player_dao", playerDao);
		session.setAttribute("team_dao", teamDao);
		try (PrintWriter pw = response.getWriter()) {
			List<String> teamsAbbreviations = teamDao.getTeamsAbbreviations();
			System.out.println("In here" + teamsAbbreviations);
			pw.print("<form method = 'post' action = 'validationPage'>");
			pw.print("<h5>Choose a Team : <select name = 'abbreviation'>");
			for (String s : teamsAbbreviations) {

				pw.print("<h5><option value='" + s + "'>"+s+"</option>" + "</h5>");
			}
			pw.print("</select>");
			pw.print("<h5>Player Name <input type='text' name='nm'/></h5>");
			pw.print("<h5>DoB <input type='date' name='dob'/></h5>");
			pw.print("<h5>Batting Avg <input type='number' name='avg'/></h5>");
			pw.print("<h5>Wickets Taken <input type='text' name='wickets'/></h5>");
			pw.print("<input type='submit' value='Submit' >");
			pw.print("</form>");
		} catch (Exception e) {
			throw new ServletException("error in do-get" + getClass(), e);
		}
	}

	public void destroy() {
		try {
			playerDao.cleanUp();
			teamDao.cleanUp();
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
