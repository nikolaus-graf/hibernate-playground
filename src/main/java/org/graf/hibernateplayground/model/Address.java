package org.graf.hibernateplayground.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address extends AbstractBaseEntity {

  @Column(name = "street", nullable = false)
  private String street;

  @Deprecated
  public Address() {
    //JPA use only
  }

  public Address(String street) {
    this.street = street;
  }
}
