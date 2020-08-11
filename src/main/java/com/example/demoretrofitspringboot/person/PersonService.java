package com.example.demoretrofitspringboot.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demoretrofitspringboot.requestParameter.IRequestParameter;
import com.example.demoretrofitspringboot.team.ITeamRepository;
import com.example.demoretrofitspringboot.team.Team;

@Service
public class PersonService implements IPersonService {
	@Autowired
	private IPersonRepository personRepository;

	@Autowired
	private ITeamRepository teamRepository;

	public Iterable<Person> findAll(IRequestParameter requestParameter) {
		Pageable pageable = requestParameter.getPageable();
		if (pageable != null) {
			return personRepository.findAll(pageable);
		}

		Sort sort = requestParameter.getSort();
		if (sort != null) {
			return personRepository.findAll(sort);
		}

		return personRepository.findAll();
	}

	public Person findById(Long id) {
		return personRepository.findById(id).orElse(new Person());
	}

	public Person addPerson(Person person) {
		return personRepository.save(person);
	}

	public PersonTeamDTO findTeamsByPersonId(Long id) {
		Person person = personRepository.findById(id).orElse(new Person());
		List<Team> teams = person.getTeams();
		return PersonTeamDTO.createFromBuilder().setId(person.getId()).setTeams(teams).build();
	}

	@Override
	public Person addTeamToPersonById(Long personId, Long teamId) {
		Person person = personRepository.findById(personId).orElse(new Person());
		Team team = teamRepository.findById(teamId).orElse(new Team());
		person.addTeam(team);
		personRepository.save(person);
		return person;
	}
}
