package org.graf.hibernateplayground.helper;

import org.graf.hibernateplayground.model.Person;
import org.graf.hibernateplayground.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class DatabaseInitializerHelper {

    private final PersonRepository personRepository;

    @Autowired
    public DatabaseInitializerHelper(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    @Transactional
    public void initDatabase() {
        Person maxMustermann = new Person("Max", "Mustermann");
        maxMustermann.addAddress("Max's Street");
        this.personRepository.save(maxMustermann);
    }
}
