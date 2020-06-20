package net.bestofcode.Facebook.service;

import lombok.AllArgsConstructor;
import net.bestofcode.Facebook.model.User;
import net.bestofcode.Facebook.persistence.forms.RegistrationFormData;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    DatabaseService databaseService;

    public boolean registerUser(RegistrationFormData registrationFormData) {
        if(registrationFormData.isValid() && this.databaseService.insertIntoDB(
                User.create(
                    registrationFormData.getUsername().getValue(),
                    registrationFormData.getPassword().getEncryptedPassword(),
                    registrationFormData.getPassword().getSalt(),
                    registrationFormData.getEmail().getAddress())
                )
        ) {
            return true;
        }

        return false;
    }

}
