package com.example.demoretrofitspringboot.team;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface ITeamRepository extends CrudRepository<Team, Long> {
	Iterable<Team> findAll(Sort sort);

	Iterable<Team> findAll(Pageable pageable);

}
