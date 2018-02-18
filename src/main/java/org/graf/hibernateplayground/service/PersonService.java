package org.graf.hibernateplayground.service;

import org.graf.hibernateplayground.helper.DatabaseInitializerHelper;
import org.graf.hibernateplayground.model.Address;
import org.graf.hibernateplayground.model.Person;
import org.graf.hibernateplayground.repository.AddressRepository;
import org.graf.hibernateplayground.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.graf.hibernateplayground.helper.DatabaseInitializerHelper.PERSON_MAX_LASTNAME;
import static org.graf.hibernateplayground.helper.DatabaseInitializerHelper.STREET_MAX_STREET;

@Service
public class PersonService {

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }

    @Transactional
    public void loadAndRemoveAddress() {
        Address address = addressRepository.findByStreet(STREET_MAX_STREET);
        addressRepository.delete(address);
    }

    @Transactional
    public void loadAndRemovePerson() {
        Person person = personRepository.findByLastName(PERSON_MAX_LASTNAME);
        personRepository.delete(person);
    }
}
