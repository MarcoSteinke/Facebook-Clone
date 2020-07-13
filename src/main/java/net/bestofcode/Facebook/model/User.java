package net.bestofcode.Facebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.bestofcode.Facebook.model.profile.accountState.Address;
import net.bestofcode.Facebook.model.profile.*;
import net.bestofcode.Facebook.model.profile.accountState.AccountState;

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
    UUID salt;
    private AccountState accountState;

    private User(Username username, Password password, UUID salt, Email email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public static User generateErrorUser(Username username) {
        System.out.println("Error during login occured");
        return new User(username, new Password(""), UUID.randomUUID(), new Email(""));
    }

    public static User create(Long id, String username, String password, UUID salt, String email, String forename, String familyname, String street, String city, int houseNumber) {
        Username username1 = new Username(username);
        VerificationPassword password1 = new VerificationPassword(password, salt);
        Email email1 = new Email(email);
        PersonalInformation personalInformation = new PersonalInformation(forename, familyname);
        Address address = new Address(street, houseNumber, city);

        password1.setSalt(salt);
        return new User(id, username1, password1, email1, personalInformation, address, salt, AccountState.REGISTERED);
    }

    public static User create(String username, String password, UUID salt, String email) {
        Username username1 = new Username(username);
        VerificationPassword password1 = new VerificationPassword(password, salt);
        Email email1 = new Email(email);

        User user = new User(username1, password1, salt, email1);
        user.setAccountState(AccountState.NEW);

        return user;
    }
}
