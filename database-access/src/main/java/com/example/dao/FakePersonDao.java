package com.example.dao;

import com.example.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("fake")
public class FakePersonDao implements PersonDao {
    private static final List<Person> DB = new ArrayList<>();
    private static int max = 0;

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public int insertPerson(Person person) {
        DB.add(new Person(max++, person.getName()));
        return 1;
    }

    @Override
    public Optional<Person> selectPersonById(long id) {
        return DB.stream().filter(person -> person.getId() == id).findFirst();
    }

    @Override
    public int deletePersonById(long id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if (!personMaybe.isPresent()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public List<Person> selectPersonByName(String name) {
        return DB.stream().filter(person -> person.getName().indexOf(name) != -1).collect(Collectors.toList());
    }

    @Override
    public int updatePerson(long id, Person personToUpdate) {
        Optional<Person> person = selectPersonById(id);
        if (person.isPresent()) {
            DB.set(DB.indexOf(person.get()), new Person(id, personToUpdate.getName()));
            return 1;
        }
        return 0;
    }
}
