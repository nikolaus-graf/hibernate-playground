package org.graf.hibernateplayground.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
public class Address extends AbstractBaseEntity {

    @Column(name = "street", nullable = false)
    public String street;

    @ManyToMany(mappedBy = "addressList")
    public List<Person> personList = new ArrayList<>();

    @Deprecated
    public Address() {
        //JPA use only
    }

    public Address(String street) {
        this.street = street;
    }

    List<Person> getPersonList() {
        return personList;
    }
}
