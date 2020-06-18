package net.bestofcode.Facebook.service;

import lombok.AllArgsConstructor;
import net.bestofcode.Facebook.model.User;
import net.bestofcode.Facebook.model.profile.Credential;
import net.bestofcode.Facebook.persistence.FormData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationService {

    DatabaseService databaseService;

    public boolean registerUser(FormData formData) {
        if(formData.isValid() && this.databaseService.insertIntoDB(
                User.create(
                    formData.getUsername().getValue(),
                    formData.getPassword().getEncryptedPassword(),
                    formData.getEmail().getAddress())
                )
        ) {
            return true;
        }

        return false;
    }

}
