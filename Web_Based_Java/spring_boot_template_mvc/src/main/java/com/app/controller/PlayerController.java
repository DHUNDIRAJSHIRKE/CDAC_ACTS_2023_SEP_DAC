package com.app.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.PlayerService;

@Controller
@RequestMapping
public class PlayerController {
//http://localhost:8080/day15_lab/players/add
	//dependency : PlayerService i/f
	
	
	private PlayerService playerService;
	@PostMapping("/addPlayer")
	public String getTeamAbbr(ModelMap modelMap) {
		modelMap.addAttribute("team_list",playerService.getAbbr());
		return "/teams/add_player_form";//AVN : /WEB-INF/views/add_player_form
	}
	
	@PostMapping("/add")
	public String addPlayer(@RequestParam String abbr,
			@RequestParam String fn,
			@RequestParam String ln,
			@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dob,
			@RequestParam double avg,
			@RequestParam int wickets,
			@RequestParam long teamId,Model map ) {
		
	return null;
	}
	
}
