package com.example.demoretrofitspringboot.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {
	@Autowired
	private IPersonService personService;

	@GetMapping("/persons")
	public Iterable<Person> findAll() {
		return personService.findAll();
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
}
