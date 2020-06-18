package net.bestofcode.Facebook.persistence.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserDTO {

    @Id
    @GeneratedValue
    Long id;
    String username;
    String password;
    String salt;
    String forename;
    String familyname;
    String email;
    String city;
    String street;
    Integer houseNumber;
}
