package com.example.dao;

import com.example.model.Person;

import java.util.List;

public interface PersonDao {
    List<Person> selectAllPeople();

    public int insertPerson(Person person);
}
