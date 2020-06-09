package net.bestofcode.Facebook.model.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class Email implements Credential {

    String address;

    @Override
    public String getValue() {
        return address;
    }
}
