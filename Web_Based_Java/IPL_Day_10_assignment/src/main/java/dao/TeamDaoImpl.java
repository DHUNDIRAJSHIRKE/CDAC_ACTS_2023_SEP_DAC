package dao;

import static utils.HibernateUtils.getFactory;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Team;

public class TeamDaoImpl implements TeamDao {
	
	@Override
	public String addNewTeam(Team team) {
		String msg = "Adding new team failed!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(team);
			tx.commit();
			msg = "Added new Team with ID :"+team.getId();
			}catch(RuntimeException e) {
				if(tx!=null) {
					tx.rollback();
					throw e;
				}
		}

	// TODO Auto-generated method stub
	return msg;
}

	

}
