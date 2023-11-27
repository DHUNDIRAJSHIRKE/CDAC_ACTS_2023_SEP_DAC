package beans;

import java.util.List;

import dao.TeamDao;
import dao.TeamDaoImpl;

public class TeamBean {
//Dependency
	private TeamDao teamDao;
	//default constructor
	public TeamBean() {
		//Create a dependency
		teamDao = new TeamDaoImpl();
//		System.out.println("team Bean n team dao created");
	}
	//Add a business Logic method to fetch abbreviations of all teams
	public List<String> fetchTeamsAbbr(){
//		System.out.println("0");
		return teamDao.getAllTeamsAbbreviations();
		
	}
}
