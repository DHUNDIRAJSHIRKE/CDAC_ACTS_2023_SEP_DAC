package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.TeamService;

@Controller
public class TeamController {
	@Autowired
	TeamService teamService;
	@RequestMapping("/index")
	public String getTeamAbbr(ModelMap modelMap) {
		modelMap.addAttribute("team_list",teamService.getAbbr()).addAttribute("TEAM_LIST",teamService.getAbbr());
		return "/teams/add_player_form";//AVN : /WEB-INF/views/add_player_form
	}
	
	
	/*
	 * @Autowired PlayerService playerServiec;
	 * 
	 * @RequestMapping("/player/add") public String addPlayer(ModelMap modelMap) {
	 * 
	 * @RequestParam
	 * 
	 * }
	 */
}
