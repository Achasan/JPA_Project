package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Getter
@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
