package com.github.curriculeon.services;

import com.github.curriculeon.models.Person;
import com.github.curriculeon.utils.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceLogger implements PersonServiceInterface, Loggable {
    @Autowired
    private PersonService service;

    @Override
    public Iterable<Person> index() {
        Iterable<Person> result = null;
        info("Attempting to `PersonService.index()`...");
        try {
            result = service.index();
            info("`PersonService.index()` was successful.");
        } catch (RuntimeException exception) {
            info("`PersonService.index()` was NOT successful.");
        }
        info("`PersonService.index()` resulted in [ %s ]", result);
        return result;
    }

    @Override
    public Person show(Long id) {
        Person result = null;
        info("Attempting to `PersonService.show(%s)`...", id);
        try {
            result = service.show(id);
            info("`PersonService.show(%s)` was successful.", id);
        } catch (RuntimeException exception) {
            info("`PersonService.show(%s)` was NOT successful.", id);
        }
        info("`PersonService.show(%s)` resulted in [ %s ]", id, result);
        return result;
    }

    @Override
    public Person create(Person person) {
        Person result = null;
        info("Attempting to `PersonService.create(%s)`...", person);
        try {
            result = service.create(person);
            info("`PersonService.create(%s)` was successful.", person);
        } catch (RuntimeException exception) {
            info("`PersonService.create(%s)` was NOT successful.", person);
        }
        info("`PersonService.create(%s)` resulted in [ %s ]", person, result);
        return result;
    }

    @Override
    public Person update(Long id, Person newPersonData) {
        Person result = null;
        info("Attempting to `PersonService.update(%s, %s)`...", id, newPersonData);
        try {
            result = service.update(id, newPersonData);
            info("`PersonService.update(%s, %s)` was successful.", id, newPersonData);
        } catch (RuntimeException exception) {
            info("`PersonService.update(%s, %s)` was NOT successful.", id, newPersonData);
        }
        info("`PersonService.update(%s, %s)` resulted in [ %s ]", id, newPersonData, result);
        return result;
    }

    @Override
    public Boolean delete(Long id) {
        Boolean result = null;
        info("Attempting to `PersonService.delete(%s)`...", id);
        try {
            result = service.delete(id);
            info("`PersonService.delete(%s)` was successful.", id);
        } catch (RuntimeException exception) {
            info("`PersonService.delete(%s)` was NOT successful.", id);
        }
        info("`PersonService.delete(%s)` resulted in [ %s ]", id, result);
        return result;
    }
}
