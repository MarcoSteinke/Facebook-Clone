package net.bestofcode.Facebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.bestofcode.Facebook.model.profile.*;

import java.util.UUID;

@Data
@AllArgsConstructor
public class User {

    Long id;
    Username username;
    Password password;
    Email email;
    PersonalInformation personalInformation;
    Address address;

    public static User create(Long id, String username, String password, UUID salt, String email, String forename, String familyname, String street, String city, int houseNumber) {
        Username username1 = new Username(username);
        Password password1 = new Password(password, salt);
        Email email1 = new Email(email);
        PersonalInformation personalInformation = new PersonalInformation(forename, familyname);
        Address address = new Address(street, houseNumber, city);

        return new User(id, username1, password1, email1, personalInformation, address);
    }
}
