package net.bestofcode.Facebook.service;

import lombok.AllArgsConstructor;
import net.bestofcode.Facebook.model.User;
import net.bestofcode.Facebook.model.profile.Password;
import net.bestofcode.Facebook.persistence.LoginFormData;
import org.springframework.stereotype.Service;
import net.bestofcode.Facebook.model.profile.VerificationPassword;

@Service
@AllArgsConstructor
public class LoginService {

    DatabaseService databaseService;

    public User loginUser(LoginFormData loginFormData) {

        User user = this.databaseService.getUserByEmail(loginFormData.getEmail());

        if(loginFormData.isValid() && user != null) {

            // validate password:
            VerificationPassword password = new VerificationPassword(loginFormData.getVerificationPassword().getVerificationPassword());
            if(password.getEncryptedPassword().equals(user.getPassword().getEncryptedPassword())) {
                return user;
            }
        } else {
            return null;
        }
        return null;
    }

}
