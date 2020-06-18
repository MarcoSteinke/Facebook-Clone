package net.bestofcode.Facebook.persistence;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.bestofcode.Facebook.model.profile.Credential;
import net.bestofcode.Facebook.model.profile.Email;
import net.bestofcode.Facebook.model.profile.Password;
import net.bestofcode.Facebook.model.profile.Username;

import java.util.List;

@Getter
public class FormData {

    Username username;
    Email email;
    Password password;

    public FormData(@NotNull Username username, @NotNull Email email, @NotNull Password password) {

        if(username == null || password == null || email == null) {

            this.createErrorFormData();
        } else {

            this.username = username;
            this.email = email;
            this.password = password;
        }
    }

    public boolean isValid() {
        return !this.username.equals("error");
    }

    private void createErrorFormData() {
        this.username = new Username("error");
    }
}
