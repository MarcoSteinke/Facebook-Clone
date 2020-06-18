package net.bestofcode.Facebook.model.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Address {

    String street;
    Integer houseNumber;
    String city;

    public Address(String street, int houseNumber, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
    }
}
