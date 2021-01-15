package com.example.api;

import com.example.model.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        this.personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(params = "name")
    public List<Person> getPersonByName(@RequestParam("name") String name) {
        return personService.getPersonByName(name);
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable long id) {
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deletePersonById(@PathVariable int id) {
        return personService.deletePersonById(id);
    }

    @PutMapping(path = "{id}")
    public int updatePerson(@PathVariable int id, @RequestBody Person personToUpdate) {
        return personService.updatePerson(id,personToUpdate);
    }

}