package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
@Repository
public class TeamDaoImpl implements TeamDao {
	
	@PersistenceContext
	EntityManager eManager;
	@Override
	public List<String> getTeamsAbbreviations() {
		String jpql = "select t.abbreviation from Team t";
		 
		return eManager.createQuery(jpql,String.class).getResultList() ;
	}

}
