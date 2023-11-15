package dao;

import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;

public class CandidateDaoImpl implements CandidateDao {
	private Connection connection;
	private PreparedStatement pst1;

	public CandidateDaoImpl() throws SQLException {
		connection = openConnection();
		pst1 = connection.prepareStatement("select * from candidates");
	}
	
	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		ArrayList<Candidate> candidateList = new ArrayList<>();
		try(ResultSet rst = pst1.executeQuery()){
			
		}
		return candidateList;
	}

}
