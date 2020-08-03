package com.example.demoretrofitspringboot.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService implements ITeamService {
	@Autowired
	private ITeamRepository teamRepository;

	public Iterable<Team> findAll() {
		return teamRepository.findAll();
	}

	public Team findById(Long id) {
		return teamRepository.findById(id).orElse(new Team());
	}

	public Team addTeam(Team team) {
		return teamRepository.save(team);
	}
}
