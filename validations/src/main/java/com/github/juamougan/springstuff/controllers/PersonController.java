package com.github.juamougan.springstuff.controllers;

import com.github.juamougan.springstuff.entities.Cuil;
import com.github.juamougan.springstuff.entities.Person;
import com.github.juamougan.springstuff.services.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.github.juamougan.springstuff.services.PeopleService.nextId;

@RestController
@Slf4j
public class PersonController {

  @Autowired
  private PeopleService peopleService;

  @PostMapping("/people")
  Person addPerson(@Valid @RequestBody Person person) {       // Need to annotate with @Valid
    return new Person(nextId(), person.getName(), person.getAge(), person.getEmail());
  }

  @PutMapping("/people/{id}/cuil")
  // Without @Valid it won't validate :)
  Cuil addCuilToPerson(@PathVariable("id") Long id, @Valid @RequestBody Cuil cuil) {
    log.info("Will add cuil {} to person with id {}", cuil, id);
    return new Cuil(cuil.getCuil());
  }

  // To test the 404 error code
  @GetMapping("/people/{id}")
  Person getPerson(@PathVariable("id") Long id) {
    Person p = peopleService.getPerson(id);
    if (p == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
    }
    return p;
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(
    MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }

}
