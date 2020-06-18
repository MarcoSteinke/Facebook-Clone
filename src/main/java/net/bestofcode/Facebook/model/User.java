package net.bestofcode.Facebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.bestofcode.Facebook.model.profile.Address;
import net.bestofcode.Facebook.model.profile.Email;
import net.bestofcode.Facebook.model.profile.PersonalInformation;
import net.bestofcode.Facebook.model.profile.Username;

@Data
@AllArgsConstructor
public class User {

    Long id;
    Username username;
    Email email;
    PersonalInformation personalInformation;
    Address address;

    public static User create(Long id, String username, String email, String forename, String familyname, String street, String city, int houseNumber) {
        Username username1 = new Username(username);
        Email email1 = new Email(email);
        PersonalInformation personalInformation = new PersonalInformation(forename, familyname);
        Address address = new Address(street, houseNumber, city);

        return new User(id, username1, email1, personalInformation, address);
    }
}
