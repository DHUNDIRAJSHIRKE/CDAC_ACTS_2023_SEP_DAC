package beans;

import java.time.LocalDate;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

public class PlayerBean {
	public PlayerDao playerDao;
	public TeamDao teamDao;
	public PlayerDao getPlayerDao() {
		return playerDao;
	}
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	public TeamDao getTeamDao() {
		return teamDao;
	}
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	private String abbr;
	private String fName;
	private String lName;
	private String dob;
	private double avg;
	private int wickets;
	public String msg;
	public String getMsg() {
		return msg;
	}
	
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public PlayerBean() {
		System.out.println("Player bean constructor");
		playerDao = new PlayerDaoImpl();
		teamDao = new TeamDaoImpl();
	}
	
	public String validateNaddPlayer() {
		//validation logic
		//get team details by it's abbreviation
		System.out.println("1");
		Team team = teamDao.getTeamByAbbreviation(abbr);
		LocalDate LDDob = LocalDate.parse(dob);
		LocalDate validDOb = LocalDate.now().minusYears(21);
		System.out.println("1.6");
		if(LDDob.isAfter(validDOb) || avg<team.getMinBattingAvg() || wickets<team.getMinWicketsTaken()) {
			msg = "Player Can't be added. not a good fit!!";
			System.out.println("1.7");
			return "add_player_form";
		}
		System.out.println("2");
		Player newPlayer = new Player(fName, lName, validDOb, avg, wickets);
		msg= playerDao.savePlayerDetails(newPlayer, team.getId());
		System.out.println("3");
		return msg;
		
	}
	
	public String addPlayer(Player newPlayer,Long TeamId) {
		
		return playerDao.savePlayerDetails(newPlayer, TeamId);
	}
}
