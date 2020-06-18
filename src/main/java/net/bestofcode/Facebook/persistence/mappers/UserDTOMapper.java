package net.bestofcode.Facebook.persistence.mappers;

import net.bestofcode.Facebook.model.User;
import net.bestofcode.Facebook.persistence.DTO.UserDTO;
import org.springframework.context.annotation.Bean;

public class UserDTOMapper {

    public User mapUserDTOToUser(UserDTO dto) {
        return User.create(dto.getId(), dto.getUsername(), dto.getEmail(), dto.getForename(), dto.getFamilyname(), dto.getStreet(), dto.getCity(), dto.getHouseNumber());
    }
}
