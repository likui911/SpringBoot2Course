package com.example.service;

import com.example.dao.PersonDao;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonDao personDao;

    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(long id) {
        return personDao.selectPersonById(id);
    }

    public int deletePersonById(long id) {
        return personDao.deletePersonById(id);
    }

    public List<Person> getPersonByName(String name) {
        return personDao.selectPersonByName(name);
    }

    public int updatePerson(long id, Person personToUpdate) {
        return personDao.updatePerson(id, personToUpdate);
    }
}
