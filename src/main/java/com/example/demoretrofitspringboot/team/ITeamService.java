package com.example.demoretrofitspringboot.team;

import com.example.demoretrofitspringboot.requestParameter.IRequestParameter;

public interface ITeamService {
	Iterable<Team> findAll(IRequestParameter requestParameter);

	Team findById(Long id);

	Team addTeam(Team team);
}
