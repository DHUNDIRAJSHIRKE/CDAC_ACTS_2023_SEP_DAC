package com.app.service;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Player;

public interface PlayerService {
	String addPlayerToTeam(Player newPlayer, String abbreviation);
	String addPlayer(Player player,Model map);
}
