package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojos.Team;

/**
 * Servlet implementation class validationPage
 */
@WebServlet("/validationPage")
public class validationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validationPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pq = response.getWriter()){				
			HttpSession session = request.getSession();
			TeamDaoImpl teamDao = (TeamDaoImpl) session.getAttribute("team_dao");
			PlayerDaoImpl playerDao = (PlayerDaoImpl) session.getAttribute("player_dao");
			if(teamDao != null) {
				String abbr = request.getParameter("abbrevation"); 
				Team team = teamDao.getTeamDetails(abbr);
				String playerName = request.getParameter("nm");
//				String lastName = request.getParameter("lnm");
				String unParsedDob = request.getParameter("dob");
				int batAvg = Integer.parseInt(request.getParameter("avg"));
				int wickets = Integer.parseInt(request.getParameter("wickets"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
