package com.example.dao;

import com.example.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("postgres")
public class PersonDaoPostgres implements PersonDao {
    private final JdbcTemplate jdbcTemplate;

    public PersonDaoPostgres(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> selectAllPeople() {
        return null;
    }

    @Override
    public int insertPerson(Person person) {
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(long id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(long id) {
        return 0;
    }

    @Override
    public List<Person> selectPersonByName(String name) {
        return null;
    }

    @Override
    public int updatePerson(long id, Person personToUpdate) {
        return 0;
    }
}
