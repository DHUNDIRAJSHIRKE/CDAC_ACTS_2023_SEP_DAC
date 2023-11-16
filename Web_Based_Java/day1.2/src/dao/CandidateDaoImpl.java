package dao;

import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.*;

import pojos.Candidate;

public class CandidateDaoImpl implements CandidateDao {
	private Connection connection;
	private PreparedStatement pst1;

	public CandidateDaoImpl() throws SQLException {
		connection = openConnection();
		pst1 = connection.prepareStatement("select * from candidates");
		System.out.println("Candidate Dao created!");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		ArrayList<Candidate> candidateList = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next()) {
				candidateList.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
			}
		}
		return candidateList;
	}

	public void cleanUp() throws SQLException {

		pst1.close();
		closeConnection();
		System.out.println("Clean up done!");

	}

}
