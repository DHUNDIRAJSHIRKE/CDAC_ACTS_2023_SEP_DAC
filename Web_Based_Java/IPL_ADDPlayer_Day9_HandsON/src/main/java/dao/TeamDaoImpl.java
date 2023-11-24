package dao;

import pojos.Team;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String addTeamDetails(Team newTeam) {
		// 1. open hibernate session from SF
		Session session = getFactory().openSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			session.save(newTeam);
			//end of try => success
			tx.commit();
		} catch (RuntimeException e) {
			// rollback tx n re throw the exc to the caller
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			// close the session
			if (session != null)
				session.close();
		}
		return "Added new Team with ID "+newTeam.getTeamId();
	}

	@Override
	public Team getTeamDetailsByAbbr(String Abbr) {
		Team team = null;
		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		String jpql = "select t from Team t where t.abbreviation=:Abbr";
		try {
			team = session.createQuery(jpql, Team.class).setParameter("Abbr", Abbr).getSingleResult();
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
		return team;
	}

	@Override
	public List<Team> getTeamsAboveAge(int a) {
		List<Team> list = new ArrayList<>();
		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select t from Team t where t.maxAge>=:age";
		try {
			list = session.createQuery(jpql,Team.class).setParameter("age", a).getResultList();
		}catch(RuntimeException e) {
			tx.rollback();
			throw e;
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public Team getTeamById(int id) {
//		String jpql = "select t from Team t where ";
		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();
		Team team = null;
		try {
			team = session.get(Team.class,id);
		}catch(RuntimeException e) {
			tx.rollback();
			throw e;
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return team;
	}

	@Override
	public String updateWicketsNAvg(int wickets , double bAvg,int id) {
		String ret = "Updation Failed!!";
//		String jpql = "update Team t set minWicketsTaken=:w and minBattingAvg=:avg";
		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();
		Team t = null;
		try {
			t = session.get(Team.class,id);
			t.setMinBattingAvg(bAvg);
			t.setMinWicketsTaken(wickets);
			tx.commit();
			ret = "Values Updated!!";
//			session.createQuery(jpql,Team.class).setParameter("w",wickets).setParameter("avg", bAvg).executeUpdate();
		}catch(RuntimeException e) {
			tx.rollback();
			throw e;
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return ret;
	}

}
