package com.example.demoretrofitspringboot.person;

import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends CrudRepository<Person, Long> {

}
