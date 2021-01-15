package com.example.dao;

import com.example.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
}
