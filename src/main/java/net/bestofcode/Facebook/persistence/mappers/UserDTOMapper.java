package net.bestofcode.Facebook.persistence.mappers;

import net.bestofcode.Facebook.model.User;
import net.bestofcode.Facebook.model.profile.accountState.AccountState;
import net.bestofcode.Facebook.persistence.DTO.UserDTO;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

public class UserDTOMapper {

    public User mapUserDTOToUser(UserDTO dto) {
        User user = User.create(dto.getId(), dto.getUsername(), dto.getPassword(), UUID.fromString(dto.getSalt()), dto.getEmail(), dto.getForename(), dto.getFamilyname(), dto.getStreet(), dto.getCity(), dto.getHouseNumber());
        return user;
    }

    public UserDTO mapUserToUserDTO(User user) {

        UserDTO userDTO;

        if(user.getAccountState() == AccountState.REGISTERED) {

            userDTO = new UserDTO(
                    user.getId(),
                    user.getUsername().getValue(),
                    user.getPassword().getEncryptedPassword(),
                    user.getPassword().getSalt().toString(),
                    user.getPersonalInformation().getForename(),
                    user.getPersonalInformation().getFamilyname(),
                    user.getEmail().getAddress(),
                    user.getAddress().getCity(),
                    user.getAddress().getStreet(),
                    user.getAddress().getHouseNumber());
        } else {
            
            userDTO = new UserDTO(
                    user.getId(),
                    user.getUsername().getValue(),
                    user.getPassword().getEncryptedPassword(),
                    user.getPassword().getSalt().toString(),
                    "",
                    "",
                    user.getEmail().getAddress(),
                    "",
                    "",
                    -1);
        };


        return userDTO;
    }
}
