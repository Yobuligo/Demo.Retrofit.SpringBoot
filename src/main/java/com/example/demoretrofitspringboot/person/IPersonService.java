package com.example.demoretrofitspringboot.person;

public interface IPersonService {

	Iterable<Person> findAll();

	Person findById(Long id);

	Person addPerson(Person person);

	PersonTeamDTO findTeamsByPersonId(Long id);

	Person addTeamToPersonById(Long personId, Long teamId);
}
