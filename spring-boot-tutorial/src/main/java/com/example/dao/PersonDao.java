package com.example.dao;

import com.example.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {

    List<Person> selectAllPeople();

    List<Person> selectPersonByName(String name);

    Optional<Person> selectPersonById(int id);

    int insertPerson(Person person);

    int deletePersonById(int id);

    int updatePersonById(int id, Person person);
}
