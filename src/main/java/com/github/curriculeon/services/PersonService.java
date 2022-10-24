package com.github.curriculeon.services;

import com.github.curriculeon.repositories.PersonRepository;
import com.github.curriculeon.models.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements PersonServiceInterface {
    private PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Person> index() {
        return repository.findAll();
    }

    @Override
    public Person show(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Person create(Person person) {
        return repository.save(person);
    }

    @Override
    public Person update(Long id, Person newPersonData) {
        Person originalPerson = repository.findById(id).get();
        originalPerson.setName(newPersonData.getName());
        return repository.save(originalPerson);
    }

    @Override
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
