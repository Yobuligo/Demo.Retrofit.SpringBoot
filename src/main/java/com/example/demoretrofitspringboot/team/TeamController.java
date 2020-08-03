package com.example.demoretrofitspringboot.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeamController {
	@Autowired
	private ITeamService teamService;

	@GetMapping("/teams")
	public Iterable<Team> findAll() {
		return teamService.findAll();
	}

	@GetMapping("/teams/{id}")
	public Team findById(@PathVariable("id") Long id) {
		return teamService.findById(id);
	}

	@PostMapping("/teams")
	public Team addTeam(@RequestBody Team team) {
		return teamService.addTeam(team);
	}
}
