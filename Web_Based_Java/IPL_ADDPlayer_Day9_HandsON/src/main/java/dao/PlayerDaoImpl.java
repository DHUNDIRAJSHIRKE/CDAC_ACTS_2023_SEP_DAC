package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addPlayerDetails(Player newPlayer) {
		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(newPlayer);
			tx.commit();
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		
		return "Added new Player"+newPlayer.getName();
	}

}
