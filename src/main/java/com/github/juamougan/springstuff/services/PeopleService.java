package com.github.juamougan.springstuff.services;

import com.github.juamougan.springstuff.entities.Person;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PeopleService {

    public List<Person> retrieveAll() {
        return Arrays.asList(
                new Person("Rigoberto", 56, "rigo@berto.com"),
                new Person("Tomasa", 59, "tomasa@mail.com"),
                new Person("Robustiano", 97, "elviejo@mail.com")
        );
    }

}
