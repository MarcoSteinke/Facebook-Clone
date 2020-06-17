package net.bestofcode.Facebook.service;

import net.bestofcode.Facebook.model.User;
import net.bestofcode.Facebook.model.profile.Username;
import net.bestofcode.Facebook.persistence.DTO.UserDTO;
import net.bestofcode.Facebook.persistence.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatabaseService {

    private UserRepository userRepository;

    public DatabaseService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserDTO getFromDB(Username username) {
        Optional<UserDTO> user = this.userRepository.findById(username.getValue());

        return user.get();
    }

}
