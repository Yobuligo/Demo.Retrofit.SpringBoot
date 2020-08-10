package com.example.demoretrofitspringboot.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {
	@Autowired
	private IPersonService personService;

	@GetMapping("/persons")
	public Iterable<Person> findAll(@RequestParam(name = "sort", required = false) String sort,
			@RequestParam(name = "offset", required = false) String offset,
			@RequestParam(name = "limit", required = false) String limit) {

		int internalOffset = 0;
		int internalLimit = 0;

		if (offset != null) {
			internalOffset = Integer.parseInt(offset);
		}

		if (limit != null) {
			internalLimit = Integer.parseInt(limit);
		}

		return personService.findAll(sort, internalOffset, internalLimit);
	}

	@GetMapping("/persons/{id}")
	public Person findById(@PathVariable("id") long id) {
		return personService.findById(id);
	}

	@PostMapping("/persons")
	public Person addPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}

	@GetMapping("/persons/{id}/teams")
	public PersonTeamDTO findTeamsByPersonId(@PathVariable("id") Long id) {
		return personService.findTeamsByPersonId(id);
	}

	@PostMapping("/persons/{person_id}/teams/{team_id}")
	public void addTeamToPersonById(@PathVariable("person_id") Long personId, @PathVariable("team_id") Long teamId) {
		personService.addTeamToPersonById(personId, teamId);
	}
}
