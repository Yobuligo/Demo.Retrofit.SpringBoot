package com.example.demoretrofitspringboot.person;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends CrudRepository<Person, Long> {

	Iterable<Person> findAll(Sort sort);

	Iterable<Person> findAll(Pageable pageable);

}
