package net.bestofcode.Facebook.persistence.mappers;

import net.bestofcode.Facebook.model.User;
import net.bestofcode.Facebook.persistence.DTO.UserDTO;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

public class UserDTOMapper {

    public User mapUserDTOToUser(UserDTO dto) {
        User user = User.create(dto.getId(), dto.getUsername(), dto.getPassword(), UUID.fromString(dto.getSalt()), dto.getEmail(), dto.getForename(), dto.getFamilyname(), dto.getStreet(), dto.getCity(), dto.getHouseNumber());
        return user;
    }
}
