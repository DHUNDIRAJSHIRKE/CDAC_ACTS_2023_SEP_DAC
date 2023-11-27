package pojos;
import java.time.LocalDate;

/*
 * id , first_name,last_name, dob,batting_avg,wickets_taken....
+team_id 
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="players")
public class Player extends BaseEntity {
	@Column(name="First_Name",length=20)
	private String firstName;
	@Column(name="Last_Name",length=20)
	private String lastName;
	@Column(name="Date_of_Birth")
	private LocalDate dob;
	@Column(name="Batting_Average")
	private double battingAvg;
	@Column()
	private int wicketsTaken;
	@ManyToOne
	@JoinColumn(name="Team_Id")
	private Team myTeam;
	public Player() {
		
	}
	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", battingAvg="
				+ battingAvg + ", wicketsTaken=" + wicketsTaken + ", myTeam=" + myTeam + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public double getBattingAvg() {
		return battingAvg;
	}
	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	public Team getMyTeam() {
		return myTeam;
	}
	public void setMyTeam(Team myTeam) {
		this.myTeam = myTeam;
	}
	public Player(String firstName, String lastName, LocalDate dob, double battingAvg, int wicketsTaken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}
	
	
	
	
}
