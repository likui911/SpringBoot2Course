package com.example.dao;

import com.example.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mysql")
public class PersonDaoMysql implements PersonDao {
    private final JdbcTemplate jdbcTemplate;

    public PersonDaoMysql(JdbcTemplate jdbcTemplate) {
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
}
