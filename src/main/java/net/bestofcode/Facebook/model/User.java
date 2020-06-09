package net.bestofcode.Facebook.model;

import lombok.AllArgsConstructor;
import net.bestofcode.Facebook.model.profile.Address;
import net.bestofcode.Facebook.model.profile.PersonalInformation;
import net.bestofcode.Facebook.model.profile.Username;

@AllArgsConstructor
public class User {

    Long id;
    Username username;
    PersonalInformation personalInformation;
    Address address;
}