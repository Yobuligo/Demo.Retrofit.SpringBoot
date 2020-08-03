package com.example.demoretrofitspringboot.team;

public interface ITeamService {
	Iterable<Team> findAll();

	Team findById(Long id);

	Team addTeam(Team team);
}
