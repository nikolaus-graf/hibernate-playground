package org.graf.hibernateplayground.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "person")
public class Person extends AbstractBaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToMany(cascade = ALL)
    @JoinTable(name = "person_address",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> addressList = new ArrayList<>();

    @Deprecated
    public Person() {
        //JPA use only
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addAddress(String street) {
        Address address = new Address(street);
        addressList.add(address);
        address.getPersonList().add(this);
    }

    public void removeAddress(Address address) {
        addressList.remove(address);
        address.getPersonList().remove(this);
    }
}
