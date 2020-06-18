package net.bestofcode.Facebook.model.profile;

import lombok.Data;

@Data
public class Email implements Credential {

    String address;

    public Email(String email) {
        this.address = email;
    }

    @Override
    public String getValue() {
        return address;
    }
}
