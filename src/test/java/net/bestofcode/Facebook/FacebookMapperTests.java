package net.bestofcode.Facebook;

import net.bestofcode.Facebook.model.User;
import net.bestofcode.Facebook.persistence.DTO.UserDTO;
import net.bestofcode.Facebook.persistence.mappers.UserDTOMapper;
import net.bestofcode.Facebook.service.DatabaseService;
import net.bestofcode.Facebook.service.RegistrationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class FacebookMapperTests {

    @Autowired
    DatabaseService databaseService;
    @Autowired
    RegistrationService registrationService;

    @Test
    void testMapperInBothDirections() {
        String initialPassword = "foobar";
        String initialUsername = "John";
        String initialEmail = "john@gmail.com";
        User user = User.create(initialUsername, initialPassword, UUID.randomUUID(), initialEmail);
        UserDTOMapper userDTOMapper = new UserDTOMapper();

        UserDTO userDTO = userDTOMapper.mapUserToUserDTO(user);
        User restoredUser = userDTOMapper.mapUserDTOToUser(userDTO);

        assertEquals("", user.getUsername().getValue()
                +user.getPassword().getEncryptedPassword()
                +user.getEmail().getAddress(),
                restoredUser.getUsername().getValue()
                        +restoredUser.getPassword().getEncryptedPassword()
                        +restoredUser.getEmail().getAddress());
    }
}
