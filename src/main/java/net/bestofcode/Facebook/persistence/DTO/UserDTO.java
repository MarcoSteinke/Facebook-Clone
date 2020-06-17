package net.bestofcode.Facebook.persistence.DTO;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UserDTO {

    @Id
    Long id;
    String username;
    String forename;
    String familyname;
    String email;
}
