package com.example.dao;

import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("mysql")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(Person person) {
        final String sql = "INSERT INTO person ( name )  VALUES( ? )";
        jdbcTemplate.update(sql, person.getName());
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT id,name FROM person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            return new Person(id, name);
        });
    }

    @Override
    public List<Person> selectPersonByName(String key) {
        final String sql = "SELECT id,name FROM person WHERE name LIKE ?";

        return jdbcTemplate.query(sql, new Object[]{"%" + key + "%"}, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            return new Person(id, name);
        });
    }

    @Override
    public Optional<Person> selectPersonById(int id) {
        final String sql = "SELECT name FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    String name = resultSet.getString("name");
                    return new Person(id, name);
                });
        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(int id) {
        final String sql = "DELETE FROM person WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updatePersonById(int id, Person person) {
        final String sql = "UPDATE person SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, person.getName(), id);
    }
}
