package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static utils.DBUtils.*;
import pojos.Player;

public class PlayerDaoImpl implements PlayerDao{
	private Connection cn;
	private PreparedStatement pst1, pst2;
	
	public PlayerDaoImpl() throws SQLException {
		cn = getCn();
		pst1 = cn.prepareStatement("insert into players values(default, ?,?,?,?,?,?)");
		System.out.println("Player Dao Created!!");
	}
	
	@Override
	public String addPlayerToTeam(Player newPlayer, int teamId) throws SQLException {
		pst1.setString(1, newPlayer.getFirstName());
		pst1.setString(2, newPlayer.getLastName());
		pst1.setDate(3, newPlayer.getDob());
		pst1.setDouble(4, newPlayer.getBattingAvg());
		pst1.setInt(5, newPlayer.getWicketsTaken());
		pst1.setInt(6, teamId);
		
		int rows = pst1.executeUpdate();
		if(rows == 1) {
			return "New Player Added successfully!!";
		}
		return "Couldn't add the player!!";
	}
	
	public void cleanUp() throws SQLException {
		if(pst1 != null) {
			pst1.close();
			System.out.println(" PlayerDaoImplementation cleaned up!!");
		}
	}
	
	
}
