package com.github.curriculeon.services;

import com.github.curriculeon.models.Person;

public interface PersonServiceInterface {
    Iterable<Person> index();

    Person show(Long id);

    Person create(Person person);

    Person update(Long id, Person newPersonData);

    Boolean delete(Long id);
}
