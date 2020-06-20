package net.bestofcode.Facebook.persistence;

import lombok.Getter;
import lombok.Setter;
import net.bestofcode.Facebook.model.profile.Email;
import net.bestofcode.Facebook.model.profile.Password;
import net.bestofcode.Facebook.model.profile.Username;
import net.bestofcode.Facebook.model.profile.VerificationPassword;

@Getter
public class LoginFormData implements FormData {

    Username username;
    Email email;
    Password password;
    @Setter
    VerificationPassword verificationPassword;

    public LoginFormData(Email email, Password password) {

        if(password == null || email == null) {

            this.createErrorFormData();
        } else {
            this.username = new Username("");
            this.email = email;
            this.password = password;
            this.verificationPassword = new VerificationPassword(password.getEncryptedPassword());
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
