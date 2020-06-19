package net.bestofcode.Facebook.persistence;

import lombok.Getter;
import net.bestofcode.Facebook.model.profile.Email;
import net.bestofcode.Facebook.model.profile.Password;
import net.bestofcode.Facebook.model.profile.Username;

@Getter
public class RegistrationFormData implements FormData {

    Username username;
    Email email;
    Password password;

    public RegistrationFormData(Username username, Email email, Password password) {

        if(username == null || password == null || email == null) {

            this.createErrorFormData();
        } else {

            this.username = username;
            this.email = email;
            this.password = password;
        }
    }

    public boolean isValid() {
        return !this.username.getValue().equals("error");
    }

    private void createErrorFormData() {
        this.username = new Username("error");
        System.out.println("invalid FormData");
    }
}
