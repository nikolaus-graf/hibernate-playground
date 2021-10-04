package org.graf.hibernateplayground.helper;

import org.graf.hibernateplayground.model.Person;
import org.graf.hibernateplayground.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class DatabaseInitializerHelper {

    public static final String PERSON_MAX_FIRSTNAME = "Max";
    public static final String PERSON_MAX_LASTNAME = "Mustermann";
    public static final String STREET_MAX_STREET = "Max's Street";
    public static final String STREET_MAX_PARENTS_STREET = "Max Parent's Street";

    private final PersonRepository personRepository;

    @Autowired
    public DatabaseInitializerHelper(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    @Transactional
    public void initDatabase() {
        Person maxMustermann = new Person(PERSON_MAX_FIRSTNAME, PERSON_MAX_LASTNAME);
        maxMustermann.addAddress(STREET_MAX_STREET);
        maxMustermann.addAddress(STREET_MAX_PARENTS_STREET);
        this.personRepository.save(maxMustermann);
    }
}
