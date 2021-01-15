package com.example.dao;

import com.example.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {
    List<Person> selectAllPeople();

    public int insertPerson(Person person);

    public Optional<Person> selectPersonById(long id);

    public int deletePersonById(long id);

    public List<Person> selectPersonByName(String name);

    public int updatePerson(long id,Person personToUpdate);
}
