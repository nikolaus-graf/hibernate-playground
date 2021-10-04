package org.graf.hibernateplayground.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address extends AbstractBaseEntity {

    @Column(name = "street", nullable = false)
    public String street;

    @ManyToMany(mappedBy = "addressList")
    public Set<Person> personList = new HashSet<>();

    @Deprecated
    public Address() {
        //JPA use only
    }

    public Address(String street) {
        this.street = street;
    }

    Set<Person> getPersonList() {
        return personList;
    }
}
