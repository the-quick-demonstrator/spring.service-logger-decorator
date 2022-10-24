package com.github.curriculeon.controllers;

import com.github.curriculeon.models.Person;
import com.github.curriculeon.services.PersonServiceInterface;
import com.github.curriculeon.services.PersonServiceLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/person")
public class PersonController {
    private PersonServiceInterface service;

    @Autowired
    public PersonController(PersonServiceLogger service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Person>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
        return new ResponseEntity<>(service.update(id, person), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
