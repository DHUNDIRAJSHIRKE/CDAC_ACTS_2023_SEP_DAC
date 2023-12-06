package com.app.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.PlayerDao;
import com.app.pojos.Player;

public class PlayerServiceImpl implements PlayerService {

	
	@Autowired
	private PlayerDao playerDao;
	
	

	@Override
	public String addPlayerToTeam(Player newPlayer, String abbreviation) {
		// TODO Auto-generated method stub
		
		return null;
	}



	@Override
	public String addPlayer(Player player, Model map) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
