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
	private IPersonRepository personRepository;

	@GetMapping("/persons")
	public Iterable<Person> findAll() {
		return personRepository.findAll();
	}

	@GetMapping("/persons/{id}")
	public Person findById(@PathVariable("id") long id) {
		return personRepository.findById(id).orElse(new Person());
	}

	@PostMapping("/persons")
	public Person addPerson(@RequestBody Person person) {
		return personRepository.save(person);
	}
}
