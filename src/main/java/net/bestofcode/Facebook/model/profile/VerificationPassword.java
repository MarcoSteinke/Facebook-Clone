package net.bestofcode.Facebook.model.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
public class VerificationPassword extends Password {

    String verificationPassword;
    UUID salt;

    public VerificationPassword(String verificationPassword) {
        this.verificationPassword = verificationPassword;
        this.encryptedPassword = verificationPassword;
        super.encryptedPassword = verificationPassword;
    }

    public VerificationPassword(String verificationPassword, UUID salt) {
        this.verificationPassword = verificationPassword;
        super.encryptedPassword = verificationPassword;
        this.encryptedPassword = verificationPassword;
        this.salt = salt;
    }


}
