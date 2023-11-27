package dao;

import static utils.HibernateUtils.getFactory;

import java.sql.SQLException;
import java.util.ArrayList;
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

	public List<Team> getSelectedDetails() {
		List<Team> list = new ArrayList<>();
		return list;
	}

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
	
	
	
	public List<String> getAllTeamsAbbreviations(){
		System.out.println("1");
		List<String> abbrList = null;
		String jpql = "select t.abbreviation from Team t ";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			abbrList = session.createQuery(jpql,String.class).getResultList();
			System.out.println("1.5");
			tx.commit();
		}
		catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		System.out.println("2");
		return abbrList;
	}

	@Override
	public Team getTeamByAbbreviation(String abbr) {
		// 
		System.out.println("1.1 "+abbr);
		Team team = null;
		String jpql = "select t from Team t where abbreviation=:ab ";
		System.out.println("1.2");
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
	
			team = session.createQuery(jpql,Team.class).setParameter("ab", abbr).getSingleResult();
			System.out.println("1.3");
//			System.out.println("1.5");
			tx.commit();
			System.out.println("1.4");
		}
		catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		System.out.println("1.5");
		return team;
	}

}
