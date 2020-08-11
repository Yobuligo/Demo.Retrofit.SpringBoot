package com.example.demoretrofitspringboot.person;

import com.example.demoretrofitspringboot.requestParameter.IRequestParameter;

public interface IPersonService {

	Iterable<Person> findAll(IRequestParameter requestParameter);

	Person findById(Long id);

	Person addPerson(Person person);

	PersonTeamDTO findTeamsByPersonId(Long id);

	Person addTeamToPersonById(Long personId, Long teamId);

}
