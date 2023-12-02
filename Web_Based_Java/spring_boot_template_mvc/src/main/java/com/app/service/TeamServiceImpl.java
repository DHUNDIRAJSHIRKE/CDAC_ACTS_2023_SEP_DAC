package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.TeamDao;
@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	TeamDao teamDao ;
	@Override
	public List<String> getAbbr() {
		
		return teamDao.getTeamsAbbreviations();
	}

}
