package org.graf.hibernateplayground.repository;

import org.graf.hibernateplayground.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select p from Person p left join fetch p.address where p.lastName = :lastName")
    Person findByLastNameWithFetch(String lastName);

    Person findByLastName(String lastName);
}
