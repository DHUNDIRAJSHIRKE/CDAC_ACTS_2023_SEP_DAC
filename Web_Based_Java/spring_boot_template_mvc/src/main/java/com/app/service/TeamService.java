package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dao.TeamDao;

@Service
public interface TeamService {
	
	List<String> getAbbr();
}
