package com.example.dao;

import com.example.model.Person;
import org.springframework.dao.EmptyResultDataAccessException;
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
        String sql = "select id,name from person";
        return jdbcTemplate.query(sql, (rse, i) -> {
            return new Person(rse.getLong("id"), rse.getString("name"));
        });
    }

    @Override
    public int insertPerson(Person person) {
        String sql = "insert into person(name) values(?);";
        return jdbcTemplate.update(sql, person.getName());
    }

    @Override
    public Optional<Person> selectPersonById(long id) {
        String sql = "select id,name from person where id=?;";
        try {
            Person person = jdbcTemplate.queryForObject(sql, new Object[]{id},
                    (resultSet, i) -> {
                        String name = resultSet.getString("name");
                        return new Person(id, name);
                    });
            return Optional.ofNullable(person);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public int deletePersonById(long id) {
        String sql = "delete from person where id =?;";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Person> selectPersonByName(String name) {
        String sql = "select id,name from person where name  like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + name + "%"},
                (resultSet, i) -> {
                    return new Person(resultSet.getLong("id"), resultSet.getString("name"));
                });
    }

    @Override
    public int updatePerson(long id, Person personToUpdate) {
        String sql = "update person set name = ? where id = ?;";
        return jdbcTemplate.update(sql, personToUpdate.getName(), id);
    }
}
