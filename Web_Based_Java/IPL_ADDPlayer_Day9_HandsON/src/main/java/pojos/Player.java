package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "player_id")
	private Integer playerId;// as per the founder(Gavin King) , till hib 5 , use id prop : explicitly
	// serializable
	private String name;
	private int Age;
	private double BattingAvg;
	private int WicketsTaken;
	
	public Player() {
		
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public double getBattingAvg() {
		return BattingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		BattingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return WicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		WicketsTaken = wicketsTaken;
	}

	public Player( String name, int age, double battingAvg, int wicketsTaken) {
		super();
//		this.playerId = playerId;
		this.name = name;
		Age = age;
		BattingAvg = battingAvg;
		WicketsTaken = wicketsTaken;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", name=" + name + ", Age=" + Age + ", BattingAvg=" + BattingAvg
				+ ", WicketsTaken=" + WicketsTaken + "]";
	}

}
