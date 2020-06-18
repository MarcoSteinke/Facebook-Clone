package net.bestofcode.Facebook.service;

import net.bestofcode.Facebook.model.User;
import net.bestofcode.Facebook.model.profile.Username;
import net.bestofcode.Facebook.persistence.DTO.UserDTO;
import net.bestofcode.Facebook.persistence.Repositories.UserRepository;
import net.bestofcode.Facebook.persistence.mappers.UserDTOMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatabaseService {

    private UserRepository userRepository;
    private UserDTOMapper userDTOMapper;

    public DatabaseService(UserRepository userRepository) {

        this.userRepository = userRepository;
        this.userDTOMapper = new UserDTOMapper();
    }

    User getFromDB(Username username) {
        Optional<UserDTO> user = this.userRepository.findById(username.getValue());

        return this.userDTOMapper.mapUserDTOToUser(user.get());
    }

}
