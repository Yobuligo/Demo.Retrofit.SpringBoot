package com.example.demoretrofitspringboot.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demoretrofitspringboot.requestParameter.IRequestParameter;

@Service
public class TeamService implements ITeamService {
	@Autowired
	private ITeamRepository teamRepository;

	public Iterable<Team> findAll(IRequestParameter requestParameter) {
		Pageable pageable = requestParameter.getPageable();
		if (pageable != null) {
			return teamRepository.findAll(pageable);
		}

		Sort sort = requestParameter.getSort();
		if (sort != null) {
			return teamRepository.findAll(sort);
		}

		return teamRepository.findAll();
	}

	public Team findById(Long id) {
		return teamRepository.findById(id).orElse(new Team());
	}

	public Team addTeam(Team team) {
		return teamRepository.save(team);
	}
}
