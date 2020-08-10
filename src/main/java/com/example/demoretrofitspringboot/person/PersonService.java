package com.example.demoretrofitspringboot.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.example.demoretrofitspringboot.team.ITeamRepository;
import com.example.demoretrofitspringboot.team.Team;

@Service
public class PersonService implements IPersonService {
	@Autowired
	private IPersonRepository personRepository;

	@Autowired
	private ITeamRepository teamRepository;

	public Iterable<Person> findAll(String sort, int offset, int limit) {
		Sort sortOrder = createSort(sort);
		Pageable pageable = createPageable(offset, limit, sortOrder);

		if (pageable != null) {
			return personRepository.findAll(pageable);
		}

		if (sortOrder != null) {
			return personRepository.findAll(sortOrder);
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

	private Sort createSort(String sort) {
		if (sort != null) {
			List<Order> orders = new ArrayList<>();
			orders.add(new Order(Sort.Direction.ASC, sort));
			return Sort.by(orders);
		}

		return null;
	}

	private Pageable createPageable(int offset, int limit, Sort sort) {
		if ((limit != 0)) {
			if (sort != null) {
				return PageRequest.of(offset, limit, sort);
			} else {
				return PageRequest.of(offset, limit);
			}
		}

		return null;
	}
}
