package net.bestofcode.Facebook.model.profile;

import lombok.AllArgsConstructor;

import java.util.UUID;

public class Password implements Credential {

    String encryptedPassword;
    UUID salt;

    public Password(String decryptedPassword) {
        this.salt = UUID.randomUUID();
        decryptedPassword += this.salt.toString();

    }

    @Override
    public String getValue() {
        return null;
    }
}
