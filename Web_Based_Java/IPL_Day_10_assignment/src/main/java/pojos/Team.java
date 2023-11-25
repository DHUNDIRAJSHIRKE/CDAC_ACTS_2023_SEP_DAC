package pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
/*
 * id , name, abbreviation,owner,max_age,batting_avg,wickets_taken	
 */
@Entity
@Table(name = "Teams")
public class Team extends BaseEntity{
	@Column(length=30)
	private String name;
	@Column(length=5)
	private String abbreviation;
	@Column(length=20)
	private String owner;
	@Column
	private int maxAge;
	@Column
	private double minBattingAvg;
	@Column
	private int minWicketsTaken;
	@OneToMany(mappedBy = "myTeam")
	private List<Player> players = new ArrayList<>();
	
	public Team(String name, String abbreviation, String owner, int maxAge, double minBattingAvg, int minWicketsTaken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}


	public Team() {
		// TODO Auto-generated constructor stub
	}
	
	
	


	
	public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public double getMinBattingAvg() {
		return minBattingAvg;
	}
	public void setMinBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}
	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}
	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}
	public void addPlayer(Player p) {
		players.add(p);
		p.setMyTeam(this);
	}
	public void removePlayer(Player p) {
		players.remove(p);
		p.setMyTeam(null);
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner + ", maxAge=" + maxAge
				+ ", minBattingAvg=" + minBattingAvg + ", minWicketsTaken=" + minWicketsTaken + ", players=" + players
				+ "]";
	}
	
	
}
