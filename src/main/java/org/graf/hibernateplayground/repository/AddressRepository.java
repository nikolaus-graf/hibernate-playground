package org.graf.hibernateplayground.repository;

import org.graf.hibernateplayground.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByStreet(String street);
}
