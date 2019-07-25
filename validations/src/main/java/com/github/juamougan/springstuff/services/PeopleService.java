package com.github.juamougan.springstuff.services;

import com.github.juamougan.springstuff.entities.Person;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PeopleService {

    private static Long nextId = 0L;

    private static final List<Person> people = Arrays.asList(
            new Person(nextId(), "Rigoberto", 56, "rigo@berto.com"),
            new Person(nextId(), "Tomasa", 59, "tomasa@mail.com"),
            new Person(nextId(), "Robustiano", 97, "elviejo@mail.com")
    );

    public static Long nextId() {
        nextId++;
        return nextId;
    }

    public List<Person> retrieveAll() {
        return people;
    }

    public Person getPerson(Long id) {
        return people
                .stream()
                .filter(p -> id.equals(p.getId()))
                .findFirst()
                .orElse(null);
    }

}
