package net.bestofcode.Facebook.model.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bestofcode.Facebook.security.MD5Hashing;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Password implements Credential {

    String encryptedPassword;
    @Setter
    UUID salt;

    public Password(String decryptedPassword) {
        this.salt = UUID.randomUUID();
        decryptedPassword += this.salt.toString();
        this.encryptedPassword = MD5Hashing.generateSecuredHash(decryptedPassword, salt);
    }

    public Password(String decryptedPassword, UUID salt) {
        this.encryptedPassword = MD5Hashing.generateSecuredHash(decryptedPassword, salt);
        this.salt = salt;
    }

    @Override
    public String getValue() {
        return null;
    }
}
