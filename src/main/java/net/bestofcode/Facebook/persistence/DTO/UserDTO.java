package net.bestofcode.Facebook.persistence.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserDTO {

    @Id
    Long id;
    String username;
    String forename;
    String familyname;
    String email;
    String city;
    String street;
    Integer houseNumber;
}
