package com.example.service;

import com.example.dao.PersonDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private  final PersonDao personDao;

    public PersonService(@Qualifier("postgres")PersonDao personDao) {
        this.personDao = personDao;
    }
}
