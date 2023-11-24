package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {
//add a method to insert new team details
	String addTeamDetails(Team newTeam);
	Team getTeamDetailsByAbbr(String Abbr);
	List<Team> getTeamsAboveAge(int i);
	Team getTeamById(int id);
	String updateWicketsNAvg(int w, double bAvg,int id);
}
