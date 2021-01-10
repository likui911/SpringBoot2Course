package com.example.dao;

import com.example.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static int max = 0;
    private static final List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(Person person) {
        DB.add(new Person(max++, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public List<Person> selectPersonByName(String name) {
        return null;
    }

    @Override
    public Optional<Person> selectPersonById(int id) {
        return DB.stream()
                .filter(person -> person.getId() == id)
                .findFirst();
    }

    @Override
    public int deletePersonById(int id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if (!personMaybe.isPresent()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(int id, Person update) {
        return selectPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
