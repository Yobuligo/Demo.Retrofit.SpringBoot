package com.example.demoretrofitspringboot.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoretrofitspringboot.team.Team;

@Service
public class PersonService implements IPersonService {
	@Autowired
	private IPersonRepository personRepository;

	public Iterable<Person> findAll() {
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

}
